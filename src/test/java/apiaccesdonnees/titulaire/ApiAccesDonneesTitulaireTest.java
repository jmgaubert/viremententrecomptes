package apiaccesdonnees.titulaire;

import apiaccesdonnees.solde.ApiAccesDonneesSolde;
import apiaccesdonnees.titulaire.ApiAccesDonneesTitulaire;
import informationlieecompte.solde.Solde;
import informationlieecompte.titulaire.Titulaire;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiAccesDonneesTitulaireTest {

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

    //ordonner les soldes

    @Test
    @DisplayName("récupération Titulaire associé au Compte version bouchonnee")
    @Order(1)
    public void recupere_titulaire_associe_au_compte_version_bouchonnee() {

        Titulaire titulaire1 = ApiAccesDonneesTitulaire.recupererTitulaireBouchonne("cptref00001");
        Titulaire titulaire2 = ApiAccesDonneesTitulaire.recupererTitulaireBouchonne("cptref00002");
        Titulaire titulaire3 = ApiAccesDonneesTitulaire.recupererTitulaireBouchonne("reference inconnue");

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
    @DisplayName("lecture fichier titulaire")
    @Order(2)
    public void lire_fichier_titulaire() {

        ApiAccesDonneesTitulaire.lireFichierSequentielTitulaire();
    }

    @Test
    @DisplayName("récupérer informations titulaire dans un fichier texte")
    @Order(3)
    public void recuperer_informations_titulaire_dans_un_fichier_texte() {

        Titulaire titulaire1 = ApiAccesDonneesTitulaire.recupererTitulaireAPartirFichier("cptref00001");
        Titulaire titulaire2 = ApiAccesDonneesTitulaire.recupererTitulaireAPartirFichier("cptref00002");
        Titulaire titulaire3 = ApiAccesDonneesTitulaire.recupererTitulaireAPartirFichier("reference inconnue");

        assertThat(titulaire1.getTitulaire()).isEqualTo("Antoine Dupond");
        assertThat(titulaire1.getAdresseMail()).isEqualTo("Antoine.Dupond@gmail.com");
        assertThat(titulaire2.getTitulaire()).isEqualTo("Valérie Labelle");
        assertThat(titulaire2.getAdresseMail()).isEqualTo("Valérie.Labelle@gmail.com");
        assertThat(titulaire3.getTitulaire()).isEqualTo("absence titulaire");
        assertThat(titulaire3.getAdresseMail()).isEqualTo("absence titulaire");

        titulaire1.afficherInformations();
        titulaire2.afficherInformations();
        titulaire3.afficherInformations();

    }

}
