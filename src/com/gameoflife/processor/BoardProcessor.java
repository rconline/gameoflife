package com.gameoflife.processor;

import com.gameoflife.elements.Board;
import com.gameoflife.elements.Cell;

public class BoardProcessor {

	/**
	 * Seeds the board with x, y. Puts in null cells at the outset and changes
	 * the pattern based on the seed, provided from the main method.
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws Exception
	 */
	public static Board seedBoard(int x, int y, int[][] seed) throws Exception {
		Board board = new Board(x, y, new Cell[x][y]);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				board.cell[i][j] = new Cell(false);
			}
		}
		for (int i = 0; i < seed.length; i++) {
			board.cell[seed[i][0]][seed[i][1]] = new Cell(true);
		}
		serializeBoard(board);
		return board;
	}

	/**
	 * Creates a new board with the next set of board variables
	 * 
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public static Board updateBoard(Board board) throws Exception {
		// Create the next board with identical dimensions
		Board newBoard = new Board(board.x, board.y, new Cell[board.x][board.y]);
		for (int i = 0; i < board.x; i++) {
			for (int j = 0; j < board.y; j++) {
				if (CellProcessor.determineNextState(board, i, j)) {
					newBoard.cell[i][j] = new Cell(true);
				} else {
					newBoard.cell[i][j] = new Cell(false);
				}
			}
		}
		serializeBoard(newBoard);
		return newBoard;
	}

	/**
	 * Serialize board for the console viewing. '=' determines dead cells '*'
	 * determines live cells
	 * 
	 * @param board
	 */
	private static void serializeBoard(Board board) {
		for (int i = 0; i < board.x; i++) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int j = 0; j < board.y; j++) {
				if (board.cell[i][j].isAlive())
					stringBuffer.append("*");
				else
					stringBuffer.append("=");
			}
			System.out.println(stringBuffer.toString());
		}
		System.out.println("\n");
	}
}
