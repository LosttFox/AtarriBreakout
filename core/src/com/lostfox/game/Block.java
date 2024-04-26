package com.lostfox.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block
{
	int xPos, yPos, width, height;
	boolean destroyed;

	public Block(int xPos, int yPos, int width, int height)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.destroyed = false;
	}

	public void draw(ShapeRenderer shape)
	{
		shape.rect(xPos, yPos, width, height);
	}
}
