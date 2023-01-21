package animals.packAnimals;

public class Camel extends packAnimals{
    public Camel(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String species() {
        return "верблюд";
    }
}
