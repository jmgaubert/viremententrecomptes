package apiaccesdonnees;

import compte.titulaire.Titulaire;
import org.junit.jupiter.api.*;

public class ApiAccesDonneesTest {

    @BeforeAll
    static void beforeALL(){
        System.out.println("début session test");
    }

    @AfterAll
    static void afterALL(){
        System.out.println("fin session test");
    }

    @BeforeEach
    void timeAvant(){
        timeAtStart = System.currentTimeMillis();
    }
    long timeAtStart;

    @AfterEach
    void timeApres(){
        long timeAtEnd = System.currentTimeMillis();
        System.out.println("ce test a pris "+(timeAtEnd-timeAtStart));
    }


    @Test
    @DisplayName("test sur API récupération titulaire")
    public void apiRecupererTitulaire() {

        Titulaire titulaire1 = ApiAccesDonnees.recupererTitulaire("cptref00001");
        System.out.println(titulaire1);
        titulaire1.afficherInformations();

        Titulaire titulaire2 = ApiAccesDonnees.recupererTitulaire("cptref00002");
        System.out.println(titulaire2);
        titulaire2.afficherInformations();
    }

}
