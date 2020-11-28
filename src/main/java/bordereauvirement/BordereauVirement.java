package bordereauvirement;

import apiaccesdonnees.ApiAccesDonnees;
import compte.mouvement.Mouvement;
import compte.solde.Solde;
import compte.titulaire.Titulaire;

import java.time.LocalDate;

public class BordereauVirement {

    String referenceVirement;
    String referenceCompteEmetteur;
    String referenceCompteRecepteur;
    LocalDate dateVirement;
    double montant;
    String libelle;
    boolean informationBeneficiaire;

    public BordereauVirement(String referenceVirement,
                             String referenceCompteEmetteur,
                             String referenceCompteRecepteur,
                             LocalDate dateVirement, double montant,
                             String libelle, boolean informationBeneficiaire) {
        this.referenceVirement = referenceVirement;
        this.referenceCompteEmetteur = referenceCompteEmetteur;
        this.referenceCompteRecepteur = referenceCompteRecepteur;
        this.dateVirement = dateVirement;
        this.montant = montant;
        this.libelle = libelle;
        this.informationBeneficiaire = informationBeneficiaire;
    }

    public void afficherInformations() {

        System.out.println("Bordereau Virement : "
                + referenceVirement + " : "
                + referenceCompteEmetteur + " --> "
                + referenceCompteRecepteur + " : "
                + dateVirement + " : "
                + montant + " : "
                + libelle + " : informer le beneficiaire : "
                + informationBeneficiaire);
    }

    public void executerBordereauVirement() {
        System.out.println("executer bordereau virement");

        Titulaire titulaireCompteEmetteur = ApiAccesDonnees.recupererTitulaire("cptref00001");
        Titulaire titulaireCompteRecepteur = ApiAccesDonnees.recupererTitulaire("cptref00002");

        Solde soldeCompteEmetteur = ApiAccesDonnees.recupererSolde("cptref00001");
        Solde soldeCompteRecepteur = ApiAccesDonnees.recupererSolde("cptref00002");

        System.out.println(titulaireCompteEmetteur);
        titulaireCompteEmetteur.afficherInformations();
        System.out.println(titulaireCompteRecepteur);
        titulaireCompteRecepteur.afficherInformations();
        System.out.println(soldeCompteEmetteur);
        soldeCompteEmetteur.afficherInformations();
        System.out.println(soldeCompteRecepteur);
        soldeCompteRecepteur.afficherInformations();

        Mouvement mouvementVirementEmetteur = new Mouvement(referenceCompteEmetteur,
                dateVirement,
                dateVirement.minusDays(1),
                (double) montant * -1,
                libelle+ " à destination de "+titulaireCompteRecepteur.getTitulaire());
        mouvementVirementEmetteur.afficherInformations();

        Mouvement mouvementVirementRecepteur = new Mouvement(referenceCompteRecepteur,
                dateVirement,
                dateVirement.plusDays(1),
                montant,
                libelle+" de la part de "+titulaireCompteEmetteur.getTitulaire());
        mouvementVirementRecepteur.afficherInformations();

        System.out.println("soldes après virement");
        soldeCompteEmetteur.ajouterASolde(mouvementVirementEmetteur);
        soldeCompteEmetteur.afficherInformations();
        soldeCompteRecepteur.ajouterASolde(mouvementVirementRecepteur);
        soldeCompteRecepteur.afficherInformations();

        informerBeneficiaire(titulaireCompteRecepteur,mouvementVirementRecepteur);

    }

    public void informerBeneficiaire(Titulaire titulaireCompteRecepteur, Mouvement mouvementVirementRecepteur){

        System.out.println(titulaireCompteRecepteur.getAdresseMail()+" vous avez reçu un virement de :"
                +mouvementVirementRecepteur.getMontant()+" "+mouvementVirementRecepteur.getLibelle());


    }
    ////        //recherche titulaire du compte emetteur
//        String nomTitulaireCompteEmetteur = "Antoine Dupond";
//        String adresseMailTitulaireCompteEmetteur = "Antoine.Dupond@gmail.com";
//        Titulaire titulaireCompteEmetteur = new Titulaire(nomTitulaireCompteEmetteur,
//                referenceCompteEmetteur,adresseMailTitulaireCompteEmetteur);
//        titulaireCompteEmetteur.afficherInformations();
//        //recherche titulaire du compte recepteur
//        String nomTitulaireCompteRecepteur = "Valérie Labelle";
//        String adresseMailTitulaireCompteRecepteur = "Valérie.Labelle@gmail.com";
//        Titulaire titulaireCompteRecepteur = new Titulaire(nomTitulaireCompteRecepteur,
//                referenceCompteRecepteur,adresseMailTitulaireCompteRecepteur);
//        titulaireCompteRecepteur.afficherInformations();
///////
//        System.out.println("soldes avant virement");
//        //verification/récuperation du solde associé au compte emetteur
//        //on suppose que solde du compte emetteur est à 3790.14
//        double montantSoldeEmetteur = (double) 3790.14;
//        Solde soldeCompteEmetteur = new Solde(referenceCompteEmetteur, montantSoldeEmetteur);
//        soldeCompteEmetteur.afficherInformations();
//        //verification/récuperation du solde associé au compte recepteur
//        //on suppose que solde du compte recepteur est à -145.32
//        double montantSoldeRecepteur = (double) -145.32;
//        Solde soldeCompteRecepteur = new Solde(referenceCompteRecepteur, montantSoldeRecepteur);
//        soldeCompteRecepteur.afficherInformations();





}

