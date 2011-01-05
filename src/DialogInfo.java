import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogInfo extends JDialog {
	private static final long serialVersionUID = 4562859961578458421L;

	public DialogInfo(String albums, Color color) {
		JPanel panel = new JPanel();
		setTitle("informations");
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Albi.png")));
		panel.setBorder(BorderFactory.createLineBorder(color));
		add(panel);
		JLabel label = new JLabel(albums);
		panel.add(label);
		setSize(500,200);
		setLocationRelativeTo(null);
	}
}
