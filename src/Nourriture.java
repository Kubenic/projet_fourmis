public class Nourriture {
    private int x;
    private int y;
    private int width;
    private int height;
    private int stock;

    public Nourriture(int x, int y){
        this.x =x;
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setStock(int stock) {
        this.stock = stock;
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
    public int getStock() {
        return this.stock;
    }
}
