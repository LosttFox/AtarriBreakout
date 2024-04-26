package com.lostfox.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class AtariBreakout extends ApplicationAdapter
{
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Block> blocks = new ArrayList<>();
	@Override
	public void create()
	{
		shape = new ShapeRenderer();
		ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 7, 8, 5);
		paddle = new Paddle(Gdx.graphics.getWidth() / 2, 50, 75, 10);

		int blockWidth = 63;
		int blockHeight = 20;
		for (int xPos = 0; xPos < Gdx.graphics.getWidth(); xPos += blockWidth + 10)
		{
			for (int yPos = Gdx.graphics.getHeight()/2; yPos < Gdx.graphics.getHeight(); yPos += blockHeight + 10)
			{
				blocks.add(new Block(xPos, yPos, blockWidth, blockHeight));
			}
		}
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
		for (Block block : blocks)
		{
			block.draw(shape);
			ball.checkCollision(block);
		}
		for (int index = 0; index < blocks.size(); index++)
		{
			Block block = blocks.get(index);
			if (block.destroyed)
			{
				blocks.remove(block);
				index--;
			}
		}
		ball.checkCollision(paddle);
		shape.end();
	}
}
