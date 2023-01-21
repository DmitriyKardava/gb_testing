package animals.homeAnimals;

import animals.Animals;

public abstract class homeAnimals extends Animals {

    public homeAnimals(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String type() {
        return "домашнее животное";
        }

    public abstract String species();
}
