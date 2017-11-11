package com.kamil.robson.GameState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DeadState extends State {

	private GameStateManager gsm;
	private BitmapFont font;

	protected DeadState(GameStateManager gsm) {
		super(gsm);
		this.gsm = gsm;
		this.font = new BitmapFont();
	}


	@Override
	public void update(float dt) {
		handleInput();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
			font.draw(sb, "Pad³eœ ciulu", 100, 200);
		sb.end();
		
	}

	@Override
	public void handleInput() {
		if(Gdx.input.justTouched())
			this.gsm.set(new BeginState(gsm));
		
	}

	@Override
	public void dispose() {
				
	}

}
