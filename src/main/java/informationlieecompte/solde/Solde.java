package informationlieecompte.solde;

import informationlieecompte.InformationLieeCompte;
import informationlieecompte.mouvement.Mouvement;

import java.math.BigDecimal;

public class Solde extends InformationLieeCompte {
    double solde;

    public Solde(String reference, double solde) {
        super(reference);
        this.solde = solde;
    }

    public double getSolde() {

        return solde;
    }

    public void afficherInformations() {

        System.out.println("Compte : " + reference + " Solde : " + solde);
    }

    public void ajouterASolde(Mouvement mouvement) {

        BigDecimal soldeBigDecimal = new BigDecimal(solde + mouvement.getMontant()).setScale(2, BigDecimal.ROUND_HALF_UP);
        solde = soldeBigDecimal.doubleValue();
    }
}
