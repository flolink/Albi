import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogCredits extends JDialog {
	private static final long serialVersionUID = -1994051266574269318L;

	public DialogCredits() {
		JPanel mainPanel = new JPanel();
		JPanel panelGauche = new JPanel();
		JPanel panelDroite = new JPanel();
		
		setTitle("?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Albi.png")));

		JLabel nomT = new JLabel("<html><body><u><b style='color: #000000'>Nom<b></u> :</body></html>", JLabel.CENTER);
		JLabel versionT = new JLabel("<html><body><u><b style='color: #000000'>Version<b></u> :</body></html>", JLabel.CENTER);
		JLabel dateT = new JLabel("<html><body><u><b style='color: #000000'>Date<b></u> :</body></html>", JLabel.CENTER);
		JLabel auteurT = new JLabel("<html><body><u><b style='color: #000000'>Auteur<b></u> :</body></html>", JLabel.CENTER);
		JLabel groupeT = new JLabel("<html><body><u><b style='color: #000000'>Groupe<b></u> :</body></html>", JLabel.CENTER);
		JLabel titreT = new JLabel("<html><body><h1><b style='color: #FFFFFF'>?<b></h1></body></html>", JLabel.CENTER);
		JLabel nom = new JLabel("<html><body><h1><b style='color: #000000'>Albi<b></h1></body></html>", JLabel.CENTER);
		JLabel version = new JLabel("<html><body><h5><b style='color: #000000'>v1.2<b></h5></body></html>", JLabel.CENTER);
		JLabel date = new JLabel("<html><body><h4><b style='color: #000000'>Avril 2010<b></h4></body></html>", JLabel.CENTER);
		JLabel auteur = new JLabel("<html><body><h3><b style='color: #000000'>Florian Lepinay<b></h3></body></html>", JLabel.CENTER);
		JLabel groupe = new JLabel("<html><body><h2><b style='color: #000000'>BLG<b></h2></body></html>", JLabel.CENTER);
		JPanel fermer = new JPanel();
		JButton clore = new JButton("Fermer");
		
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		setUndecorated(true);
		setModal(true);
		mainPanel.setLayout(new GridLayout(1, 2));
		panelGauche.setLayout(new GridLayout(6, 1));
		panelDroite.setLayout(new GridLayout(6, 1));
		fermer.setLayout(new GridLayout());
		
		mainPanel.add(panelGauche);
		mainPanel.add(panelDroite);

		panelGauche.add(titreT);
		titreT.setOpaque(true);
		titreT.setBackground(new Color(0,0,255));
		titreT.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelGauche.add(nomT);
		nomT.setOpaque(true);
		nomT.setBackground(new Color(100,100,255));
		panelGauche.add(versionT);
		versionT.setOpaque(true);
		versionT.setBackground(new Color(120,120,255));
		panelGauche.add(dateT);
		dateT.setOpaque(true);
		dateT.setBackground(new Color(140,140,255));
		panelGauche.add(auteurT);
		auteurT.setOpaque(true);
		auteurT.setBackground(new Color(160,160,255));
		panelGauche.add(groupeT);
		groupeT.setOpaque(true);
		groupeT.setBackground(new Color(180,180,255));

		panelDroite.add(fermer);
		fermer.add(clore);
		clore.addActionListener(new EcouteurFermer(this));
		fermer.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelDroite.add(nom);
		nom.setOpaque(true);
		nom.setBackground(new Color(140,140,255));
		panelDroite.add(version);
		version.setOpaque(true);
		version.setBackground(new Color(160,160,255));
		panelDroite.add(date);
		date.setOpaque(true);
		date.setBackground(new Color(180,180,255));
		panelDroite.add(auteur);
		auteur.setOpaque(true);
		auteur.setBackground(new Color(200,200,255));
		panelDroite.add(groupe);
		groupe.setOpaque(true);
		groupe.setBackground(new Color(220,220,255));
		
		add(mainPanel);
		setSize(300,200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
