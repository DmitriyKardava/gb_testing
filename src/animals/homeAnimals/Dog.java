package animals.homeAnimals;

public class Dog extends homeAnimals {
    public Dog(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "собака";
    }
}
