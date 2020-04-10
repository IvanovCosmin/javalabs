import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistController implements Dao<Artist> {

    private Database db;ArtistController() {
        db = new Database();
    }


    public void create(String name, String country) {
        try {
            Statement statement = db.getConnectionInstance().createStatement();
            statement.executeUpdate("insert into artists (NAME, COUNTRY) values ('" + name + "', '" + country +"')");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Artist> findByName(String name) {
        List<Artist> result = new ArrayList<>();
        try {
            Statement statement = db.getConnectionInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select id, country from artists where NAME='" + name + "'");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String country = resultSet.getString("country");
                result.add(new Artist(id, name, country));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<Artist> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Artist> getAll() {
        return null;
    }

    @Override
    public void save(Artist artist) {

    }

    @Override
    public void update(Artist artist, String[] params) {

    }

    @Override
    public void delete(Artist artist) {

    }
}
