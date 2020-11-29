package apiecrituredonnees.solde;

import apiaccesdonnees.solde.ApiAccesDonneesSolde;
import informationlieecompte.solde.Solde;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiEcritureDonneesSoldeTest {

        @BeforeAll
        static void beforeALL() {
            System.out.println("début session test sur API écriture des données");
        }

        @AfterAll
        static void afterALL() {
            System.out.println("fin session test sur API écriture des données");
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
        @DisplayName("écriture solde mis à jour")
        @Order(1)
        public void ecrire_solde_mis_a_jour() {

            ApiEcritureDonneesSolde.EcrireSoldeDansFichier("cptref00001",3790.14);
            ApiEcritureDonneesSolde.EcrireSoldeDansFichier("cptref00002",-145.32);

        }
}
