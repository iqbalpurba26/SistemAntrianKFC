/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaspbo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M IQBAL
 */
public class Antrian {
         
    private Queue<String> queueList;
    
    public Antrian() {
        queueList = new LinkedList<>();
    }
    
    public void enqueue(String data) {
        queueList.add(data);
    }
    
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        return queueList.poll();
    }
    
    public boolean isEmpty() {
        return queueList.isEmpty();
    }
    
    public int size() {
        return queueList.size();
    }

    public  Queue<String> getQueue() {
        return queueList;
    }
    
   
}