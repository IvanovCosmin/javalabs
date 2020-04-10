import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class main {
    public static void main(String[] args) {

        ArtistController artistController = new ArtistController();
        artistController.create("Adrian", "TaraMetalului");
        List<Artist> marians = artistController.findByName("Marian");
        for (Artist artist: marians
             ) {
            System.out.println(artist.getName());
        }

        System.out.println("Albume:");

        AlbumController albumController = new AlbumController();
        //albumController.create("Cum mi-am pierdut piticul", 2, 1999);
        List<Album> albums = albumController.findByArtist(2);

        for (Album album: albums
             ) {
            System.out.println(album.getName());
        }
        Database db = new Database();

        try {
            db.getConnectionInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
