package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player2 extends GameObject{
	
	Handler handler;
	public Player2(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,24,72);
		}
	public void tick() {
		x += velX;
		y += velY;
		x=Game.clamp(x, 0, Game.WIDTH-24);
		y=Game.clamp(y, 0, Game.HEIGHT-95);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect((int)x,(int) y, 24, 72);
		g.fillRect((int)x,(int) y, 24, 72);
		
	}
}