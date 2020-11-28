package bordereauvirement;

import apiaccesdonnees.ApiAccesDonnees;
import informationlieecompte.mouvement.Mouvement;
import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;

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

//        Titulaire titulaireCompteEmetteur = ApiAccesDonnees.recupererTitulaireBouchonne("cptref00001");
//        Titulaire titulaireCompteRecepteur = ApiAccesDonnees.recupererTitulaireBouchonne("cptref00002");
        Titulaire titulaireCompteEmetteur = ApiAccesDonnees.recupererTitulaireAPartirFichier("cptref00001");
        Titulaire titulaireCompteRecepteur = ApiAccesDonnees.recupererTitulaireAPartirFichier("cptref00002");

        Solde soldeCompteEmetteur = ApiAccesDonnees.recupererSolde("cptref00001");
        Solde soldeCompteRecepteur = ApiAccesDonnees.recupererSolde("cptref00002");

        Mouvement mouvementVirementEmetteur = new Mouvement(referenceCompteEmetteur,
                dateVirement,
                dateVirement.minusDays(1),
                (double) montant * -1,
                libelle + " à destination de " + titulaireCompteRecepteur.getTitulaire());

        Mouvement mouvementVirementRecepteur = new Mouvement(referenceCompteRecepteur,
                dateVirement,
                dateVirement.plusDays(1),
                montant,
                libelle + " de la part de " + titulaireCompteEmetteur.getTitulaire());

        //print
        System.out.println("executer bordereau virement");
//        System.out.println(titulaireCompteEmetteur);
        titulaireCompteEmetteur.afficherInformations();
//        System.out.println(titulaireCompteRecepteur);
        titulaireCompteRecepteur.afficherInformations();
//        System.out.println(soldeCompteEmetteur);
        soldeCompteEmetteur.afficherInformations();
//        System.out.println(soldeCompteRecepteur);
        soldeCompteRecepteur.afficherInformations();
        mouvementVirementEmetteur.afficherInformations();
        mouvementVirementRecepteur.afficherInformations();
        //print

        soldeCompteEmetteur.ajouterASolde(mouvementVirementEmetteur);
        soldeCompteRecepteur.ajouterASolde(mouvementVirementRecepteur);

        //print
        System.out.println("soldes après virement");
        soldeCompteEmetteur.afficherInformations();
        soldeCompteRecepteur.afficherInformations();
        //print

        informerBeneficiaire(titulaireCompteRecepteur, mouvementVirementRecepteur);

    }

    public void informerBeneficiaire(Titulaire titulaireCompteRecepteur, Mouvement mouvementVirementRecepteur) {

        System.out.println(titulaireCompteRecepteur.getAdresseMail() + " vous avez reçu un virement de :"
                + mouvementVirementRecepteur.getMontant() + " " + mouvementVirementRecepteur.getLibelle());


    }

}

