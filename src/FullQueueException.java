/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matthieu
 */
public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super("Attempted to add item to full queue"); 
    }
    
}
