package com.kamil.robson.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Faggot {

	private Rectangle rectangle;
	private Vector2 position;
	private Vector2 velocity;
	private Texture tex;
	
	public static final float GRAV = -15;
	public static final float SIDE_JUMP = 250;
	
	public Faggot(float x, float y){
		
		this.tex = new Texture(Gdx.files.internal("ryj.png"));
		this.position = new Vector2(x,y);
		this.velocity = new Vector2(0,0);
		this.rectangle = new Rectangle(position.x, position.y, 34 , 30);
	}
	
	public void update(float dt){
		this.velocity.add(0,GRAV);
		this.velocity.scl(dt);
		
		this.position.add(this.velocity.x, this.velocity.y);
		velocity.scl(1/dt);
		rectangle.setPosition(this.position);
	}
	
	public void jump(float sideJump){
		float verticalVelocity = this.velocity.y;
		
			verticalVelocity = 850;
		
			this.velocity.add(sideJump, verticalVelocity);
	}
	
	public float getX(){
		return this.position.x;
	}
	
	public float getY(){
		return this.position.y;
	}
	
	public Rectangle getBounds(){
		return rectangle;
	}
	
	public Texture getTex(){
		return tex;
	}
	
}
