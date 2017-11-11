package com.kamil.robson.GameState;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kamil.robson.Sprites.Faggot;
import com.kamil.robson.Sprites.Floor;
import com.kamil.robson.Sprites.GapObstacle;

public class PlayState extends State {

	public static float STEP = 0.9f;

	private BitmapFont font;
	private Faggot fag;
	private Floor floor;
	private List<GapObstacle> obstacles;
	private float deltaDist = 0.0f;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		font = new BitmapFont();
		fag = new Faggot(100, 200);
		floor = new Floor();
		obstacles = new ArrayList<GapObstacle>();
	}

	@Override
	public void update(float dt) {

		if (fag.die)
			this.gsm.push(new DeadState(gsm));

		handleInput();
		checkFagCollideWithFloor();
		if (canStartMoveObstacles()) {

			if (!floor.isDisposed)
				floor.moveDown();

			if (obstacles.isEmpty())
				obstacles.add(new GapObstacle());
			List<GapObstacle> toRemove = new ArrayList<GapObstacle>();
			for (int i = 0; i < obstacles.size(); i++) {
				GapObstacle obs = obstacles.get(i);

				obs.update(0, deltaDist);

				this.deltaDist = 0.0f;

				if (obs.getVerticalPosition() == 150) {
					obstacles.add(new GapObstacle());
				}
				if (obs.getVerticalPosition() <= 0.0) {
					toRemove.add(obs);
					obs.dispose();
				}

				obs.checkCollisionWithFag(fag);

			}

			obstacles.removeAll(toRemove);

		}

		fag.update(dt);

		cam.position.set(fag.getX(), fag.getY(), 0);
		cam.update();
	}

	private boolean canStartMoveObstacles() {
		return (fag.getY() > Gdx.graphics.getHeight() / 2 + 100 || floor.getY() < 35);
	}

	private void checkFagCollideWithFloor() {

		if (floor.colide(fag.getBounds()))
			fag.collideWithFloor = true;
		else
			fag.collideWithFloor = false;
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		font.draw(sb, "Penisek", 300, 250);
		sb.draw(fag.getTex(), fag.getX(), fag.getY() - fag.getTex().getHeight());
		sb.draw(floor.getTex(), floor.getX(), floor.getY() - floor.getTex().getHeight());

		for (GapObstacle obs : obstacles) {
			sb.draw(obs.getTex()[0], obs.getRec()[0].getWidth() - obs.getTex()[0].getWidth(),
					obs.getRec()[0].getY() - obs.getTex()[0].getHeight());

			sb.draw(obs.getTex()[1], obs.getRec()[1].getX(), obs.getRec()[1].getY() - obs.getTex()[1].getHeight());
		}
		sb.end();

	}

	@Override
	public void handleInput() {
		if (Gdx.input.justTouched()) {
			fag.jump();

			if (fag.getY() > Gdx.graphics.getHeight() / 2-150)
				this.deltaDist = 50;

		}
	}

	@Override
	public void dispose() {

	}

}
