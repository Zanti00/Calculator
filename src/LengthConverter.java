import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LengthConverter extends JFrame implements ActionListener, MouseListener, DocumentListener{
	private static final long serialVersionUID = 1L;
	static JTextField textField1, textField2;
	JComboBox<String> option1, option2;
	static JButton[] numButtons = new JButton[10];
	JButton[] functionButtons = new JButton[4];
	JButton deciButton, delButton, clrButton, menu;
	JPanel topPanel, botPanel;
	Font numFont = new Font("Calibri", Font.BOLD, 20);
	static Font activeFont = new Font("Calibri", Font.BOLD, 45);
	Font inactiveFont = new Font("Calibri", Font.PLAIN, 45);
	String[] textFieldOptions = {"Milimeter", "Centimeter", "Feet", "Inches", "Meters"};
	static double num1, num2, result;
	ImageIcon frameIcon = new ImageIcon("icon.png");
	JFrame lengthConverterFrame = new JFrame("Length Converter");

	LengthConverter(){
		lengthConverterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lengthConverterFrame.setSize(335, 545);
		lengthConverterFrame.setLocationRelativeTo(null);
		lengthConverterFrame.setLayout(new BorderLayout());
		lengthConverterFrame.getContentPane().setBackground(new Color(27, 27, 27));
		lengthConverterFrame.setIconImage(frameIcon.getImage());
		
		topPanel = new JPanel(null);
		topPanel.setPreferredSize(new Dimension(300, 247));
		topPanel.setBackground(new Color(27, 27, 27));
		
		botPanel = new JPanel();
		botPanel.setLayout(new GridLayout(5, 5, 2, 2));
		botPanel.setBackground(new Color(27, 27, 27));
		
		lengthConverterFrame.add(topPanel, BorderLayout.NORTH);
		lengthConverterFrame.add(botPanel, BorderLayout.SOUTH);
		
		option1 = new JComboBox<>(textFieldOptions);
		option1.addActionListener(this);
		option1.setBounds(10, 100, 120, 20);

		option2 = new JComboBox<>(textFieldOptions);
		option2.addActionListener(this);
		option2.setBounds(10, 210, 120, 20);
		
		textField1 = new JTextField("0");
		textField1.setBounds(10, 20, 295, 70);
		textField1.setBackground(new Color(27, 27, 27));
		textField1.setForeground(new Color(255, 255, 255));
		textField1.setFont(activeFont);
		textField1.setBorder(null);
		textField1.setCaretColor(new Color(27, 27, 27));
		textField1.addMouseListener(this);
		textField1.getDocument().addDocumentListener(this);
		textField1.setEditable(false);
		
		textField2 = new JTextField("0");
		textField2.setBounds(10, 130, 295, 70);
		textField2.setBackground(new Color(27, 27, 27));
		textField2.setForeground(new Color(255, 255, 255));
		textField2.setFont(inactiveFont);
		textField2.setBorder(null);
		textField2.setCaretColor(new Color(27, 27, 27));
		textField2.addMouseListener(this);
		textField2.setEditable(false);
		
		deciButton = new JButton(".");
		delButton = new JButton("DEL");
		clrButton = new JButton("C");
		menu = new JButton("…");
		
		functionButtons[0] = deciButton;
		functionButtons[1] = delButton;
		functionButtons[2] = clrButton;
		functionButtons[3] = menu;
		
		for(int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].addMouseListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(numFont);
			functionButtons[i].setBackground(new Color(75, 74, 73));
			functionButtons[i].setForeground(new Color(255, 255, 255));
			functionButtons[i].setBorderPainted(false);
			functionButtons[i].setPreferredSize(new Dimension(50, 50));
		}
		for(int i = 0; i < numButtons.length; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].addMouseListener(this);
			numButtons[i].setFocusable(false);
			numButtons[i].setFont(numFont);
			numButtons[i].setBackground(new Color(88, 87, 86));
			numButtons[i].setForeground(new Color(255, 255, 255));
			numButtons[i].setBorderPainted(false);
		}
		topPanel.add(option2);
		topPanel.add(option1);
		topPanel.add(textField1);
		topPanel.add(textField2);
		botPanel.add(menu);
		botPanel.add(clrButton);
		botPanel.add(delButton);
		botPanel.add(numButtons[7]);
		botPanel.add(numButtons[8]);
		botPanel.add(numButtons[9]);
		botPanel.add(numButtons[4]);
		botPanel.add(numButtons[5]);
		botPanel.add(numButtons[6]);
		botPanel.add(numButtons[1]);
		botPanel.add(numButtons[2]);
		botPanel.add(numButtons[3]);
		botPanel.add(deciButton);
		botPanel.add(numButtons[0]);
		lengthConverterFrame.setVisible(true);
	}
	static void decreaseFontSize(JTextField textField1, JTextField textField2) {
		int maxWidth = textField1.getWidth();
		String text = textField1.getText();
		Font currentFont = textField1.getFont();
		int maxWidth2 = textField2.getWidth();
		String text2 = textField2.getText();
		Font currentFont2 = textField2.getFont();
		
		Font tempFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize());
		Font tempFont2 = new Font(currentFont2.getName(), currentFont2.getStyle(), currentFont2.getSize());
		
		FontMetrics fontMetrics = textField1.getFontMetrics(tempFont);
		FontMetrics fontMetrics2 = textField2.getFontMetrics(tempFont2);
		
		int textWidth = fontMetrics.stringWidth(text);
		int textWidth2 = fontMetrics2.stringWidth(text2);
		
			while(textWidth > maxWidth) {
				tempFont = new Font(tempFont.getName(), tempFont.getStyle(), tempFont.getSize() - 1);
				fontMetrics = textField1.getFontMetrics(tempFont);
				textWidth = fontMetrics.stringWidth(text);
			}
			while(textWidth2 > maxWidth2) {
				tempFont2 = new Font(tempFont2.getName(), tempFont2.getStyle(), tempFont2.getSize() - 1);
				fontMetrics2 = textField2.getFontMetrics(tempFont2);
				textWidth2 = fontMetrics2.stringWidth(text2);
			}
			textField1.setFont(tempFont);
			textField2.setFont(tempFont2);
		}
	static void increaseFontSize(JTextField textField1, JTextField textField2) {
		// increase the size of font every time delete button is called
					Font currentFontSize = textField1.getFont();
					int activeFontSize = activeFont.getSize();
					Font tempFont = new Font(currentFontSize.getName(), currentFontSize.getStyle(), currentFontSize.getSize());
					FontMetrics fontMetrics = textField1.getFontMetrics(tempFont);
					
					Font currentFontSize2 = textField2.getFont();
					int activeFontSize2 = activeFont.getSize();
					Font tempFont2 = new Font(currentFontSize2.getName(), currentFontSize2.getStyle(), currentFontSize2.getSize());
					FontMetrics fontMetrics2 = textField2.getFontMetrics(tempFont2);
					
					if(currentFontSize.getSize() < activeFontSize) { // check if font size overlaps the maximum width of text field
						tempFont = new Font(tempFont.getName(), tempFont.getStyle(), tempFont.getSize() + 1);
						fontMetrics = textField1.getFontMetrics(tempFont);
					}
					if(currentFontSize2.getSize() < activeFontSize2) { // check if font size overlaps the maximum width of text field
						tempFont2 = new Font(tempFont2.getName(), tempFont2.getStyle(), tempFont2.getSize() + 1);
						fontMetrics2 = textField2.getFontMetrics(tempFont2);
					}
					textField1.setFont(tempFont);		
					textField2.setFont(tempFont2);		
	}
	static int printMethod(double result) {
		if(result%1 == 0) {
			textField2.setText(String.format("%,d", (long)result)); // turn result to whole number
		}
		else {
			String numberAsString = Double.toString(result);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				textField2.setText(String.format("%,." + decimalPart.length() + "f", result)); // turn it into decimal form based on the length of decimal digits
				return decimalPart.length();
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	static int printNumericButtons(int i) {
		String currentText = textField1.getText(); // removes comma
		String buttonText = numButtons[i].getText(); // removes comma
		String addedText = (currentText.concat(buttonText));
		textField1.setText(addedText);
		
		return 0;
	}
	static int delButton() {
		String string = textField1.getText().replaceAll(",", "");
		double digit = Double.parseDouble(string);
		textField1.setText("");
		
		if(digit%1 == 0) {
				for(int i = 0; i < string.length()-1; i++) {
					try {
						textField1.setText(String.format("%,d", Long.parseLong((textField1.getText()+string.charAt(i)).replaceAll(",", ""))));
					}catch (NumberFormatException e) {
						return 0;
					}
				}
		}
		else {
			if(digit < 1000) {
				for(int i = 0; i < string.length()-1; i++) {
					textField1.setText((textField1.getText()+string.charAt(i)).replaceAll(",", ""));
				}
			}
			else {
				String stringDecimalPart = null;
				string = string.substring(0, string.length()-1);
				int dotIndex = string.indexOf("."); // count how many characters after .
				if(dotIndex != -1) {
					stringDecimalPart = string.substring(dotIndex + 1);
				}
				if(string.contains(".") && stringDecimalPart.length() < 1) { // print if there is no decimal left
					for(int i = 0; i < string.length()-1;i++) {
						textField1.setText(String.format("%,d", Long.parseLong((textField1.getText()+string.charAt(i)).replaceAll(",", ""))));
					}
				}
				else {
				digit = Double.parseDouble(string);
					String digitAsString = Double.toString(digit);
					if(digitAsString.contains(".")) { // print if there has still decimals left
						String decimalPart = digitAsString.split("\\.")[1];
						textField1.setText(String.format("%,." + decimalPart.length() + "f", digit)); // print in a decimal format
					}
				}
			}
		}
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == delButton) {
			delButton();
			// turn 0 the number whenever text field is empty
			if(textField1.getText().isEmpty()) {
				textField1.setText("0");
			}
			increaseFontSize(textField1, textField2);
		}
		if(e.getSource() == clrButton) {
			textField1.setText("0");
			textField1.setFont(activeFont);
			textField2.setFont(inactiveFont);
		}
		for(int i = 0; i < numButtons.length; i++) {
			if(e.getSource() == numButtons[i]) {
				if(textField1.getText().equals("0")) {
					textField1.setText(""); // remove the first 0 in the text field
				}
				printNumericButtons(i);
			}
		}
		for(int i = 0; i < numButtons.length; i++) {
			if(e.getSource() == numButtons[i] || e.getSource() == option1 || e.getSource() == option2 || e.getSource() == delButton || e.getSource() == clrButton) {
				switch(option1.getSelectedIndex()) {
				case 0:
					switch(option2.getSelectedIndex()) {
					case 0: 
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 1:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 2:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.00328084;
						printMethod(result);
						break;
					case 3:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.03937;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 4:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.001;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					}
					break;
				case 1:
					switch(option2.getSelectedIndex()) {
					case 0: 
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*10;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 1:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 2:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.032808;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 3:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.393701;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 4:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.01;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					}
					break;
				case 2:
					switch(option2.getSelectedIndex()) {
					case 0: 
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*304.8;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 1:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*30.48;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 2:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 3:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*12;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 4:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.3048;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					}
					break;
				case 3:
					switch(option2.getSelectedIndex()) {
					case 0: 
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*25.4;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 1:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*2.54;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 2:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.083333;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 3:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 4:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*0.0254;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					}
					break;
				case 4:
					switch(option2.getSelectedIndex()) {
					case 0: 
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1000;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 1:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*100;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 2:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*3.28084;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 3:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*39.37008;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					case 4:
						num1 = Double.parseDouble(textField1.getText().replaceAll(",", ""));
						result = num1*1;
						printMethod(result);
						increaseFontSize(textField1, textField2);
						decreaseFontSize(textField1, textField2);
						break;
					}
					break;
				}
			}	
		}
		if(e.getSource() == deciButton) {
			textField1.setText(textField1.getText().concat("."));
		}
		if(e.getSource() == menu) {
			Menu menu = new Menu();
			lengthConverterFrame.dispose();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0; i < numButtons.length; i++) {
			if (e.getSource() == numButtons[i]){
				numButtons[i].setForeground(new Color(16, 12, 8));
				numButtons[i].setBackground(new Color(211, 211, 211));
			}
		}
		for(int i = 0; i < functionButtons.length; i++) {
			if (e.getSource() == functionButtons[i]) {
				functionButtons[i].setForeground(new Color(16, 12, 8));
				functionButtons[i].setBackground(new Color(211, 211, 211));
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0; i < numButtons.length; i++) {
			if (e.getSource() == numButtons[i]){
				numButtons[i].setForeground(new Color(255, 255, 255));
				numButtons[i].setBackground(new Color(88, 87, 86));
			}
		}
		for(int i = 0; i < functionButtons.length; i++) {
			if (e.getSource() == functionButtons[i]) {
				functionButtons[i].setForeground(new Color(255, 255, 255));
				functionButtons[i].setBackground(new Color(75, 74, 73));
			}
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		decreaseFontSize(textField1, textField2);
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		decreaseFontSize(textField1, textField2);
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		decreaseFontSize(textField1, textField2);
	}
}