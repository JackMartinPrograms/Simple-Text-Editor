package me.JackMartin.TextEditor;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class KeyboardManager {

	private HashMap<KeyStroke, Action> actionMap = new HashMap<KeyStroke, Action>();

	@SuppressWarnings("serial")
	public void setup() {
		KeyStroke ctrlA = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
		actionMap.put(ctrlA, new AbstractAction("ControlA") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.getTextArea().selectAll();
			}
		});

		KeyStroke ctrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
		actionMap.put(ctrlC, new AbstractAction("ControlC") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.getTextArea().copy();
			}
		});

		KeyStroke ctrlV = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
		actionMap.put(ctrlV, new AbstractAction("ControlV") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.getTextArea().paste();
			}
		});

		KeyStroke ctrlW = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK);
		actionMap.put(ctrlW, new AbstractAction("ControlW") {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Main.getTextArea().getText().isEmpty()) {
					int reply = JOptionPane.showConfirmDialog(null,
							"You Have Work There! Are You Sure You Want To Continue?", "Wait!",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						System.exit(0);
					} else {}
				} else {
					System.exit(0);
				}
			}
		});
		
		KeyStroke ctrlF = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
		actionMap.put(ctrlF, new AbstractAction("ControlF") {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchWindow(Main.getTextArea());
			}
		});

		KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		kfm.addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
				if (actionMap.containsKey(keyStroke)) {
					final Action a = actionMap.get(keyStroke);
					final ActionEvent ae = new ActionEvent(e.getSource(), e.getID(), null);
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							a.actionPerformed(ae);
						}
					});
					return true;
				}
				return false;
			}
		});
	}

}
