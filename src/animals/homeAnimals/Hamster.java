package animals.homeAnimals;

public class Hamster extends homeAnimals{
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "хомяк";
    }
}
