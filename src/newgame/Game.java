package newgame;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	


	
	private static final long serialVersionUID = -4553219204084625889L;
	public static final int WIDTH=640,HEIGHT = WIDTH /12*9;
	private Thread thread;
	private Handler handler;
	private HUD hud;
	private boolean running = false;
	private Spawn spawner;
	private End end;
	public enum STATE {
		Game,
		End
		};
		public static  STATE gameState= STATE.Game;
		public Game(){
			hud =new HUD();
			handler = new Handler();
			spawner =new Spawn(handler,hud);
			end =new End(this,handler,hud);
			this.addKeyListener(new KeyInput(handler));
			if (gameState==STATE.Game){
			//handler.addObject(new Player1(WIDTH-635,HEIGHT/2-80,ID.Player1,handler));
			handler.addObject(new Player(WIDTH/2,HEIGHT/2-32+165,ID.Player,handler));	
			handler.addObject(new Enemy(Game.WIDTH/2-32, Game.HEIGHT-450,ID.Enemy,handler));
			handler.addObject(new Ground(WIDTH/2-32-290,HEIGHT/2-32+190,ID.Ground,handler));
			//handler.addObject(new Projectilez(WIDTH-250,HEIGHT/2-50,ID.Projectilez,handler));
			handler.addObject(new Ceiling(WIDTH/2-32-290,HEIGHT-800,ID.Ceiling,handler));
			//handler.addObject(new Player2(WIDTH-35,HEIGHT/2-80,ID.Player2,handler));
			}
		new Window(WIDTH,HEIGHT,"Project",this);
		}

	public synchronized void start(){ 
		thread = new Thread(this);
		thread.start();
		running = true;
	}public synchronized void stop(){ 
		try{
			thread.join();
		running = false;
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	public void run() {
		this.requestFocus();
		long lastTime= System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta +=(now - lastTime) /ns;
			lastTime = now;
			while(delta >=1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
					System.out.println("FPS : "+ frames);
				frames = 0;
			}
		}
		stop();
		}
	private void tick(){
		if (gameState==STATE.Game){
		handler.tick();
		hud.tick();
		spawner.tick();}
		
		
	}

	private void render(){
		BufferStrategy bs =this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return ;
		}		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if(gameState==STATE.Game){
		hud.render(g);}
		else if(gameState==STATE.End){
			end.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	public static float clamp(float var,float min,float max){
		if(var >=max)
			return var =max;
		else if(var <=min)
			return var =min;
		else
			return var;
	}
	
	
	public static void main (String [] args){
		new Game();
}

	
	
}
