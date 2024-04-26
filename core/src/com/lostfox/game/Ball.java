package com.lostfox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;


public class Ball
{
	int xPos;
	int yPos;
	int size;
	int xSpeed;
	int ySpeed;
	Color color = Color.WHITE;

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
		shape.setColor(color);
		shape.circle(xPos, yPos, size);
	}

	public void checkCollision(Paddle paddle)
	{
		if (collidesWith(paddle))
		{
			ySpeed = -ySpeed;
		}
	}

	private boolean collidesWith(Paddle paddle)
	{
		boolean isCollide = false;

		if (xPos + size > paddle.xPos && xPos - size < paddle.xPos + paddle.width)
		{
			if (yPos + size > paddle.yPos && yPos - size < paddle.yPos + paddle.height)
			{
				isCollide = true;
			}
		}

		return isCollide;
	}
}
