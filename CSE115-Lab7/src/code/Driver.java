package code;

import javax.swing.SwingUtilities;

import code.gui.KeyBricksGUI;
import code.model.KeyBricksModel;

public class Driver {
	public static void main(String[] args) {
		KeyBricksModel dataModel = new KeyBricksModel();
		KeyBricksGUI userInterface = new KeyBricksGUI(dataModel);
		SwingUtilities.invokeLater(userInterface);
	}
}
