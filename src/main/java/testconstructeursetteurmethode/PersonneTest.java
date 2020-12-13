package testconstructeursetteurmethode;

public class PersonneTest {

    String name;
    int age;

    public PersonneTest() {
    }

    public PersonneTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonneTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void valoriserAttributsPersonneTest(String name, int age){
        this.name = name;
        this.age = age;
    }
}
