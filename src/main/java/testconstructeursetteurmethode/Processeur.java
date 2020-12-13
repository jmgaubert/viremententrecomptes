package testconstructeursetteurmethode;

public class Processeur {
    private String marque;
    private int    frequence;

    public Processeur() {
    }

    public Processeur(String marque, int frequence) {
        this.marque = marque;
        this.frequence = frequence;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
