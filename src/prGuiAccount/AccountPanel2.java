package prGuiAccount;
/*********************************************************
 *   Account View 2
 *********************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AccountPanel2 extends JPanel implements AccountView 
{
	private JTextField amountJTF;
	private JLabel balanceJL;
	private JLabel messageJL;
	private JButton depositJB;
	private JButton withdrawJB;

	public AccountPanel2() 
	{
		amountJTF = new JTextField(10);
		amountJTF.setHorizontalAlignment(JTextField.RIGHT);
		balanceJL = new JLabel(" ");
		balanceJL.setHorizontalAlignment(SwingConstants.CENTER);
		messageJL = new JLabel(" ");
		depositJB = new JButton("DEPOSIT");
		withdrawJB = new JButton("WITHDRAW");

		JPanel actions = new JPanel();
		actions.setLayout(new GridLayout(1,3));
		actions.add(depositJB);
		actions.add(withdrawJB);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1));
		leftPanel.add(amountJTF);
		leftPanel.add(actions);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(balanceJL, BorderLayout.CENTER);
		rightPanel.add(messageJL, BorderLayout.SOUTH);
		
		setLayout(new GridLayout(1, 2));
		add(leftPanel);
		add(rightPanel);
	}

	public void controller(ActionListener ctr) 
	{
		depositJB.addActionListener(ctr);
		depositJB.setActionCommand(DEPOSIT);
		withdrawJB.addActionListener(ctr);
		withdrawJB.setActionCommand(WITHDRAW);
		amountJTF.addActionListener(ctr);
		amountJTF.setActionCommand(DEPOSIT);
	}

	public double getAmount() 
	{
		return Double.parseDouble(amountJTF.getText());
	}

	public void setBalance(double cantidad) 
	{
		balanceJL.setText(String.format("Balance: %12.2f", cantidad));
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
