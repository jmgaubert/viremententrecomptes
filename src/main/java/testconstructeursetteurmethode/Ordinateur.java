package testconstructeursetteurmethode;

public class Ordinateur {
    private String marque;
    private String type;
    private Clavier clavier;
    private Processeur processeur;

    public Ordinateur() {
    }

    public Ordinateur(String marque, String type, Clavier clavier, Processeur processeur) {
        this.marque = marque;
        this.type = type;
        this.clavier = clavier;
        this.processeur = processeur;
    }

    public Ordinateur(String marque, String type, Clavier clavier) {
        this.marque = marque;
        this.type = type;
        this.clavier = clavier;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Clavier getClavier() {
        return clavier;
    }

    public void setClavier(Clavier clavier) {
        this.clavier = clavier;
    }

    public Processeur getProcesseur() {
        return processeur;
    }

    public void setProcesseur(Processeur processeur) {
        this.processeur = processeur;
    }

//    @Override
//    public String toString() {
    public String affichage() {
        return (marque+" "+type+" "+clavier.getMarque()+" "+clavier.getType()+" "+processeur.getMarque()+" "+processeur.getFrequence());
    }



}
