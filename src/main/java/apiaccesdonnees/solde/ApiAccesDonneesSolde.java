package apiaccesdonnees.solde;

import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiAccesDonneesSolde {

    public static Solde recupererSolde(String referenceCompte) {
        //mettre des displays pour vérifier que c'est bien même adresse et pas création d'objet intermédiaire
         return recupererSoldeAPartirFichier(referenceCompte);
    }

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

    public static void lireFichierSequentielSolde() {
        Path fichier = Paths.get("src/fichiersoldes.txt");
        BufferedReader bufferedReader = null;
        boolean fichierExiste = Files.exists(fichier);
//        if (fichierExiste){
//            System.out.println("fichier existe");
//        }
//        else{
//            System.out.println("fichier n'existe pas");
//        }
        try {
            bufferedReader = Files.newBufferedReader(fichier);
            String ligne = null;
            while ((ligne = bufferedReader.readLine()) != null) {
                System.out.println(ligne);
                String[] result = ligne.split(";");
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static Solde recupererSoldeAPartirFichier(String referenceCompte) {

        double montantSolde;
        boolean soldeNonTrouve = true;
        String[] result = null;

        Path fichier = Paths.get("src/fichiersoldes.txt");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = Files.newBufferedReader(fichier);
            String ligne = null;
            while (((ligne = bufferedReader.readLine()) != null) && soldeNonTrouve) {
//                System.out.println(ligne);
                result = ligne.split(";");
//                System.out.println("cle fichier solde : " + result[0]+" reference cherchee : "+ referenceCompte);
                if (result[0].equals(referenceCompte)) {
//                    System.out.println(referenceCompte + " trouve");
                    soldeNonTrouve = false;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (soldeNonTrouve) {
            return new Solde(referenceCompte, 0);
        } else {
            return new Solde(referenceCompte, Double.valueOf(result[1]));
        }

    }
}


