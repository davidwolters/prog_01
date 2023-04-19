package com.clock.components;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.clock.Config;


public class DateMarker extends Component {
	
	private String dayString;
	private String monthString;
	private String yearString;
	
	public DateMarker() {
		Date date = Calendar.getInstance(TimeZone.getDefault()).getTime();

		DateFormat dayFormat = new SimpleDateFormat("d");
		DateFormat monthFormat = new SimpleDateFormat("MMMM");
		DateFormat yearFormat = new SimpleDateFormat("yyyy");
		dayString = dayFormat.format(date);
		monthString = monthFormat.format(date);
		yearString = yearFormat.format(date);
	}

	@Override
	public void paint(Graphics2D g) {
		
		g.setColor(Config.Date.COLOR);
		
		int x = ClockPanel.CENTER.getScaledX() - Config.Date.SIZE / 2;
		int y = ClockPanel.CENTER.getScaledY() + Config.Date.Y_OFFSET - Config.Date.SIZE / 2;

		drawRect(x, y, g);
		drawText(x, y, g);

	}
	
	private void drawText(int x, int y, Graphics2D g) {
		g.setColor(Config.Date.TEXT) ;
		g.setFont(new Font(Config.Date.FONT, Font.PLAIN, Config.Date.FONT_SIZE));

		int dayWidth = g.getFontMetrics().stringWidth(dayString);
		int monthWidth = g.getFontMetrics().stringWidth(monthString);
		int yearWidth = g.getFontMetrics().stringWidth(yearString);

		int originX = x + Config.Date.SIZE / 2; 
		int originY = y + Config.Date.GAP  + Config.Date.FONT_SIZE;
		
		g.drawString(dayString, originX - (dayWidth/2), originY);
		originY += Config.Date.FONT_SIZE + Config.Date.GAP;
		g.drawString(monthString, originX - (monthWidth/2), originY);
		originY += Config.Date.FONT_SIZE + Config.Date.GAP;
		g.drawString(yearString, originX - (yearWidth/2), originY);	
	}
	
	private void drawRect(int x, int y, Graphics2D g) {
		g.setStroke(new BasicStroke(1));
		g.drawRect(
			x,
			y,
			Config.Date.SIZE,
			Config.Date.SIZE
		);	
	}

}