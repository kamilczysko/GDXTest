package com.kamil.robson.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.kamil.robson.GameState.PlayState;

public class Floor {

	private Texture floorTex;
	private Rectangle floorBoudns;
	public boolean isDisposed = false;

	public Floor() {
		this.floorTex = new Texture(Gdx.files.internal("floor.png"));
		this.floorBoudns = new Rectangle();
		this.floorBoudns.set(0, 35, Gdx.graphics.getWidth(), 35);
	}

	public Texture getTex() {
		return floorTex;
	}

	public float getX() {
		return floorBoudns.getX();
	}

	public float getY() {
		return floorBoudns.getY();
	}
	
	public boolean colide(Rectangle player){
		return this.floorBoudns.overlaps(player);
	}

	public void moveDown() {
		floorBoudns.y -= PlayState.STEP;
	}
	
	public void dispose() {
		this.floorTex.dispose();
		isDisposed = true;
	}

}
