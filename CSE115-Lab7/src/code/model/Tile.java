package code.model;

import java.awt.Color;

public class Tile {
	private Color _color;
	private Character _char;
	
	public Tile(Color c) {
		_color = c;
		_char = null;
	}
	
	public void setCharacter(char c) {
		_char = c;
	}
	
	public Character getCharacter() {
		return _char;
	}
	
	public Color getColor() {
		return _color;
	}
}
