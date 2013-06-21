import com.gameoflife.elements.Board;
import com.gameoflife.processor.BoardProcessor;

public class GameOfLife {

	public static void main(String[] args) {

		try {
			int[][] seed = createSeedArray();
			Board board = BoardProcessor.seedBoard(10, 10, seed);
			board = BoardProcessor.updateBoard(board);
			BoardProcessor.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();

		}
	}

	private static int[][] createSeedArray() {
		/**
		 * Initial seed pattern for game of life. To be changed for testing
		 * different sequences
		 */
		int[][] array = new int[][] { { 1, 3 }, { 2, 1 }, { 2, 3 }, { 3, 2 },
				{ 3, 3 }, { 3, 4 }, { 2, 4 } };
		return array;
	}
}
