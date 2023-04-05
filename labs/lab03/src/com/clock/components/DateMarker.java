package com.clock.components;

import java.awt.Graphics2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.clock.Config;


public class DateMarker extends Component {
	
	private String dateString;
	
	public DateMarker() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("d MMM");
		dateString = dateFormat.format(date);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		
		g.setColor(Config.Date.COLOR);
		g.fillRect(0, 0, Config.Date.SIZE, Config.Date.SIZE);
		
		g.setColor(Config.Date.TEXT) ;
		g.drawString(dateString, 30, 40);
	}

}
