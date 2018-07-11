package prGuiAccount;
/*********************************************************
 *   View Interface
 *********************************************************/
import java.awt.event.*;

public interface AccountView 
{
	String DEPOSIT = "DEPOSIT";
	String WITHDRAW = "WITHDRAW";
	String BALANCE = "BALANCE";

	double getAmount();
	void setBalance(double saldo);
	void printMessage(String msg);
	void clear();
	void controller(ActionListener ctr);
}
