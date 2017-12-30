import bank.kotak.account.Account;




public class TestAccount {

	public static void main(String[] args) 
	{
	Account acc=new Account(111,"Vaishali",50000);
	
	acc.withdraw(500);
	System.out.println(" Account Details  :"+acc);
	}

}
