package com.gameoflife.processor;

import com.gameoflife.elements.Board;

public class CellProcessor {

	/**
	 * Determines the next cell state
	 * 
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean determineNextState(Board board, int x, int y) {
		boolean currentState = board.cell[x][y].alive;
		int liveCount = CellProcessor.determineLiveNeighbours(board, x, y);
		if (currentState) {
			if (liveCount < 2) {
				currentState = false;
			} else if (liveCount == 2 || liveCount == 3) {
				currentState = true;
			} else if (liveCount > 3) {
				currentState = false;
			}
		} else {
			if (liveCount == 3)
				currentState = true;
		}
		return currentState;
	}

	/**
	 * Determines the number of neighbours of the cell in question
	 * 
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	private static int determineLiveNeighbours(Board board, int x, int y) {
		int xStart, xEnd, yStart, yEnd, liveCells = 0;

		// Determine x variables
		if (x == 0) {
			xStart = 0;
			xEnd = 1;
		} else if (x == board.x - 1) {
			xStart = board.x - 2;
			xEnd = x;
		} else {
			xStart = x - 1;
			xEnd = x + 1;
		}

		// Determine y variables
		if (y == 0) {
			yStart = 0;
			yEnd = 1;
		} else if (y == board.y - 1) {
			yStart = board.y - 2;
			yEnd = y;
		} else {
			yStart = y - 1;
			yEnd = y + 1;
		}

		// Determine live count, ignore current cell values
		for (int i = xStart; i <= xEnd; i++) {
			for (int j = yStart; j <= yEnd; j++) {
				if (i == x && j == y)
					continue;
				if (board.cell[i][j].isAlive()) {
					liveCells++;
				}
			}
		}

		return liveCells;
	}

}
