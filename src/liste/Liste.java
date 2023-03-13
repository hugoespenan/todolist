package liste;

import Utilisateur.Utilisateur;

import java.sql.*;
import java.util.ArrayList;

public class Liste {
    private ArrayList<Tache> laliste = new ArrayList<Tache>();
    Connection maco = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");

    public Liste() throws SQLException {
    }


    public void creerliste(String nom, String description) throws SQLException {
        PreparedStatement crea = maco.prepareStatement("INSERT INTO liste (nom, description) VALUES (?,?)");
        crea.setString(1,nom);
        crea.setString(2,description);
        crea.executeUpdate();
    }
    public String afficherlistes(int id_utili)throws SQLException{
        PreparedStatement aff = maco.prepareStatement("SELECT nom, description, id_liste FROM liste WHERE ref_utilisateur = ?");
        aff.setInt(1, id_utili);
        ResultSet resultat = aff.executeQuery();
        String a = "";
        while (resultat.next()){
            a = a+"- Le nom de cette liste est "+resultat.getString(1)+" voici sa description "+resultat.getString(2)+" et son id "+resultat.getInt(3)+"\n";
        }
        return a;
    }
    public void ajouterTache(String nom, String description, boolean est_realise, int ref_type, int ref_liste)throws SQLException{
        laliste.add(new Tache(nom, description, est_realise, ref_type, ref_liste));
    }
}
