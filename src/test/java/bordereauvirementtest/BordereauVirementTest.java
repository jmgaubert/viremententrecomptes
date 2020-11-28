package bordereauvirementtest;

import bordereauvirement.BordereauVirement;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class BordereauVirementTest {

    @BeforeAll
    static void beforeALL(){
        System.out.println("début session test sur bordereau virement");
    }

    @AfterAll
    static void afterALL(){
        System.out.println("fin session test sur bordereau virement");
    }

    long timeAtStart;

    @BeforeEach
    void timeAvant(){
        timeAtStart = System.currentTimeMillis();
    }

    @AfterEach
    void timeApres(){
        long timeAtEnd = System.currentTimeMillis();
        System.out.println("ce test a pris "+(timeAtEnd-timeAtStart));
    }

    @Test
    @DisplayName("test sur traitement bordereau virement")
    public void bordereauDeVirement() {

        String referenceVirementRecu = "virement 0001";
        String referenceCompteEmetteurRecu = "cptref00001";
        String referenceCompteRecepteurRecu = "cptref00002";
        LocalDate dateVirementRecu = LocalDate.of(2020,11,20);
        double montantRecu = 1550.53;
        String libelleRecu = "virement pour anniversaire";
        boolean informationBeneficiaireRecu = true;

        BordereauVirement bordereauVirement = new BordereauVirement(
                referenceVirementRecu,
                referenceCompteEmetteurRecu,
                referenceCompteRecepteurRecu,
                dateVirementRecu,
                montantRecu,
                libelleRecu,
                informationBeneficiaireRecu);


//        //recherche titulaire du compte emetteur
//        String nomTitulaireCompteEmetteur = "Antoine Dupond";
//        String adresseMailTitulaireCompteEmetteur = "Antoine.Dupond@gmail.com";
//        Titulaire titulaireCompteEmetteur = new Titulaire(nomTitulaireCompteEmetteur,
//                referenceCompteEmetteurRecu,adresseMailTitulaireCompteEmetteur);
//        titulaireCompteEmetteur.afficherInformations();


        bordereauVirement.afficherInformations();
        bordereauVirement.executerBordereauVirement();

        //.............................................................
        //montant mouvement compte emetteur = montant bordereau virement
        //montant mouvement compte recepteur = montant bordereau virement multiplié par -1
        //date opération mouvement compte emetteur = date virement bordereau virement
        //date opération mouvement compte récepteur = date virement bordereau virement
        //date valeur mouvement compte emetteur = date virement bordereau virement - 1 jour calandaire
        //date valeur mouvement compte récepteur = date virement bordereau virement + 1 jour calandaire
        //libelle mouvement compte emetteur on retrouve le libellé du virement
        //libelle mouvement compte recepteur on retrouve le libellé du virement
        //solde compte emetteur après virement = solde compte emetteur avant virement - montant mouvement compte emetteur
        //.............................. on y retrouve les spesc


//        System.out.println("projet pilote tenue de position");
//        referenceVirementRecu = "virement 0001";
//        referenceCompteEmetteurRecu = "cptref00001";
//        referenceCompteRecepteurRecu = "cptref00002";
//        dateVirementRecu = LocalDate.of(2020,11,20);
//        montantRecu = (double) 1550.53;
//        libelleRecu = "virement pour anniversaire";
//        informationBeneficiaireRecu = true;
        /* simule la zone de donnee recue de la transaction (par ex) */


//        String nomTitulaireCompteEmetteur = "Antoine Dupond";
//        String adresseMailTitulaireCompteEmetteur = "Antoine.Dupond@gmail.com";
//        Titulaire titulaireCompteEmetteur = new Titulaire(nomTitulaireCompteEmetteur,
//                referenceCompteEmetteurRecu,adresseMailTitulaireCompteEmetteur);
//        titulaireCompteEmetteur.afficherInformations();
//        //recherche titulaire du compte recepteur
//        String nomTitulaireCompteRecepteur = "Valérie Labelle";
//        String adresseMailTitulaireCompteRecepteur = "Valérie.Labelle@gmail.com";
//        Titulaire titulaireCompteRecepteur = new Titulaire(nomTitulaireCompteRecepteur,
//                referenceCompteRecepteurRecu,adresseMailTitulaireCompteRecepteur);
//        titulaireCompteRecepteur.afficherInformations();

        //GIVEN
        //THEN
        assertThat(montantRecu);

    }



}
