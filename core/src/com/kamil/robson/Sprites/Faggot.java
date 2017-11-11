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
	
	public boolean collideWithFloor = false;
	public boolean die = false;

	public static final float GRAV = -20;
	public static final float SIDE_JUMP = 150;
	public static final float VERTICAL_JUMP = 550;

	public Faggot(float x, float y) {

		die = false;
		this.tex = new Texture(Gdx.files.internal("ryj.png"));
		this.position = new Vector2(x, y);
		this.velocity = new Vector2(0, 0);
		this.rectangle = new Rectangle(position.x, position.y, 34, 30);
	}

	public void update(float dt) {

		this.velocity.add(0, GRAV);
		this.velocity.scl(dt);
		
		isFagInScreen();

		if (collideWithFloor && this.velocity.y < 0)
			setZeroVelocity();
		
		this.position.add(this.velocity.x, this.velocity.y);
		velocity.scl(1 / dt);
		rectangle.setPosition(this.position);
	}
	
	private void isFagInScreen(){
		float xPos = this.position.x;
		float yPos = this.position.y;
		if(yPos <= 0 || xPos <= 0 || xPos > Gdx.graphics.getWidth())
			die = true;
	}

	public void jump() {
		setZeroVelocity();

		if (Gdx.input.getX() >= Gdx.graphics.getWidth() / 2)
			this.velocity.add(SIDE_JUMP, VERTICAL_JUMP);
		else
			this.velocity.add(-SIDE_JUMP, VERTICAL_JUMP);
	}
	
	public void hitHead(){
		this.velocity.y = -150;
	}
	
	private void setZeroVelocity(){
		this.velocity.set(0, 0);
	}

	public float getX() {
		return this.position.x;
	}

	public float getY() {
		return this.position.y;
	}

	public Rectangle getBounds() {
		return rectangle;
	}

	public Texture getTex() {
		return tex;
	}

}
