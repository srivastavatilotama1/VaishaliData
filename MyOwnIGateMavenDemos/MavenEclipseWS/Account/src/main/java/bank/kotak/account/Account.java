package bank.kotak.account;

public class Account 
{
	
	int accountId;
	String custName;
	int balance;
	public Account(int accountId, String custName, int balance) {
		super();
		this.accountId = accountId;
		this.custName = custName;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", custName=" + custName
				+ ", balance=" + balance + "]";
	}
	
	
	public void withdraw(int withdrawAmt)

	{
		
		balance=balance-withdrawAmt;
	}
	
	public void deposite(int depositeAmt)

	{
		
		balance=balance+depositeAmt;
	}
}
