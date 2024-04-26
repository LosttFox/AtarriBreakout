package com.lostfox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball
{
	int xPos;
	int yPos;
	int size;
	int xSpeed;
	int ySpeed;

	public Ball(int xPos, int yPos, int size, int xSpeed, int ySpeed)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public void update()
	{
		xPos += xSpeed;
		yPos += ySpeed;

		if (xPos - size < 0 || xPos + size > Gdx.graphics.getWidth())
		{
			xSpeed = -xSpeed;
		}
		if (yPos - size < 0 || yPos + size > Gdx.graphics.getHeight())
		{
			ySpeed = -ySpeed;
		}
	}

	public void draw(ShapeRenderer shape)
	{
		shape.circle(xPos, yPos, size);
	}
}
