import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ListeAlbums extends JPanel {
	private static final long serialVersionUID = 7594414639160711792L;
	private Discographie disco;
	private int cmp = 0;
	private JMenuItem afficher;

	public ListeAlbums(JMenuItem afficher) {
		super();
		disco = new Discographie();
		this.afficher = afficher;
	}
	
	public boolean contains(Album album) {
		return disco.contains(album);
	}
	
	public void add(Album album) {
		disco.add(album);
		refresh();
	}
	
	public void rm(Album album) {
		disco.rm(album);
		refresh();
	}
	
	public void rmAll() {
		disco.rmAll();
		refresh();
	}
	
	public void refresh() {
		removeAll();
		if (afficher.getText().equals("Groupe")) {
			afficherDate();
			removeAll();
			afficherGroupe();
		} else {
			afficherDate();
		}
			repaint();
		save();
	}
	
	public Color testColorDate() {
		Color color;
		if (cmp == 0)        //1 album
			color = new Color(255,255,255);
		else if (cmp == 1)   //2 albums
			color = new Color(255,230,230);
		else if (cmp == 2)   //3 albums
			color = new Color(255,200,200);
		else if (cmp == 3)   //4 albums
			color = new Color(255,150,150);
		else if (cmp == 4)   //5 albums
			color = new Color(255,75,75);
		else				//> 5 albums
			color = new Color(255,0,0);
		cmp = 0;
		return color;
	}
	
	public Color testColorGroupe() {
		Color color;
		if (cmp == 0)        //1 album
			color = new Color(255,255,255);
		else if (cmp == 1)   //2 albums
			color = new Color(220,255,230);
		else if (cmp == 2)   //3 albums
			color = new Color(190,255,200);
		else if (cmp == 3)   //4 albums
			color = new Color(140,255,150);
		else if (cmp == 4)   //5 albums
			color = new Color(70,255,75);
		else				//> 5 albums
			color = new Color(0,255,0);
		cmp = 0;
		return color;
	}
	
	public int testChar(String text) {
		String the = "the";
		String le = "le";
		String les = "les";
		String la = "la";
		if ((text.charAt(0) == the.charAt(0) && text.charAt(1) == the.charAt(1) && text.charAt(2) == the.charAt(2)) ||
				(text.charAt(0) == les.charAt(0) && text.charAt(1) == les.charAt(1) && text.charAt(2) == les.charAt(2))) {
			return 4;
		} else if ((text.charAt(0) == le.charAt(0) && text.charAt(1) == le.charAt(1)) ||
				(text.charAt(0) == la.charAt(0) && text.charAt(1) == la.charAt(1))) {
			return 3;
		} else {
			return 0;
		}
	}
	
	public boolean containsGroupe(ArrayList<JLabel> list, String nom) {
		boolean res = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(nom)) {
				res = true;
			}
		}
		return res;
	}
	
	public void afficherGroupe() {
		setLayout(new GridLayout(8,1));
		ArrayList<String> listes = new ArrayList<String>();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		JLabel label = new JLabel();
		String liste = "<html><body>";
			if (disco.size() > 0) {
				for (int i = 0; i < disco.size(); i++) {
					if (!containsGroupe(labels, disco.get(i).getGroupe())) {
						liste += "<b style='color: GREEN'>"+disco.get(i).getTitre()+"</b> ("+disco.get(i).getDate()+")";
						label = new JLabel(disco.get(i).getGroupe(), JLabel.CENTER);
						labels.add(label);
						label.setOpaque(true);
						label.setBackground(testColorDate());
						label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						listes.add(liste);
						label.addMouseListener(new EcouteurInfo(liste, Color.GREEN));
						liste = "<html><body>";
					} else {
						for (int j = 0; j < labels.size(); j++) {
							if (labels.get(j).getText().equals(disco.get(i).getGroupe())) {
								listes.add(j,listes.get(j)+"<br/><b style='color: GREEN'>"+disco.get(i).getTitre()+"</b> ("+disco.get(i).getDate()+")");
								listes.remove(j+1);
								labels.get(j).getMouseListeners();
								MouseListener[] array = labels.get(j).getMouseListeners();
								labels.get(j).removeMouseListener(array[0]);
								labels.get(j).addMouseListener(new EcouteurInfo(listes.get(j), Color.GREEN));
							}
							
							for (int jj = 0; jj < disco.size(); jj++) {
								if (disco.get(jj).getGroupe().equals(labels.get(j).getText())) {
									cmp++;
								}
							}
							cmp--;
							labels.get(j).setBackground(testColorGroupe());
						}
					}
					LinkedList<JLabel> tri = new LinkedList<JLabel>();
					int max = 0;
					boolean done = false;
					for (int k = 0; k < labels.size(); k++) {
						done = false;
						max = tri.size();
						if (tri.size() > 0) {
							for (int ii = 0; ii < max; ii++) {
								if (tri.get(ii).getText().charAt(testChar(tri.get(ii).getText())) > labels.get(k).getText().charAt(testChar(labels.get(k).getText()))) {
									if (!done)
										tri.add(ii, labels.get(k));
									done = true;
								}
							}
							if (!done)
								tri.addLast(labels.get(k));
						} else {
							tri.addLast(labels.get(k));
						}
					}
					for (int kk = 0; kk < tri.size(); kk++) {
						add(tri.get(kk));
					}
				}
			} else {
				add(new JLabel("aucun album"), JLabel.CENTER);
			}
	}
	
	public void afficherDate() {
		setLayout(new GridLayout());
		JLabel label = new JLabel();
		String liste = "<html><body>";
		if (disco.size() > 0) {
			for (int i = 0; i < disco.size()-1; i++) {
				if (disco.get(i).getDate() != disco.get(i+1).getDate()) {
					liste += "<b style='color: RED'>"+disco.get(i).getGroupe()+"</b> - "+disco.get(i).getTitre()+"</body></html>";
					label = new JLabel(""+disco.get(i).getDate(), JLabel.CENTER);
					add(label);
					label.setOpaque(true);
					label.setBackground(testColorDate());
					label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
					label.addMouseListener(new EcouteurInfo(liste, Color.RED));
					liste = "<html><body>";
				} else {
					liste += "<b style='color: RED'>"+disco.get(i).getGroupe()+"</b> - "+disco.get(i).getTitre()+"<br/>";
					cmp++;
				}
			}
			liste += "<b style='color: RED'>"+disco.get(disco.size()-1).getGroupe()+"</b> - "+disco.get(disco.size()-1).getTitre()+"</body></html>";
			label = new JLabel(""+disco.get(disco.size()-1).getDate(), JLabel.CENTER);
			label.setOpaque(true);
			label.setBackground(testColorDate());
			add(label);
			label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			label.addMouseListener(new EcouteurInfo(liste, Color.RED));
		} else {
			add(new JLabel("aucun album"), JLabel.CENTER);
		}
	}
	
	public void save() {
		try {
		    FileOutputStream fos = new FileOutputStream(".albums.dis"); 
		    ObjectOutputStream oos = new ObjectOutputStream(fos); 
		    try {
		    	oos.writeObject(disco);
		    	oos.flush();
		    } finally {
		    	try {
		    		oos.close();
		    	} finally {
		    		fos.close();
		    	}
		    }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void load() {
		try {
			FileInputStream fis = new FileInputStream(".albums.dis"); 
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    try {
			    disco = (Discographie) ois.readObject();
		    } finally {
		    	try {
		    		ois.close();
		    	} finally {
		    		fis.close();
		    	}
		    }
		} catch (IOException e) {
			save();
		} catch (ClassNotFoundException ee) {
			ee.printStackTrace();
		}
		refresh();
	}
	
	public String toString() {
		return disco.toString();
	}
}
