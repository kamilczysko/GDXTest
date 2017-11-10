package com.kamil.robson.Sprites;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.kamil.robson.GameState.PlayState;

public class GapObstacle {
	
	public static final float GAP = 100;
	
	private Vector2 position;
	private Texture[] tex;
	private Rectangle[] rectangles;
	private Random random;
	
	
	public GapObstacle() {
		this.position = new Vector2(0,Gdx.graphics.getHeight()+40);
		this.tex = new Texture [2];
		tex[0] = new Texture(Gdx.files.internal("floor.png"));
		tex[1] = new Texture(Gdx.files.internal("floor.png"));
		this.rectangles = new Rectangle[2];
		this.random = new Random();
				
		makeGap();
	}
	
	private void makeGap(){
		int gapPos = random.nextInt(400)+200;
		rectangles[0] = makeRec(0, gapPos);
		rectangles[1] = makeRec(gapPos+GAP, Gdx.graphics.getWidth());
	}
	
	private Rectangle makeRec(float start,float end){
		Rectangle rec =  new Rectangle();
		
		rec.set(start, 0, end, 35);
		return rec;
	}
	
	public Texture[] getTex(){
		return tex;
	}
	
	public void update(float dt){
		this.position.y -= PlayState.STEP;

		rectangles[0].y = position.y;
		rectangles[1].y = position.y;
	}
	
	public Rectangle[] getRec(){
		return rectangles;
	}
	
	public float getVerticalPosition(){
		return this.position.y;
	}
	
	public void checkCollisionWithFag(Faggot fag){
		
		if(rectangles[0].overlaps(fag.getBounds()) || rectangles[1].overlaps(fag.getBounds()))
			fag.die = true;
	}
	
	public void dispose(){
		for(Texture t : tex)
			t.dispose();
		
	}
	
	

}
