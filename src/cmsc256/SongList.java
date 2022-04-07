/**
 *   Minh Nguyen
 *   SongList.java
 *   project 3
 *   CMSC256 Spring semester
 *   This project is an implementation of linked lists
 */


package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;
import bridges.base.SLelement;
import java.util.ArrayList;

public class SongList implements cmsc256.List<Song> {
    private SLelement<Song> head; //This variable points to the head of the list
    private SLelement<Song> tail; //This variable points to the last element in the list
    private SLelement<Song> curr; //this points to the current element
    private int listSize; //size of the list

    //A constructor based on lab 3 constructor.
    public SongList() {
        Bridges bridges = new Bridges(3, "Minh Nguyen", "386889807102");
        clear();
        DataSource ds = bridges.getDataSource();
        listSize = 0;
        ArrayList<Song> temp = null;
        try {
            temp = ds.getSongData();
        }
        catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }
        for (Song songs : temp) {
            append(songs);
        }
    }
    //Removes all elements in list
    @Override
    public void clear() {
        curr = tail = new SLelement<Song>();
        head = new SLelement<Song>(tail);
        listSize = 0;
    }
    //Insert "it" at the current location
    //The client must also ensure that the list's capacity is not exceeded
    @Override
    public boolean insert(Song it) {
        curr.setNext(new SLelement<Song>(curr.getValue(), curr.getNext()));
        curr.setValue(it);
        if (tail == curr) {
            tail = curr.getNext();
        }
        listSize++;
        return true;
    }
    //Append "it" at the end of the list
    @Override
    public boolean append(Song it) {
        SLelement<Song> temp = new SLelement<>(null);
        tail.setNext(temp);
        tail.setValue(it);
        tail = tail.getNext();
        listSize++;
        return true;
    }
    //Remove and return the current element
    @Override
    public Song remove() {
        if (curr.equals(tail)) {
            return null;
        }
        Song it = curr.getValue();
        curr.setValue(curr.getNext().getValue());
        if (curr.getNext().equals(tail)) {
            curr.setNext(null);
            tail = curr;
        }
        else {
            curr.setNext(curr.getNext().getNext());
        }
        listSize--;
        return it;
    }
    //Set the current position to the start of the list
    @Override
    public void moveToStart() {
        curr = head.getNext();
    }
    //Set the current position to the end of the list
    @Override
    public void moveToEnd() {
        curr = tail;
    }
    //Move the current position one step left, no change if already at beginning
    @Override
    public void prev() {
        if (head.getNext() == curr) {
            return;
        }
        SLelement<Song> temp = head;
        while (temp.getNext() != curr) {
            temp = temp.getNext();
        }
        curr = temp;
    }
    //Move the current position one step right, no change if already at end
    @Override
    public void next() {
        if (curr != tail) {
            curr = curr.getNext();
        }
    }
    //Return the number of elements in the list
    @Override
    public int length() {
        return listSize;
    }
    //Return the position of the current element
    @Override
    public int currPos() {
        SLelement<Song> temp = head.getNext();
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.getNext();
        }
        return i;
    }
    //Set the current position to "pos"
    @Override
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            curr = head.getNext();
        }
        return true;
    }
    //Return true if current position is at end of the list
    @Override
    public boolean isAtEnd() {
        return curr == tail;
    }
    //Return the current element
    @Override
    public Song getValue() {
        if (curr == tail) {
            return null;
        }
        return curr.getValue();
    }
    //Returns a song by a specific artist
    public String getSongsByArtist(String artist) {
        return artist;
    }
}