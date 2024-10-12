
public class Fish extends Thread{
    private final String fishGender;
    private int fishLifeSpan;
    private final Aquarium aquarium;
    public Fish(String fishGender, int fishLifeSpan, Aquarium aquarium){
        this.fishGender = fishGender;
        this.fishLifeSpan = fishLifeSpan;
        this.aquarium = aquarium;
    }


    public String getFishGender(){
        return fishGender;
    }


    @Override
    public void run() {

        try {
            while (fishLifeSpan > 0){
                Thread.sleep(1000);
                fishLifeSpan--;
                if(fishLifeSpan % 2 ==0){
                    aquarium.checkForMate(this);
                }
                if (fishLifeSpan == 0){
                    System.out.println(Color.RED + fishGender + " fish is died." + Color.RESET);
                    aquarium.removeFish(this);
                }
            }
        }catch (InterruptedException e){
            System.out.println(Color.RED + fishGender + " fish is stopped." + Color.RESET);
        }

    }
}
