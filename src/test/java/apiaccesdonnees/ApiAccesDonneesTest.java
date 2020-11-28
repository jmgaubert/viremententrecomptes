package apiaccesdonnees;

import compte.solde.Solde;
import compte.titulaire.Titulaire;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiAccesDonneesTest {

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
//        System.out.println("ce test a durer " + (timeAtEndMethod - timeAtStartMethod) + " ms");
    }

    //ordonner les soldes

    @Test
    @DisplayName("récupération Titulaire associé au Compte")
    @Order(1)
    public void recupere_titulaire_associe_au_compte() {

        Titulaire titulaire1 = ApiAccesDonnees.recupererTitulaire("cptref00001");
        Titulaire titulaire2 = ApiAccesDonnees.recupererTitulaire("cptref00002");
        Titulaire titulaire3 = ApiAccesDonnees.recupererTitulaire("reference inconnue");

        assertThat(titulaire1.getTitulaire()).isEqualTo("Antoine Dupond");
        assertThat(titulaire1.getAdresseMail()).isEqualTo("Antoine.Dupond@gmail.com");
        assertThat(titulaire2.getTitulaire()).isEqualTo("Valérie Labelle");
        assertThat(titulaire2.getAdresseMail()).isEqualTo("Valérie.Labelle@gmail.com");
        assertThat(titulaire3.getTitulaire()).isEqualTo("absence titulaire");
        assertThat(titulaire3.getAdresseMail()).isEqualTo("absence titulaire");

//        System.out.println(titulaire1);
//        titulaire1.afficherInformations();
//        System.out.println(titulaire2);
//        titulaire2.afficherInformations();
//        System.out.println(titulaire3);
//        titulaire3.afficherInformations();

    }

    @Test
    @DisplayName("récupération Solde associé au Compte")
    @Order(2)
    public void recupere_solde_associe_au_compte() {

        Solde solde1 = ApiAccesDonnees.recupererSolde("cptref00001");
        Solde solde2 = ApiAccesDonnees.recupererSolde("cptref00002");
        Solde solde3 = ApiAccesDonnees.recupererSolde("reference inconnue");

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

}
