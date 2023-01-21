package animals.menu;

import java.util.Scanner;


public class Menu {
    public int readInt() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) return sc.nextInt();
        else {
            sc.next();
        }
        return -1;
    }

    public String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public int menuChoice(String menu, int items) {
        int choice;
        while (true) {
            System.out.println(menu);
            choice = readInt();
            if (choice >= 0 && choice <= items) return choice;
            System.out.println("Неправильный выбор");
        }
    }
}

