package compte.compte;

public class Compte {
    public String reference;
//String dateOuverture;
//appeler cette classe ObjetReferenceParCompte
//creer un vrai objet compte en extends

    public Compte(String reference) {
        this.reference = reference;
    }

    public void afficherInformations() {
        System.out.println("Compte : " + reference);
    }

}
