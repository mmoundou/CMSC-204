/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matthieu
 */

import java.util.Random; 

public class MusicQueue {
    
    public static void main(String[] args) {
    
        QueueInterface<Songs> songQueue = new Queue<>(10);
        Songs[] array = new Songs[10];
        Random randomGenerator = new Random(); 
        int index = 0; 
    
        Songs track01 = new Songs("River Lea", "Adele"); 
        Songs track02 = new Songs("Love in the Dark", "Adele"); 
        Songs track03 = new Songs("Hello", "Adele"); 
        Songs track04 = new Songs("Send my Love", "Adele"); 
        Songs track05 = new Songs("Remedy", "Adele");
        Songs track06 = new Songs("Gava", "Tayc"); 
        Songs track07 = new Songs("Aloviou", "Tayc"); 
        Songs track08 = new Songs("Bonnie", "Tayc"); 
        Songs track09 = new Songs("Come Over", "Melvitto"); 
        Songs track10 = new Songs("Bad", "Shaydee"); 
    
        songQueue.enqueue(track01); 
        songQueue.enqueue(track02); 
        songQueue.enqueue(track03);
        songQueue.enqueue(track04); 
        songQueue.enqueue(track05);
        songQueue.enqueue(track06);
        songQueue.enqueue(track07);
        songQueue.enqueue(track08);
        songQueue.enqueue(track09);
        songQueue.enqueue(track10); 
        
        
        System.out.println("This is a fun music player simulation\n");
        System.out.println("A music library comprised of 10 songs is going "+
                            "to shuffle songs and play them in no particular order\n");
        System.out.println("\nThis is a list of our songs in the order they were added"); 
        while(!songQueue.isEmpty()) {
            Songs temp = songQueue.dequeue(); 
            array[index] = temp; 
            System.out.println(temp.getTitle()); 
            index++;
        }
        System.out.println("Let's try to add a song to our playlist"); 
        try {
            songQueue.enqueue(new Songs("Soco", "Wizkid"));  
        }
        catch(FullQueueException e) {
            System.out.println(e.getMessage()); 
        }
        System.out.println("\nThis is a list of the songs shuffled"); 
        for(int j = 0; j < array.length; j++) {
            System.out.println(array[(int)(10.0 * Math.random())].getTitle()); 
        }
        System.out.println(); 
 
    }
    
}
