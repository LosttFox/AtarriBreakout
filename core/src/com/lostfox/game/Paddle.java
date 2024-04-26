package com.lostfox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Paddle
{
	int xPos;
	int width;

	public Paddle(int xPos, int width)
	{
		this.xPos = xPos;
		this.width = width;
	}

	public void update()
	{
		xPos = Gdx.input.getX();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) xPos -= 20;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) xPos += 20;
	}
}
