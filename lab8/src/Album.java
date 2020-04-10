public class Album {
    private int id;
    private String name;
    private int artist_id;
    private int releaseYear;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public Album(int id, String name, int artist_id, int releaseYear) {
        this.id = id;
        this.name = name;
        this.artist_id = artist_id;
        this.releaseYear = releaseYear;
    }
}
