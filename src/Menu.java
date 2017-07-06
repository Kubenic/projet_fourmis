import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by xonfall on 06/07/2017.
 */
public class Menu extends JFrame implements ActionListener {
    private JLabel lFourmis = new JLabel("Fourmis :");
    private JLabel lNourriture = new JLabel("Nourriture :");
    private JLabel lHauteur = new JLabel("Hauteur:");
    private JLabel lLargeur = new JLabel("Laugeur :");
    private JFormattedTextField  tFourmis = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JFormattedTextField  tNourriture = new JFormattedTextField (NumberFormat.getIntegerInstance());
    private JFormattedTextField  tHauteur = new JFormattedTextField (NumberFormat.getIntegerInstance());
    private JFormattedTextField  tLargeur = new JFormattedTextField (NumberFormat.getIntegerInstance());
    private JButton bValidation = new JButton("Valider");
    private JButton bAnnulation = new JButton("Quitter");
    private JPanel pan = new JPanel();

    public Menu() {
        this.setTitle("Menu de configuration");
        this.setSize(250,200);

        this.pan.add(this.lFourmis);
        this.tFourmis.setPreferredSize(new Dimension(150, 30));
        this.pan.add(this.tFourmis);

        this.pan.add(this.lNourriture);
        this.tNourriture.setPreferredSize(new Dimension(150, 30));
        this.pan.add(this.tNourriture);

        this.pan.add(this.lHauteur);
        this.tHauteur.setPreferredSize(new Dimension(150, 30));
        this.pan.add(this.tHauteur);


        this.pan.add(this.lLargeur);
        this.tLargeur.setPreferredSize(new Dimension(150, 30));
        this.pan.add(this.tLargeur);

        this.pan.add(this.bValidation);
        this.pan.add(this.bAnnulation);

        this.setContentPane(this.pan);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.bValidation) {
            int largeur = Integer.parseInt(this.tLargeur.getText());
            int hauteur = Integer.parseInt(this.tHauteur.getText());
            int fourmis = Integer.parseInt(this.tFourmis.getText());
            System.out.println("KJZDBZBHZDBHZDBHLBHLJZDBHLJDZBHLZBHLJZ");
            new Fenetre(largeur, hauteur, fourmis);
        } else if(event.getSource() == this.bAnnulation) {
            this.dispose();
        }
    }
}
