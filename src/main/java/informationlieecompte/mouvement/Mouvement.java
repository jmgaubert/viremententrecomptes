package informationlieecompte.mouvement;

import informationlieecompte.InformationLieeCompte;

import java.time.LocalDate;

public class Mouvement extends InformationLieeCompte {

    String referenceMouvement;
    double montant;
    LocalDate dateOperation;
    LocalDate dateValeur;
    String libelle;

    public Mouvement(String reference,
                     LocalDate dateOperation,
                     LocalDate dateValeur,
                     double montant,
                     String libelle) {
        super(reference);
        this.dateOperation = dateOperation;
        this.dateValeur = dateValeur;
        this.montant = montant;
        this.libelle = libelle;
        referenceMouvement = "reference mouvement à définir";
    }

    public String getLibelle() {
        return libelle;
    }

    public double getMontant() {
        return montant;
    }

    public void afficherInformations() {

        System.out.println("Mouvement : "
                + reference + " :"
                + referenceMouvement + " : "
                + dateOperation + " : "
                + dateValeur + " : "
                + montant + " : "
                + libelle);

    }

}

