/**
 *   Debra Duke  
 *   Computer Science Department
 *   School of Engineering
 *   Virginia Commonwealth University
 */
package cmsc256;

import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

import java.util.ArrayList;

//List class ADT. Generalize the element type using Java Generics.
public interface List<E> { // List class ADT
    // Remove all contents from the list, so it is once again empty
    public void clear();

    // Insert "it" at the current location
    // The client must ensure that the list's capacity is not exceeded
    public boolean insert(E it);

    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    public boolean append(E it);

    // Remove and return the current element
    public E remove();

    // Set the current position to the start of the list
    public void moveToStart();

    // Set the current position to the end of the list
    public void moveToEnd();

    // Move the current position one step left, no change if already at beginning
    public void prev();

    // Move the current position one step right, no change if already at end
    public void next();

    // Return the number of elements in the list
    public int length();

    // Return the position of the current element
    public int currPos();

    // Set the current position to "pos"
    public boolean moveToPos(int pos);

    // Return true if current position is at end of the list
    public boolean isAtEnd();

    // Return the current element
    public E getValue();
}

//package cmsc256;
//        import bridges.base.SLelement;
//        import bridges.connect.Bridges;
//        import bridges.connect.DataSource;
//        import bridges.data_src_dependent.Song;
//        import java.util.ArrayList;
//
//
//public class SongList implements cmsc256.List<Song> {
//    private SLelement<Song> head;
//    private SLelement<Song> tail;
//    private SLelement<Song> curr;
//    private int listSize;
//
//    public SongList() {
//        Bridges bridges = new Bridges(3, "nguyenms2", "386889807102");
//        clear();
//        DataSource ds = bridges.getDataSource();
//
//        listSize = 0;
//        ArrayList<Song> message = null;
//        try {
//            message = ds.getSongData();
//        } catch (Exception e) {
//            System.out.println("Unable to connect to Bridges.");
//        }
//        for (Song console : message) {
//            append(console);
//
//        }
//    }
//
//    @Override
//    public void clear() {
//        curr = tail = new SLelement<Song>();
//        head = new SLelement<Song>(tail);
//        listSize = 0;
//    }
//
//    @Override
//    public boolean insert(Song it) {
//        SLelement<Song> temp = new SLelement<>(it);
//        if (curr == head) {
//            temp.setNext(head);
//            listSize++;
//            return true;
//        }
//        curr.setNext(new SLelement<Song>(curr.getValue(), curr.getNext()));
//        curr.setValue(it);
//        if (tail == curr) {
//            tail = curr.getNext();
//        }
//        listSize++;
//        return true;
//    }
//
//    @Override
//    public boolean append(Song it) {
//        SLelement<Song> message = new SLelement<>(null);
//        tail.setNext(message);
//        tail.setValue(it);
//        tail = tail.getNext();
//        listSize++;
//        return true;
//    }
//
//    @Override
//    public Song remove() {
//        if (curr == tail) {
//            return null;
//        }
//        Song it = curr.getValue();
//        curr.setValue(curr.getNext().getValue());
//        if (curr.getNext().equals(tail)) {
//            curr.setNext(null);
//            tail = curr;
//        }
//        else {
//            curr.setNext(curr.getNext().getNext());
//        }
//        listSize--;
//        return it;
//    }
//
//    @Override
//    public void moveToStart() {
//        curr = head.getNext();
//    }
//
//    @Override
//    public void moveToEnd() {
//        curr = tail;
//
//    }
//    @Override
//    public void prev() {
//        if (head.getNext() == curr) {
//            return;
//        }
//        SLelement<Song> message = head;
//        while (message.getNext() != curr) {
//            message = message.getNext();
//        }
//        curr = message;
//    }
//
//    @Override
//    public void next() {
//        if (curr != tail) {
//            curr = curr.getNext();
//        }
//    }
//
//    @Override
//    public int length() {
//        return listSize;
//    }
//
//    @Override
//    public int currPos() {
//        SLelement<Song> temp = head.getNext();
//        int i;
//        for (i = 0; curr != temp; i++) {
//            temp = temp.getNext();
//        }
//        return i;
//    }
//
//    @Override
//    public boolean moveToPos(int pos) {
//        if ((pos < 0) || (pos > listSize)) {
//            return false;
//        }
//        for (int i = 0; i < pos; i++) {
//            curr = head.getNext();
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isAtEnd() {
//        return curr == tail;
//    }
//
//    @Override
//    public Song getValue() {
//        if (curr == tail) {
//            return null;
//        }
//        return curr.getValue();
//    }
//
//    public String getSongsByArtist(String artist) {
//        return artist;
//
//    }
//}