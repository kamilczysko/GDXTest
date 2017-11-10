package com.kamil.robson.GameState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kamil.robson.Sprites.Faggot;

public class PlayState extends State {

	private GameStateManager gsm;
	private BitmapFont font;
	private Faggot fag;
	
	
	public  PlayState(GameStateManager gsm) {
		super(gsm);
		this.gsm = gsm;
		font = new BitmapFont();
		fag = new Faggot(100, 200);
	}

	@Override
	public void update(float dt) {
		handleInput();
		fag.update(dt);
		cam.position.set(fag.getX()-100	, fag.getY()/2, 0);
		cam.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
			font.draw(sb, "Penisek", 300, 250);
			sb.draw(fag.getTex(), fag.getX(), fag.getY());
		sb.end();
		
	}

	@Override
	public void handleInput() {
		if(Gdx.input.justTouched()){
			fag.jump(getDeltaXDistance());
		}
		
	}
	
	private float getDeltaXDistance(){
		float touchedX = Gdx.input.getX();
		float fagX = fag.getX();
		float deltaDistance = touchedX - fagX;
		
		return deltaDistance;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	

}
