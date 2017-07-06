public class Fourmilliere {
    private int x;
    private int y;
    private int width;
    private int height;

    public Fourmilliere(int x, int y){
        this.width = 50;
        this.height = 50;
        this.x = x;
        this.y = y;

        if (this.x < 10) {
            this.x = this.x+10;
        }
        if (this.y < 10) {
            this.y = this.y+10;
        }
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x) {this.x = x; }
    public void setY(int y) {this.y = y; }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

}
