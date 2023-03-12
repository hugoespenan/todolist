package liste;

import java.sql.*;

public class Liste {
    private String nom;
    private String description;
    private Tache tache;
    Connection maco = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");

    public Liste() throws SQLException {
    }


    public void creerliste(String nom, String description) throws SQLException {
        PreparedStatement crea = maco.prepareStatement("INSERT INTO liste (nom, description) VALUES (?,?)");
        crea.setString(1,nom);
        crea.setString(2,description);
        crea.executeUpdate();
    }
}
