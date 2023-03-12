import Utilisateur.Utilisateur;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int connected = 0;
        Scanner scanner = new Scanner(System.in);
        Connection maco = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
        while (connected == 0) {
            System.out.println("Etes vous inscrit : (O)ui/(N)on");
            String choix = scanner.nextLine().toUpperCase();
            while (!choix.equals("O") && !choix.equals("N")) {
                System.out.println("Veuillez entrez O pour oui et N pour non");
                choix = scanner.nextLine().toUpperCase();
            }
            Utilisateur co = new Utilisateur();
            if (choix.equals("O")) {
                connected = co.connexion();
            }
            if (choix.equals("N")) {
                co.inscription();
            }
        }
        while (connected == 1) {
            System.out.println("Vous êtes connecté");
            System.out.println("------------Menu principal, que souhaitez vous faire ?------------");
            System.out.println("-(C)réer une liste");
            System.out.println("-(G)érer une liste");
            System.out.println("-(GE)rer une tâche");
            System.out.println("-(A)fficher mes listes");
            System.out.println("-(AF)ficher les tâches d'une de mes liste");
            System.out.println("-(AFF)icher une tâche");
            String nchoix = scanner.nextLine().toUpperCase();
            if (nchoix.equals("C")){

            }
        }


    }
}