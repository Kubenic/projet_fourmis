import java.awt.*;
import java.util.ArrayList;

public class Fourmis {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean nourriture;
    private int lastX;
    private int lastY;
    private ArrayList<Pheromones> stockPheromones = new ArrayList<Pheromones>();
    private int difficulty = 0;

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

    public ArrayList<Pheromones> getStockPheromones() {
        return stockPheromones;
    }

    public void setStockPheromones(ArrayList<Pheromones> stockPheromones) {
        this.stockPheromones = stockPheromones;
    }
    public void addPheromones(Pheromones pheromones){
        if(this.stockPheromones.size()<12) {
            this.stockPheromones.add(pheromones);
        }else{
            this.stockPheromones.remove(0);
            this.stockPheromones.add(pheromones);
        }
    }
    public int getActualDifficulty(){
        int bigCpt = 0;
        //System.out.println(this.stockPheromones);
        for(int i = 0; i < this.stockPheromones.size(); i++){
            int cpt = 0;
            for(int j =i+1; j<this.stockPheromones.size(); j++){
                if(i%3==0){
                    if(j%3==0){

                        Pheromones base = this.stockPheromones.get(i);
                        Pheromones toCheck = this.stockPheromones.get(j);
                        if(base.getX() == toCheck.getX() && base.getY() == toCheck.getY()){
                            cpt++;
                        }
                    }
                }else{
                    if(j%2==0){

                        Pheromones base = this.stockPheromones.get(i);
                        Pheromones toCheck = this.stockPheromones.get(j);
                        if(base.getX() == toCheck.getX() && base.getY() == toCheck.getY()){
                            cpt++;
                        }
                    }
                }
            }
            if(cpt > bigCpt){
                bigCpt = cpt;
            }
        }
        if(bigCpt > this.difficulty){
            this.difficulty = bigCpt;
        }

        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
