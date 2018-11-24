package newgame;
import java.util.Random;







public class Spawn {
private Handler handler;
private HUD hud;
private int timer= 0;
private Random r = new Random();
public Spawn(Handler handler,HUD hud){
	this.handler = handler;
	this.hud = hud;
	
}
public void tick(){
	
	timer++;
	if (hud.getLevel()==1){
	if(timer >=150){
		timer =0;
		
		if (hud.getScore()<=10){
			handler.addObject(new Enemy(Game.WIDTH/2-32, Game.HEIGHT-450,ID.Enemy,handler));}
		else if(hud.getScore()<=20){
			for(int i =0;i<7;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-430,ID.Enemy,handler));
				
			}}
		else if(hud.getScore()>=30&&hud.getScore()<=50){
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-430,ID.Enemy,handler));
		}
			else if (hud.getScore()<=300){
				for(int i =0;i<9;i++){
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-410,ID.Enemy,handler));
			}}
				else if (hud.getScore()<=500&&hud.getScore()>=300){
					for(int i =0;i<11;i++){
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-390,ID.Enemy,handler));}}
				else if(hud.getScore()>500&&hud.getScore()<700){
					hud.setLevel(2);
					
				}
		
		}
}else if(hud.getLevel()==2){
	if(timer >=125){
		timer=0;
		if(hud.getScore()>=500&&hud.getScore()<=750){
			for(int i =0;i<7;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-390,ID.Enemy,handler));}}
		
	else if(hud.getScore()>=750&&hud.getScore()<=1000){
		
		for(int i =0;i<9;i++){
			
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-410,ID.Enemy,handler));}}
	else if(hud.getScore()>=1000&&hud.getScore()<=1350){
		for (int i = 0 ;i<7;i++){
		handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-430,ID.Enemy,handler));}
		
	}
	else if(hud.getScore()>=1350&&hud.getScore()<=1600){
		for(int i =0;i<11;i++){
		handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-430,ID.Enemy,handler));
	}
		}
	else if(hud.getScore()>=1600&&hud.getScore()<=1800){
		for(int i =0;i<13;i++){
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-430,ID.Enemy,handler));
			hud.setLevel(3);
	}}
	}
	
}else if(hud.getLevel()==3){
	if (timer>=100){
		timer=0;
		
		if(hud.getScore()>=1800&&hud.getScore()<=2100){
			for(int i =0;i<9;i++){
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-32),Game.HEIGHT-410,ID.Enemy,handler));}
		}else if(hud.getScore()>=2100&&hud.getScore()<=2600){
			for(int i =0;i<11;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-80),Game.HEIGHT-410,ID.Enemy,handler));} 
		}else if(hud.getScore()>=2600&&hud.getScore()<=3200){
			for(int i =0;i<13;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-60),Game.HEIGHT-410,ID.Enemy,handler));
				hud.setLevel(4);
			} 
		}
	}
}
	
else if(hud.getLevel()==4){
	if(timer>=75){
		timer=0;
		if(hud.getScore()>=3200&&hud.getScore()<=3600){
			for(int i =0;i<9;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-60),Game.HEIGHT-410,ID.Enemy,handler));}
			
		}
		else if(hud.getScore()>=3600&&hud.getScore()<=4200){
			for(int i =0;i<12;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-60),Game.HEIGHT-410,ID.Enemy,handler));}
			hud.setLevel(5);
		}
		
	}
	
}
else if(hud.getLevel()==5){
	if(timer>=60){
		timer=0;
		if(hud.getScore()>=4200&&hud.getScore()<=4600){
			for(int i =0;i<12;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-60),Game.HEIGHT-410,ID.Enemy,handler));}
		}
		else if(hud.getScore()>=4600&&hud.getScore()<=5000){
			for(int i =0;i<15;i++){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH/2-60),Game.HEIGHT-410,ID.Enemy,handler));}
		}
	}
	
}
}

}
	
	
	
	





