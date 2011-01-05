import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class EcouteurInfo implements MouseListener {
	DialogInfo dialogInfo;
	
	public EcouteurInfo(String albums, Color color) {
		dialogInfo = new DialogInfo(albums, color);
	}

	@Override
	public void mouseClicked(MouseEvent ae) {		
	}

	@Override
	public void mouseEntered(MouseEvent ae) {		
	}

	@Override
	public void mouseExited(MouseEvent ae) {		
	}

	@Override
	public void mousePressed(MouseEvent ae) {	
		dialogInfo.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent ae) {		
		dialogInfo.setVisible(false);
	}
}
