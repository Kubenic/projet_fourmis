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
            this.repaint();
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
        //int locX = Helper.RandomNumber(0,this.width);
        //int locY = Helper.RandomNumber(0,this.height);

        this.fourmilliere = new Fourmilliere(50,50);
    }

    public void addFourmis(){
        for(int i =0; i< nbFourmis; i++){
            Fourmis fourmis = new Fourmis();
            fourmis.setX(this.fourmilliere.getX());
            fourmis.setY(this.fourmilliere.getY());
            fourmis.setColor(new Color(0,0,0));
            this.stockFourmis.add(fourmis);
        }
    }

    public void addNourriture(){
        int size = 5;
        int size1 = 10;
        int size2 = 15;
        int size3 = 20;

        for(int i =0; i < nbNourriture; i++){

            int stock = Helper.RandomNumber(1, 20);

            if (stock >= 20) {
                int locX = Helper.RandomNumber(0,this.width - size3);
                int locY = Helper.RandomNumber(0,this.height - size3);

                Nourriture nourriture = new Nourriture(locX,locY);

                nourriture.setStock(stock);

                nourriture.setWidth(size3);
                nourriture.setHeight(size3);

                this.stockNourriture.add(nourriture);
                System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
            } else if (stock >= 15) {
                int locX = Helper.RandomNumber(0,this.width - size2);
                int locY = Helper.RandomNumber(0,this.height - size2);

                Nourriture nourriture = new Nourriture(locX,locY);

                nourriture.setStock(stock);

                nourriture.setWidth(size2);
                nourriture.setHeight(size2);

                this.stockNourriture.add(nourriture);
                System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
            } else if (stock >= 10) {
                int locX = Helper.RandomNumber(0,this.width - size1);
                int locY = Helper.RandomNumber(0,this.height - size1);

                Nourriture nourriture = new Nourriture(locX,locY);

                nourriture.setStock(stock);

                nourriture.setWidth(size1);
                nourriture.setHeight(size1);

                this.stockNourriture.add(nourriture);
                System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
            } else if (stock < 10) {
                int locX = Helper.RandomNumber(0,this.width - size);
                int locY = Helper.RandomNumber(0,this.height - size);

                Nourriture nourriture = new Nourriture(locX,locY);

                nourriture.setStock(stock);

                nourriture.setWidth(size);
                nourriture.setHeight(size);

                this.stockNourriture.add(nourriture);
                System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
            }

        }
        /*this.stockNourriture.add(new Nourriture(0,0));
        this.stockNourriture.add(new Nourriture(94,0));
        this.stockNourriture.add(new Nourriture(94,94));
        this.stockNourriture.add(new Nourriture(0,94));*/
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
            deposeNourriture(fourmis);
        }
    }

    public void getNourriture(Fourmis fourmis){
        for(int i=0; i < stockNourriture.size(); i++) {
            Nourriture nourriture = stockNourriture.get(i);

            if ((fourmis.getX() >= nourriture.getX() && fourmis.getX() <= (nourriture.getX() + nourriture.getWidth())) &&
                (fourmis.getY() >= nourriture.getY() && fourmis.getY() <= (nourriture.getY() + nourriture.getHeight())) &&
                (!fourmis.getNourriture())) {

                fourmis.setNourriture(true);

                if (nourriture.getStock() > 1) {
                    nourriture.setStock(nourriture.getStock() - 1);
                } else if (nourriture.getStock() == 1) {
                    stockNourriture.remove(nourriture);
                }
            }
        }
    }

    public void deposeNourriture(Fourmis fourmis) {
        if ((fourmis.getX() >= fourmilliere.getX() && fourmis.getX() <= (fourmilliere.getX() + fourmilliere.getWidth())) &&
                (fourmis.getY() >= fourmilliere.getY() && fourmis.getY() <= (fourmilliere.getY() + fourmilliere.getHeight())) &&
                (fourmis.getNourriture())) {

            fourmis.setNourriture(false);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(68,108,179));
        g.fillOval(this.fourmilliere.getX(),this.fourmilliere.getY(),this.fourmilliere.getWidth(),this.fourmilliere.getHeight());

        for(int i=0; i < this.stockFourmis.size(); i++){
            Fourmis fourmis = stockFourmis.get(i);

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

        for(int i=0; i < this.stockNourriture.size(); i++){
            Nourriture nourriture = stockNourriture.get(i);
            g.setColor(new Color(251, 145, 0));
            g.fillOval(nourriture.getX(),nourriture.getY(),nourriture.getWidth(),nourriture.getHeight());
        }
    }
}
