package me.JackMartin.TextEditor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import me.JackMartin.TextEditor.Utils.Utils;

@SuppressWarnings("serial")
public class SearchWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnFind;

	public SearchWindow(JTextArea textArea) {
		setSize(450, 149);
		setTitle("Find");
		setLocationRelativeTo(textArea);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(79, 30, 345, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFind = new JLabel("Find:");
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFind.setBounds(10, 30, 59, 20);
		contentPane.add(lblFind);
		
		btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,  "You Did Not Enter Anything To Find!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Utils.find(textField.getText());
					dispose();
				}
			}
		});
		btnFind.setBounds(166, 76, 89, 23);
		contentPane.add(btnFind);
		setVisible(true);
	}

}
