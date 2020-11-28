package apiaccesdonnees;

import compte.solde.Solde;
import compte.titulaire.Titulaire;

public class ApiAccesDonnees {
    //classe ne possédant pas d'attributs
    //classe ne contenant que des méthodes static de type "utilitaires API" --> appelable sans instanciation de la classe

    public static Titulaire recupererTitulaire(String referenceCompte){

        String adresseMail;
        String nom;

        switch(referenceCompte)
        {
            //bouchonnage donc ...... pas cible du tout
            case "cptref00001":
                nom = "Antoine Dupond";
                adresseMail = "Antoine.Dupond@gmail.com";
                break;
            case "cptref00002":
                nom = "Valérie Labelle";
                adresseMail = "Valérie.Labelle@gmail.com";
                break;
            default:
                nom = "absence nom";
                adresseMail = "absence adresse";
        }
        //definir gestion de titulaire non trouve
        return new Titulaire(nom,referenceCompte,adresseMail);
    }

    public static Solde recupererSolde(String referenceCompte){

        double montantSolde;

        switch(referenceCompte)
        {
            //bouchonnage donc ...... pas cible du tout
            case "cptref00001":
                montantSolde = (double) 3790.14;
                break;
            case "cptref00002":
                montantSolde = (double) -145.32;
                break;
            default:
                montantSolde = 0;
        }
        //definir gestion de solde non trouve
        return new Solde(referenceCompte,montantSolde);
    }
}
