import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class EcouteurFermer implements ActionListener {
	JDialog dialog;
	
	public EcouteurFermer(JDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		dialog.setVisible(false);
	}
}
