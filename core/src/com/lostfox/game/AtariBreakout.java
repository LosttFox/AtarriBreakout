package com.lostfox.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class AtariBreakout extends ApplicationAdapter
{
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;

	@Override
	public void create()
	{
		shape = new ShapeRenderer();
		ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 15, 8, 5);
		paddle = new Paddle(Gdx.graphics.getWidth() / 2, 50, 75, 10);
	}

	@Override
	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();
		paddle.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		ball.checkCollision(paddle);
		shape.end();
	}
}
