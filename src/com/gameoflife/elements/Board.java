package com.gameoflife.elements;

public class Board {

	/**
	 * Constructor to determine the size of the game of life board and seed it
	 * with the cells. References to cells to be provided later.
	 * 
	 * @param x
	 * @param y
	 * @param cell
	 * @throws Exception
	 */
	public Board(int x, int y, Cell[][] cell) throws Exception {
		if (x < 0 || y < 0)
			throw new Exception("Incorrect Contructor arguements");
		this.x = x;
		this.y = y;
		this.cell = new Cell[x][y];
	}

	public int x, y;
	public Cell cell[][];

}
