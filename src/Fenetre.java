import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fenetre extends JPanel implements ActionListener {
        private int width;
        private int height;
        private Container contenu;
        private JFrame frame;
        private JLabel lNbNourritureStat = new JLabel("Nombre :");
        private JLabel lNbFourmisStat = new JLabel("Fourmis :");
        private int nbFourmis;
        private int nbNourriture;
        private ArrayList<Fourmis> stockFourmis = new ArrayList<Fourmis>();
        private ArrayList<Nourriture> stockNourriture = new ArrayList<Nourriture>();
        private ArrayList<Pheromones> stockPheromones = new ArrayList<Pheromones>();
        private Fourmilliere fourmilliere;
        private Timer timer;
        private final int ANIMATION_TIME = 20;
        private final int MOVE_STEP = 4;

        public Fenetre(int width, int height, int nbFourmis, int nbNourriture){
            this.width = width;
            this.height = height;
            this.nbFourmis = nbFourmis;

            this.nbNourriture = nbNourriture;
            this.timer = new Timer(this.ANIMATION_TIME,this);
            this.addFourmilliere();
            this.addNourriture();
            this.addFourmis();

            this.frame = new JFrame();
            this.frame.setTitle("La fourmilière");
            this.frame.setSize(this.width, this.height);
            this.frame.add(this.lNbNourritureStat);

            this.contenu = this.frame.getContentPane();

            contenu.add(this);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setResizable(false);

            timer.start();
            this.frame.setVisible(true);
        }

        public void addFourmilliere(){
            int locX = Helper.RandomNumber(0,this.width);
            int locY = Helper.RandomNumber(0,this.height);

            this.fourmilliere = new Fourmilliere(locX,locY);
            while((this.fourmilliere.getX()+this.fourmilliere.getWidth() > this.width)
                    || (this.fourmilliere.getY()+this.fourmilliere.getHeight() >this.height)){
                locX = Helper.RandomNumber(0,this.width);
                locY = Helper.RandomNumber(0,this.height);
                this.fourmilliere.setX(locX);
                this.fourmilliere.setY(locY);
            }
        }

        public void addFourmis() {
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
                System.out.println(stock);
                if (stock >= 20) {
                    int locX = Helper.RandomNumber(0,this.width - size3);
                    int locY = Helper.RandomNumber(0,this.height - size3);

                    Nourriture nourriture = new Nourriture(locX,locY);

                    while((nourriture.getX() + nourriture.getWidth() > this.width)
                            || nourriture.getY() + nourriture.getHeight() > this.height){
                        locX = Helper.RandomNumber(0,this.width - size3);
                        locY = Helper.RandomNumber(0,this.height - size3);
                        nourriture.setX(locX);
                        nourriture.setY(locY);
                    }
                    nourriture.setStock(stock);
                    nourriture.setWidth(size3);
                    nourriture.setHeight(size3);

                    this.stockNourriture.add(nourriture);
                    System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
                } else if (stock >= 15) {
                    int locX = Helper.RandomNumber(0,this.width - size2);
                    int locY = Helper.RandomNumber(0,this.height - size2);

                    Nourriture nourriture = new Nourriture(locX,locY);

                    while((nourriture.getX() + nourriture.getWidth() > this.width)
                            || nourriture.getY() + nourriture.getHeight() > this.height){
                        locX = Helper.RandomNumber(0,this.width - size3);
                        locY = Helper.RandomNumber(0,this.height - size3);
                        nourriture.setX(locX);
                        nourriture.setY(locY);
                    }

                    nourriture.setStock(stock);
                    nourriture.setWidth(size2);
                    nourriture.setHeight(size2);

                    this.stockNourriture.add(nourriture);
                    //System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
                } else if (stock >= 10) {
                    int locX = Helper.RandomNumber(0,this.width - size1);
                    int locY = Helper.RandomNumber(0,this.height - size1);

                    Nourriture nourriture = new Nourriture(locX,locY);

                    while((nourriture.getX() + nourriture.getWidth() > this.width)
                            || nourriture.getY() + nourriture.getHeight() > this.height){
                        locX = Helper.RandomNumber(0,this.width - size3);
                        locY = Helper.RandomNumber(0,this.height - size3);
                        nourriture.setX(locX);
                        nourriture.setY(locY);
                    }

                    nourriture.setStock(stock);
                    nourriture.setWidth(size1);
                    nourriture.setHeight(size1);

                    this.stockNourriture.add(nourriture);
                    //System.out.println("x : " + nourriture.getX() + " || y : " + nourriture.getY());
                } else if (stock < 10) {
                    int locX = Helper.RandomNumber(0,this.width - size);
                    int locY = Helper.RandomNumber(0,this.height - size);

                    Nourriture nourriture = new Nourriture(locX,locY);

                    while((nourriture.getX() + nourriture.getWidth() > this.width)
                            || nourriture.getY() + nourriture.getHeight() > this.height){
                        locX = Helper.RandomNumber(0,this.width - size3);
                        locY = Helper.RandomNumber(0,this.height - size3);
                        nourriture.setX(locX);
                        nourriture.setY(locY);
                    }
                    nourriture.setStock(stock);
                    nourriture.setWidth(size);
                    nourriture.setHeight(size);

                    this.stockNourriture.add(nourriture);

                }

            }

        }

        public void moveFourmis(){
            for(int i=0; i < stockFourmis.size(); i++) {
                Fourmis fourmis = stockFourmis.get(i);
                ArrayList<Integer> possibilities = new ArrayList<Integer>();
                for(int j = 0; j < this.stockPheromones.size(); j++){
                    Pheromones pheromones = this.stockPheromones.get(j);
                    if(fourmis.getLastX()!=pheromones.getX() && fourmis.getLastY() != pheromones.getY() && fourmis.getActualDifficulty() < 3){
                        if(((fourmis.getX()-this.MOVE_STEP) == pheromones.getX()) && (fourmis.getY() == pheromones.getY())){
                            possibilities.add(0);
                        }
                        if(((fourmis.getX()+this.MOVE_STEP) == pheromones.getX()) && (fourmis.getY() == pheromones.getY())){
                            possibilities.add(1);
                        }
                        if((fourmis.getY()-this.MOVE_STEP == pheromones.getY()) && (fourmis.getX() == pheromones.getX())){
                            possibilities.add(2);
                        }
                        if(((fourmis.getY()+this.MOVE_STEP) == pheromones.getY()) && (fourmis.getX() == pheromones.getX())){
                            possibilities.add(3);
                        }
                        if(((fourmis.getX()-this.MOVE_STEP) == pheromones.getX()) && ((fourmis.getY()+this.MOVE_STEP) == pheromones.getY())){
                            possibilities.add(4);
                        }
                        if(((fourmis.getX()+this.MOVE_STEP) == pheromones.getX()) && ((fourmis.getY()+this.MOVE_STEP) == pheromones.getY())){
                            possibilities.add(5);
                        }
                        if(((fourmis.getX()+this.MOVE_STEP) == pheromones.getX()) && ((fourmis.getY()-this.MOVE_STEP)==pheromones.getY())){
                            possibilities.add(6);
                        }
                        if(((fourmis.getX()-this.MOVE_STEP) == pheromones.getX()) && ((fourmis.getY()-this.MOVE_STEP) == pheromones.getY())){

                            possibilities.add(7);
                        }
                    }

                }

                int option;
                if(possibilities.size() > 0){
                    int dice = Helper.RandomNumber(0, possibilities.size()-1);
                    option = possibilities.get(dice);
                }else {
                    option = Helper.RandomNumber(0, 7);
                }


                if (option == 0 && fourmis.getX() - this.MOVE_STEP < 0) {
                    option = 1;
                } else if (option == 1 && (fourmis.getX()+ fourmis.getWidth()) + this.MOVE_STEP > this.width) {
                    option = 0;
                } else if (option == 2 && fourmis.getY() - this.MOVE_STEP < 0) {
                    option = 3;
                } else if (option == 3 && (fourmis.getY()+fourmis.getHeight()) + this.MOVE_STEP > this.height) {
                    option = 2;
                } else if (option == 4 && fourmis.getX() - this.MOVE_STEP < 0 && (fourmis.getY()+fourmis.getHeight()) + this.MOVE_STEP > this.height ){
                    option = 6;
                } else if (option == 5 && (fourmis.getX()+ fourmis.getWidth()) + this.MOVE_STEP > this.width && (fourmis.getY()+fourmis.getHeight()) + this.MOVE_STEP > this.height){
                    option = 7;
                } else if (option == 6 && (fourmis.getX()+ fourmis.getWidth()) + this.MOVE_STEP > this.width && fourmis.getY() - this.MOVE_STEP < 0){
                    option = 4;
                }else if (option == 7 && fourmis.getX() - this.MOVE_STEP < 0 && fourmis.getY() - this.MOVE_STEP < 0){
                    option = 5;
                }

                fourmis.setLastX(fourmis.getX());
                fourmis.setLastY(fourmis.getY());
                if(fourmis.getActualDifficulty() > 3){
                    fourmis.setDifficulty(0);
                    fourmis.setStockPheromones(new ArrayList<Pheromones>());
                }

                if (option == 0) {
                    fourmis.setX(fourmis.getX() - this.MOVE_STEP);
                } else if (option == 1) {
                    fourmis.setX(fourmis.getX() + this.MOVE_STEP);
                } else if (option == 2) {
                    fourmis.setY(fourmis.getY() - this.MOVE_STEP);
                } else if (option == 3) {
                    fourmis.setY(fourmis.getY() + this.MOVE_STEP);
                } else if (option == 4) {
                    fourmis.setX(fourmis.getX() - this.MOVE_STEP);
                    fourmis.setY(fourmis.getY() + this.MOVE_STEP);
                } else if (option == 5) {
                    fourmis.setX(fourmis.getX() + this.MOVE_STEP);
                    fourmis.setY(fourmis.getY() + this.MOVE_STEP);
                } else if (option == 6) {
                    fourmis.setX(fourmis.getX() + this.MOVE_STEP);
                    fourmis.setY(fourmis.getY() - this.MOVE_STEP);
                } else if (option == 7) {
                    fourmis.setX(fourmis.getX() - this.MOVE_STEP);
                    fourmis.setY(fourmis.getY() - this.MOVE_STEP);
                }
                getNourriture(fourmis);
                deposeNourriture(fourmis);
            }
        }

        public void setPheromones(){
            for(int i =0; i < this.stockFourmis.size(); i++){
                Fourmis fourmis = this.stockFourmis.get(i);
                if(fourmis.getNourriture()){
                    this.stockPheromones.add(new Pheromones(fourmis.getX(),fourmis.getY()));
                }
            }
        }

        public void changePheromones(){
            for(int i = 0; i < this.stockPheromones.size(); i++){
                Pheromones pheromones = this.stockPheromones.get(i);
                pheromones.hit();

                if(pheromones.getHp() <= 0){
                    this.stockPheromones.remove(i);
                    i--;
                }
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

        public void checkIfInPheromones(){
            for(int i=0; i < this.stockPheromones.size(); i++){
                Pheromones pheromones = this.stockPheromones.get(i);
                for(int j =0; j < this.stockFourmis.size(); j++){
                    Fourmis fourmis = this.stockFourmis.get(j);

                    if(fourmis.getX() == pheromones.getX() && fourmis.getY()==pheromones.getY()){
                        fourmis.addPheromones(pheromones);
                    }
                }
            }
        }
        public void actionPerformed(ActionEvent ev) {
            if (ev.getSource() == timer) {
                this.changePheromones();
                this.moveFourmis();
                this.checkIfInPheromones();
                this.setPheromones();

                this.lNbNourritureStat.setText("Nb nourriture : " +String.valueOf(this.stockNourriture.size()));
                this.lNbFourmisStat.setText("Nb de fourmis : " +String.valueOf(this.stockFourmis.size()));

                this.repaint();
            }
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(new Color(68,108,179));
            g.fillOval(this.fourmilliere.getX(),this.fourmilliere.getY(),this.fourmilliere.getWidth(),this.fourmilliere.getHeight());
            g.drawString(this.lNbNourritureStat.getText(), this.getWidth() / 2, 10);
            g.drawString(this.lNbFourmisStat.getText(), this.getWidth() / 2, 25);

            for(int i=0; i < this.stockPheromones.size(); i++){
                Pheromones pheromones = this.stockPheromones.get(i);
                g.setColor(new Color(179, 6, 0));
                g.fillOval(pheromones.getX(),pheromones.getY(),(pheromones.getWidth()-((pheromones.getWidth()/pheromones.getHp())*10000)),(pheromones.getHeight()-((pheromones.getHeight()/pheromones.getHp())*10000)));
            }
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
