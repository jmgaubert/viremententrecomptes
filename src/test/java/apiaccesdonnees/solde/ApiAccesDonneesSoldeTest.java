package apiaccesdonnees.solde;

import apiaccesdonnees.titulaire.ApiAccesDonneesTitulaire;
import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiAccesDonneesSoldeTest {
    @BeforeAll
    static void beforeALL() {
        System.out.println("début session test sur API accès aux données");
    }

    @AfterAll
    static void afterALL() {
        System.out.println("fin session test sur API accès aux données");
    }

    public long timeAtStartMethod;
    public long timeAtEndMethod;

    @BeforeEach
    void timeAvant() {
        timeAtStartMethod = System.currentTimeMillis();
    }


    @AfterEach
    void timeApres() {
        timeAtEndMethod = System.currentTimeMillis();
        System.out.println("ce test a durer " + (timeAtEndMethod - timeAtStartMethod) + " ms");
    }
    @Test
    @DisplayName("récupération Solde associé au Compte version bouchonnee")
    @Order(1)
    public void recupere_solde_associe_au_compte_version_bouchonnee() {

        Solde solde1 = ApiAccesDonneesSolde.recupererSoldeBouchonne("cptref00001");
        Solde solde2 = ApiAccesDonneesSolde.recupererSoldeBouchonne("cptref00002");
        Solde solde3 = ApiAccesDonneesSolde.recupererSoldeBouchonne("reference inconnue");

        assertThat(solde1.getSolde()).isEqualTo((double) 3790.14);
        assertThat(solde2.getSolde()).isEqualTo((double) -145.32);
        assertThat(solde3.getSolde()).isEqualTo((double) 0);

//        System.out.println(solde1);
//        solde1.afficherInformations();
//        System.out.println(solde2);
//        solde2.afficherInformations();
//        System.out.println(solde3);
//        solde3.afficherInformations();
    }

    @Test
    @DisplayName("lecture fichier solde")
    @Order(2)
    public void lire_fichier_solde() {

        ApiAccesDonneesSolde.lireFichierSequentielSolde();
    }

    @Test
    @DisplayName("récupérer informations solde dans un fichier texte")
    @Order(3)
    public void recuperer_informations_solde_dans_un_fichier_texte() {

        Solde solde1 = ApiAccesDonneesSolde.recupererSoldeAPartirFichier("cptref00001");
        Solde solde2 = ApiAccesDonneesSolde.recupererSoldeAPartirFichier("cptref00002");
        Solde solde3 = ApiAccesDonneesSolde.recupererSoldeAPartirFichier("reference inconnue");

        assertThat(solde1.getSolde()).isEqualTo((double) 3790.14);
        assertThat(solde2.getSolde()).isEqualTo((double) -145.32);
        assertThat(solde3.getSolde()).isEqualTo((double) 0);

//        solde1.afficherInformations();
//        solde2.afficherInformations();
//        solde3.afficherInformations();

    }

    @Test
    @DisplayName("récupérer informations solde version INTERFACE isolation")
    @Order(4)
    public void recuperer_informations_solde_version_interface_isolation() {

        Solde solde1 = ApiAccesDonneesSolde.recupererSolde("cptref00001");
        Solde solde2 = ApiAccesDonneesSolde.recupererSolde("cptref00002");
        Solde solde3 = ApiAccesDonneesSolde.recupererSolde("reference inconnue");

        assertThat(solde1.getSolde()).isEqualTo((double) 3790.14);
        assertThat(solde2.getSolde()).isEqualTo((double) -145.32);
        assertThat(solde3.getSolde()).isEqualTo((double) 0);

//        solde1.afficherInformations();
//        solde2.afficherInformations();
//        solde3.afficherInformations();

    }

}
