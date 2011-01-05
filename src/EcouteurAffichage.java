import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class EcouteurAffichage implements ActionListener {
	private ListeAlbums listeAlbums;
	
	public EcouteurAffichage(ListeAlbums listeAlbums) {
		this.listeAlbums = listeAlbums;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem menuItem = ((JMenuItem) ae.getSource());
		if (menuItem.getText().equals("Groupe")) {
			menuItem.setText("Dates");
		} else {
			menuItem.setText("Groupe");
		}
		listeAlbums.refresh();
	}

}
