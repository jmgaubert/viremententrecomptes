package testconstructeursetteurmethode;

public class Clavier {
    private String marque;
    private String type;

    public Clavier() {
    }

    public Clavier(String marque, String type) {
        this.marque = marque;
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTypeEnrichi(String type) {
          this.type = type+"plusplus";
    }
}
