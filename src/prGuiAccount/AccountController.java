package prGuiAccount;
/*********************************************************
 *    Controller
 *********************************************************/
import java.awt.event.*;

public class AccountController implements ActionListener 
{
	private AccountView accountView;
	private Account account;

	/**
	 * Constructor receives View and Model 
	 */
	public AccountController(AccountView av, Account a) 
	{
		accountView = av;
		account = a;
	}

	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand();
		accountView.printMessage(" ");
		try 
		{
			if (command.equals(AccountView.DEPOSIT)) 
			{
				double amount = accountView.getAmount();
				account.deposit(amount);
				accountView.setBalance(account.getBalance());
				accountView.printMessage(amount + "€ deposit done");
				accountView.clear();
			} 
			else if (command.equals(AccountView.WITHDRAW)) 
			{
				double amount = accountView.getAmount();
				double realAmount = account.withdraw(amount);
				accountView.setBalance(account.getBalance());
				if (amount != realAmount) 
				{
					accountView.printMessage("Withdraw limited to "
							+ String.format("%12.2f", realAmount) + "€");
				} 
				else 
				{
					accountView.printMessage(realAmount + "€ withdraw done");
				}
				accountView.clear();
			} 
			else if (command.equals(AccountView.BALANCE)) 
			{
				accountView.setBalance(account.getBalance());
				accountView.printMessage("Balance got");
			}
		} 
		catch (NumberFormatException e) 
		{
			accountView.printMessage("Wrong Number Format");
		}
	}
}
