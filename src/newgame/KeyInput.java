package newgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import newgame.Game.STATE;




public class KeyInput extends KeyAdapter {

	private Handler handler;

 	
	public KeyInput(Handler handler){
		this.handler=handler;
	
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0;i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Player){
				//key events for p
				
				
				if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5);}
				if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-5);}
				if(key== KeyEvent.VK_SPACE){handler.addObject(new Projectile((int)tempObject.getX(), (int)tempObject.getY(), ID.Projectile, handler));}
				
			}
			if(tempObject.getID()==ID.Player1){
				if(key== KeyEvent.VK_W){tempObject.setVelY(5);}
				if(key== KeyEvent.VK_S){tempObject.setVelY(-5);}}
			if(tempObject.getID()==ID.Player2){
				if(key== KeyEvent.VK_W){tempObject.setVelY(5);}
				if(key== KeyEvent.VK_S){tempObject.setVelY(-5);}}
		}
		if(key == KeyEvent.VK_ESCAPE)System.exit(1);
		if(Game.gameState==STATE.End){
			if(key==KeyEvent.VK_ENTER){
				Game.gameState=STATE.Game;
				for(int i=0;i<20;i++){
				handler.ClearAll();}
				
				handler.addObject(new Player(Game.WIDTH/2-32-290,Game.HEIGHT/2-32+165,ID.Player,handler));
				HUD.score=0;
				HUD.level=1;
				
			}
			
		}
			
		
	}
	public void keyReleased(KeyEvent e){
		int key =e.getKeyCode();
		for(int i = 0;i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==ID.Player){
				//key events for p
				
			
				if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(0);}
				if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(0); }
				//if(key== KeyEvent.VK_SPACE){handler.addObject(new Projectile((int)tempObject.getX(), (int)tempObject.getY(), ID.Projectile, handler));}
				
			}
			if(tempObject.getID()==ID.Player1){
				if(key== KeyEvent.VK_W){tempObject.setVelX(0);}
				if(key== KeyEvent.VK_S){tempObject.setVelX(0);}
			}
			if(tempObject.getID()==ID.Player2){
				if(key== KeyEvent.VK_W){tempObject.setVelX(0);}
				if(key== KeyEvent.VK_S){tempObject.setVelY(0);}}
			}
		}
	}