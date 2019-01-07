package me.JackMartin.TextEditor.Utils;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class Utils {
	
	public static void setFont(Font font, JTextArea textArea) {
		textArea.setFont(font);
	}
	
	public static void setForegroundColor(Color color, JTextArea textArea) {
		textArea.setForeground(color);
	}
	
	public static void setBackgroundColor(Color color, JTextArea textArea) {
		textArea.setBackground(color);
	}

	public static void readInTextFile(String path, JTextArea textArea) {
		String line = null;

		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				textArea.append(line + System.getProperty("line.separator"));
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
