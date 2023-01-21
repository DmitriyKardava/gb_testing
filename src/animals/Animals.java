package animals;

import java.util.ArrayList;


public abstract class Animals {
    private final String name;
    private final String birthDate;
    private final ArrayList<String> commands = new ArrayList<>();

    protected Animals(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName(){
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void addCommand(String command){
        this.commands.add(command);
    }

    public ArrayList<String> getCommands(){
        return this.commands;
    }
    public abstract String type();
    public abstract String species();
}
