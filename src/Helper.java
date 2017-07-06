import java.util.Random;

public class Helper {
    public static int RandomNumber(int min, int max)
    {
        Random rand = new Random();

        return rand.nextInt( max - min + 1 ) + min;
    }
}
