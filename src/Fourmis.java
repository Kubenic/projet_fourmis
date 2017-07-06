import java.awt.*;

public class Fourmis {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean nourriture;
    private int lastX;
    private int lastY;


    public Fourmis(){
        this.width = 10;
        this.height = 10;
    }

    public Fourmis(int x, int y){
        this.width = 10;
        this.height = 10;
        this.x = x;
        this.y = y;
    }

    public void setNourriture(boolean nourriture) {
        this.nourriture = nourriture;
    }
    public boolean getNourriture() {
        return this.nourriture;
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
    public void setColor(Color color) {
        this.color = color;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public Color getColor(){
        return this.color;
    }
}
