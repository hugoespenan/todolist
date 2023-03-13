package liste;

public class Tache {
    private String nom;
    private String description;
    private boolean est_realise;
    private int ref_type;
    private int ref_liste;


    public Tache(String nom, String description, boolean est_realise, int ref_type, int ref_liste){
        this.nom = nom;
        this.description = description;
        this.est_realise = est_realise;
        this.ref_type = ref_type;
        this.ref_liste = ref_liste;
    }



}
