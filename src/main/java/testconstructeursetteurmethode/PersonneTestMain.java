package testconstructeursetteurmethode;

public class PersonneTestMain {
        public static void main( String[] args )
        {
            PersonneTest personneTestviaContructeur = new PersonneTest("jean-michel", 56);

            PersonneTest personneTestviaSetteur = new PersonneTest();
            personneTestviaSetteur.setName("raymonde");
            personneTestviaSetteur.setAge(74);

            PersonneTest personneTestviaContructeurEtSetteur = new PersonneTest("mathis");
            personneTestviaContructeurEtSetteur.setAge(18);

            PersonneTest personneTestviaMethode = new PersonneTest();
            personneTestviaMethode.valoriserAttributsPersonneTest("bruno", 51);

            System.out.println( personneTestviaContructeur.getName()+" "+ personneTestviaContructeur.getAge());
            System.out.println( personneTestviaSetteur.getName()+" "+ personneTestviaSetteur.getAge());
            System.out.println( personneTestviaContructeurEtSetteur.getName()+" "+ personneTestviaContructeurEtSetteur.getAge());
            System.out.println( personneTestviaMethode.getName()+" "+ personneTestviaMethode.getAge());

        }
}
