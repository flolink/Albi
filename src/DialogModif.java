import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogModif extends JDialog {
	private static final long serialVersionUID = -5090042818667417895L;
	private JTextField textGroupe;
	private JTextField textTitre;
	private JTextField textDate;

	public DialogModif(ListeAlbums listeAlbums) {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setUndecorated(true);
		setModal(true);
		mainPanel.setLayout(new GridLayout(2, 3));
		//les 3 panels et le label
		JPanel panelGroupe = new JPanel();
		panelGroupe.setBorder(BorderFactory.createTitledBorder("Groupe"));
		JPanel panelTitre = new JPanel();
		panelTitre.setBorder(BorderFactory.createTitledBorder("Titre"));
		JPanel panelDate = new JPanel();
		panelDate.setBorder(BorderFactory.createTitledBorder("Date"));
		//les 3 zones de texte
		textTitre = new JTextField("", 7);
		textGroupe = new JTextField("", 7);
		textDate = new JTextField("", 7);
		//les boutons
		JButton ajout = new JButton("ajout");
		ajout.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		JButton retrait = new JButton("retrait");
		retrait.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		JButton annuler = new JButton("annuler");
		annuler.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		//ajouts
		add(mainPanel);
		panelTitre.add(textTitre);
		panelGroupe.add(textGroupe);
		panelDate.add(textDate);
		mainPanel.add(panelGroupe);
		mainPanel.add(panelTitre);
		mainPanel.add(panelDate);
		mainPanel.add(ajout);
		mainPanel.add(retrait);
		mainPanel.add(annuler);
		ajout.addActionListener(new EcouteurAjout(listeAlbums, this));
		retrait.addActionListener(new EcouteurRetrait(listeAlbums, this));
		annuler.addActionListener(new EcouteurAnnuler(this));
				
		setSize(300,200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setGroupe(String groupe) {
		textGroupe.setText(groupe);
	}
	
	public void setTitre(String titre) {
		textTitre.setText(titre);
	}
	
	public void setDate(String date) {
		textDate.setText(date);
	}
	
	public String getGroupe() {
		return textGroupe.getText();
	}
	
	public String getTitre() {
		return textTitre.getText();
	}
	
	public String getDate() {
		return textDate.getText();
	}
}
