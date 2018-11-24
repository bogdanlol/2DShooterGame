package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import newgame.Game.STATE;



public class End {
	private Game game;
	private Handler handler;
	private HUD hud;
	

		public End(Game game,Handler handler,HUD hud){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		}
		public void tick(){}
		public void render(Graphics g){
			if (game.gameState==STATE.End){
				g.setColor(Color.black);
				g.drawString("Play Again",270, 190);
				g.drawRect(200,150, 200, 64);
				g.drawString("You lost with a score of "+hud.getScore(), 225, 300);
			}
			
			
		}
}
