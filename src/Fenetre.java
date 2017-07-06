import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.* ;

/**
 * Created by kuben on 05/07/17.
 */
public class Fenetre extends JPanel implements ActionListener {
    private int width;
    private int height;
    private Container contenu;
    private JFrame frame;
    private int nbFourmis = 10;
    private ArrayList<Fourmis> stockFourmis = new ArrayList<Fourmis>();
    private Fourmilliere fourmilliere;
    private Timer timer;


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            this.moveFourmis();
            this.repaint();// this will call at every 1 second
        }
    }
    public Fenetre(int width, int height){

        this.width = width;
        this.height = height;
        this.addFourmilliere();
        this.addFourmis();
        this.frame = new JFrame();
        this.frame.setTitle("LA BAMBOULA");
        this.frame.setSize(this.width, this.height);
        this.contenu = this.frame.getContentPane();
        //this.panel = new Panneau();
        contenu.add(this);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.timer = new Timer(20,this);
            timer.start();
        this.frame.setVisible(true);
    }
    public void addFourmilliere(){
        Double locX = new Double(Math.random() * (this.width - 0));
        Double locY = new Double(Math.random() * (this.height - 0));
        this.fourmilliere = new Fourmilliere(locX.intValue(),locY.intValue());
    }
    public void addFourmis(){
        for(int i =0; i< nbFourmis; i++){
            //Double locX = new Double(Math.random() * (this.width - 0));
            //Double locY = new Double(Math.random() * (this.height - 0));
            Fourmis fourmis = new Fourmis();
            fourmis.setX(this.fourmilliere.getX());
            fourmis.setY(this.fourmilliere.getY());
            this.stockFourmis.add(fourmis);

        }
    }
    public void moveFourmis(){
        for(int i=0; i < stockFourmis.size(); i++){
            Fourmis fourmis = stockFourmis.get(i);

            if(i%3 ==0){
                fourmis.setX(fourmis.getX()-1);
            }else{
                fourmis.setX(fourmis.getX()+1);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(68,108,179));
        g.fillRect(this.fourmilliere.getX(),this.fourmilliere.getY(),this.fourmilliere.getWidth(),this.fourmilliere.getHeight());
       for(int i=0; i < this.stockFourmis.size(); i++){
            Fourmis fourmis = stockFourmis.get(i);
            g.setColor(new Color(0,0,0));
            g.fillRect(fourmis.getX(),fourmis.getY(),fourmis.getWidth(),fourmis.getHeight());
        }
    }
}
