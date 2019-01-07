package me.JackMartin.TextEditor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.JackMartin.TextEditor.Utils.Utils;

public class Main {

	private static JFrame frame;
	private static JTextArea textArea;

	public static void main(String[] args) {
		frame = new JFrame("Text Editor");
		frame.setMinimumSize(new Dimension(250, 250));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setSize(new Dimension(800, 600));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		/*------------------JMENU------------------*/

		JMenuBar menuBar = new JMenuBar();
		// File Menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem file_New = new JMenuItem("New");
		JMenuItem file_Open = new JMenuItem("Open");
		JMenuItem file_Save = new JMenuItem("Save");
		JMenuItem file_Quit = new JMenuItem("Quit");

		file_New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().length() == 0) {
					textArea.setText("");
				} else {
					int reply = JOptionPane.showConfirmDialog(null,
							"You Have Work There! Are You Sure You Want To Continue?", "Wait!",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						textArea.setText("");
					} else {
					}
				}
			}
		});

		file_Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(getFrame()) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Utils.readInTextFile(file.getAbsolutePath(), textArea);
				}
			}
		});

		file_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setApproveButtonText("Save");
				fileChooser.setDialogTitle("Save");
				if (fileChooser.showOpenDialog(getFrame()) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Utils.saveToFile(file.getAbsolutePath(), textArea);
				}
			}
		});

		file_Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(file_New);
		fileMenu.add(file_Open);
		fileMenu.add(file_Save);
		fileMenu.add(file_Quit);

		// Edit Menu
		JMenu editMenu = new JMenu("Edit");
		JMenuItem edit_Cut = new JMenuItem("Cut");
		JMenuItem edit_Copy = new JMenuItem("Copy");
		JMenuItem edit_Paste = new JMenuItem("Paste");
		JMenuItem edit_SelectAll = new JMenuItem("Select All");

		edit_Cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});

		edit_Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});

		edit_Paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});

		edit_SelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
			}
		});

		editMenu.add(edit_Cut);
		editMenu.add(edit_Copy);
		editMenu.add(edit_Paste);
		editMenu.add(edit_SelectAll);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		frame.setJMenuBar(menuBar);

		/*------------------TEXT AREA------------------*/

		textArea = new JTextArea();
		
		JScrollPane textAreaScrollPane = new JScrollPane(textArea);
		textAreaScrollPane.setPreferredSize(new Dimension(800, 600));
		frame.add(textAreaScrollPane);

		frame.pack();
	}

	public static JFrame getFrame() {
		return frame;
	}

}
