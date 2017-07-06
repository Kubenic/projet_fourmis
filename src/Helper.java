import java.util.Random;

/**
 * Created by adrienpayen on 06/07/2017.
 */
public class Helper {
    public static int RandomNumber(int min, int max)
    {
        Random rand = new Random();

        return rand.nextInt( max - min + 1 ) + min;
    }
}
