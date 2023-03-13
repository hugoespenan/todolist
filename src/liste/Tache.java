package liste;

import java.sql.*;

public class Tache {
    private String nom;
    private String description;
    private boolean est_realise;
    private int ref_type;
    private int ref_liste;
    Connection maco = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");


    public Tache(String nom, String description, boolean est_realise, int ref_type, int ref_liste) throws SQLException {
        this.nom = nom;
        this.description = description;
        this.est_realise = est_realise;
        this.ref_type = ref_type;
        this.ref_liste = ref_liste;
    }

    public void creerTache(String nom, String description, boolean est_realise,int ref_type, int ref_liste) throws SQLException {
        PreparedStatement crea = maco.prepareStatement("INSERT INTO liste (nom, description, est_realise, ref_liste, ref_type) VALUES (?,?,?,?,?)");
        crea.setString(1,nom);
        crea.setString(2,description);
        crea.setBoolean(3,est_realise);
        crea.setInt(4,ref_liste);
        crea.setInt(5,ref_type);
        crea.executeUpdate();
    }

    public String afficherTaches(int ref_liste)throws SQLException{
        PreparedStatement aff = maco.prepareStatement("SELECT nom, description, id_tache,ref_liste FROM tache WHERE ref_liste = ?");
        aff.setInt(1, ref_liste);
        ResultSet resultat = aff.executeQuery();
        String a = "";
        while (resultat.next()){
            a = a+"- Le nom de cette tache est "+resultat.getString(1)+" voici sa description "+resultat.getString(2)+" et son id "+resultat.getInt(3)+ " et la référence de sa liste est "+resultat.getInt(4)  +"\n";
        }
        return a;
    }

}
