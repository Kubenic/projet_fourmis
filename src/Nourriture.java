/**
 * Created by adrienpayen on 06/07/2017.
 */
public class Nourriture {
    private int x;
    private int y;
    private int width;
    private int height;

    public Nourriture(int x, int y){
        this.x =x;
        this.y = y;
        this.width = 6;
        this.height = 6;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
}
