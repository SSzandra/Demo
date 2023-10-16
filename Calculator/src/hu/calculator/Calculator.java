package hu.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	JFrame frame;
	JLabel label = new JLabel();
	JTextField textField;
	
	JButton num0 = new JButton("0");
	JButton num1 = new JButton("1");
	JButton num2 = new JButton("2");
	JButton num3 = new JButton("3");
	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");

	JButton t = new JButton(",");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton mul = new JButton("*");
	JButton dev = new JButton("/");
	JButton equ = new JButton("=");
	JButton sq = new JButton("x\u00B2");
	JButton sqrt = new JButton("\u221A");
	JButton rec = new JButton("1/x");
	JButton neg = new JButton("+/-");
	
	JButton del = new JButton("del");
	JButton clear = new JButton("c");
	
	JButton[] buttons = new JButton[22];
	
	JPanel panel;
	Font font = new Font("Monospaced",Font.BOLD,15);
	
	double number1=0;
	double number2=0;
	double result=0;
	char op;
		
	Calculator() {
		elokeszit();
	}
	
	public void elokeszit() {
		
		//keret beállítása
		frame = new JFrame("Calculator");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setSize(420,520);
		frame.setResizable(false);	
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ellenőrző sáv beállítása
		label.setBounds(50, 0, 300, 30);
		label.setFont(font);
		label.setForeground(Color.white);
		frame.add(label);
		
		//kijelző beállítása
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 30);
		textField.setFont(font);
		textField.setEditable(false);
		frame.add(textField);
		
		//gombok beállítása
		buttons[0] = num0;
		buttons[1] = num1;
		buttons[2] = num2;
		buttons[3] = num3;
		buttons[4] = num4;
		buttons[5] = num5;
		buttons[6] = num6;
		buttons[7] = num7;
		buttons[8] = num8;
		buttons[9] = num9;
		buttons[10] = t;
		buttons[11] = plus;
		buttons[12] = minus;
		buttons[13] = mul;
		buttons[14] = dev;
		buttons[15] = equ;
		buttons[16] = sq;
		buttons[17] = sqrt;
		buttons[18] = rec;
		buttons[19] = neg;
		buttons[20] = del;
		buttons[21] = clear;
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i].addActionListener(this);
			buttons[i].setFont(font);
			buttons[i].setFocusable(false);
		}
		
		del.setBounds(50,420,145,50);
		clear.setBounds(205,420,145,50);
		frame.add(del);
		frame.add(clear);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(5,4,10,10));
		panel.setBackground(Color.LIGHT_GRAY);
		
		panel.add(num1);
		panel.add(num2);
		panel.add(num3);
		panel.add(plus);
		panel.add(num4);
		panel.add(num5);
		panel.add(num6);
		panel.add(minus);
		panel.add(num7);
		panel.add(num8);
		panel.add(num9);
		panel.add(mul);
		panel.add(t);
		panel.add(num0);
		panel.add(equ);
		panel.add(dev);
		panel.add(neg);
		panel.add(sq);
		panel.add(sqrt);
		panel.add(rec);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//számok kezelése
		try {
			if((textField.getText().equals(String.valueOf(result))==false)) {
					if(e.getSource() == num0) {
						textField.setText(textField.getText().concat("0"));
					}
					if(e.getSource() == num1) {
						textField.setText(textField.getText().concat("1"));
					}
					if(e.getSource() == num2) {
						textField.setText(textField.getText().concat("2"));
					}
					if(e.getSource() == num3) {
						textField.setText(textField.getText().concat("3"));
					}
					if(e.getSource() == num4) {
						textField.setText(textField.getText().concat("4"));
					}
					if(e.getSource() == num5) {
						textField.setText(textField.getText().concat("5"));
					}
					if(e.getSource() == num6) {
						textField.setText(textField.getText().concat("6"));
					}
					if(e.getSource() == num7) {					
						textField.setText(textField.getText().concat("7"));
					}
					if(e.getSource() == num8) {
						textField.setText(textField.getText().concat("8"));
					}
					if(e.getSource() == num9) {
						textField.setText(textField.getText().concat("9"));
					}
					if(e.getSource() == t) {
						textField.setText(textField.getText().concat("."));
					}
			}
		} catch (Exception error) {
		}
			try {
				if(e.getSource() == neg) {
					if(textField.getText()!="") {
						double temp = Double.parseDouble(textField.getText());
						temp*=-1;
						textField.setText(String.valueOf(temp));
					}
				} 
			} catch (Exception error1) {
						label.setText("előbb a számot kérem");
				}
			//alapműveletek
			try {
				if(textField.getText()!="") {
					if(e.getSource() == plus) {
						number1 = Double.parseDouble(textField.getText());
						op = '+';
						textField.setText("");
						label.setText(String.valueOf(number1)+ " +");
					}
					if(e.getSource() == minus) {
						number1 = Double.parseDouble(textField.getText());
						op = '-';
						textField.setText("");
						label.setText(String.valueOf(number1)+ " -");
					}
					if(e.getSource() == mul) {
						number1 = Double.parseDouble(textField.getText());
						op = '*';
						textField.setText("");
						label.setText(String.valueOf(number1)+ " *");
					}
					if(e.getSource() == dev) {
						number1 = Double.parseDouble(textField.getText());
						op = '/';
						textField.setText("");
						label.setText(String.valueOf(number1)+ " /");
					}
				}
				} catch (Exception error2) {
					label.setText("írja be az első számot");
			}
			try {
				if(e.getSource() == equ) {
					if (textField.getText()!="") {
						number2 = Double.parseDouble(textField.getText());
						switch(op) {
							case '+':
								result = number1+number2;
								label.setText(String.valueOf(number1)+ " + "+String.valueOf(number2));
								break;
							case '-':
								result = number1-number2;
								label.setText(String.valueOf(number1)+ " - "+String.valueOf(number2));
								break;
							case '*':
								result = number1*number2;
								label.setText(String.valueOf(number1)+ " * "+String.valueOf(number2));
								break;
							case '/':
								if (number2!=0) {
									result = number1/number2;
									label.setText(String.valueOf(number1)+ " / "+String.valueOf(number2));
								} else { 
									result = 0;
									label.setText("0-val nem lehet osztani");
								}
								break;
						}
						textField.setText(String.valueOf(result));
						number1=result;
					}
				} 
			} catch (Exception error3) {
				label.setText("számot kérek");
			}
			//sq,sqrt,rec
			try {
				if(textField.getText()!="") {
					if(e.getSource() == sq) {
						number1 = Double.parseDouble(textField.getText());
						number2 = Double.parseDouble(textField.getText()); 
						result = number1*number2;
						label.setText(String.valueOf(number1)+"\u00B2");
						textField.setText(String.valueOf(result));
						number1=result;
					}
					if(e.getSource() == sqrt) {
						number1 = Double.parseDouble(textField.getText());
						if(number1>=0) {
							result = Math.sqrt(number1);
							label.setText("\u221A"+String.valueOf(number1));
							textField.setText(String.valueOf(result));
							number1=result;
						} else {
							result = 0;
							label.setText("csak nem negatív valós számmal!");
						}
					}
					if(e.getSource() == rec) {
						number1 = Double.parseDouble(textField.getText());
						if(number1!=0) {
							result = 1/number1;
							label.setText(String.valueOf(number1)+" rec");
							textField.setText(String.valueOf(result));
							number1=result;
						} else {
							result = 0;
							label.setText("0-nak nincs reciproka!");
						}
					}
				} 
			} catch (Exception error4) {
				label.setText("kérem a számot");	
				}
			//clear és del
			if(e.getSource() == clear) {
				textField.setText("");
				label.setText("");
				number1=0;
				number2=0;
				result=0;
			}
			try {
				if(e.getSource() == del) {
					if((textField.getText().equals(String.valueOf(result))==false)) {
						String string = textField.getText();
						textField.setText("");
						for(int i=0;i<string.length()-1;i++) {
						textField.setText(textField.getText()+string.charAt(i));
					}
				}		
			}
		} catch (Exception error5) {
		}
	}
}

		

