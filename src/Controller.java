import javax.swing.*;
import java.awt.*;

/**
 * Created by kuben on 07/07/17.
 */
public class Controller extends JFrame {
    Simulation sim;
    Rendu rendu;
    private int nbNourriture;
    private int nbFourmis;
    private int width;
    private int height;
    private Container contenu;
    private final int ANIMATION_TIME = 20;
    private int trigger = 1;

    public Controller(int width, int height, int nbFourmis, int nbNourriture){
        this.width = width;
        this.height = height;
        this.sim = new Simulation(width, height, nbFourmis, nbNourriture);
        this.rendu = new Rendu(width, height);
        this.setTitle("La fourmilière");
        this.setSize(this.width, this.height);
        //this.frame.add(this.lNbNourritureStat);
        this.contenu = this.getContentPane();
        contenu.add(this.rendu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.start();

    }


    public void start(){
        while(this.trigger ==1){
            sim.nextStep();
            rendu.paint(sim);
            //rendu.repaint();
            try {
                Thread.sleep(ANIMATION_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
