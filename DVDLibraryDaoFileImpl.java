
 
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HP
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    public static final String DVD_ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD AddDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadDVDCollection();
        DVD newDVD = dvds.put(title, dvd);
        writeDVDCollection();
        return newDVD;
    }
    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        try {
            loadLibrary();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>(dvds.values());
    }
    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadDVDCollection();
        return dvds.get(title);
    }
 @Override
    public DVD removeDVD(String dvdID) throws DVDLibraryDaoException {
        loadDVDCollection();
        DVD removedDVD = dvds.remove(dvdID);
        writeDVDCollection();
        return removedDVD;
    }
    private DVD unmarshallData(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        DVD dvdFromFile = new DVD(dvdTokens[1]);
        dvdFromFile.setDvdID(dvdTokens[0]);
//        dvdFromFile.setTitle(dvdTokens[1]);
        dvdFromFile.setReleaseDate(dvdTokens[2]);
        dvdFromFile.setMpaaRating(dvdTokens[3]);
        dvdFromFile.setDirectorName(dvdTokens[4]);
        dvdFromFile.setStudio(dvdTokens[5]);
        dvdFromFile.setUserNote(dvdTokens[6]);
        return dvdFromFile;
    }
    private void loadLibrary() throws DVDLibraryDaoException, FileNotFoundException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(
                            new BufferedReader(
                                    new FileReader(DVD_ROSTER_FILE)));
        }catch(FileNotFoundException e){
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster Data into memory.", e);
        }
//        String currentLine;
//        Library currentDVD;
        while(scanner.hasNextLine()){
            String currentLine = scanner.nextLine();
            DVD currentDVD = unmarshallData(currentLine);
             dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    private String marshallData(DVD mDVD){
        String dvdAsText = mDVD.getDvdID()+DELIMITER;
        dvdAsText += mDVD.getTitle()+DELIMITER;
        dvdAsText += mDVD.getReleaseDate()+DELIMITER;
        dvdAsText += mDVD.getMpaaRating()+ DELIMITER;
        dvdAsText += mDVD.getDirectorName()+DELIMITER;
        dvdAsText += mDVD.getStudio()+DELIMITER;
        dvdAsText += mDVD.getUserNote();
        return dvdAsText;
    }
    private void writeLibrary() throws DVDLibraryDaoException, IOException {
        PrintWriter out;
        try {
                out = new PrintWriter(new FileWriter(DVD_ROSTER_FILE));
    } catch (IOException e) {
                throw new DVDLibraryDaoException(
                    "Could not save DVD data.", (FileNotFoundException) e);
    }
//        String dvdAsText;
        List dvdList = this.getAllDVDs();
        dvdList.stream().map(currentDVD -> marshallData((DVD) currentDVD)).map(dvdAsText -> {
            out.println(dvdAsText);
            return dvdAsText;
        }).forEachOrdered(_item -> {
            out.flush();
        });
        out.close();
    }

}