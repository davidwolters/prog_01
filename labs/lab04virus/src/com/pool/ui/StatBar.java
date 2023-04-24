package com.pool.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pool.util.Config;

public class StatBar extends JPanel implements ActionListener {
	
	
	private static StatBar instance;
	
	private JButton pauseButton = new JButton("Pause");
	private JLabel statLabel = new JLabel();
	
	private int dead = 0;
	private int sick = 0;
	
	
	private ScenePanel panel;
	public StatBar() {
		add(pauseButton, BorderLayout.LINE_START);
		add(statLabel, BorderLayout.LINE_END);

		pauseButton.addActionListener(this);
	}
	
	
	public void setScenePanel(ScenePanel panel) {
		this.panel = panel;
	}
	
	public static StatBar getInstance() {
		if (instance == null) instance = new StatBar();
		return instance;
	}
	
	public void increaseDead() {
		dead++;
		formatLabel();
	}
	
	public void setSick(int sick) {
		this.sick = sick;
		formatLabel();
	}

	
	private void formatLabel() {
		statLabel.setText("Dead: " + dead + ", Sick: " + sick + "/" + Config.Ball.NUM_BALLS);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		panel.startStop();
	}
}
