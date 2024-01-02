package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Hand.VMHandler;

//GUI Interface
public class Interface extends JPanel
{
	private static final long serialVersionUID = 1L;
	//Button and main display of GUI
	public JButton plusButton;
	public JButton minusButton;
	public JButton divisionButton;
	public JButton zeroButton;
	public JButton oneButton;
	public JButton twoButton;
	public JButton threeButton;
	public JButton fourButton;
	public JButton fiveButton;
	public JButton sixButton;
	public JButton sevenButton;
	public JButton eightButton;
	public JButton nineButton;
	public JButton zerozeroButton;
	public JButton decimalButton;
	public JButton startGameButton;
	public JButton leftpButton;
	public JButton rightpButton;
	public JButton multiButton;
	public JButton powButton;
	public JButton clearButton;
	public JButton equalButton;
	public JLabel display;
	
	//Handler that handles events when a button is clicked
	VMHandler vm;

	//Initialize display and buttons
	public Interface()
	{
		init();
		//addComponents();
	}
	
	//Initialization
	void init() {
		// Initializes objects
		display = new JLabel();
		plusButton = new JButton("+");
		minusButton = new JButton("-");
		divisionButton = new JButton("/");
		zeroButton = new JButton("0");
		oneButton = new JButton("1");
		twoButton = new JButton("2");
		threeButton = new JButton("3");
		fourButton = new JButton("4");
		fiveButton = new JButton("5");
		sixButton = new JButton("6");
		sevenButton = new JButton("7");
		eightButton = new JButton("8");
		nineButton = new JButton("9");
		zerozeroButton = new JButton("00");
		decimalButton = new JButton(".");
		leftpButton = new JButton("(");
		rightpButton = new JButton(")");
		multiButton = new JButton("*");
		powButton = new JButton("^");
		clearButton = new JButton("C");
		equalButton = new JButton("=");

		vm = new VMHandler(this);
		
		//Set up grid layout for the display
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
		
		//add display to the GUI
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,5,5,5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(display, gbc);
		
		//place each button at a specific point on the grid
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(plusButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(minusButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(divisionButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(multiButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(zeroButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(oneButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(twoButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(threeButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(fourButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(fiveButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(sixButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(sevenButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(eightButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(nineButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(zerozeroButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(decimalButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(powButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(leftpButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(rightpButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(clearButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(equalButton, gbc);
		
		// Add listeners for the buttons
		plusButton.addActionListener(vm);
		minusButton.addActionListener(vm);
		divisionButton.addActionListener(vm);
		zeroButton.addActionListener(vm);
		oneButton.addActionListener(vm);
		twoButton.addActionListener(vm);
		threeButton.addActionListener(vm);
		fourButton.addActionListener(vm);
		fiveButton.addActionListener(vm);
		sixButton.addActionListener(vm);
		sevenButton.addActionListener(vm);
		eightButton.addActionListener(vm);
		nineButton.addActionListener(vm);
		zerozeroButton.addActionListener(vm);
		decimalButton.addActionListener(vm);
		leftpButton.addActionListener(vm);
		rightpButton.addActionListener(vm);
		multiButton.addActionListener(vm);
		powButton.addActionListener(vm);
		clearButton.addActionListener(vm);
		equalButton.addActionListener(vm);
		
		// Configure display
		display.setPreferredSize(new Dimension(250, 40));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
	}
	
	void addComponents() 
	{
		// Adds buttons to panel
		//add();
	}
}
