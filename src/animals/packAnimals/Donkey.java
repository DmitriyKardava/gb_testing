package animals.packAnimals;

public class Donkey extends packAnimals {
    public Donkey(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "осёл";
    }
}
