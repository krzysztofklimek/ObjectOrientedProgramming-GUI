package prGuiAccount;
/*********************************************************
 * 	Account View 1
 *********************************************************/
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AccountPanel1 extends JPanel implements AccountView 
{
	private JTextField amountJTF;
	private JLabel balanceJL;
	private JLabel messageJL;
	private JButton depositJB;
	private JButton withdrawJB;
	private JButton balanceJB;

	public AccountPanel1() {
		// basic component creation
		amountJTF = new JTextField(10);
		balanceJL = new JLabel(" ");
		messageJL = new JLabel(" ");
		depositJB = new JButton("DEPOSIT");
		withdrawJB = new JButton("WITHDRAW");
		balanceJB = new JButton("BALANCE");
		//  Central Panel
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new GridLayout(2, 2));
		centralPanel.add(new JLabel("Amount"));
		centralPanel.add(amountJTF);
		centralPanel.add(new JLabel("Balance"));
		centralPanel.add(balanceJL);
		// Right Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3, 1));
		rightPanel.add(depositJB);
		rightPanel.add(withdrawJB);
		rightPanel.add(balanceJB);
		// Building main panel
		setLayout(new BorderLayout());
		add(centralPanel, BorderLayout.CENTER);
		add(rightPanel, BorderLayout.EAST);
		add(messageJL, BorderLayout.SOUTH);
	}

	public void controller(ActionListener ctr) 
	{
		depositJB.addActionListener(ctr);
		depositJB.setActionCommand(DEPOSIT);
		withdrawJB.addActionListener(ctr);
		withdrawJB.setActionCommand(WITHDRAW);
		balanceJB.addActionListener(ctr);
		balanceJB.setActionCommand(BALANCE);
	}

	public double getAmount() 
	{
		return Double.parseDouble(amountJTF.getText());
	}

	public void setBalance(double cantidad) 
	{
		balanceJL.setText(String.format("%12.2f", cantidad));
	}

	public void printMessage(String msg) 
	{
		messageJL.setText(msg);
	}
	
	public void clear() 
	{
		amountJTF.setText("");
	}

}
