package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;







public class Projectile extends GameObject {
		
	Handler handler;
		HUD hud;
		
		public Projectile(int x, int y, ID id,Handler handler) {
			super(x, y, id);
			this.handler = handler;		
			velX=0;
			velY=-5;
		}
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int)y,16,16);
			}
		public void tick() {
			x += velX;
			y += velY;
			x=Game.clamp(x, 0, Game.WIDTH-24);

			if(y> Game.HEIGHT)handler.removeObject(this);
			collision();
		}
		
		public void render(Graphics g) {
			g.setColor(Color.blue);
			g.drawRect((int)x,(int) y, 16, 16);
			g.fillRect((int)x,(int) y, 16, 16);
			
		}
		public void collision(){
			
			for(int i=0;i<handler.object.size();i++){
				
				GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Ceiling){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(this);}}
				 if(tempObject.getID()==ID.Enemy){
					if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					HUD.score+=10;
					handler.removeObject(this);
					
			}
			
		}
			}
}
			
		}
