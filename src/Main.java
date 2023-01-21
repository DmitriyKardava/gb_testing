import animals.Animals;
import animals.animalNursery.AnimalNursery;
import animals.homeAnimals.Cat;
import animals.homeAnimals.Dog;
import animals.homeAnimals.Hamster;
import animals.menu.Menu;
import animals.packAnimals.Camel;
import animals.packAnimals.Donkey;
import animals.packAnimals.Horse;

public class Main {
    public static void main(String[] args) {
        AnimalNursery nursery = new AnimalNursery();
        Menu main_menu = new Menu();
        while (true) {
            switch (main_menu.menuChoice("""
                    1 Показать всех животных\s
                    2 Добавить животное\s
                    3 Выбрать животное\s
                    4 Обучить команде\s
                    5 Посмотреть команды животного\s
                    6 Удалить животное\s
                    Выход - 0""", 6)){
                case 1:
                    nursery.printInfo();
                    break;
                case 2:
                    nursery.addAnimal(addAnimal());
                    break;
                case 3:
                    System.out.println("Введите номер: ");
                    nursery.selectAnimal(main_menu.readInt());
                    break;
                case 4:
                    System.out.println("Введите комменду: ");
                    nursery.addCommand(main_menu.readString());
                    break;
                case 5:
                    nursery.getCommands();
                    break;
                case 6:
                    nursery.deleteAnimal();
                    break;
                case 0:
                    return;
            }
        }
    }
    private static Animals addAnimal() {
        Menu select_animal = new Menu();
        int species = select_animal.menuChoice("""
                    1 Кот\s
                    2 Собака\s
                    3 Хомяк\s
                    4 Лошадь\s
                    5 Осел\s
                    6 Верблюд\s
                    Выход - 0""", 6);
        if (species == 0) return null;
        System.out.print("Имя животного: ");
        String name = select_animal.readString();
        System.out.print("Дата рождения: ");
        String birth_date = select_animal.readString();
        switch (species) {
            case 1:
                return new Cat(name, birth_date);
            case 2:
                return new Dog(name,birth_date);
            case 3:
                return new Hamster(name, birth_date);
            case 4:
                return new Horse(name, birth_date);
            case 5:
                return  new Donkey(name, birth_date);
            case 6:
                return new Camel(name, birth_date);
            default:
                return null;
        }
    }
}
