package animals.animalNursery.counter;
import animals.Animals;

public class Counter implements AutoCloseable{
    private boolean resources = true;
    public static int count;

    public boolean addCount(Animals animals) {
        if (!animals.getName().equals("") && !animals.getBirthDate().equals("")) {
            count++;
            resources = false;
            return true;
        }
        return false;
    }

    public void removeCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    public void close() throws Exception {
        if (resources) throw new Exception("Ресурс не закрыт");
    }
}
