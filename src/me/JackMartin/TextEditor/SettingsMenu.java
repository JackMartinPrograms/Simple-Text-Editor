package me.JackMartin.TextEditor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import me.JackMartin.TextEditor.Utils.Utils;

@SuppressWarnings("serial")
public class SettingsMenu extends JFrame {

	private JPanel contentPane;
	private JPanel fontPanel;
	private JPanel backgroundPanel;
	private JPanel cardPanel;
	
	private Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	private JButton btnBlue;
	private JButton btnGray;
	private JButton btnYellow;
	private JButton btnGreen;
	private JButton btnMagenta;
	private JButton btnOrange;
	private JButton btnCyan;
	private JButton btnDarkgray;
	private JButton btnPink;
	private JButton btnBackgroundBlue;
	private JButton btnBackgroundGray;
	private JButton btnBackgroundYellow;
	private JButton btnBackgroundGreen;
	private JButton btnBackgroundMagenta;
	private JButton btnBackgroundOrange;
	private JButton btnBackgroundCyan;
	private JButton btnBackgroundDarkgray;
	private JButton btnBackgroundPink;
	
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	private String[] fontList = ge.getAvailableFontFamilyNames();	
	private String[] fontSizes = {"2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28"};
	private String fontName;
	private String fontSizeTemp;
	
	private int fontSize;
	private JButton btnSetFont;
	private JLabel lblChangeFontColour;
	private JLabel lblChangeFontAnd;
	private JLabel lblChangeBackgroundColour;

	public SettingsMenu(Component c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				drawWindow(c);
			}
		});
	}
	
	public void drawWindow(Component c) {
		setTitle("Settings");
		setSize(600, 600);
		setLocationRelativeTo(c);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setupPanels();
		
		listModel.addElement("Font");
		listModel.addElement("Background");
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list = new JList(listModel);
		list.setBounds(10, 11, 165, 539);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					@SuppressWarnings("unchecked")
					final List<String> selectedValuesList = list.getSelectedValuesList();
					if (selectedValuesList.get(0) == "Font") {
						CardLayout cardLayout = (CardLayout) (cardPanel.getLayout());
						cardLayout.next(cardPanel);
					} else if (selectedValuesList.get(0) == "Background") {
						CardLayout cardLayout = (CardLayout) (cardPanel.getLayout());
						cardLayout.previous(cardPanel);
					}
				}
			}
		});
		
		contentPane.add(list);
		
		setVisible(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setupPanels() {
		fontPanel = new JPanel();
		backgroundPanel = new JPanel();
		cardPanel = new JPanel(new CardLayout());		
		
		cardPanel.add(fontPanel, "font");
		fontPanel.setLayout(null);
		
		/*---------------Font Panel---------------*/
		
		JButton btnBlack = new JButton();
		btnBlack.setBackground(Color.BLACK);
		btnBlack.setContentAreaFilled(false);
		btnBlack.setOpaque(true);
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.BLACK, Main.getTextArea());
			}
		});
		btnBlack.setBounds(50, 129, 89, 23);
		fontPanel.add(btnBlack);
		
		JButton btnRed = new JButton();
		btnRed.setBackground(Color.RED);
		btnRed.setContentAreaFilled(false);
		btnRed.setOpaque(true);
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.RED, Main.getTextArea());
			}
		});
		btnRed.setBounds(248, 129, 89, 23);
		fontPanel.add(btnRed);
		
		JButton btnWhite = new JButton();
		btnWhite.setBackground(Color.WHITE);
		btnWhite.setContentAreaFilled(false);
		btnWhite.setOpaque(true);
		btnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.WHITE, Main.getTextArea());
			}
		});
		btnWhite.setBounds(149, 129, 89, 23);
		fontPanel.add(btnWhite);
		
		btnBlue = new JButton();
		btnBlue.setBackground(Color.BLUE);
		btnBlue.setContentAreaFilled(false);
		btnBlue.setOpaque(true);
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.BLUE, Main.getTextArea());
			}
		});
		btnBlue.setBounds(149, 197, 89, 23);
		fontPanel.add(btnBlue);
		
		btnGray = new JButton();
		btnGray.setBackground(Color.GRAY);
		btnGray.setContentAreaFilled(false);
		btnGray.setOpaque(true);
		btnGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.GRAY, Main.getTextArea());
			}
		});
		btnGray.setBounds(149, 163, 89, 23);
		fontPanel.add(btnGray);
		
		btnYellow = new JButton();
		btnYellow.setBackground(Color.YELLOW);
		btnYellow.setContentAreaFilled(false);
		btnYellow.setOpaque(true);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.YELLOW, Main.getTextArea());
			}
		});
		btnYellow.setBounds(248, 163, 89, 23);
		fontPanel.add(btnYellow);
		
		btnGreen = new JButton();
		btnGreen.setBackground(Color.GREEN);
		btnGreen.setContentAreaFilled(false);
		btnGreen.setOpaque(true);
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.GREEN, Main.getTextArea());
			}
		});
		btnGreen.setBounds(50, 197, 89, 23);
		fontPanel.add(btnGreen);
		
		btnMagenta = new JButton();
		btnMagenta.setBackground(Color.MAGENTA);
		btnMagenta.setContentAreaFilled(false);
		btnMagenta.setOpaque(true);
		btnMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.MAGENTA, Main.getTextArea());
			}
		});
		btnMagenta.setBounds(50, 163, 89, 23);
		fontPanel.add(btnMagenta);
		
		btnOrange = new JButton();
		btnOrange.setBackground(Color.ORANGE);
		btnOrange.setContentAreaFilled(false);
		btnOrange.setOpaque(true);
		btnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.ORANGE, Main.getTextArea());
			}
		});
		btnOrange.setBounds(248, 197, 89, 23);
		fontPanel.add(btnOrange);
		
		btnCyan = new JButton();
		btnCyan.setBackground(Color.CYAN);
		btnCyan.setContentAreaFilled(false);
		btnCyan.setOpaque(true);
		btnCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.CYAN, Main.getTextArea());
			}
		});
		btnCyan.setBounds(50, 231, 89, 23);
		fontPanel.add(btnCyan);
		
		btnDarkgray = new JButton();
		btnDarkgray.setBackground(Color.DARK_GRAY);
		btnDarkgray.setContentAreaFilled(false);
		btnDarkgray.setOpaque(true);
		btnDarkgray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.DARK_GRAY, Main.getTextArea());
			}
		});
		btnDarkgray.setBounds(149, 231, 89, 23);
		fontPanel.add(btnDarkgray);
		
		btnPink = new JButton();
		btnPink.setBackground(Color.PINK);
		btnPink.setContentAreaFilled(false);
		btnPink.setOpaque(true);
		btnPink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setForegroundColor(Color.PINK, Main.getTextArea());
			}
		});
		btnPink.setBounds(248, 231, 89, 23);
		fontPanel.add(btnPink);
		
		DefaultComboBoxModel fontBoxModel = new DefaultComboBoxModel(fontList);
		JComboBox fontBox = new JComboBox(fontBoxModel);
		
		fontBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontName = (String) fontBox.getSelectedItem();
			}
		});
		fontBox.setBounds(50, 323, 120, 20);
		fontPanel.add(fontBox);
		
		DefaultComboBoxModel fontSizeModel = new DefaultComboBoxModel(fontSizes);
		JComboBox fontSizeBox = new JComboBox(fontSizeModel);		
		
		fontSizeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontSizeTemp = (String) fontSizeBox.getSelectedItem();
				fontSize = Integer.parseInt(fontSizeTemp);
			}
		});
		fontSizeBox.setBounds(180, 323, 58, 20);
		fontPanel.add(fontSizeBox);		
		
		btnSetFont = new JButton("Set");
		btnSetFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fontSizeModel.getSelectedItem().equals("") || fontBoxModel.getSelectedItem().equals("")) {
					Utils.setFont(new Font("Ariel", Font.PLAIN, 12), Main.getTextArea());
				} else {
					Utils.setFont(new Font(fontName, Font.PLAIN, fontSize), Main.getTextArea());
				}
			}
		});
		btnSetFont.setBounds(248, 322, 89, 23);
		fontPanel.add(btnSetFont);
		
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		JLabel lblFont = new JLabel("Font");
		lblFont.setFont(new Font("Tahoma", Font.BOLD, 35).deriveFont(fontAttributes));
		lblFont.setBounds(149, 0, 89, 44);
		fontPanel.add(lblFont);
		
		lblChangeFontColour = new JLabel("Change Font Colour");
		lblChangeFontColour.setFont(new Font("Tahoma", Font.PLAIN, 15).deriveFont(fontAttributes));
		lblChangeFontColour.setBounds(50, 95, 135, 23);
		fontPanel.add(lblChangeFontColour);
		
		lblChangeFontAnd = new JLabel("Change Font And Font Size");
		lblChangeFontAnd.setFont(new Font("Tahoma", Font.PLAIN, 15).deriveFont(fontAttributes));
		lblChangeFontAnd.setBounds(50, 289, 177, 23);
		fontPanel.add(lblChangeFontAnd);
		
		cardPanel.add(backgroundPanel, "background");
		backgroundPanel.setLayout(null);
		
		/*-------------Background Panel-------------*/
		
		JLabel lblBackground = new JLabel("Font");
		lblBackground.setFont(new Font("Tahoma", Font.BOLD, 35).deriveFont(fontAttributes));
		lblBackground.setBounds(149, 0, 89, 44);
		backgroundPanel.add(lblBackground);
		
		lblChangeBackgroundColour = new JLabel("Change Background Colour");
		lblChangeBackgroundColour.setFont(new Font("Tahoma", Font.PLAIN, 15).deriveFont(fontAttributes));
		lblChangeBackgroundColour.setBounds(50, 95, 180, 23);
		backgroundPanel.add(lblChangeBackgroundColour);
		
		JButton btnBackgroundBlack = new JButton();
		btnBackgroundBlack.setBackground(Color.BLACK);
		btnBackgroundBlack.setContentAreaFilled(false);
		btnBackgroundBlack.setOpaque(true);
		btnBackgroundBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.BLACK, Main.getTextArea());
			}
		});
		btnBackgroundBlack.setBounds(50, 129, 89, 23);
		backgroundPanel.add(btnBackgroundBlack);
		
		JButton btnBackgroundRed = new JButton();
		btnBackgroundRed.setBackground(Color.RED);
		btnBackgroundRed.setContentAreaFilled(false);
		btnBackgroundRed.setOpaque(true);
		btnBackgroundRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.RED, Main.getTextArea());
			}
		});
		btnBackgroundRed.setBounds(248, 129, 89, 23);
		backgroundPanel.add(btnBackgroundRed);
		
		JButton btnBackgroundWhite = new JButton();
		btnBackgroundWhite.setBackground(Color.WHITE);
		btnBackgroundWhite.setContentAreaFilled(false);
		btnBackgroundWhite.setOpaque(true);
		btnBackgroundWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.WHITE, Main.getTextArea());
			}
		});
		btnBackgroundWhite.setBounds(149, 129, 89, 23);
		backgroundPanel.add(btnBackgroundWhite);
		
		btnBackgroundBlue = new JButton();
		btnBackgroundBlue.setBackground(Color.BLUE);
		btnBackgroundBlue.setContentAreaFilled(false);
		btnBackgroundBlue.setOpaque(true);
		btnBackgroundBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.BLUE, Main.getTextArea());
			}
		});
		btnBackgroundBlue.setBounds(149, 197, 89, 23);
		backgroundPanel.add(btnBackgroundBlue);
		
		btnBackgroundGray = new JButton();
		btnBackgroundGray.setBackground(Color.GRAY);
		btnBackgroundGray.setContentAreaFilled(false);
		btnBackgroundGray.setOpaque(true);
		btnBackgroundGray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.GRAY, Main.getTextArea());
			}
		});
		btnBackgroundGray.setBounds(149, 163, 89, 23);
		backgroundPanel.add(btnBackgroundGray);
		
		btnBackgroundYellow = new JButton();
		btnBackgroundYellow.setBackground(Color.YELLOW);
		btnBackgroundYellow.setContentAreaFilled(false);
		btnBackgroundYellow.setOpaque(true);
		btnBackgroundYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.YELLOW, Main.getTextArea());
			}
		});
		btnBackgroundYellow.setBounds(248, 163, 89, 23);
		backgroundPanel.add(btnBackgroundYellow);
		
		btnBackgroundGreen = new JButton();
		btnBackgroundGreen.setBackground(Color.GREEN);
		btnBackgroundGreen.setContentAreaFilled(false);
		btnBackgroundGreen.setOpaque(true);
		btnBackgroundGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.GREEN, Main.getTextArea());
			}
		});
		btnBackgroundGreen.setBounds(50, 197, 89, 23);
		backgroundPanel.add(btnBackgroundGreen);
		
		btnBackgroundMagenta = new JButton();
		btnBackgroundMagenta.setBackground(Color.MAGENTA);
		btnBackgroundMagenta.setContentAreaFilled(false);
		btnBackgroundMagenta.setOpaque(true);
		btnBackgroundMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.MAGENTA, Main.getTextArea());
			}
		});
		btnBackgroundMagenta.setBounds(50, 163, 89, 23);
		backgroundPanel.add(btnBackgroundMagenta);
		
		btnBackgroundOrange = new JButton();
		btnBackgroundOrange.setBackground(Color.ORANGE);
		btnBackgroundOrange.setContentAreaFilled(false);
		btnBackgroundOrange.setOpaque(true);
		btnBackgroundOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.ORANGE, Main.getTextArea());
			}
		});
		btnBackgroundOrange.setBounds(248, 197, 89, 23);
		backgroundPanel.add(btnBackgroundOrange);
		
		btnBackgroundCyan = new JButton();
		btnBackgroundCyan.setBackground(Color.CYAN);
		btnBackgroundCyan.setContentAreaFilled(false);
		btnBackgroundCyan.setOpaque(true);
		btnBackgroundCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.CYAN, Main.getTextArea());
			}
		});
		btnBackgroundCyan.setBounds(50, 231, 89, 23);
		backgroundPanel.add(btnBackgroundCyan);
		
		btnBackgroundDarkgray = new JButton();
		btnBackgroundDarkgray.setBackground(Color.DARK_GRAY);
		btnBackgroundDarkgray.setContentAreaFilled(false);
		btnBackgroundDarkgray.setOpaque(true);
		btnBackgroundDarkgray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.DARK_GRAY, Main.getTextArea());
			}
		});
		btnBackgroundDarkgray.setBounds(149, 231, 89, 23);
		backgroundPanel.add(btnBackgroundDarkgray);
		
		btnBackgroundPink = new JButton();
		btnBackgroundPink.setBackground(Color.PINK);
		btnBackgroundPink.setContentAreaFilled(false);
		btnBackgroundPink.setOpaque(true);
		btnBackgroundPink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.setBackgroundColor(Color.PINK, Main.getTextArea());
			}
		});
		btnBackgroundPink.setBounds(248, 231, 89, 23);
		backgroundPanel.add(btnBackgroundPink);
		
		cardPanel.setBounds(185, 11, 389, 539);
		contentPane.add(cardPanel);
	}
	
	public String getFontName() {
		return fontName;
	}
	
	public int getFontSize() {
		return fontSize;
	}
}
