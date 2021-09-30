/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDController;
import com.sg.dvdlibrary.ui.DVDView;
import com.sg.dvdlibrary.ui.userIOConsoleImpl;

/**
 *
 * @author HP
 */
public class App {
  
    public static void main(String[] args) throws Exception{
    
  
//        DVDController controller = new DVDController();
//        controller.run();
        userIOConsoleImpl myIo = new userIOConsoleImpl();
        DVDView myView = new DVDView(myIo);
        FileImpl myDao = new FileImpl();
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }

    private static class FileImpl {

        public FileImpl() {
        }
    }
}
    
        
    
