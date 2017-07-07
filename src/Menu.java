import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private JButton bSaveXmlConfig = new JButton("Créer une configuration");
    private JButton bGetXmlConfig = new JButton("Charger une configuration");
    private JFileChooser chooser = new JFileChooser();
    private String pathFolder = "";
    private final String error = "Message d'erreur";
    private JPanel pan = new JPanel();

    public Menu() {
        this.setTitle("Menu de configuration");
        this.setSize(500,200);

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

        this.pan.add(this.bSaveXmlConfig);
        this.pan.add(this.bGetXmlConfig);
        this.pan.add(this.bValidation);
        this.pan.add(this.bAnnulation);

        this.bValidation.addActionListener(this);
        this.bAnnulation.addActionListener(this);
        this.bSaveXmlConfig.addActionListener(this);
        this.bGetXmlConfig.addActionListener(this);

        this.setResizable(false);
        this.setContentPane(this.pan);
        this.setVisible(true);
    }

    public void generateXmlConfig() {
        if (this.checkForm()) {
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<configuration>" +
                    "<fourmis>" + this.tFourmis.getText() + "</fourmis>" +
                    "<nourriture>" + this.tNourriture.getText() + "</nourriture>" +
                    "<hauteur>" + this.tHauteur.getText() + "</hauteur>" +
                    "<largeur>" + this.tLargeur.getText() + "</largeur>" +
                    "</configuration>";
            this.generateFileConfig(xml);
        }
    }

    public void generateFileConfig(String xml) {
        if (this.chooseFolderDirectory()) {
            File file = new File(this.pathFolder +"/fourmi_conf.xml");

            try {
                if (file.createNewFile()) {
                    System.out.println("Le fichier a bien été créé");
                } else {
                    System.out.println("Le fichier existe déjà, il sera écrasé");
                }
                FileWriter writer = new FileWriter(file);

                writer.write(xml);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean chooseFolderDirectory() {
        this.chooser.setDialogTitle("Choissisez une destination de sauvegarde");
        this.chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.pathFolder = this.chooser.getSelectedFile().toString();
            return true;
        }
        return false;
    }

    public boolean chooseFileDirectory() {
        this.chooser.setDialogTitle("Choissisez un fichier de configuration");
        this.chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.chooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.pathFolder = this.chooser.getSelectedFile().toString();
            return true;
        }
        return false;
    }

    public void parseXmlConfig() throws ParserConfigurationException, IOException, SAXException {
        if (this.chooseFileDirectory()) {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document= builder.parse(new File(this.pathFolder));
            final Element racine = document.getDocumentElement();

            final NodeList racineNoeuds = racine.getChildNodes();

            final int nbRacineNoeuds = racineNoeuds.getLength();

            for (int i = 0; i<nbRacineNoeuds; i++) {
                if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    final Node value = racineNoeuds.item(i);

                    if (value.getNodeName().equals("fourmis")) {
                        this.tFourmis.setText(value.getTextContent());
                    }

                    if (value.getNodeName().equals("nourriture")) {
                        this.tNourriture.setText(value.getTextContent());
                    }

                    if (value.getNodeName().equals("hauteur")) {
                        this.tHauteur.setText(value.getTextContent());
                    }

                    if (value.getNodeName().equals("largeur")) {
                        this.tLargeur.setText(value.getTextContent());

                    }
                }
            }
        }
    }

    public boolean checkForm() {
        boolean formError = true;

        if (this.tLargeur.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Le champ "+ this.lLargeur.getText() +" est vide !",
                    this.error,
                    JOptionPane.ERROR_MESSAGE);
            formError = false;
        }

        if (this.tHauteur.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Le champ "+ this.lHauteur.getText() +" est vide !",
                    this.error,
                    JOptionPane.ERROR_MESSAGE);
            formError = false;
        }

        if (this.tNourriture.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Le champ "+ this.lNourriture.getText() +" est vide !",
                    this.error,
                    JOptionPane.ERROR_MESSAGE);
            formError = false;
        }

        if (this.tFourmis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Le champ "+ this.lFourmis.getText() +" est vide !",
                    this.error,
                    JOptionPane.ERROR_MESSAGE);
            formError = false;
        }
        return formError;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.bValidation) {
            if (!this.tLargeur.getText().isEmpty() && !this.tHauteur.getText().isEmpty() &&
                    !this.tFourmis.getText().isEmpty() && !this.tFourmis.getText().isEmpty()) {
                int largeur = Integer.parseInt(this.tLargeur.getText().trim());
                int hauteur = Integer.parseInt(this.tHauteur.getText().trim());
                int fourmis = Integer.parseInt(this.tFourmis.getText().trim());
                int nourriture = Integer.parseInt(this.tNourriture.getText().trim());

                new Fenetre(largeur, hauteur, fourmis, nourriture);
                this.dispose();
                //new Controller(largeur, hauteur, fourmis, nourriture);
            }
        } else if (event.getSource() == this.bSaveXmlConfig) {
            this.generateXmlConfig();

        } else if (event.getSource() == this.bGetXmlConfig) {
            try {

                this.parseXmlConfig();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource() == this.bAnnulation) {
            this.dispose();
        }
    }
}
