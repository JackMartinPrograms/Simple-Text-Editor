package me.JackMartin.TextEditor.Utils;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import me.JackMartin.TextEditor.Main;

public class Utils {

	public static void find(String text) {
		if (Main.getTextArea().getText().contains(text)) {
			int wordPosition = Main.getTextArea().getText().indexOf(text);
			Main.getTextArea().setCaretPosition(wordPosition);
		} else {
			JOptionPane.showMessageDialog(null, "Could Not Find '" + text + "'", "Could Not Find",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void setFont(Font font) {
		Main.getTextArea().setFont(font);
	}

	public static void setForegroundColor(Color color) {
		Main.getTextArea().setForeground(color);
	}

	public static void setBackgroundColor(Color color) {
		Main.getTextArea().setBackground(color);
	}

	public static void readInTextFile(String path) {
		String line = null;

		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				Main.getTextArea().append(line + System.getProperty("line.separator"));
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + path + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + path + "'");
		}
	}

	public static void saveToFile(String path, JTextArea textArea) {
		try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(path))) {
			textArea.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}