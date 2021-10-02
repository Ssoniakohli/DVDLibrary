/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDController;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.userIO;
import com.sg.dvdlibrary.ui.userIOConsoleImpl;


/**
 *
 * @author HP
 */ 
public class App {
    public static void main(String[] args){
    userIO myIo = new userIOConsoleImpl();
    DVDView myView = new DVDView(myIo);
    DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
    DVDController controller = 
        new DVDController(myDao, myView);
    controller.run();
    }
}