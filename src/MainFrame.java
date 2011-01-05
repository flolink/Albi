import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ListeAlbums listeAlbums;
	private Image IMAGEALBI = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Albi.png"));

	public MainFrame(int x, int y) {
		super("albi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(IMAGEALBI);
		setSize(x, y);
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			PopupMenu popup = new PopupMenu();
			MenuItem quitterTray = new MenuItem("quitter");
			quitterTray.addActionListener(new EcouteurQuitter());
			popup.add(quitterTray);
			TrayIcon trayIcon = new TrayIcon(IMAGEALBI, "Albi", popup);
			trayIcon.setImageAutoSize(true);
			trayIcon.addMouseListener(new EcouteurTray(this));
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem modifier = new JMenuItem("Modifier");
		JMenuItem affichage = new JMenuItem("Dates");
		JMenuItem credits = new JMenuItem("?");
		JPanel panelModif = new JPanel();
		JPanel panelAffichage = new JPanel();
		JPanel panelQuitter = new JPanel();
		panelModif.setLayout(new GridLayout());
		panelAffichage.setLayout(new GridLayout());
		panelQuitter.setLayout(new GridLayout());
		panelModif.add(modifier);
		panelAffichage.add(affichage);
		panelQuitter.add(credits);
		menuBar.add(panelModif);
		menuBar.add(panelAffichage);
		menuBar.add(panelQuitter);
		setJMenuBar(menuBar);
		listeAlbums = new ListeAlbums(affichage);
		add(listeAlbums);
		listeAlbums.load();
		panelModif.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelAffichage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelQuitter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		affichage.setBackground(Color.BLACK);
		affichage.setForeground(Color.WHITE);
		modifier.addActionListener(new EcouteurModif(listeAlbums));
		affichage.addActionListener(new EcouteurAffichage(listeAlbums));
		credits.addActionListener(new EcouteurCredits());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
