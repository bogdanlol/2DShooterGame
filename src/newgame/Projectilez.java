package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


	public class Projectilez extends GameObject {
		
		Handler handler;
			HUD hud;
			
			public Projectilez(int x, int y, ID id,Handler handler) {
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

				y=Game.clamp(y,0,Game.HEIGHT-24);
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
							setVelY((int) (getVelY()+10));
							setVelX((int)getVelX()+1);}}
					if(tempObject.getID()==ID.Ground){
						if(getBounds().intersects(tempObject.getBounds())){
							setVelY((int) (getVelY()-10));
							setVelX((int)getVelX()+1);}}
					if(tempObject.getID()==ID.Player1){
						if(getBounds().intersects(tempObject.getBounds())){
							setVelY((int) (getVelY()-10));
							setVelX((int)getVelX()+1);}}
					if(tempObject.getID()==ID.Player2){
						if(getBounds().intersects(tempObject.getBounds())){
							setVelY((int) (getVelY()-10));
							setVelX((int)getVelX()+1);}}
					}
}
					}