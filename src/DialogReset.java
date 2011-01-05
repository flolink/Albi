import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogReset extends JDialog {
	private static final long serialVersionUID = -8619147832802983555L;

	public DialogReset(ListeAlbums listeAlbums, DialogModif dialogModif) {
		JPanel panelTour = new JPanel();
		JPanel panelOther = new JPanel();
		panelTour.setLayout(new GridLayout());
		panelOther.setLayout(new GridLayout(1,2));
		setTitle("reset");
		setUndecorated(true);
		dialogModif.setVisible(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Albi.png")));
		panelTour.setBorder(BorderFactory.createLineBorder(Color.RED));
		panelOther.setBorder(BorderFactory.createTitledBorder("reset ?"));
		panelTour.add(panelOther);
		add(panelTour);
		JButton ok = new JButton("ok");
		JButton annuler = new JButton("annuler");
		panelOther.add(ok);
		panelOther.add(annuler);
		ok.addActionListener(new EcouteurReset(this, listeAlbums));
		annuler.addActionListener(new EcouteurAnnuler(this));
		setSize(200,200);
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
