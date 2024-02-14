import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class ScientificCalculator extends JFrame implements ActionListener, MouseListener, DocumentListener{
	private static final long serialVersionUID = 1L;
	static JButton[] numButtons = new JButton[10];
	JButton[] functionButtons = new JButton[20];
	JButton addButton, subButton, mulButton, divButton, menu;
	JButton deciButton, equalButton, delButton, clrButton, integerButton;
	JButton sinButton, cosButton, tanButton, expButton, logButton, sqrtButton;
	JButton ceilButton, floorButton, powButton, roundButton;
	static JTextField textField;
	static JTextField formula;
	static Font textFieldFont = new Font("Arial Black", Font.PLAIN, 35);
	Font numFont = new Font("Calibri", Font.BOLD, 20);
	Font functionFont = new Font("Calibri", Font.BOLD, 11);
	double num1 = 0, num2 = 0, result = 0, result2 = 0;
	char operator;
	ImageIcon frameIcon = new ImageIcon("icon.png");
	JFrame scientificFrame = new JFrame();
	
	ScientificCalculator(){
		scientificFrame.setTitle("Scientific Calculator");
		scientificFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scientificFrame.setSize(335, 545);
		scientificFrame.setLocationRelativeTo(null);
		scientificFrame.setLayout(new BorderLayout());
		scientificFrame.getContentPane().setBackground(new Color(27, 27, 27));
		scientificFrame.setIconImage(frameIcon.getImage());
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		menu = new JButton("…");
		deciButton = new JButton(".");
		equalButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("C");
		integerButton = new JButton("±");
		sinButton = new JButton("Sin");
		cosButton = new JButton("Cos");
		tanButton = new JButton("Tan");
		expButton = new JButton("e");
		logButton = new JButton("log");
		sqrtButton = new JButton("\u221A");
		ceilButton = new JButton("x]");
		floorButton = new JButton("[x");
		roundButton = new JButton("[x]");
		powButton = new JButton("Xʸ");
		
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		
		midPanel.setLayout(new GridLayout(5, 5, 2, 2));
		topPanel.setLayout(new BorderLayout());
		
		midPanel.setBackground(new Color(27, 27, 27));

		scientificFrame.add(topPanel, BorderLayout.NORTH);
		scientificFrame.add(midPanel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250, 100));
		textField.setBackground(new Color(27, 27, 27));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(textFieldFont);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setBorder(null);
		textField.getDocument().addDocumentListener(this);
		
		formula = new JTextField(" ");
		formula.setBackground(new Color(27, 27, 27));
		formula.setForeground(new Color(255, 255, 255));
		formula.setOpaque(true);
		formula.setFont(new Font("Arial Black", Font.PLAIN, 25));
		formula.setEditable(false);
		formula.setBorder(null);
		formula.setCaretColor(new Color(27, 27, 27));
		formula.getDocument().addDocumentListener(this);

		menu.setForeground(new Color(255, 255, 255));
		menu.setLayout(null);
		menu.setBounds(0, 0, 0, 0);
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = menu;
		functionButtons[5] = deciButton;
		functionButtons[6] = equalButton;
		functionButtons[7] = delButton;
		functionButtons[8] = clrButton;
		functionButtons[9] = integerButton;
		functionButtons[10] = sinButton;
		functionButtons[11] = cosButton;
		functionButtons[12] = tanButton;
		functionButtons[13] = expButton;
		functionButtons[14] = logButton;
		functionButtons[15] = sqrtButton;
		functionButtons[16] = ceilButton;
		functionButtons[17] = floorButton;
		functionButtons[18] = roundButton;
		functionButtons[19] = powButton;
		
		for(int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].addMouseListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(functionFont);
			functionButtons[i].setBackground(new Color(75, 74, 73));
			functionButtons[i].setForeground(new Color(255, 255, 255));
			functionButtons[i].setBorderPainted(false);
				if(functionButtons[i] == functionButtons[6]) {
					functionButtons[i].setBackground(new Color(237, 170, 11));
					functionButtons[i].setForeground(new Color(255, 255, 255));
				}
		}
		for(int i = 0; i < 10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].addMouseListener(this);
			numButtons[i].setFocusable(false);
			numButtons[i].setFont(numFont);
			numButtons[i].setBackground(new Color(88, 87, 86));
			numButtons[i].setForeground(new Color(255, 255, 255));
			numButtons[i].setBorderPainted(false);
		}
		midPanel.add(functionButtons[4]);
		midPanel.add(functionButtons[9]);
		midPanel.add(functionButtons[8]);
		midPanel.add(functionButtons[7]);
		midPanel.add(functionButtons[10]);
		midPanel.add(functionButtons[15]);
		midPanel.add(numButtons[7]);
		midPanel.add(numButtons[8]);
		midPanel.add(numButtons[9]);
		midPanel.add(functionButtons[3]);
		midPanel.add(functionButtons[11]);
		midPanel.add(functionButtons[16]);
		midPanel.add(numButtons[4]);
		midPanel.add(numButtons[5]);
		midPanel.add(numButtons[6]);
		midPanel.add(functionButtons[2]);
		midPanel.add(functionButtons[12]);
		midPanel.add(functionButtons[17]);
		midPanel.add(numButtons[1]);
		midPanel.add(numButtons[2]);
		midPanel.add(numButtons[3]);
		midPanel.add(functionButtons[1]);
		midPanel.add(functionButtons[13]);
		midPanel.add(functionButtons[18]);
		midPanel.add(deciButton);
		midPanel.add(numButtons[0]);
		midPanel.add(equalButton);
		midPanel.add(functionButtons[0]);
		midPanel.add(functionButtons[14]);
		midPanel.add(functionButtons[19]);
		topPanel.add(textField);
		topPanel.add(formula, BorderLayout.NORTH);
		
		scientificFrame.setVisible(true);
	}
	static void decreaseFontSize(JTextField textField) {
		int maxWidth = textField.getWidth();
		String text = textField.getText();
		Font currentFont = textField.getFont();
		
		int maxWidthF = formula.getWidth();
		String textF = formula.getText();
		Font currentFontF = formula.getFont();

		Font tempFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize());
		Font tempFontF = new Font(currentFontF.getName(), currentFontF.getStyle(), currentFontF.getSize());
		
		FontMetrics fontMetrics = textField.getFontMetrics(tempFont);
		FontMetrics fontMetricsF = formula.getFontMetrics(tempFontF);
		
		int textWidth = fontMetrics.stringWidth(text);
		int textWidthF = fontMetricsF.stringWidth(textF);
		
			while(textWidth > maxWidth) {
				tempFont = new Font(tempFont.getName(), tempFont.getStyle(), tempFont.getSize() - 1);
				fontMetrics = textField.getFontMetrics(tempFont);
				textWidth = fontMetrics.stringWidth(text);
			}
			while(textWidthF > maxWidthF) {
				tempFontF = new Font(tempFontF.getName(), tempFontF.getStyle(), tempFontF.getSize() - 1);
				fontMetricsF = formula.getFontMetrics(tempFontF);
				textWidthF = fontMetricsF.stringWidth(textF);
			}
			textField.setFont(tempFont);
			formula.setFont(tempFontF);
		}
	static int printMethod(double result) {
		if(result%1 == 0) {
			textField.setText(String.format("%,d", (long)result)); // turn result to whole number
		}
		else {
			String numberAsString = Double.toString(result);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				textField.setText(String.format("%,." + decimalPart.length() + "f", result)); // turn it into decimal form based on the length of decimal digits
				return decimalPart.length();
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	static int printMethodSign(double temp) {
		if(temp%1 == 0) {
			textField.setText(String.format("%,d", (long)temp)); // turn result to whole number
		}
		else {
			String numberAsString = Double.toString(temp);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				textField.setText(String.format("%,." + decimalPart.length() + "f", temp)); // turn it into decimal form based on the length of decimal digits
				return decimalPart.length();
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	static int printMethodFormula(double num1, double num2, double operator) {
		// both are whole numbers
		if(num1%1 == 0 && num2%1 == 0) {
			formula.setText(((String.format(" %d ", (long)num1) + (char)operator + (String.format(" %d ", (long)num2) + " = "))));
		}
		// num 1 has decimal
		else if (num1%1 != 0 && num2%1 == 0){
			String numberAsString = Double.toString(num1);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				formula.setText((String.format(" %." + decimalPart.length() + "f ", num1) + (char)operator + (String.format(" %d ", (long)num2) + " = ")));
			}
			else {
				return 0;
			}
		}
		// num 2 has decimal
		else if (num1%1 == 0 && num2%1 != 0){
			String numberAsString = Double.toString(num2);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				formula.setText((String.format(" %d ", (long)num1) + (char)operator + (String.format(" %." + decimalPart.length() + "f ", num2) + " = ")));
			}
			else {
				return 0;
			}
		}
		// both has decimal
		else if(num1%1 != 0 && num2%1 != 0) {
			String numberAsString = Double.toString(num1);
			String numberAsString2 = Double.toString(num2);
			if(numberAsString.contains(".") && numberAsString2.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				String decimalPart2 = numberAsString2.split("\\.")[1];
				formula.setText(String.format(" %." + decimalPart.length() + "f ", num1) + (char)operator + (String.format(" %." + decimalPart2.length() + "f ", num2) + " = "));
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	static int printNumericButtons(int i) {	
		String currentText = textField.getText();
		String buttonText = numButtons[i].getText(); 
		String addedText = (currentText.concat(buttonText)); // removes comma
		textField.setText(addedText);
			return 0;
	}
	static int printNum1(double num1, double operator) {
		if(num1%1 == 0) {
			formula.setText((String.format(" %d ", (int)num1)) + (char)operator);
		}
		else {
			String numberAsString = Double.toString(num1);
			if(numberAsString.contains(".")) {
				String decimalPart = numberAsString.split("\\.")[1];
				formula.setText(String.format(" %." + decimalPart.length() + "f ", num1) + (char)operator);
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	static int delButton() {
		String string = textField.getText().replaceAll(",", "");
		double digit = Double.parseDouble(string);
		textField.setText("");
			if(digit%1 == 0) {
					for(int i = 0; i < string.length()-1; i++) {
						try {
							textField.setText(String.format("%,d", Long.parseLong((textField.getText()+string.charAt(i)).replaceAll(",", ""))));
						}catch (NumberFormatException e) {
							return 0;
						}
					}
			}
			else {
				if(digit < 1000) {
					for(int i = 0; i < string.length()-1; i++) {
						textField.setText((textField.getText()+string.charAt(i)).replaceAll(",", ""));
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
							textField.setText(String.format("%,d", Long.parseLong((textField.getText()+string.charAt(i)).replaceAll(",", ""))));
						}
					}
					else {
					digit = Double.parseDouble(string);
						String digitAsString = Double.toString(digit);
						if(digitAsString.contains(".")) { // print if there has still decimals left
							String decimalPart = digitAsString.split("\\.")[1];
							textField.setText(String.format("%,." + decimalPart.length() + "f", digit)); // print in a decimal format
						}
					}
				}
			}
		return 0;
	}
	static void increaseFontSize(JTextField textField) {
		// increase the size of font every time delete button is called
		Font currentFontSize = textField.getFont();
		int activeFontSize = textFieldFont.getSize();
		Font tempFont = new Font(currentFontSize.getName(), currentFontSize.getStyle(), currentFontSize.getSize());
		FontMetrics fontMetrics = textField.getFontMetrics(tempFont);
			if(currentFontSize.getSize() < activeFontSize) { // check if font size overlaps the maximum width of text field
				tempFont = new Font(tempFont.getName(), tempFont.getStyle(), tempFont.getSize() + 1);
				fontMetrics = textField.getFontMetrics(tempFont);
			textField.setFont(tempFont);	
			}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == delButton) {
			delButton();
			// turn 0 the number whenever text field is empty
			if(textField.getText().isEmpty()) {
				textField.setText("0");
			}
			increaseFontSize(textField);			
		}
		for(int i = 0; i < numButtons.length; i++) {
			if(e.getSource() == numButtons[i]) {
				if(textField.getText().equals("0")) {
					textField.setText("");
				}
		        printNumericButtons(i);
			}
		}
		if(e.getSource() == deciButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			operator = '+';
			textField.setText("");
			printNum1(num1, operator);
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			operator = '-';
			textField.setText("");
			printNum1(num1, operator);
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			operator = 'x';
			textField.setText("");
			printNum1(num1, operator);
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			operator = '÷';
			textField.setText("");
			printNum1(num1, operator);
		}
		if(e.getSource() == sinButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.toRadians(num1);
			result2 = Math.sin(result);
			operator = 'S';
			textField.setText(String.valueOf(String.format("%.2f", result2)));
			formula.setText((String.valueOf(" sin0" + "(" + num1 + ")")));
		}
		if(e.getSource() == cosButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.toRadians(num1);
			result2 = Math.cos(result);
			operator = 'C';
			textField.setText(String.valueOf(String.format("%.2f", result2)));
			formula.setText((String.valueOf(" cos0" + "(" + num1 + ")")));
		}
		if(e.getSource() == tanButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.toRadians(num1);
			result2 = Math.tan(result);
			textField.setText(String.valueOf(String.format("%.2f", result2)));
			formula.setText((String.valueOf(" tan0" + "(" + num1 + ")")));
		}
		if(e.getSource() == expButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.exp(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));		
		}
		if(e.getSource() == logButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.log(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));
			formula.setText((String.valueOf(" log" + "(" + num1 + ")")));
		}
		if(e.getSource() == sqrtButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.sqrt(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));	
		}
		if(e.getSource() == ceilButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.ceil(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));
		}
		if(e.getSource() == floorButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.floor(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));	
		}
		if(e.getSource() == powButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			operator = '^';
			textField.setText("");
			formula.setText((String.format(" %.1f ", num1)) + operator);
		}
		if(e.getSource() == roundButton) {
			num1 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			result = Math.round(num1);
			textField.setText(String.valueOf(String.format("%.2f", result)));
			formula.setText((String.valueOf(" Round" + "(" + num1 + ")")));
		}
		if(e.getSource() == equalButton) {
			num2 = Double.parseDouble(textField.getText().replaceAll(",", ""));
			
			switch(operator) {
			case '+': result = num1+num2; break;
			case '-': result = num1-num2; break;
			case 'x': result = num1*num2; break;
			case '÷': result = num1/num2; break;
			case '^': result = Math.pow(num1, num2); break;
			}
			printMethod(result);
			printMethodFormula(num1, num2, operator);
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			textField.setText("0");
			textField.setFont(textFieldFont);
			formula.setText(" ");
		}
		if(e.getSource() == integerButton) {
			double temp = Double.parseDouble(textField.getText().replaceAll(",", ""));
			temp *= -1;
			printMethodSign(temp);
			
			if(e.getSource() == integerButton) {
				temp = Double.parseDouble(textField.getText().replaceAll(",", ""));
				temp *= 1;
				printMethodSign(temp);
			}
		}
		if(e.getSource() == menu) {
			Menu menu = new Menu();
			scientificFrame.dispose();
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
		for(int i = 0; i < 10; i++) {
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
		for(int i = 0; i < 10; i++) {
			if (e.getSource() == numButtons[i]){
				numButtons[i].setForeground(new Color(255, 255, 255));
				numButtons[i].setBackground(new Color(88, 87, 86));
			}
		}
		for(int i = 0; i < functionButtons.length; i++) {
			if (e.getSource() == functionButtons[i]) {
				functionButtons[i].setForeground(new Color(255, 255, 255));
				functionButtons[i].setBackground(new Color(75, 74, 73));
					if(e.getSource() == functionButtons[6]) { // To keep the color yellow of equal button
						functionButtons[i].setBackground(new Color(237, 170, 11));
						functionButtons[i].setForeground(new Color(255, 255, 255));
					}
			}
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		decreaseFontSize(textField);	
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		decreaseFontSize(textField);		
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		decreaseFontSize(textField);	
	}
}

