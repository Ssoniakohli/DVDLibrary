/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public class DVDView {
    
  private userIO con; //new userIOConsoleImpl();
 
    public DVDView(userIO con) {
        this.con = con;
    }

    public DVDView(userIOConsoleImpl myIo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public int printMenuandGetSelection(){
            con.print("Main Menu");
            con.print("1. add DVD");
            con.print("2. remove DVD");
            con.print("3. get all DVDs");
            con.print("4. get DVDs");
            con.print("5. Edit DVD");
            con.print("6. Exit");
        return con.readInt("Please select from the above choices.", 1, 6);
    }
    public com.sg.dvdlibrary.dto.DVD getNewDVDInfo() throws Exception {
    String dvdID = con.readString("Please enter DVD ID");
    String Title = con.readString("Please enter the Title: ");
    String dateStr = con.readString("Enter the release date in format YYYY-mm-dd ");
    LocalDate date = LocalDate.parse(dateStr);
    String mpaaRating = con.readString("Enter the MPAA Rating as \"G\", \"GP\", \"PG\", \"R\"");
    String directorName = con.readString("Enter the director Name: ");
    String studio = con.readString("Enter the studio name: ");
    String userNotes = con.readString("Enter your note: ");
        com.sg.dvdlibrary.dto.DVD currentDVD = new DVD();
    currentDVD.setDvdID(dvdID);
    currentDVD.setTitle(Title);
    currentDVD.setReleaseDate(dateStr);
    currentDVD.setMpaaRating(mpaaRating);
    currentDVD.setDirectorName(directorName);
    currentDVD.setStudio(studio);
    currentDVD.setUserNote(userNotes);
    displayDVD(currentDVD);
    return currentDVD;
}
    public void displayCreateDVDBanner(){
        con.print("==== CREATE DVD ====");
    }
    public void displayCreateSuccessBanner() {
    con.readString(
            "DVD successfully created.  Please hit enter to continue");
    }
    public com.sg.dvdlibrary.dto.DVD editDVDInfo() throws Exception{
        DVD toEdit = new DVD();
        boolean done = false;
        String dvdID = con.readString("Please enter the DVD ID that you want to Edit:");
        while (done == false) {
            int editChoice = printEditMenu();
            switch (editChoice) {
            case 1:
                editTitle(toEdit);
                break;
            case 2:
                editReleaseDate(toEdit);
                break;
            case 3:
                editMpaaRating(toEdit);
                break;
            case 4:
                editDirectorName(toEdit);
                break;
            case 5:
                editStudio(toEdit);
                break;
            case 6:
                editUserNote(toEdit);
                break;
            case 7:
                done = true;
                break;
            }
        }
        return toEdit;
    }
    public int printEditMenu() {
        con.print("1:Edit title");
        con.print("2:Edit release date");
        con.print("3:Edit MPAA rating");
        con.print("4:Edit director name");
        con.print("5:Edit studio");
        con.print("6:Edit user note");
        con.print("7:Return to main menu");
        return con.readInt("Please choose from the choices above ", 1, 7);
    }
    private void editTitle(com.sg.dvdlibrary.dto.DVD toEdit) {
        String newTitle = con.readString("Please enter the new title for this DVD.");
        toEdit.setTitle(newTitle);
        con.print("The new title is " + newTitle);
    }
    private void editReleaseDate(com.sg.dvdlibrary.dto.DVD toEdit) {
        String dateStr = con.readString("Enter the new release date in format YYYY-mm-dd");
        LocalDate date = LocalDate.parse(dateStr);
        toEdit.setReleaseDate(dateStr);
        con.print("The new release date is " + dateStr);
    }
    private void editMpaaRating(com.sg.dvdlibrary.dto.DVD toEdit) {
        String newRating = con.readString("Please enter the new MPAA rating for this DVD.");
        toEdit.setMpaaRating(newRating);
        con.print("The new rating is " + newRating);
    }
    private void editDirectorName(com.sg.dvdlibrary.dto.DVD toEdit) {
        String newDirectorName = con.readString("Please enter the new director's name for this DVD.");
        toEdit.setDirectorName(newDirectorName);
        con.print("The new director name is " + newDirectorName);
    }
    private void editStudio(com.sg.dvdlibrary.dto.DVD toEdit) {
        String newStudioName = con.readString("Please enter the new studio's name for this DVD.");
        toEdit.setStudio(newStudioName);
        con.print("The new studio name is " + newStudioName);
    }
    private void editUserNote(com.sg.dvdlibrary.dto.DVD toEdit) {
        String additionalUserNote = con.readString("Please enter another user note for this DVD.");
        toEdit.setUserNote(additionalUserNote);
        con.print("The newly added usernote is " + additionalUserNote);
    }
    //List for DVD
    public void printDVDList(List<com.sg.dvdlibrary.dto.DVD> dvd) throws Exception {
         try{
             dvd.forEach(dvdList -> {
                 displayDVD(dvdList);
             });
                } catch (NullPointerException e){
                    System.out.println("No DVD found by that title.");
                }
    }
    //Search for DVDs
    public void displayDVD(com.sg.dvdlibrary.dto.DVD dvd){
        if(dvd != null){
            System.out.println("====================================");
            System.out.println("DVD Id:             " + dvd.getDvdID());
            System.out.println("DVD Title:          " + dvd.getTitle());
            System.out.println("DVD Release Date:   " + dvd.getReleaseDate());
            System.out.println("DVD MPAA Ratings:   " + dvd.getMpaaRating());
            System.out.println("DVD Director Name:  " + dvd.getDirectorName());
            System.out.println("DVD Studio:         " + dvd.getStudio());
            System.out.println("DVD User Note:      " + dvd.getUserNote());
            System.out.println("=====================================");
        } else {
            con.print("No Such DVD found. ");
        }
//        con.readString("Please hit enter to continue");
    }
    public void displayDVDBanner(){
        con.print("==== SEARCH DVD ====");
    }
    public String getdvdIDChoice(){
        return con.readString("Please enter the DVD ID");
    }
    public String getdvdTitle(){
        return con.readString("Please Enter the Title");
    }
    public void displayRemoveResult(com.sg.dvdlibrary.dto.DVD dvdRecord){
        if(dvdRecord != null){
            con.print("DVD Record Successfully removed.");
        } else {
            con.print("No Such DVD record found.");
        }
        con.print("Please hit enter to continue.");
    }
      public void displayRemoveDVDBanner(){
        con.print("==== Remove DVD ====");
    }
    public void displayExitBanner(){
        con.print("Good Bye!!!");
    }
    public void displayUnknownCommanBanner(){
        con.print("Unknown Command!!!");
    }
    public void displayAllBanner() {
    con.print("=== Display All DVDs ===");
    }
    public void displayErrorMessage(String errorMsg) {
    con.print("=== ERROR ===");
    con.print(errorMsg);
    }

    public String getDVDChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class DVD extends com.sg.dvdlibrary.dto.DVD {

        public DVD() {
        }
    }
}
