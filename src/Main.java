import java.util.Random;

class Color {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Aquarium aquarium = new Aquarium();
        int numberOfMaleFish = random.nextInt(5) + 1;
        int numberOfFemaleFish = random.nextInt(5) + 1;

        System.out.println(Color.YELLOW + "In Aquarium " + numberOfMaleFish + " male fish and " + numberOfFemaleFish + " female fish" + Color.RESET);


        for (int i = 0; i < numberOfMaleFish; i++) {
            int fishLifeSpan = random.nextInt(5) + 5;
            Fish maleFish = new Fish("Male", fishLifeSpan, aquarium);
            aquarium.addFish(maleFish);
        }

        for (int i = 0; i < numberOfFemaleFish; i++) {
            int fishLifeSpan = random.nextInt(5) + 5;
            Fish femaleFish = new Fish("Female", fishLifeSpan, aquarium);
            aquarium.addFish(femaleFish);
        }
    }
}