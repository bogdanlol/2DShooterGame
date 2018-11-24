package newgame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
public static  int score;
public static int level=1;
public void tick(){}


public void render(Graphics g){
	
	g.setColor(Color.black);
	
	g.drawString("Score: " + score,15,16);
	g.drawString("Level: " + level,15,32);
}


public int getScore() {
	return score;
}


public void setScore(int score) {
	this.score = score;
}


public int getLevel() {
	return level;
}


public void setLevel(int level) {
	this.level = level;
}
}
