package com.pool.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.pool.scenes.PoolScene;

public class PoolFrame extends JFrame {
	public PoolFrame(String name) {
		super(name);
		
		initWindow();
	}
	
	private void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ScenePanel panel  = new ScenePanel();
		panel.setScene(new PoolScene(panel));

		add(panel, BorderLayout.PAGE_START);
		add(StatBar.getInstance(), BorderLayout.PAGE_END);
		StatBar.getInstance().setScenePanel(panel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
