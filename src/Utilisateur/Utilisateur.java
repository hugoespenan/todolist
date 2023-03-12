package Utilisateur;

import java.sql.*;
import java.util.Scanner;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    Scanner scanner = new Scanner(System.in);
    Connection maco = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");

    public Utilisateur() throws SQLException {
    }

    public int connexion() throws SQLException {
        int connected = 0;
        System.out.println("---------Connectez-vous---------");
        System.out.println("Votre login : ");
        String login = scanner.nextLine();
        System.out.println("Votre mdp : ");
        String mdp = scanner.nextLine();
        PreparedStatement connexionrequ = maco.prepareStatement("SELECT * FROM utilisateur WHERE login = ? and mdp = ?");
        connexionrequ.setString(1, login);
        connexionrequ.setString(2, mdp);
        ResultSet res = connexionrequ.executeQuery();

        if (res.next()) {
            connected = 1;
        }
        return connected;
    }

    public void inscription() throws SQLException {
        System.out.println("-----------Inscrivez vous-----------");
        System.out.println("Votre nom");
        String nom = scanner.nextLine();
        System.out.println("Votre prenom");
        String prenom = scanner.nextLine();
        System.out.println("Votre login");
        String login = scanner.nextLine();
        System.out.println("Votre mdp");
        String mdp = scanner.nextLine();
        if (!nom.isEmpty() && !prenom.isEmpty() && !login.isEmpty() && !mdp.isEmpty()) {
            PreparedStatement inscription = maco.prepareStatement("INSERT INTO utilisateur (nom, prenom, login, mdp) VALUES (?,?,?,?)");
            inscription.setString(1, nom);
            inscription.setString(2, prenom);
            inscription.setString(3, login);
            inscription.setString(4, mdp);
            inscription.executeUpdate();
        } else {
            System.out.println("Il manque un ou plusieurs champs à remplir");
        }
    }


}
