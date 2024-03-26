package Hand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import GUI.Interface;

//Handles events via listeners
public class VMHandler implements ActionListener
{
	
	Interface temp;
	public VMHandler(Interface x)
	{
		temp = x;
	}
	public VMHandler() {
		// TODO Auto-generated constructor stub
	}
	//performs something on display based on which button was pressed
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == temp.plusButton) 
		{
			temp.display.setText(temp.display.getText() + " + ");
		}
		else if(e.getSource() == temp.minusButton) 
		{
			temp.display.setText(temp.display.getText() + " - ");
		}
		else if(e.getSource() == temp.divisionButton) 
		{
			temp.display.setText(temp.display.getText() + " / ");
		}
		else if(e.getSource() == temp.zeroButton) 
		{
			temp.display.setText(temp.display.getText() + "0");
		}
		else if(e.getSource() == temp.oneButton) 
		{
			temp.display.setText(temp.display.getText() + "1");
		}
		else if(e.getSource() == temp.twoButton) 
		{
			temp.display.setText(temp.display.getText() + "2");
		}
		else if(e.getSource() == temp.threeButton) 
		{
			temp.display.setText(temp.display.getText() + "3");
		}
		else if(e.getSource() == temp.fourButton) 
		{
			temp.display.setText(temp.display.getText() + "4");
		}
		else if(e.getSource() == temp.fiveButton) 
		{
			temp.display.setText(temp.display.getText() + "5");
		}
		else if(e.getSource() == temp.sixButton) 
		{
			temp.display.setText(temp.display.getText() + "6");
		}
		else if(e.getSource() == temp.sevenButton) 
		{
			temp.display.setText(temp.display.getText() + "7");
		}
		else if(e.getSource() == temp.eightButton) 
		{
			temp.display.setText(temp.display.getText() + "8");
		}
		else if(e.getSource() == temp.nineButton) 
		{
			temp.display.setText(temp.display.getText() + "9");
		}
		else if(e.getSource() == temp.zerozeroButton) 
		{
			temp.display.setText(temp.display.getText() + "00");
		}
		else if(e.getSource() == temp.decimalButton) 
		{
			temp.display.setText(temp.display.getText() + ".");
		}
		else if(e.getSource() == temp.leftpButton) 
		{
			temp.display.setText(temp.display.getText() + "(");
		}
		else if(e.getSource() == temp.rightpButton) 
		{
			temp.display.setText(temp.display.getText() + ")");
		}
		else if(e.getSource() == temp.multiButton) 
		{
			temp.display.setText(temp.display.getText() + " * ");
		}
		else if(e.getSource() == temp.powButton) 
		{
			temp.display.setText(temp.display.getText() + " ^ ");
		}
		else if(e.getSource() == temp.clearButton) 
		{
			temp.display.setText("");
		}
		else if(e.getSource() == temp.equalButton) 
		{
			temp.display.setText("" + BigDecimal.valueOf(ERPN(CRPN(tokenizing(temp.display.getText())))).stripTrailingZeros().toPlainString());
		}
		
	}
	
	//Splits what is on the display into separate tokens
	ArrayList<String> tokenizing(String v)
	{
		ArrayList<String> t = new ArrayList<String>();
		Boolean c = false;
		for(String intermediate : v.split(" "))
		{
			if(intermediate.charAt(0) == '(')
			{
				if(c == true)
				{
					t.add("*");
					c = false;
				}
				t.add("(");
				intermediate = intermediate.replace("(", "");
			}
			else if(intermediate.indexOf(')') != -1)
			{
				t.add(")");
				intermediate = intermediate.replace(")", "");
			}
			
			if(Character.isDigit(intermediate.charAt(0)) || isDouble(intermediate))
			{
				c = true;
			}
			
			if(intermediate.charAt(0) == '0' && intermediate.charAt(intermediate.length() - 1) == '0')
			{
				intermediate = "0";
			}
			
			t.add(intermediate);
		}
		return t;
	}
	
	//Checks if char is a double
	Boolean isDouble(String x)
	{
		try
		{
			Double.parseDouble(x);
		}
		catch(NumberFormatException e) 
		{
			return false;
		}
		return true;
	}
	
	//Converts the tokens/ArrayList of String into Reverse Polish Notation
	Queue<String> CRPN(ArrayList<String> v)
	{
		Queue<String> out = new LinkedList<String>();
		Stack <operator> ops = new Stack<operator>();
		
		for(String x : v)
		{
			String temp = x;
			if (Character.isDigit(temp.charAt(0)))
			{
				out.add(temp);
			}
			else
			{
				operator o = new operator(temp);
				if (o.getOp() == "(")
				{
					ops.push(o);
				}

				else if (o.getOp() == ")")
				{
					while (ops.peek().getOp() != "(" && !ops.empty())
					{
						out.add(ops.peek().getOp());
						ops.pop();
						if (ops.empty())
						{
							break;
						}
					}
					if (ops.peek().getOp() == ")")
					{
						ops.pop();
					}
				}

				else
				{
					if (!ops.empty())
					{
						while (ops.peek().getPrec() >= o.getPrec() && o.getAssoc() == "Left" && ops.peek().getOp() != "(")
						{
							out.add(ops.peek().getOp());
							ops.pop();
							if (ops.empty())
							{
								break;
							}
						}
					}
					ops.push(o);
				}
			}
		}

		while (!ops.empty())
		{
			if (ops.peek().getOp() != "(")
			{
				out.add(ops.peek().getOp());
				ops.pop();
			}
			else
			{
				ops.pop();
			}
		}
		return out;
	}
	
	//Evaluates Reverse Polish Notation of the Queue of String
	Double ERPN(Queue<String> v)
	{
		Stack<Double> s = new Stack<Double>();
		Double right = (double) 0;
		Double left = (double) 0;
		int cd = 0;
		
		for (String x : v)
		{
			String temp = x;
			if (s.size() >= 2)
			{
				cd = 1;
				if (temp.equals("+"))
				{
					right = s.peek();
					s.pop();
					left = s.peek();
					s.pop();
					s.push(left + right);
				}
				else if (temp.equals("-"))
				{
					right = s.peek();
					s.pop();
					left = s.peek();
					s.pop();
					s.push(left - right);
				}
				else if (temp.equals("*"))
				{
					right = s.peek();
					s.pop();
					left = s.peek();
					s.pop();
					s.push(left * right);
				}
				else if (temp.equals("/"))
				{
					right = s.peek();
					s.pop();
					left = s.peek();
					s.pop();
					if(right == 0)
					{
						s.push(0.0);
					}
					else 
					{
						s.push(left / right);
					}
				}
				else if (temp.equals("^"))
				{
					right = s.peek();
					s.pop();
					left = s.peek();
					s.pop();
					s.push((double)Math.pow(left, right));
				}
			}
			else
			{
				if(!temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/") && !temp.equals("^"))
				{
					s.push(Double.parseDouble(temp));
				}
			}
		}

		if(cd == 0)
		{
			return 0.0;
		}
		
		
		if (s.size() == 0)
		{
			return 0.0;
		}
		
		return s.peek();
	}
	
	//Math operators can be created
	public class operator
	{
	private
		String op;
		int prec;
		String assoc;

	public
		operator(String in)
		{
			op = in;
			if (op == "+")
			{
				prec = 2;
				assoc = "Left";
			}
			else if (op == "-")
			{
				prec = 2;
				assoc = "Left";
			}
			else if (op == "*")
			{
				prec = 3;
				assoc = "Left";
			}
			else if (op == "/")
			{
				prec = 3;
				assoc = "Left";
			}
			else if (op == "^")
			{
				prec = 4;
				assoc = "Right";
			}
			else if (op == "_")
			{
				prec = 4;
				assoc = "Right";
			}
		}

		//Get operator in String
		String getOp()
		{
			return op;
		}

		//Get precedence of operator
		int getPrec()
		{
			return prec;
		}

		//Get Associativity of operator
		String getAssoc()
		{
			return assoc;
		}
	}
}
