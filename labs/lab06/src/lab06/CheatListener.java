package lab06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CheatListener implements KeyListener {
	
	private PlayerInterface game;
	
	
	private final String PASSWORD = "123456";
	private final int LEN = PASSWORD.length();
	private String lastTyped = "";
	
	public CheatListener(PlayerInterface game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		lastTyped += e.getKeyChar();
		lastTyped = lastTyped.substring(Math.max(0, lastTyped.length() - (LEN)));
		System.out.println(lastTyped + ", " + lastTyped.length());
		
		if (lastTyped.equals(PASSWORD)) {
			System.out.println("CHEAT ENETERD");
			game.cheatEntered();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
