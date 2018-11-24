package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import newgame.Game.STATE;

public class EnemyProjectile extends GameObject {
	
	Handler handler;
		HUD hud;
		
		public EnemyProjectile(int x, int y, ID id,Handler handler) {
			super(x, y, id);
			this.handler = handler;		
			velX=0;
			velY=2;
			if(HUD.level==3){
				velY=2.5f;
			}
			if(HUD.level==4){
				velY=2.8f;
			}
			if(HUD.level==5){
				velY=3;
			}
		}
		public Rectangle getBounds() {
			return new Rectangle((int)x,(int)y,16,16);
			}
		public void tick() {
			x += velX;
			y += velY;
			x=Game.clamp(x, 0, Game.WIDTH-24);
			
			if(y>= Game.HEIGHT)handler.removeObject(this);
			collision();
		}
		
		public void render(Graphics g) {
			g.setColor(Color.black);
			g.drawRect((int)x,(int) y, 16, 16);
			g.fillRect((int)x,(int) y, 16, 16);
			
		}public void collision(){
			
			for(int i=0;i<handler.object.size();i++){
				
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getID()==ID.Player){
					if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					
					handler.removeObject(this);
					handler.ClearAll();
					Game.gameState=STATE.End;
					
					}
				}else if(tempObject.getID()==ID.Ground){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(this);
					}
				}
			}
		}
	}
