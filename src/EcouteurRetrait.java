import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EcouteurRetrait implements ActionListener {
	private ListeAlbums listeAlbums;
	private DialogModif dialogModif;
	
	public EcouteurRetrait(ListeAlbums listeAlbums, DialogModif dialogModif) {
		this.listeAlbums = listeAlbums;
		this.dialogModif = dialogModif;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean dateNombre = true;
		if (dialogModif.getTitre().equals("reset.dis") || dialogModif.getGroupe().equals("reset.dis") || dialogModif.getDate().equals("reset.dis")) {
			new DialogReset(listeAlbums, dialogModif);
		} else {
			for (int i = 0; i < dialogModif.getDate().length(); i++) {
				if (dialogModif.getDate().length() != 4)
					dateNombre = false;
				if (dateNombre && (dialogModif.getDate().charAt(i) > '9' || dialogModif.getDate().charAt(i) < '0')) {
					dateNombre = false;
				}
			}
			if (dialogModif.getDate().equals(""))
				dateNombre = false;
			if (dateNombre && listeAlbums.contains(new Album(dialogModif.getGroupe(), dialogModif.getTitre(), Integer.parseInt(dialogModif.getDate())))) {
				listeAlbums.rm(new Album(dialogModif.getGroupe(), dialogModif.getTitre(), Integer.parseInt(dialogModif.getDate())));
				dialogModif.setVisible(false);			
			} else {
				dialogModif.setTitre("");
				dialogModif.setGroupe("");
				dialogModif.setDate("");			
			}
		}
	}
	
}
