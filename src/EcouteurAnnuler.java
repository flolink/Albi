import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class EcouteurAnnuler implements ActionListener {
	private JDialog dialog;
	
	public EcouteurAnnuler(JDialog dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent ae) {
		dialog.setVisible(false);
	}
}
