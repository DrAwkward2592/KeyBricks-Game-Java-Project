package code.model;

import java.awt.Color;
import java.util.ArrayList;

public class KeyBricksModel {
	
	private static int COLS = 1;
	private static int ROWS = 4;
	
	private Observer _observer;
	
	private ArrayList<ArrayList<Tile>> _board;
	
	public KeyBricksModel() {
		_observer = null;
		initializeBoard();
	}
	
	public int getCols() {
		return COLS;
	}

	public int getRows() {
		return ROWS;
	}

	public void initializeBoard() {
		_board = new ArrayList<ArrayList<Tile>>();
		for (int c=0; c<COLS; c++) {
			ArrayList<Tile> col = new ArrayList<Tile>();
			_board.add(col);
			for (int r=0; r<ROWS; r++) {
				Tile t = new Tile(Color.RED);
				t.setCharacter((char) ('a' + c*COLS + r));
				col.add(t);
			}
		}
	}

	public void setObserver(Observer obs) {
		_observer = obs;
	}
	
	public void gameStateChanged() {
		if (_observer != null) {
			_observer.update();
		}
	}

	public Tile get(int col, int row) {
		return _board.get(col).get(row);
	}

	public void remove(char ch) {
		for (int c=0; c<COLS; c++) {
			for (int r=0; r<ROWS; r++) {
				Tile t = get(c,r);
				Character c2 = t.getCharacter();
				if (c2 != null && ch == c2.charValue()) {
					_board.get(c).remove(r);
					_board.get(c).add(0,new Tile(Color.BLACK));
					gameStateChanged();
				}
			}
		}
	}

}
