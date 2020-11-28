package informationlieecompte.titulaire;

import informationlieecompte.InformationLieeCompte;
import informationlieecompte.compte.Compte;

public class Titulaire extends InformationLieeCompte {
    String titulaire;
    String adresseMail;

    public Titulaire(String titulaire, String reference, String adresseMail) {
        super(reference);
        this.titulaire = titulaire;
        this.adresseMail = adresseMail;
    }

    public String getTitulaire() {

        return titulaire;
    }

    public String getAdresseMail() {

        return adresseMail;
    }

    public void afficherInformations() {

        System.out.println("Compte : " + reference + " Titulaire : " + titulaire + " Adresse Mail : "+adresseMail);

    }
}