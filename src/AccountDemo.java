import java.awt.event.ActionListener;
import javax.swing.*;

import prGuiAccount.*;

public class AccountDemo {
	public static void main(String[] args) 
	{
		// We are using the MVC pattern
		// Creating the View 
		int idPanel=1;
		AccountView accountView;
		
		try
		{
			idPanel = Integer.parseInt(args[0]);
		}
		catch (Exception ex){ /* ignore */}
		
		switch(idPanel)
		{
			case 2:  accountView = new AccountPanel2(); break;
			case 3:  accountView = new AccountPanel3(); break;
			default: accountView = new AccountPanel1(); break;
		}

		// Create the Model
		Account account = new Account(0);
		// create controller
		ActionListener accountCtrl = new AccountController(accountView, account);
		// set controller to the view
		accountView.controller(accountCtrl);

		// Create main windows
		JFrame ventana = new JFrame("Account Manager");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) accountView);
		ventana.pack();
		ventana.setVisible(true);
	}
}
