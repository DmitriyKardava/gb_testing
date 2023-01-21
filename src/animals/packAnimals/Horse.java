package animals.packAnimals;

public class Horse extends packAnimals {
    public Horse(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "конь";
    }
}
