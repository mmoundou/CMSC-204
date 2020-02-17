/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matthieu
 */
class Songs {
    
    private String title; 
    private String duration; 
    private String yearReleased; 
    private String artist; 
    private String album; 
    private String rating; 
    
    public Songs(String title, String artist) {
        
        this.title = title; 
        this.artist = artist; 
        
    }
    
    public String getTitle() {
        String temp = title; 
        return temp;
    }
    
    
}
