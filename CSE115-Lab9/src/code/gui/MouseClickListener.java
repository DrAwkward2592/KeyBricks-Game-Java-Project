package code.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.fileIO.FileIO;
import code.model.ColorUtility;
import code.model.KeyBricksModel;

public class MouseClickListener implements MouseListener {
	private KeyBricksModel _model;
	private String fileState;
	public MouseClickListener(KeyBricksModel m) {
		_model = m;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Character letter;
		char color;
		fileState = new String();
		for(int r=0;r<KeyBricksModel.ROWS;r++){
			for(int c=0;c<KeyBricksModel.COLS;c++){
				letter = _model.get(r, c).getCharacter();
				color = ColorUtility.color2char(_model.get(r, c).getColor());
				fileState = fileState + Character.toString(letter.charValue());
				fileState = fileState + Character.toString(color);
			}
		}
		
		FileIO.writeStringToFile("msaditya.kbr", fileState);
		System.out.println("The game was saved in the following string");
		System.out.println(fileState);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
