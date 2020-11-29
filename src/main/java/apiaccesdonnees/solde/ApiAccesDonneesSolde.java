package apiaccesdonnees.solde;

import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiAccesDonneesSolde {

    public static Solde recupererSoldeBouchonne(String referenceCompte) {

        double montantSolde;

        switch (referenceCompte) {
            //bouchonnage donc ...... pas cible du tout
            case "cptref00001":
                montantSolde = 3790.14;
                break;
            case "cptref00002":
                montantSolde = -145.32;
                break;
            default:
                montantSolde = 0;
        }
        //definir gestion de solde non trouve  implementer le bouchon à partir d'un fichier texte
        return new Solde(referenceCompte, montantSolde);
    }
}


