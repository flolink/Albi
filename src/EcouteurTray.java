import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurTray implements MouseListener {
	private MainFrame mainFrame;
	
	public EcouteurTray(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		mainFrame.setVisible(!mainFrame.isVisible());
	}

	@Override
	public void mouseEntered(MouseEvent me) {
	}

	@Override
	public void mouseExited(MouseEvent me) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
	}

	@Override
	public void mouseReleased(MouseEvent me) {
	}
}