import java.util.Arrays;

class Experiment7 {
    private final String[] songs;
    private int songCount;

    public Experiment7(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    public boolean addSong(String songTitle) {
        if (songTitle != null && this.songCount < this.songs.length) {
            this.songs[this.songCount] = songTitle;
            this.songCount++;
            return true;
        }
        return false;
    }

    public String[] getSongs() {
        // Return a safe copy of the array with only added songs
        return Arrays.copyOf(this.songs, this.songCount);
    }

    public int getSongCount() {
        return this.songCount;
    }

    public static void main(String[] args) {
        Experiment7 p = new Experiment7(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Modify the returned copy

        // The original playlist remains unchanged
        System.out.println("Original first song: " + p.getSongs()[0]); // Song A
        System.out.println("Song count: " + p.getSongCount()); // 2
    }
}