package animals.homeAnimals;

public class Cat extends homeAnimals {
    public Cat(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "кот";
    }
}
