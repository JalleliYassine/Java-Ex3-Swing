import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GestionEtudiantsUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private IGestionEtudiants gestionEtudiants;
    private JTextField nomField, prenomField, filiereField, mcField;
    public GestionEtudiantsUI() {
        super("Gestion des étudiants");

        gestionEtudiants = new GestionEtudiants();

        JPanel ajoutPanel = createAjoutPanel();
        JPanel recherchePanel = createRecherchePanel();
        JPanel tablePanel = createAjoutPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(ajoutPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(recherchePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(tablePanel);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createAjoutPanel() {
        JLabel label = new JLabel("Ajouter un étudiant");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel nomLabel = new JLabel("Nom :");
        JLabel prenomLabel = new JLabel("Prénom :");
        JLabel sexeLabel = new JLabel("Sexe :");
        JLabel filiereLabel = new JLabel("Filière :");
        nomField = new JTextField(20);
        prenomField = new JTextField(20);
        JTextField sexeField = new JTextField(20);
        filiereField = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(prenomLabel);
        panel.add(prenomField);
        panel.add(sexeLabel);
        panel.add(sexeField);
        panel.add(filiereLabel);
        panel.add(filiereField);

        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String sexe = sexeField.getText();
                String filiere = filiereField.getText();
                Etudiant etudiant = new Etudiant(nom, prenom, sexe, filiere);
                gestionEtudiants.ajouterEtudiant(etudiant);
                refreshTable();
                nomField.setText("");
                prenomField.setText("");
                sexeField.setText("");
                filiereField.setText("");
            }
        });

        panel.add(Box.createVerticalStrut(10));
        panel.add(ajouterButton);

        return panel;
    }

    protected void refreshTable() {
    }

    private JPanel createRecherchePanel() {
    JLabel label = new JLabel("Rechercher un étudiant");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JLabel mcLabel = new JLabel("Mot-clé :");
    mcField = new JTextField(20);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(label);
    panel.add(Box.createVerticalStrut(10));
    panel.add(mcLabel);
    panel.add(mcField);

    JButton rechercherButton = new JButton("Rechercher");
    rechercherButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String mc = mcField.getText();
            List<Etudiant> resultats = gestionEtudiants.rechercherParMC(mc);
            updateTable(resultats);
        }

        private void updateTable(List<Etudiant> resultats) {
        }
    });
    
    panel.add(Box.createVerticalStrut(10));
    panel.add(rechercherButton);

    return panel;
     
} 
}


