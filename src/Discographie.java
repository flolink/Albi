import java.io.Serializable;
import java.util.LinkedList;

public class Discographie implements Serializable {
	private static final long serialVersionUID = 5739691603565646137L;
	private LinkedList<Album> albums;
	
	public Discographie() {
		albums = new LinkedList<Album>();
	}
	
	public void add(Album album) {
		boolean done = false;
		int max = albums.size();
		if (!contains(album)) {
			if (albums.size() > 0) {
				for (int i = 0; i < max; i++) {
					if (album.getDate() < albums.get(i).getDate()) {
						if (!done)
							albums.add(i, album);
						done = true;
					}
				}
				if (!done)
					albums.addLast(album);
			} else
				albums.addLast(album);
		}
	}
	
	public void rm(Album album) {
		for (int i = 0; i < albums.size(); i++) {
			if (albums.get(i).getTitre().equals(album.getTitre()) &&
				albums.get(i).getGroupe().equals(album.getGroupe()) &&
				albums.get(i).getDate() == album.getDate())
					albums.remove(i);
		}
	}
	
	public void rmAll() {
		albums.clear();
	}

	public boolean contains(Album album) {
		boolean contient = false;
		for (int i = 0; i < albums.size(); i++) {
			if (albums.get(i).getGroupe().equals(album.getGroupe()) &&
				albums.get(i).getTitre().equals(album.getTitre()) &&
				albums.get(i).getDate() == album.getDate())
					contient = true;
		}
		return contient;
	}
	
	public Album get(int index) {
		return albums.get(index);
	}
	
	public int size() {
		return albums.size();
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i < albums.size(); i++)
			res += "\n"+albums.get(i);
		return res;
	}
}
