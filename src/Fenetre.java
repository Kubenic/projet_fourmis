import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.* ;

public class Fenetre extends JPanel implements ActionListener {
    private int width;
    private int height;
    private Container contenu;
    private JFrame frame;
    private int nbFourmis;
    private int nbNourriture;
    private ArrayList<Fourmis> stockFourmis = new ArrayList<Fourmis>();
    private ArrayList<Nourriture> stockNourriture = new ArrayList<Nourriture>();
    private Fourmilliere fourmilliere;
    private Timer timer;
    private final int MOVESTEP = 4;


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            this.moveFourmis();
            this.repaint();// this will call at every 1 second
        }
    }

    public Fenetre(int width, int height, int nbFourmis, int nbNourriture){
        this.width = width;
        this.height = height;
        this.nbFourmis = nbFourmis;
        this.nbNourriture = nbNourriture;
        this.timer = new Timer(20,this);

        this.addFourmilliere();
        this.addNourriture();
        this.addFourmis();

        this.frame = new JFrame();
        this.frame.setTitle("La fourmilière");
        this.frame.setSize(this.width, this.height);

        this.contenu = this.frame.getContentPane();
        contenu.add(this);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

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
            fourmis.setColor(new Color(0,0,0));
            this.stockFourmis.add(fourmis);
        }
    }

    public void addNourriture(){
        for(int i =0; i < nbNourriture; i++){
            Double locX = new Double(Math.random() * (this.width - 0));
            Double locY = new Double(Math.random() * (this.height - 0));

            Nourriture nourriture = new Nourriture(locX.intValue(),locY.intValue());
            this.stockNourriture.add(nourriture);
        }
    }

    public void moveFourmis(){
        for(int i=0; i < stockFourmis.size(); i++) {
            Fourmis fourmis = stockFourmis.get(i);
            int option = Helper.RandomNumber(0, 7);

            if (option == 0 && fourmis.getX() - this.MOVESTEP < 0) {
                option = 1;
            } else if (option == 1 && fourmis.getX() + this.MOVESTEP > this.width) {
                option = 0;
            } else if (option == 2 && fourmis.getY() - this.MOVESTEP < 0) {
                option = 3;
            } else if (option == 3 && fourmis.getY() + this.MOVESTEP > this.height) {
                option = 2;
            } else if (option == 4 && fourmis.getX() - this.MOVESTEP < 0 && fourmis.getY() + this.MOVESTEP > this.height ){
                option = 6;
            } else if (option == 5 && fourmis.getX() + this.MOVESTEP > this.width && fourmis.getY() + this.MOVESTEP > this.height){
                option = 7;
            } else if (option == 6 && fourmis.getX() + this.MOVESTEP > this.width && fourmis.getY() - this.MOVESTEP < 0){
                option = 4;
            }else if (option == 7 && fourmis.getX() - this.MOVESTEP < 0 && fourmis.getY() - this.MOVESTEP < 0){
                option = 5;
            }

            if (option == 0) {
                fourmis.setX(fourmis.getX() - this.MOVESTEP);
            } else if (option == 1) {
                fourmis.setX(fourmis.getX() + this.MOVESTEP);
            } else if (option == 2) {
                fourmis.setY(fourmis.getY() - this.MOVESTEP);
            } else if (option == 3) {
                fourmis.setY(fourmis.getY() + this.MOVESTEP);
            } else if (option == 4) {
                fourmis.setX(fourmis.getX() - this.MOVESTEP);
                fourmis.setY(fourmis.getY() + this.MOVESTEP);
            } else if (option == 5) {
                fourmis.setX(fourmis.getX() + this.MOVESTEP);
                fourmis.setY(fourmis.getY() + this.MOVESTEP);
            } else if (option == 6) {
                fourmis.setX(fourmis.getX() + this.MOVESTEP);
                fourmis.setY(fourmis.getY() - this.MOVESTEP);
            } else if (option == 7) {
                fourmis.setX(fourmis.getX() - this.MOVESTEP);
                fourmis.setY(fourmis.getY() - this.MOVESTEP);
            }
            getNourriture(fourmis);
        }
    }

    public void getNourriture(Fourmis fourmis){
        for(int i=0; i < stockNourriture.size(); i++) {
            Nourriture nourriture = stockNourriture.get(i);

            if ((fourmis.getX() >= nourriture.getX() && fourmis.getX() <= (nourriture.getX() + nourriture.getWidth())) &&
                    (fourmis.getY() >= nourriture.getY() && fourmis.getY() <= (nourriture.getY() + nourriture.getHeight())) &&
                    (!fourmis.getNourriture())) {

                Color color = new Color(249, 3, 0);

                fourmis.setNourriture(true);
                fourmis.setColor(color);
                stockNourriture.remove(nourriture);
                fourmis.setY(fourmis.getY() + this.MOVESTEP);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(68,108,179));
        g.fillRect(this.fourmilliere.getX(),this.fourmilliere.getY(),this.fourmilliere.getWidth(),this.fourmilliere.getHeight());
        for(int i=0; i < this.stockFourmis.size(); i++){
            Fourmis fourmis = stockFourmis.get(i);
            g.setColor(fourmis.getColor());
            g.fillRect(fourmis.getX(),fourmis.getY(),fourmis.getWidth(),fourmis.getHeight());
        }
        for(int i=0; i < this.stockNourriture.size(); i++){
            Nourriture nourriture = stockNourriture.get(i);
            g.setColor(new Color(154, 251, 131));
            g.fillRect(nourriture.getX(),nourriture.getY(),nourriture.getWidth(),nourriture.getHeight());
        }
    }
}
