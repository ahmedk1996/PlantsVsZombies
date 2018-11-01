package Model;
import java.awt.event.*;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;
	
	public Controller(Game game, View view) {
		this.game=game;
		this.view=view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
