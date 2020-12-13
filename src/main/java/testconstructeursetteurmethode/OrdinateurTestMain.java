package testconstructeursetteurmethode;

public class OrdinateurTestMain {
    public static void main( String[] args )
    {

        //creation via getteur/setter
        Clavier clavier1 = new Clavier();
        clavier1.setMarque("DELL");
        clavier1.setType("AZERTY");
        System.out.println("clavier1    :"+clavier1);

        Processeur processeur1 = new Processeur();
        processeur1.setMarque("MOTOROLA");
        processeur1.setFrequence(10);
        System.out.println("processeur1 :"+processeur1);

        Ordinateur ordinateur1 = new Ordinateur();
        ordinateur1.setMarque("HP");
        ordinateur1.setType("portable");
        ordinateur1.setProcesseur(processeur1);
        ordinateur1.setClavier(clavier1);
        System.out.println("ordinateur1 :"+ordinateur1);
        System.out.println("clavier     :" + ordinateur1.getClavier());
        System.out.println("processeur  :" + ordinateur1.getProcesseur());
        System.out.println("ordinateur 1 cree via getter/setter "+ ordinateur1.affichage());

        System.out.println();
        //creation via constructeur
        Ordinateur ordinateur2 = new Ordinateur("IBM","DESKTOP",new Clavier("COMPAQ","QWERTY"),new Processeur("INTEL",25));
        System.out.println("ordinateur2 :"+ordinateur2);
        System.out.println("clavier     :" + ordinateur2.getClavier());
        System.out.println("processeur  :" + ordinateur2.getProcesseur());
        System.out.println("ordinateur 2 cree via constructeur "+ ordinateur2.affichage());

        System.out.println();
        //creation via constructeur sauf processeur
        Ordinateur ordinateur3 = new Ordinateur("MICROSOFT","HYBRIDE",new Clavier("GENERIQUE","QWERTY"));
        Processeur processeur3 = new Processeur();
        processeur3.setMarque("NVIDIA");
        processeur3.setFrequence(100);
        ordinateur3.setProcesseur(processeur3);
        System.out.println("processeur3 :"+processeur3);
        System.out.println("ordinateur3 :"+ordinateur3);
        System.out.println("clavier     :" + ordinateur3.getClavier());
        System.out.println("processeur  :" + ordinateur3.getProcesseur());
        System.out.println("ordinateur3 2 cree via constructeur + setter processeur "+ ordinateur3.affichage());

        System.out.println();
        Clavier clavier3Copie = ordinateur3.getClavier();
        System.out.println("clavier3Copie affectation sans new: "+clavier3Copie+" ATTENTION pointe sur adresse clavier 3 --> ALIAS");
        System.out.println("clavier3Copie affectation sans new: "+clavier3Copie.getMarque()+" "+clavier3Copie.getType());

        System.out.println();
        Clavier clavier3CopieBis = new Clavier();
        clavier3CopieBis.setType(ordinateur3.getClavier().getType());
        clavier3CopieBis.setMarque(ordinateur3.getClavier().getMarque());
        System.out.println("clavier3CopieBis new+setter: "+clavier3CopieBis);
        System.out.println("clavier3CopieBis new+setter: "+clavier3CopieBis.getMarque()+" "+clavier3Copie.getType());

    }
}
