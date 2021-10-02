/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DVDLibraryDao {
   DVD AddDVD(String title, DVD dvd)throws DVDLibraryDaoException;
   DVD RemoveDVD(String dvdID) throws DVDLibraryDaoException;
   DVD EditDVD(String tittle) throws DVDLibraryDaoException;
   DVD DisplayDVDDetails(String tittle) throws DVDLibraryDaoException;
   List <DVD>getAllDVDs()throws DVDLibraryDaoException;

    public List<DVD> ListAllDVD();

    public void editedDVD(String title, DVD editDVD);

    public DVD gettitle(String t);

    public DVD removeDVD(String title);
}
        