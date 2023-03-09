package demorepo;

import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, LinkedList<String>> store; // Map of user to their recently played songs

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
      
        
        System.out.println("Songs");
    }

    public void addSong(String user, String song) {
        LinkedList<String> songs = store.get(user);
        if (songs == null) {
            songs = new LinkedList<>();
            store.put(user, songs);
        }
        songs.remove(song);
        songs.addFirst(song);
        if (songs.size() > capacity) {
            songs.removeLast();
        }
    }

    public List<String> getRecentSongs(String user) {
        LinkedList<String> songs = store.get(user);
        if (songs == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(songs);
        
    }
}