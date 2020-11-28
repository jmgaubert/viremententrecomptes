package informationlieecompte.compte;

import informationlieecompte.InformationLieeCompte;

import java.time.LocalDate;

public class Compte extends InformationLieeCompte {

    LocalDate dateOuverture;

    public Compte(String reference, LocalDate dateOuverture) {
        super(reference);
        this.dateOuverture = dateOuverture;
    }

    public void afficherInformations() {

        System.out.println("Compte : " + reference + " date ouverture : " + dateOuverture);
    }

}
