package informationlieecompte;

public class InformationLieeCompte {
    public String reference;

    public InformationLieeCompte(String reference) {

        this.reference = reference;
    }

    public void afficherInformations() {

        System.out.println("Compte : " + reference);
    }

}
