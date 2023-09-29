package _03_Printing_Binary;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Goal: Create a program that converts a binary string to ascii, decimal,
 *       and hexadecimal.
 * 
 * Programmers sometimes use a number system called hexadecimal that has 16
 * different possible characters per digit. Each digit can be from 0 to F,
 *     hex character: 0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F
 *     decimal value: 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 1111
 * 
 * Hex values are prefixed with a 0x in code,
 *      int hex = 0x1F;     // 31 decimal, 11111 binary
 * 
 * Since each hex digit can be 16 different characters, 1 byte can be expressed
 * as 2 hex characters. All 3 int variables below are the same value.
 *      int hex = 0x1F;
 *      int bin = 0b11111;
 *      int dec = 31;
 * 
 * Hex is used because it is more compact than binary. For example,
 *      int bin = 0b11111111111111111111111111111111    // 32 1s
 *      int hex = 0xFFFFFFFF;       // 8 F characters
 * 
 * Complete the methods so that it displays the correct hex value,.
 * decimal value, and ASCII value, if applicable.
 */
public class _02_HexadecimalPrinter implements ActionListener {
	JFrame frame;
	JPanel panel;
	JTextField hexResult, decimalResult, asciiResult, inputTextField;
	JLabel labelAscii, labelDecimal, labelHex;
	JButton convertButton;

	/*
	 * Complete these 3 methods. Assume the binary value is an int (32 bits). You
	 * don't have to handle negative numbers unless you want the challenge!
	 */
	String binaryToHex(String binaryStr) {
		if(binaryStr.length() == 0) {
			return "-";
		}
		String hex = "";
		int deci = Integer.parseInt(binaryToDec(binaryStr));
		do {
			int quote = deci>>4;
			char hexa = '\0';
			int rem = deci%16;
			String str = Integer.toString(rem);
			hex += check(str);
			deci = quote;
			
			
		}
		while(deci!= 0);
		
		
		return hex;
	}
	String check(String num) {
		if(num.equals("0")) {
			return "0";
		}
		else if(num.equals("1")) {
			return "1";
		}else if(num.equals("2")) {
			return "2";
		}else if(num.equals("3")) {
			return "3";
		}
		else if(num.equals("4")) {
			return "4";
		}else if(num.equals("5")) {
			return "5";
		}
		else if(num.equals("6")) {
			return "6";
		}
		else if(num.equals("7")) {
			return "7";
		}else if(num.equals("8")) {
			return "8";
		}else if(num.equals("9")) {
			return "9";
		}
		else if(num.equals("10")) {
			return "A";
		}else if(num.equals("11")) {
			return "B";
		}
		else if(num.equals("12")) {
			return "C";
		}else if(num.equals("13")) {
			return "D";
		}else if(num.equals("14")) {
			return "E";
		}
		else if(num.equals("15")) {
			return "F";
		}

	return "";
	}
	
	

	String binaryToDec(String binaryStr) {
		StringBuilder bob = new StringBuilder(binaryStr);
		bob.reverse();

		int sum = 0;
		int lastVal = 1;
		for (int i = 0; i < bob.length(); i++) {
			if (bob.charAt(i) == '1') {
				sum+=lastVal;
			}
			lastVal = lastVal * 2;

		}
		
		return ""+sum;
	}

	/*
	 * ASCII values are exactly 8 bits so return '-' if there isn't.
	 */
	//exactly 8 1/0's
	String binaryToAscii(String binaryStr) {
		if (binaryStr.length() != 8) {
			return "-";
		}
		String deci = binaryToDec(binaryStr);
		int decNum = Integer.parseInt(deci);
		if(decNum >= 65 && decNum <= 90) { //if its an uppercase letter
			for(int i = 0; i < 26; i++) {
				
			}
		}
		//cast chat into an int to get decimal 
		
		
		
		
		return "-";
	}

	public static void main(String[] args) {
		new _02_HexadecimalPrinter().start();
	}

	public void start() {
		frame = new JFrame("Hexadecimal Printer");
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		hexResult = new JTextField(12);
		decimalResult = new JTextField(12);
		asciiResult = new JTextField(12);
		inputTextField = new JTextField(25);
		convertButton = new JButton("Convert");
		labelAscii = new JLabel("ASCII:");
		labelDecimal = new JLabel("Decimal:");
		labelHex = new JLabel("Hexadecimal:");

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		labelAscii.setFont(new Font("Arial", Font.PLAIN, 30));
		labelDecimal.setFont(new Font("Arial", Font.PLAIN, 30));
		labelHex.setFont(new Font("Arial", Font.PLAIN, 30));
		inputTextField.setFont(new Font("Arial", Font.PLAIN, 30));
		decimalResult.setFont(new Font("Arial", Font.PLAIN, 30));
		asciiResult.setFont(new Font("Arial", Font.PLAIN, 30));
		hexResult.setFont(new Font("Arial", Font.PLAIN, 30));
		convertButton.setFont(new Font("Arial", Font.PLAIN, 30));
		convertButton.addActionListener(this);

		inputTextField.setText("<Input binary number>");
		inputTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (inputTextField.getText().contains("binary")) {
					inputTextField.setText("");
				}
			}
		});

		addObjectToPanel(inputTextField, 0, 0, 2);
		addObjectToPanel(convertButton, 1, 0, 2);
		addObjectToPanel(labelAscii, 2, 0, 1);
		addObjectToPanel(asciiResult, 2, 1, 1);
		addObjectToPanel(labelDecimal, 3, 0, 1);
		addObjectToPanel(decimalResult, 3, 1, 1);
		addObjectToPanel(labelHex, 4, 0, 1);
		addObjectToPanel(hexResult, 4, 1, 1);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 18. If convertButton was pressed...
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == convertButton) {
			String binaryStr = inputTextField.getText();

			String asciiStr = binaryToAscii(binaryStr);
			String decimalStr = binaryToDec(binaryStr);
			String hexStr = binaryToHex(binaryStr);

			asciiResult.setText(asciiStr);
			decimalResult.setText(decimalStr);
			hexResult.setText(hexStr);
		}
	}

	private void addObjectToPanel(JComponent component, int row, int column, int cellWidth) {
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL; // This expands the JComponent to fill gridwidth
		constraints.gridx = column; // This is the column the JComponent is placed
		constraints.gridy = row; // This is the row the JComponent is placed
		constraints.gridwidth = cellWidth; // This is how many horizontal cells to span across
		constraints.gridheight = 1; // This is how many vertical cells to span across
		this.panel.add(component, constraints);
	}
}
