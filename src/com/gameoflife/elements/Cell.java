package com.gameoflife.elements;

public class Cell {

	/**
	 * Determines the state of the cell. true represents alive, false determines
	 * dead.
	 */
	public boolean alive;

	public Cell(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
