import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurCredits implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent ae) {
		new DialogCredits();
	}
	
}
