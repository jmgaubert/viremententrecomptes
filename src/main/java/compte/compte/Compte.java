package compte.compte;

public class Compte {
    public String reference;
    String dateOuverture;

    public Compte(String reference) {
        this.reference = reference;
    }

    public void afficherInformations() {
        System.out.println("Compte : " + reference);
    }

}
