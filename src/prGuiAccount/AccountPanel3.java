package prGuiAccount;
/*********************************************************
 *   Account View 3
 *********************************************************/
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AccountPanel3 extends JPanel implements ActionListener, AccountView 
{
	private JTextField amountJTF;
	private JButton depositJB;
	private JButton withdrawJB;
	private static final String DELETE = "Delete";
	private JTextArea messageJTA;
	private JLabel balanceJL;

	public AccountPanel3() 
	{
		amountJTF = new JTextField(10);
		amountJTF.setEditable(false);
		amountJTF.setHorizontalAlignment(JTextField.RIGHT);
		balanceJL = new JLabel(" ");
		balanceJL.setHorizontalAlignment(JLabel.RIGHT);
//		saldoJL.setOpaque(true);
//		saldoJL.setBackground(Color.ORANGE);
		depositJB = new JButton("DEPOSIT");
		withdrawJB = new JButton("WITHDRAW");

		// Building buttons
		JPanel buttomSet = new JPanel();
		buttomSet.setLayout(new GridLayout(4, 3, 1, 1));
		JButton[] botones = new JButton[10];
		for (int i = 1; i <= 9; i++) {
			botones[i] = new JButton(Integer.toString(i));
			botones[i].setActionCommand(Integer.toString(i));
			botones[i].addActionListener(this);
			buttomSet.add(botones[i]);
		}
		botones[0] = new JButton("0");
		botones[0].setActionCommand("0");
		botones[0].addActionListener(this);
		buttomSet.add(botones[0]);
		buttomSet.add(new JLabel(" "));
		JButton deleteJB = new JButton(DELETE);
		deleteJB.addActionListener(this);
		deleteJB.setActionCommand(DELETE);
		buttomSet.add(deleteJB);
		
		// Actions
		JPanel actions = new JPanel();
		actions.setLayout(new GridLayout(2, 1));
		actions.add(depositJB);
		actions.add(withdrawJB);

		
		// Left Panel 
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(amountJTF, BorderLayout.NORTH);
		leftPanel.add(buttomSet, BorderLayout.CENTER);
		leftPanel.add(actions, BorderLayout.EAST);
		
		// Right Panel 
		JPanel rightPanel = new JPanel();
		messageJTA = new JTextArea(10,20);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(new JScrollPane(messageJTA), BorderLayout.CENTER);
		rightPanel.add(balanceJL, BorderLayout.NORTH);

		// Main Panel
		setLayout(new GridLayout(2,1));
		add(leftPanel);
		add(rightPanel);
	}

	public void controller(ActionListener ctr) 
	{
		depositJB.addActionListener(ctr);
		depositJB.setActionCommand(DEPOSIT);
		withdrawJB.addActionListener(ctr);
		withdrawJB.setActionCommand(WITHDRAW);
	}

	public double getAmount() 
	{
		return Double.parseDouble(amountJTF.getText());
	}

	public void setBalance(double amount) 
	{
		balanceJL.setText(String.format("Balance: %12.2f", amount));
	}

	public void printMessage(String msg) 
	{
		messageJTA.append(msg+"\n");
	}

	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// deleting numbers
		if (comando.equals(DELETE)) 
		{
					amountJTF.setText("");
		} 
		else 
		{
			int i = Integer.parseInt(comando);
			amountJTF.setText(Integer.toString(i
							+ 10
							* Integer.parseInt(amountJTF.getText()
									.equals("") ? "0" : amountJTF
									.getText())));
		}
	}
	
	public void clear() 
	{
		amountJTF.setText("");
	}
}
