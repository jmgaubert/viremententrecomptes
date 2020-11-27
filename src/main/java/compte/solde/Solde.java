package compte.solde;

import compte.compte.Compte;
import compte.mouvement.Mouvement;

import java.math.BigDecimal;

public class Solde extends Compte {
    double solde;

    public Solde(String reference, double solde) {
        super(reference);
        this.solde = solde;
    }

    public void afficherInformations() {
        System.out.println("Compte : " + reference + " Solde : " + solde);
    }

    public void ajouterASolde(Mouvement mouvement) {
        BigDecimal soldeBigDecimal = new BigDecimal(solde + mouvement.getMontant()).setScale(2, BigDecimal.ROUND_HALF_UP);
        solde = soldeBigDecimal.doubleValue();
    }
}
