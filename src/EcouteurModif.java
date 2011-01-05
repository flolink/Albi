import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurModif implements ActionListener {
	private ListeAlbums listeAlbums;
	
	public EcouteurModif(ListeAlbums listeAlbums) {
		this.listeAlbums = listeAlbums;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new DialogModif(listeAlbums);
	}
	
}
