import java.io.Serializable;

public class Album implements Serializable {
	private static final long serialVersionUID = 354039922486630329L;
	private String groupe;
	private String titre;
	private int date;
	
	public Album(String groupe, String titre, int date) {
		this.groupe = groupe;
		this.titre = titre;
		this.date = date;
	}
	
	public String getGroupe() {
		return groupe;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public int getDate() {
		return date;
	}
	
	public String toString() {
		return groupe+" - "+titre+" ("+date+")";
	}
}
