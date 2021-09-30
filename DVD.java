/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author HP
 */
public class DVD {
    
private String Title;
    private String dvdID;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private int userRating;
    private String userNote;

    public DVD(String dvdToken) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getDvdID() {
        return dvdID;
    }
    public void setDvdID(String dvdID) {
        this.dvdID = dvdID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getMpaaRating() {
        return mpaaRating;
    }
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public int getUserRating() {
        return userRating;
    }
    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
    public String getUserNote() {
        return userNote;
    }
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    public String getID() {
        return dvdID;
    }
}
