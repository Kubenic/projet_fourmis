import java.awt.*;

/**
 * Created by kuben on 06/07/17.
 */
public class Fourmis {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Fourmis(){
        this.width = 3;
        this.height = 3;
        this.color = new Color(0,0,0,1);
    }

    public Fourmis(int x, int y){
        this.width = 3;
        this.height = 3;
        this.color = new Color(0,0,0,1);
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
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
    public Color getColor(){
        return this.color;
    }
}
