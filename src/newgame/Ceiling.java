package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


	public class Ceiling extends GameObject {
		Handler handler;
		public Ceiling(int x, int y, ID id,Handler handler) {
			super(x, y, id);
			this.handler = handler;		
		}
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int)y,Game.WIDTH,50);
			}
		public void tick() {
			x += velX;
			y += velY;
			x=Game.clamp(x, 0, Game.WIDTH-24);
			y=Game.clamp(y, 0, Game.HEIGHT-530);
		}
		
		public void render(Graphics g) {
			g.setColor(Color.black);
			g.drawRect((int)x,(int) y, Game.WIDTH, 50);
			g.fillRect((int)x,(int)y, Game.WIDTH, 50);
			
		}
}

