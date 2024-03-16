/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Song;

import static Song.MusicGUI.artistTF;
import static Song.MusicGUI.genreCB;
import static Song.MusicGUI.popTA;
import static Song.MusicGUI.titleTF;
import static Song.MusicGUI.rapTA;
import static Song.MusicGUI.searchTF;
import javax.swing.JOptionPane;

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
        curr = head; 
        for (int i = 1; i < index; i++) {
            curr = curr.getNext();
        }
    }

    @Override
    public void addMusic() {
        int index = size + 1;
        String title = titleTF.getText();
        String artist = artistTF.getText();
        Music song = new Music(title, artist);
        if (size == 0) {
            Node newNode = new Node(song, null, null);
            head = newNode;
            last = newNode;
        } else {
            if (index == 1) {
                Node newNode = new Node(song, null, null);
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            } else if (index == (size + 1)) {
                Node newNode = new Node(song, null, null);
                newNode.setPrev(last);
                last.setNext(newNode);
                last = newNode;
            } else {
                setCurrent(index);
                Node newNode = new Node(song, null, null);
                newNode.setNext(curr);
                Node prev = curr.getPrev();
                newNode.setPrev(prev);
                prev.setNext(newNode);
                curr.setPrev(newNode);
            }
        }
        size++;
        JOptionPane.showMessageDialog(null, "Added song: Title: " + title + ", Artist: " + artist);
    }

    @Override
    public void printList() {
        String songList = "";
        for (Node aNode = head; aNode != null; aNode = aNode.getNext()) {
            songList += aNode.getElement() + "\n";
        }
        JOptionPane.showMessageDialog(null, songList);

    }

    @Override
    public int countMusic() {
        return size;
    }

    @Override
    public Object get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeMusic() {
        if (!isEmpty()) {
            Node prevLast = last.getPrev();
            if (prevLast != null) {
                prevLast.setNext(null);
            } else {
                head = null;
            }
            last = prevLast;
            size--;
            JOptionPane.showMessageDialog(null, "The last song has been removed from the playlist.");
        } else {
            JOptionPane.showMessageDialog(null, "The playlist is already empty.");
        }
    }

    @Override
    public void moveToGenre() {
        if (last != null) {
            Music song = (Music) last.getElement();
            String selectedGenre = (String) genreCB.getSelectedItem();
            if ("Rap".equals(selectedGenre)) {
                rapTA.setText(song.toString());
            } else if ("Pop".equals(selectedGenre)) {
                popTA.setText(song.toString());
            }
            JOptionPane.showMessageDialog(null, "Item is successfully moved");
        } else {
            JOptionPane.showMessageDialog(null, "The playlist is already empty.");
        }
    }

    @Override
    public void searchMusic() {
        String title = searchTF.getText();
        Node current = head;
        while (current != null) {
            Music song = (Music) current.getElement();
            if (song.getTitle().equals(title)) {
                JOptionPane.showMessageDialog(null, "Found song: " + song.toString());
                return;
            }
            current = current.getNext();
        }
        JOptionPane.showMessageDialog(null, "No song with title '" + title + "' found");
    }

    @Override
    public void createPlaylist() {
        head = null;
        last = null;
        size = 0;
        JOptionPane.showMessageDialog(null, "Playlist has been reset.");
    }
}
