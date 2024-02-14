import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Menu extends JFrame implements MouseListener, ActionListener{
	
	JButton[] buttons = new JButton[9];
	JButton sciCalButton, stanCalButton, bmiButton, lengthButton, weightButton,
	temperatureButton, speedButton, dataButton, timeButton;
	ImageIcon frameIcon = new ImageIcon("icon.png");
	JFrame menuFrame = new JFrame();
	Menu(){
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(250, 545);
		menuFrame.setLocation(515, 90);
		menuFrame.setLayout(null);
		menuFrame.getContentPane().setBackground(new Color(27, 27, 27));
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setResizable(false);
		menuFrame.setIconImage(frameIcon.getImage());
		
		JLabel calLabel = new JLabel("Calculator");
		calLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		calLabel.setForeground(new Color(215, 215, 215));
		calLabel.setBounds(5, 20, 235, 20);
		
		JLabel conLabel = new JLabel("Converter");
		conLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		conLabel.setForeground(new Color(215, 215, 215));
		conLabel.setBounds(5, 150, 235, 20);
		
		sciCalButton = new JButton("Scientific");
		stanCalButton = new JButton("Standard");
		bmiButton = new JButton("BMI");
		lengthButton = new JButton("Length");
		weightButton = new JButton("Weight");
		temperatureButton = new JButton("Temperature");
		speedButton = new JButton("Speed");
		timeButton = new JButton("Time");
		dataButton = new JButton("Data");
		
		buttons[0] = stanCalButton;
		buttons[1] = sciCalButton;
		buttons[2] = bmiButton;
		buttons[3] = lengthButton;
		buttons[4] = weightButton;
		buttons[5] = temperatureButton;
		buttons[6] = speedButton;
		buttons[7] = timeButton;
		buttons[8] = dataButton;
		
		int height = 50;
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setFont(new Font("Calibri", Font.PLAIN, 15));
			buttons[i].setForeground(new Color(215, 215, 215));
			buttons[i].setBackground(new Color(27, 27, 27));
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusable(false);
			buttons[i].setBounds(0, height, 235, 30);;
			buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
			buttons[i].addActionListener(this);
				if(buttons[i] == buttons[2]) {
					height += 70;
				}
				else {
					height += 30;
				}
		}
		
		menuFrame.add(calLabel);
		menuFrame.add(conLabel);
		
		for(int i = 0; i < buttons.length; i++) {
			menuFrame.add(buttons[i]);
		}
		
		menuFrame.setVisible(true);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stanCalButton) {
			calculator calculator = new calculator();
			menuFrame.dispose();
		}
		if(e.getSource() == sciCalButton) {
			ScientificCalculator sciCal = new ScientificCalculator();
			menuFrame.dispose();
		}
		if(e.getSource() == bmiButton) {
			BMI bmi = new BMI();
			menuFrame.dispose();
		}
		if(e.getSource() == lengthButton) {
			LengthConverter lengthConverter = new LengthConverter();
			menuFrame.dispose();
		}
		if(e.getSource() == weightButton) {
			WeightConverter weightConverter = new WeightConverter();
			menuFrame.dispose();
		}
		if(e.getSource() == temperatureButton) {
			TemperatureConverter temperatureConverter = new TemperatureConverter();
			menuFrame.dispose();		
		}
		if(e.getSource() == speedButton) {
			SpeedConverter speedConverter = new SpeedConverter();
			menuFrame.dispose();
		}
		if(e.getSource() == timeButton) {
			TimeConverter timeConverter = new TimeConverter();
			menuFrame.dispose();
		}
		if(e.getSource() == dataButton) {
			DataConverter dataConverter = new DataConverter();
			menuFrame.dispose();
		}
		
	}
	
}
