package apiecrituredonnees.solde;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiEcritureDonneesSolde {

    public static void EcrireSoldeDansFichier(String referenceCompte, double montantSolde) {

        Path fichier = Paths.get("src/fichiersoldes"+referenceCompte+".txt");
        PrintWriter fichierSortie = null;

        try {
            fichierSortie = new PrintWriter(String.valueOf(fichier));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        fichierSortie.println(referenceCompte+";"+String.valueOf(montantSolde));
        fichierSortie.close();
    }
}



