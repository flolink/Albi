import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAjout implements ActionListener {
	ListeAlbums listeAlbums;
	DialogModif dialogModif;
	
	public EcouteurAjout(ListeAlbums listeAlbums, DialogModif dialogModif) {
		this.listeAlbums = listeAlbums;
		this.dialogModif = dialogModif;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean dateNombre = true;
		for (int i = 0; i < dialogModif.getDate().length(); i++) {
			if (dialogModif.getDate().length() != 4)
				dateNombre = false;
			if (dateNombre && (dialogModif.getDate().charAt(i) > '9' || dialogModif.getDate().charAt(i) < '0')) {
				dateNombre = false;
			}
		}
		if (dialogModif.getDate().equals(""))
			dateNombre = false;
		if (dateNombre) {
			if (!listeAlbums.contains(new Album(dialogModif.getGroupe(), dialogModif.getTitre(), Integer.parseInt(dialogModif.getDate())))) {
				if (dateNombre && (!dialogModif.getGroupe().equals("") && !dialogModif.getTitre().equals(""))) {
					listeAlbums.add(new Album(dialogModif.getGroupe(), dialogModif.getTitre(), Integer.parseInt(dialogModif.getDate())));
					dialogModif.setVisible(false);
				} else {
					dialogModif.setTitre("");
					dialogModif.setGroupe("");
					dialogModif.setDate("");
				}
			} else {
				dialogModif.setTitre("");
				dialogModif.setGroupe("");
				dialogModif.setDate("");	
			}
		} else {
			dialogModif.setTitre("");
			dialogModif.setGroupe("");
			dialogModif.setDate("");			
		}
	}
}
