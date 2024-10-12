import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Aquarium {

    private final List<Fish> listOfFish = new CopyOnWriteArrayList<>();
    private static final Random random = new Random();

    public void addFish(Fish fish) {
        listOfFish.add(fish);
        fish.start();
    }

    public void removeFish(Fish fish) {
        listOfFish.remove(fish);
    }

    public void checkForMate(Fish fish) {
        for (Fish otherFish : listOfFish) {
            if (!otherFish.equals(fish) && !Objects.equals(fish.getFishGender(), otherFish.getFishGender())) {
                System.out.println(Color.PURPLE + "Male fish and Female fish mate! Creating new fish..." + Color.RESET);
                createNewFish();
                break;
            }
        }
    }

    public void createNewFish() {
        String newGender = random.nextBoolean() ? "Male" : "Female";
        int lifeSpan = random.nextInt(5) + 5;
        Fish newFish = new Fish(newGender, lifeSpan, this);
        addFish(newFish);
        System.out.println(Color.GREEN + "New gender is " + newGender + " fish is created! " + (newGender.equals("Male") ? "his " : "her ") + " life span " + lifeSpan + " second." + Color.RESET);
    }
}
