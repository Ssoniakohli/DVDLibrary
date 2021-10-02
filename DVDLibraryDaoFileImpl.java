/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.userIO;
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

/**
 *
 * @author HP
 */

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
   private userIO io;
   Map<String, DVD> dvds = new HashMap<>();
 public static final String DVDCollection_FILE = "DVDCollection.txt";
    public static final String DELIMITER = "::";
  
@Override
    public DVD AddDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }
    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<>(dvds.values());
    }
    @Override
    public DVD EditDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }
    @Override
    public DVD RemoveDVD(String dvdID) throws DVDLibraryDaoException {
       loadLibrary();
        DVD removedDVD = dvds.remove(dvdID);
        writeLibrary();
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
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        
        try{
            scanner = new Scanner(
                            new BufferedReader(
                                    new FileReader(DVDCollection_FILE)));
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
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
                out = new PrintWriter(new FileWriter(DVDCollection_FILE));
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


    @Override
    public DVD DisplayDVDDetails(String tittle) throws DVDLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> ListAllDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editedDVD(String title, DVD editDVD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD gettitle(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD removeDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    }
 
     
