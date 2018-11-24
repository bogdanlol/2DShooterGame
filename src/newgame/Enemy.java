package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



import java.awt.Rectangle;


public class Enemy extends GameObject {
	Random r =new Random();
	
	private Handler handler;

	public Enemy(float x, float y, ID id,Handler handler) {
		
		super(x, y, id);
		this.handler = handler;
		velX=r.nextInt(2)-3;
				
		velY=0;
	}

	public void tick() {
		x+=velX;
		y+=velY;
		x=Game.clamp(x, 0, Game.WIDTH-24);
		y=Game.clamp(y, 0, Game.HEIGHT-114);
		
			int spawn = r.nextInt(90);
			if(spawn == 0){handler.addObject(new EnemyProjectile((int)x+8,(int)y+24,ID.EnemyProjectile,handler));}
		if(x<=0 || x >=Game.WIDTH-36) velX *=-1;
			

	}

	public void render(Graphics g) {
		
	g.setColor(Color.red);
	g.fillRect((int)x,(int)y, 32, 32);
		
	}


	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}

	
	

}
