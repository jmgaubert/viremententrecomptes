package apiaccesdonnees;

import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiAccesDonnees {
    //classe ne possédant pas d'attributs
    //classe ne contenant que des méthodes static de type "utilitaires API" --> appelable sans instanciation de la classe

    public static Titulaire recupererTitulaireBouchonne(String referenceCompte) {

        String adresseMail;
        String nom;

        switch (referenceCompte) {
            //bouchonnage donc ...... pas cible du tout... implementer le bouchon à partir d'un fichier texte
            case "cptref00001":
                nom = "Antoine Dupond";
                adresseMail = "Antoine.Dupond@gmail.com";
                break;
            case "cptref00002":
                nom = "Valérie Labelle";
                adresseMail = "Valérie.Labelle@gmail.com";
                break;
            default:
                nom = "absence titulaire";
                adresseMail = "absence titulaire";
        }
        //definir gestion de titulaire non trouve
        return new Titulaire(nom, referenceCompte, adresseMail);
    }

    public static Solde recupererSolde(String referenceCompte) {

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

    public static void lireFichierSequentiel() {
        Path fichier = Paths.get("src/listetitulaires.txt");
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

    public static Titulaire recupererTitulaireAPartirFichier(String referenceCompte) {

        String adresseMail;
        String nom;
        boolean titulaireNonTrouve = true;
        String[] result = null;

        Path fichier = Paths.get("src/listetitulaires.txt");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = Files.newBufferedReader(fichier);
            String ligne = null;
            while (((ligne = bufferedReader.readLine()) != null) && titulaireNonTrouve) {
//                System.out.println(ligne);
                result = ligne.split(";");
//                System.out.println("cle fichier titulaire : " + result[0]+" reference cherchee : "+ referenceCompte);
                if (result[0].equals(referenceCompte)) {
//                    System.out.println(referenceCompte + " trouve");
                    titulaireNonTrouve = false;
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

        if (titulaireNonTrouve) {
            return new Titulaire("absence titulaire", referenceCompte, "absence titulaire");
        } else {
            return new Titulaire(result[1], referenceCompte, result[2]);
        }

    }
}
