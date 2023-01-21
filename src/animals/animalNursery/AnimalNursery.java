package animals.animalNursery;
import animals.Animals;
import animals.animalNursery.counter.Counter;

import java.util.ArrayList;

public class AnimalNursery {
    private final ArrayList<Animals> nurseryAnimals = new ArrayList<>();
    private int selectedAnimal = -1;
    public final Counter counter = new Counter();
    public void addAnimal(Animals animal){
        try (this.counter){
            if (counter.addCount(animal)) {
                nurseryAnimals.add(animal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAnimal(int number){
        if (number <= 0) return;
        if (nurseryAnimals.size() >= (number)) {
            selectedAnimal = number - 1;
        }
    }
    public void deleteAnimal() {
        counter.removeCount();
        if (selectedAnimal >= 0) {
            nurseryAnimals.remove(selectedAnimal);
            selectedAnimal = -1;
        }
    }

    public void addCommand(String command) {
        if (selectedAnimal >= 0) {
            nurseryAnimals.get(selectedAnimal).addCommand(command);
        }
    }
    public void getCommands(){
        if (selectedAnimal >= 0) {
            System.out.print(nurseryAnimals.get(selectedAnimal).getName() + " умеет: ");
            for (String command: nurseryAnimals.get(selectedAnimal).getCommands()) {
                System.out.print(command+ ' ');
            }
            System.out.println();
            System.out.println();
        }
    }
    public void printInfo() {
        if (nurseryAnimals.size() != 0) {
            int i = 0;
            String num;
            System.out.println("В питомнике  " + Counter.count + " животных");
            System.out.printf("%-3s %-10s %-10s %-10s%n","N", "Животное", "Кличка", "Дата рожд.");
            System.out.println(String.format("%36s", "").replace(' ', '-'));

            for (Animals animal : nurseryAnimals) {
                i++;
                if (selectedAnimal + 1 == i) {num = i + "*";}
                else {num = String.valueOf(i);}
                System.out.printf("%-3s %-10s %-10s %-10s%n",
                        num, animal.species(), animal.getName(), animal.getBirthDate());
            }
            System.out.println();
        }
    }
}
