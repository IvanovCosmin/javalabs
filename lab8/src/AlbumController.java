import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumController implements Dao<Album> {

    private Database db;

    AlbumController () {
        db = new Database();
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            Statement statement = db.getConnectionInstance().createStatement();
            statement.executeUpdate("insert into albums (NAME, ARTIST_ID, RELEASE_YEAR) values ('" + name + "', '" + artistId + "', '" + releaseYear +"')");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Album> findByArtist(int artistId) {
        List<Album> result = new ArrayList<>();
        try {
            Statement statement = db.getConnectionInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from albums where artist_id=" + artistId + "");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("ID");
                int releaseYear = resultSet.getInt("release_year");
                result.add(new Album(id, name, artistId, releaseYear));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<Album> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Album> getAll() {
        return null;
    }

    @Override
    public void save(Album album) {

    }

    @Override
    public void update(Album album, String[] params) {

    }

    @Override
    public void delete(Album album) {

    }
}
