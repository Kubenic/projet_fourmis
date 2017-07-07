import javax.swing.*;
import java.awt.*;

/**
 * Created by kuben on 07/07/17.
 */
public class Rendu extends JPanel {
    private int width;
    private int height;
    private Container contenu;
    //private JFrame frame;
    private JLabel lNbNourritureStat = new JLabel("Nombre :");
    private JLabel lNbFourmisStat = new JLabel("Fourmis :");
    private Simulation simulation;

    public Rendu(int width, int height){
        this.width = width;
        this.height = height;
        this.setSize(this.width,this.height);
        /*this.frame = new JFrame();
        this.frame.setTitle("La fourmilière");
        this.frame.setSize(this.width, this.height);
        this.frame.add(this.lNbNourritureStat);
        this.contenu = this.frame.getContentPane();
        contenu.add(this);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);*/

    }

    public void paint(Simulation sim){
        //System.out.println("PAINT");
     this.simulation =sim;
     this.repaint();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        System.out.println("PAINT COMPONENT");
        //System.out.println(this.simulation);
        //System.out.println("---------------------------------");
        g.setColor(new Color(68,108,179));
        g.fillOval(this.simulation.fourmilliere.getX(),this.simulation.fourmilliere.getY(),this.simulation.fourmilliere.getWidth(),this.simulation.fourmilliere.getHeight());
        g.drawString(this.lNbNourritureStat.getText(), this.getWidth() / 2, 10);
        g.drawString(this.lNbFourmisStat.getText(), this.getWidth() / 2, 25);

        for(int i=0; i < this.simulation.stockPheromones.size(); i++){
            Pheromones pheromones = this.simulation.stockPheromones.get(i);
            g.setColor(new Color(179, 6, 0));
            g.fillOval(pheromones.getX(),pheromones.getY(),(pheromones.getWidth()-((pheromones.getWidth()/pheromones.getHp())*10000)),(pheromones.getHeight()-((pheromones.getHeight()/pheromones.getHp())*10000)));
        }
        for(int i=0; i < this.simulation.stockFourmis.size(); i++){
            Fourmis fourmis = this.simulation.stockFourmis.get(i);

            if (!fourmis.getNourriture()) {
                g.setColor(fourmis.getColor());
                g.fillOval(fourmis.getX(),fourmis.getY(),fourmis.getWidth(),fourmis.getHeight());
            } else {
                g.setColor(fourmis.getColor());
                g.fillOval(fourmis.getX(),fourmis.getY(),fourmis.getWidth(),fourmis.getHeight());

                g.setColor(new Color(255, 198, 191));
                g.fillOval(fourmis.getX()+2,fourmis.getY()+2,fourmis.getWidth()-5,fourmis.getHeight()-5);
            }
        }

        for(int i=0; i < this.simulation.stockNourriture.size(); i++){
            Nourriture nourriture = this.simulation.stockNourriture.get(i);
            g.setColor(new Color(251, 145, 0));
            g.fillOval(nourriture.getX(),nourriture.getY(),nourriture.getWidth(),nourriture.getHeight());
        }
    }


}
