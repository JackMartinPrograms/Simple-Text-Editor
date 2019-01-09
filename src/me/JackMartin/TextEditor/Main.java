package me.JackMartin.TextEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import me.JackMartin.TextEditor.Utils.Utils;

public class Main {

	private static JFrame frame;
	private static JTextArea textArea;
	private static JLabel bottomBar;
	
	private static final double VERSION_NUMBER = 1.1;

	public static void main(String[] args) {
		frame = new JFrame("Text Editor | Version: " + Double.toString(VERSION_NUMBER));
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
		JMenuItem file_Spacer1 = new JMenuItem("");
		JMenuItem file_Settings = new JMenuItem("Settings");
		JMenuItem file_Quit = new JMenuItem("Quit");
		
		file_Spacer1.setEnabled(false);

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
		
		file_Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SettingsMenu(textArea);
			}
		});

		fileMenu.add(file_New);
		fileMenu.add(file_Open);
		fileMenu.add(file_Save);
		fileMenu.add(new JSeparator());
		fileMenu.add(file_Settings);
		fileMenu.add(file_Quit);

		// Edit Menu
		JMenu editMenu = new JMenu("Edit");
		JMenuItem edit_Cut = new JMenuItem("Cut");
		JMenuItem edit_Copy = new JMenuItem("Copy");
		JMenuItem edit_Paste = new JMenuItem("Paste");
		JMenuItem edit_SelectAll = new JMenuItem("Select All");
		JMenuItem edit_Delete = new JMenuItem("Delete");

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
		
		edit_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("");
			}
		});

		editMenu.add(edit_Cut);
		editMenu.add(edit_Copy);
		editMenu.add(edit_Paste);
		editMenu.add(edit_SelectAll);
		editMenu.add(edit_Delete);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		frame.setJMenuBar(menuBar);

		/*------------------TEXT AREA------------------*/

		textArea = new JTextArea();
		
		JScrollPane textAreaScrollPane = new JScrollPane(textArea);
		textAreaScrollPane.setPreferredSize(new Dimension(800, 550));
		
		textArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				JTextArea tempArea = (JTextArea)e.getSource();

                int lineNumber = 1;
                int columnNumber = 1;

                try {
                    int caretpos = tempArea.getCaretPosition();
                    lineNumber = tempArea.getLineOfOffset(caretpos);
                    columnNumber = caretpos - tempArea.getLineStartOffset(lineNumber);
                    lineNumber += 1;
                } catch(Exception ex) {
                	ex.printStackTrace();
                }
                updateStatus(lineNumber, columnNumber);
			}
		});
		frame.add(textAreaScrollPane, BorderLayout.CENTER);
		
		bottomBar = new JLabel(" Line: 1 " + "Column: 0" + " | Version: " + VERSION_NUMBER);		
		frame.add(bottomBar, BorderLayout.SOUTH);

		frame.pack();
	}
	
	private static void updateStatus(int linenumber, int columnnumber) {
        bottomBar.setText(" Line: " + linenumber + " Column: " + columnnumber + " | Version: " + VERSION_NUMBER);
    }
	
	public static JTextArea getTextArea() {
		return textArea;
	}

	public static JFrame getFrame() {
		return frame;
	}

}
