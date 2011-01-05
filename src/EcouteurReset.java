import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurReset implements ActionListener {
	private DialogReset dialogReset;
	private ListeAlbums listeAlbums;
	
	public EcouteurReset(DialogReset dialogReset, ListeAlbums listeAlbums) {
		this.dialogReset = dialogReset;
		this.listeAlbums = listeAlbums;
	}
	
	public void actionPerformed(ActionEvent e) {
		listeAlbums.rmAll();
		dialogReset.setVisible(false);
	}
}
