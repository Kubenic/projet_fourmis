/**
 * Created by kuben on 06/07/17.
 */
public class Pheromones {
    private int width;
    private int height;
    private int x;
    private int y;
    private int hp;
    public Pheromones(int x, int y){
        this.width = 3;
        this.height = 3;
        this.hp = 100;
        this.x=x;
        this.y=y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void hit(){
        this.hp -= 0.1;
    }
}
