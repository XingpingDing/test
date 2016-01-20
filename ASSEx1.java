import javax.swing.*;

/**
 * ASSEx1
 *
 * @author XINGPING DING
 * 
 */
public class ASSEx1 {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] arg) {
		// Get the customer name
		String customerName = getCustomerName();
		
		// Get the starting balance
		double startingBalance = getStartingBalance();
		
		// Create the customer account
		CustomerAccount customerAccount = new CustomerAccount(customerName, startingBalance);
		
		// Create LWMGUI with customer account
		new LWMGUI(customerAccount);
	}
	
    /**
     * Get the customer name
     *
     * @Title: getCustomerName
     * @return
     */
	public static String getCustomerName() {
		String customerName = JOptionPane.showInputDialog(null, "Input customer name", "Input", JOptionPane.PLAIN_MESSAGE);
		
		// If the customer name is null or empty, the program terminates. 
		if (customerName == null || customerName.equals("")) {
			System.exit(0);
		}
		
		return customerName;
	}
	
    /**
     * Get the starting balance
     *
     * @Title: getStartingBalance
     * @return
     */
	public static double getStartingBalance() {
		double startingBalance = 0;
		
		// Loop until entering a non-empty and numerical string,
		// unless the program terminates due to the dialog box being closed or cancelled.
		for(;;) {
			String startingBalanceString = JOptionPane.showInputDialog(null, "Input starting balance", "Input", JOptionPane.PLAIN_MESSAGE);
			
			// If the starting balance is null or empty, the program terminates. 
			if (startingBalanceString == null || startingBalanceString.equals("")) {
				System.exit(0);
			}
			
			// If the starting balance is numerical, jump out the loop.
			// Otherwise, an error message is displayed and a input dialog box reappear.
			try {
				startingBalance = Double.parseDouble(startingBalanceString);
				break;
			}
			catch (NumberFormatException x) {
				JOptionPane.showMessageDialog(null, "Non-numerical input. Please input again!", "ERROR", JOptionPane.ERROR_MESSAGE); 
			}
		}
		
		return startingBalance;
	}
}
