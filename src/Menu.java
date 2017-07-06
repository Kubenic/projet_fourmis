import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Menu extends JFrame implements ActionListener {
    private JLabel lFourmis = new JLabel("Fourmis :");
    private JLabel lNourriture = new JLabel("Nourriture :");
    private JLabel lHauteur = new JLabel("Hauteur:");
    private JLabel lLargeur = new JLabel("Largeur :");
    private JTextField  tFourmis = new JTextField();
    private JTextField  tNourriture = new JTextField();
    private JTextField  tHauteur = new JTextField();
    private JTextField  tLargeur = new JTextField();
    private JButton bValidation = new JButton("Valider");
    private JButton bAnnulation = new JButton("Quitter");
    private final String error = "Message d'erreur";
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
        this.bValidation.addActionListener(this);
        this.bAnnulation.addActionListener(this);

        this.setContentPane(this.pan);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.bValidation) {
            if (this.tLargeur.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Le champ "+ this.lLargeur.getText() +" est vide !",
                        this.error,
                        JOptionPane.ERROR_MESSAGE);
            }

            if (this.tHauteur.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Le champ "+ this.lHauteur.getText() +" est vide !",
                        this.error,
                        JOptionPane.ERROR_MESSAGE);
            }

            if (this.tNourriture.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Le champ "+ this.lNourriture.getText() +" est vide !",
                        this.error,
                        JOptionPane.ERROR_MESSAGE);
            }

            if (this.tFourmis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Le champ "+ this.lFourmis.getText() +" est vide !",
                        this.error,
                        JOptionPane.ERROR_MESSAGE);
            }

            if (!this.tLargeur.getText().isEmpty() && !this.tHauteur.getText().isEmpty() &&
                    !this.tFourmis.getText().isEmpty() && !this.tFourmis.getText().isEmpty()) {
                int largeur = Integer.parseInt(this.tLargeur.getText().trim());
                int hauteur = Integer.parseInt(this.tHauteur.getText().trim());
                int fourmis = Integer.parseInt(this.tFourmis.getText().trim());
                int nourriture = Integer.parseInt(this.tNourriture.getText().trim());

                new Fenetre(largeur, hauteur, fourmis, nourriture);
                this.dispose();
            }
        } else if(event.getSource() == this.bAnnulation) {
            this.dispose();
        }
    }
}
