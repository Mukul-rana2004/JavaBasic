import java.util.ArrayList;
import java.util.List;

abstract class MediaItem {
    private String title;
    private double duration;

    public MediaItem(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public abstract void play();
}

class Song extends MediaItem {
    private String artist;
    private String genre;

    public Song(String title, double duration, String artist, String genre) {
        super(title, duration);
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + getTitle() + " by " + artist);
    }
}

class Podcast extends MediaItem {
    private String host;
    private int episodeNumber;

    public Podcast(String title, double duration, String host, int episodeNumber) {
        super(title, duration);
        this.host = host;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Playing podcast episode " + episodeNumber +
                " of " + getTitle());
    }
}

class Playlist {
    private List<MediaItem> items;

    public Playlist() {
        items = new ArrayList<>();
    }

    public void addItem(MediaItem item) {
        items.add(item);
    }

    public void removeItem(String title) {
        items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
    }

    public void playAll() {
        for (MediaItem item : items) {
            item.play();
        }
    }
}
public class Exp2{
    public static void main(String[] args) {
        Song s1 = new Song("A", 3.5, "Mukul", "Pop");
        Song s2 = new Song("B", 3.2, "Ashu", "Rock");
        Podcast p1 = new Podcast("X", 15.0, "Rishu", 5);
        Podcast p2 = new Podcast("Y", 20.0, "Sarthak", 2);
        Playlist playlist = new Playlist();
        playlist.addItem(s1);
        playlist.addItem(s2);
        playlist.addItem(p1);
        playlist.addItem(p2);
        playlist.removeItem("A");
        playlist.playAll();
    }
}
