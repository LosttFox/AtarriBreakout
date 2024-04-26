package com.lostfox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle
{
	int xPos;
	int yPos;
	int width;
	int height;

	public Paddle(int xPos, int yPos, int width, int height)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public void update()
	{
		xPos = Gdx.input.getX();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) xPos -= 20;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) xPos += 20;
	}

	public void draw(ShapeRenderer shape)
	{
		shape.rect(xPos, yPos, width, height);
	}
}
