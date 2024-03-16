/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Song;

import static Song.MusicGUI.artistTF;
import static Song.MusicGUI.titleTF;
import static Song.MusicGUI.likedSongTA;
import static Song.MusicGUI.rapTA;


/**
 *
 * @author joshuatupas
 */
public class Playlist implements Interface {
    
    private Node head;
    private Node last;
    private Node curr;
    private int size; 

    Playlist() { 
        head = null; 
        last = null; 
        size = 0;
        curr = head;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    
    private void setCurrent(int index) {
        curr = head; //start at the head 
        for (int i  = 1; i < index; i++) { 
            curr = curr.getNext();
        }
    }

@Override
public void addMusic() {
    int index = size + 1;
    String title = titleTF.getText();
    String artist = artistTF.getText();
    Music theElement = new Music(title, artist);

    if (size == 0) {        
        Node newNode = new Node(theElement, null, null);
        head = newNode;
        last = newNode;
    } else {
        if (index == 1) {
            Node newNode = new Node(theElement, null, null);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (index == (size+1)) {  
            Node newNode = new Node(theElement, null, null);
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        } else {
            setCurrent(index);
            Node newNode = new Node(theElement, null, null);
            newNode.setNext(curr); 
            Node prev = curr.getPrev();
            newNode.setPrev(prev);
            prev.setNext(newNode);
            curr.setPrev(newNode);
        }
    }
    size++;
    likedSongTA.append("Title: " + title + ", Artist: " + artist + "\n");
}
    

    @Override
    public void printList() {
        for (Node aNode = head; aNode != null; aNode = aNode.getNext()) {
            System.out.println(aNode.getElement());
        }
    }

    @Override
    public int countMusic() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeMusic() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveToGenre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void RepeatPlaylist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}