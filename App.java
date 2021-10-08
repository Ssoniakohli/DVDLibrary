/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDLibrary;



import com.sg.DVDLibrary.controller.DvdLibraryController;
import com.sg.DVDLibrary.dao.DvdLibraryDao;
import com.sg.DVDLibrary.dao.DvdLibraryDaoImpl;
import com.sg.DVDLibrary.ui.DvdLibraryView;
import com.sg.DVDLibrary.ui.UserIO;
import com.sg.DVDLibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author HP
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }
}