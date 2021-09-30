/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.App;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.userIO;
import java.util.List;



/**
 *
 * @author HP
 */
public class DVDController {
    private userIO con; //new userIOConsoleImpl();
    private DVDLibraryDao dao; //new FileImpl();
    private DVDView view; //new DVDView();
    private DVDLibraryDao myDao;
    private DVDLibraryDao myView;
    String Title;
    public DVDController(DVDLibraryDao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }
    public DVDController(DVDLibraryDao myDao, DVDLibraryDao myView) {
        this.myDao = myDao;
        this.myView = myView;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
            case 1:
                //con.print("Add DVD");
                createDVD();
                break;
            case 2:
                //con.print("Remove DVD");
                removeDVD();
                break;
            case 3:
                //con.print("Display all DVDs");
                listDVDs();
                break;
            case 4:
                //con.print("Search for DVDs");
                viewDVD();
                break;
            case 5:
                //con.print("Edit DVD");
                editDVD();
                break;
            case 6:
                //con.print("Exit");
                keepGoing = false;
                break;
            default:
                unknownCommand();
            }
        } exitMessage();
    } catch(Exception e){
        view.displayErrorMessage(e.getMessage());
    }
}
    private int getMenuSelection() {
    return view.printMenuandGetSelection();
    }
    private void createDVD() throws Exception {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.AddDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    private void editDVD() throws Exception {
        DVD editDVD = view.editDVDInfo();
        dao.editDVD(editDVD.getTitle(), editDVD);
        view.printEditMenu();
    }
    private void listDVDs() throws Exception {
        view.displayAllBanner();
        List<DVD> dvdList = dao.ListAllDVD();
        view.printDVDList(dvd);
    }
    private void viewDVD() throws Exception {
        view.displayDVDBanner();
        String t = view.getdvdIDChoice();
        String m = view.getdvdTitle();
        DVD dvd = dao.gettitle(t);
        view.displayDVD(dvd);
    }

    /**
     *
     */
    private void removeDVD() throws Exception {
        view.displayRemoveDVDBanner();
        String title = view.getDVDChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }
    private void unknownCommand(){
        view.displayUnknownCommanBanner();
    }
    private void exitMessage(){
        view.displayExitBanner();
    }

    private static class DVDLibraryDao {

        public DVDLibraryDao() {
        }

        
    }
}       
        