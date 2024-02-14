import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BMI extends JFrame implements ActionListener{
	
	JTextField textFieldHeightCM, textFieldWeightKG;
	JTextField textFieldHeightFeet, textFieldHeightInches, textFieldWeightPounds;
	JLabel height, weight, bmi, result, classification, classResult, classificationImage;
	JButton calculate, clear, usUnit, metricUnit, menu;
	Font textfieldFont = new Font("Calibri", Font.PLAIN, 17);
	Font labelFont = new Font("Calibri", Font.PLAIN, 15);
	ImageIcon image;
	ImageIcon frameIcon = new ImageIcon("icon.png");
	JFrame BMIFrame = new JFrame();
	
	BMI(){
		BMIFrame.setTitle("BMI Calculator");
		BMIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BMIFrame.setSize(335, 545);
		BMIFrame.setLocationRelativeTo(null);
		BMIFrame.setLayout(null);
		BMIFrame.getContentPane().setBackground(new Color(27, 27, 27));
		BMIFrame.setResizable(false);
		BMIFrame.setIconImage(frameIcon.getImage());
		
		menu = new JButton("…");
		menu.setBounds(10, 10, 40, 40);
		menu.setFont(new Font("Calibri", Font.BOLD, 20));
		menu.setBackground(new Color(75, 74, 73));
		menu.setForeground(new Color(255, 255, 255));
		menu.setFocusable(false);
		menu.setBorder(null);
		menu.addActionListener(this);

		textFieldHeightFeet = new JTextField();
		textFieldHeightFeet.setFont(textfieldFont);
		textFieldHeightFeet.setBounds(70, 60, 115, 20);
		textFieldHeightFeet.setBorder(null);
		textFieldHeightFeet.setToolTipText("feet");

		textFieldHeightInches = new JTextField();
		textFieldHeightInches.setFont(textfieldFont);
		textFieldHeightInches.setBounds(190, 60, 115, 20);
		textFieldHeightInches.setBorder(null);
		textFieldHeightInches.setToolTipText("inches");
		
		textFieldWeightPounds = new JTextField();
		textFieldWeightPounds.setFont(textfieldFont);
		textFieldWeightPounds.setBounds(70, 90, 235, 20);
		textFieldWeightPounds.setBorder(null);
		textFieldWeightPounds.setToolTipText("pounds");
		
		textFieldHeightCM = new JTextField();
		textFieldHeightCM.setFont(textfieldFont);
		textFieldHeightCM.setBounds(70, 60, 235, 20);
		textFieldHeightCM.setBorder(null);
		textFieldHeightCM.setToolTipText("centimeter");
		textFieldHeightCM.setVisible(false);
		
		textFieldWeightKG = new JTextField();
		textFieldWeightKG.setFont(textfieldFont);
		textFieldWeightKG.setBounds(70, 90, 235, 20);
		textFieldWeightKG.setBorder(null);
		textFieldWeightKG.setToolTipText("kilogram");
		textFieldWeightKG.setVisible(false);
		
		height = new JLabel("Height");
		weight = new JLabel("Weight");
		
		height.setFont(labelFont);
		height.setForeground(Color.WHITE);
		height.setBounds(10, 60, 60, 25);
		weight.setFont(labelFont);
		weight.setForeground(Color.WHITE);
		weight.setBounds(10, 90, 60, 25);
		
		calculate = new JButton("Calculate");
		clear = new JButton("Clear");
		
		calculate.setBounds(70, 120, 115, 20);
		calculate.setFocusable(false);
		calculate.setBorder(null);
		calculate.setForeground(Color.white);
		calculate.setBackground(new Color(0, 153, 0));
		calculate.addActionListener(this);
		
		clear.setBounds(190, 120, 115, 20);
		clear.setFocusable(false);
		clear.setBorder(null);
		clear.setForeground(Color.white);
		clear.setBackground(new Color(204, 0, 0));
		clear.addActionListener(this);
		
		usUnit = new JButton("US Units");
		usUnit.setBounds(140, 30, 80, 20);
		usUnit.setFocusable(false);
		usUnit.setBorder(null);
		usUnit.setBackground(new Color(88, 87, 86));
		usUnit.setForeground(Color.white);
		usUnit.addActionListener(this);
		
		metricUnit = new JButton("Metric Units");
		metricUnit.setBounds(225, 30, 80, 20);
		metricUnit.setFocusable(false);
		metricUnit.setBorder(null);
		metricUnit.setBackground(new Color(88, 87, 86));
		metricUnit.setForeground(Color.white);
		metricUnit.addActionListener(this);
		
		bmi = new JLabel("BMI");
		bmi.setFont(labelFont);
		bmi.setForeground(Color.WHITE);
		bmi.setBounds(10, 150, 60, 25);
		
		result = new JLabel("Result");
		result.setFont(labelFont);
		result.setForeground(Color.WHITE);
		result.setBounds(165, 150, 60, 25);
		
		classification = new JLabel("Classfication:");
		classification.setFont(labelFont);
		classification.setForeground(Color.WHITE);
		classification.setBounds(10, 260, 100, 25);
		
		classResult = new JLabel();
		classResult.setFont(labelFont);
		classResult.setForeground(Color.WHITE);
		classResult.setBounds(100, 260, 150, 25);
		
		JLabel underweight = new JLabel("Underweight  <  18.5");
		underweight.setFont(labelFont);
		underweight.setForeground(Color.WHITE);
		underweight.setBounds(10, 170, 150, 25);
		
		JLabel normal = new JLabel("Normal  18.5  -  22.9");
		normal.setFont(labelFont);
		normal.setForeground(Color.WHITE);
		normal.setBounds(10, 185, 150, 25);
		
		JLabel riskToOverweight = new JLabel("Risk to Overweight  23  -  24.9");
		riskToOverweight.setFont(labelFont);
		riskToOverweight.setForeground(Color.WHITE);
		riskToOverweight.setBounds(10, 200, 200, 25);
		
		JLabel overweight = new JLabel("Overweight  25  -  29.9");
		overweight.setFont(labelFont);
		overweight.setForeground(Color.WHITE);
		overweight.setBounds(10, 215, 150, 25);
		
		JLabel obese = new JLabel("Obese  >  30");
		obese.setFont(labelFont);
		obese.setForeground(Color.WHITE);
		obese.setBounds(10, 230, 150, 25);
		
		classificationImage = new JLabel();
		classificationImage.setBounds(120, 280, 100, 210);
		
		BMIFrame.add(menu);
		BMIFrame.add(metricUnit);
		BMIFrame.add(usUnit);
		BMIFrame.add(classificationImage);
		BMIFrame.add(obese);
		BMIFrame.add(overweight);
		BMIFrame.add(riskToOverweight);
		BMIFrame.add(normal);
		BMIFrame.add(underweight);
		BMIFrame.add(classResult);
		BMIFrame.add(classification);
		BMIFrame.add(result);
		BMIFrame.add(bmi);
		BMIFrame.add(clear);
		BMIFrame.add(calculate);
		BMIFrame.add(height);
		BMIFrame.add(weight);
		BMIFrame.add(textFieldHeightFeet);
		BMIFrame.add(textFieldHeightInches);
		BMIFrame.add(textFieldWeightPounds);
		BMIFrame.add(textFieldHeightCM);
		BMIFrame.add(textFieldWeightKG);
		BMIFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calculate) {
			
			if(textFieldWeightPounds.isVisible()) {
				double feet, inches, pounds, resultBMI;
			
				if(textFieldHeightFeet.getText().trim().isEmpty() || textFieldHeightInches.getText().trim().isEmpty() || textFieldWeightPounds.getText().trim().isEmpty()) {
					result.setText("Invalid");
					classResult.setText("Invalid");
				}
				else {
					feet = Double.parseDouble(textFieldHeightFeet.getText());
					inches = Double.parseDouble(textFieldHeightInches.getText());
					pounds = Double.parseDouble(textFieldWeightPounds.getText());
					
					inches /= 12; // Convert inches into decimal
					double toInches = (feet+inches/1)*(12/1); // Convert feet & .inches into inches
					resultBMI = 703*pounds/(toInches*toInches); // Calculate the BMI
					
					result.setText(String.format("%.1f",resultBMI));
					
						if(resultBMI < 18.5) {
							classResult.setText("Underweight");
							classificationImage.setIcon(new ImageIcon(new ImageIcon("underweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
						}
						else if(resultBMI < 23) {
							classResult.setText("Normal");
							classificationImage.setIcon(new ImageIcon(new ImageIcon("normal.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
						}
						else if(resultBMI < 24.9) {
							classResult.setText("Risk to overweight");
							classificationImage.setIcon(new ImageIcon(new ImageIcon("risk to overweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
						}
						else if(resultBMI < 29.9) {
							classResult.setText("Overweight");
							classificationImage.setIcon(new ImageIcon(new ImageIcon("overweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
						}
						else {
							classResult.setText("Obese");
							classificationImage.setIcon(new ImageIcon(new ImageIcon("obese.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
						}
				}
			}
			else {
				double cm, kg, resultBMI;
				
				cm = Double.parseDouble(textFieldHeightCM.getText());
				kg = Double.parseDouble(textFieldWeightKG.getText());
				
				cm *= 0.01; // convert centimeter to meter
				resultBMI = kg/(cm*cm); // computes bmi
				
				result.setText(String.format("%.2f",resultBMI));
				
				if(resultBMI < 18.5) {
					classResult.setText("Underweight");
					classificationImage.setIcon(new ImageIcon(new ImageIcon("underweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
				}
				else if(resultBMI < 23) {
					classResult.setText("Normal");
					classificationImage.setIcon(new ImageIcon(new ImageIcon("normal.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
				}
				else if(resultBMI < 24.9) {
					classResult.setText("Risk to overweight");
					classificationImage.setIcon(new ImageIcon(new ImageIcon("risk to overweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
				}
				else if(resultBMI < 29.9) {
					classResult.setText("Overweight");
					classificationImage.setIcon(new ImageIcon(new ImageIcon("overweight.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
				}
				else {
					classResult.setText("Obese");
					classificationImage.setIcon(new ImageIcon(new ImageIcon("obese.png").getImage().getScaledInstance(80, 200, Image.SCALE_DEFAULT)));
				}
			}
		}
		if(e.getSource() == clear) {
			textFieldHeightFeet.setText("");
			textFieldHeightInches.setText("");
			textFieldWeightPounds.setText("");
			textFieldHeightCM.setText("");
			textFieldWeightKG.setText("");
			result.setText("Result");
			classResult.setText("");
			classificationImage.setIcon(null);
		}
		if(e.getSource() == usUnit) {
			textFieldHeightCM.setVisible(false);
			textFieldWeightKG.setVisible(false);
			textFieldHeightFeet.setVisible(true);
			textFieldHeightInches.setVisible(true);
			textFieldWeightPounds.setVisible(true);
			result.setText("Result");
			classResult.setText("");
			classificationImage.setIcon(null);
			textFieldHeightCM.setText(""); //clear text field
			textFieldWeightKG.setText(""); //clear text field
		}
		if(e.getSource() == metricUnit) {
			textFieldHeightFeet.setVisible(false);
			textFieldHeightInches.setVisible(false);
			textFieldWeightPounds.setVisible(false);
			textFieldHeightCM.setVisible(true);
			textFieldWeightKG.setVisible(true);
			result.setText("Result");
			classResult.setText("");
			classificationImage.setIcon(null);
			textFieldHeightFeet.setText(""); //clear text field
			textFieldHeightInches.setText(""); //clear text field
			textFieldWeightPounds.setText(""); //clear text field
		}
		if(e.getSource() == menu) {
			Menu menu = new Menu();
			BMIFrame.dispose();
		}
	}
}
