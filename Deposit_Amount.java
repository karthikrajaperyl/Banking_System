package bank_Management;

import java.util.Scanner;

class Deposit_Amount {
	protected static void  UpdateAmount(Long id,int amount)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter your Password ");
		 String str=sc.nextLine();
		
		
		 int updatedamount=AccountCreation.mp.get(id).getBalance()+amount;
		 AccountCreation.mp.get(id).setBalance(updatedamount);
		 System.out.println("Amount was Deposited to Account "+AccountCreation.mp.get(id).AccountId);
	 
	}
}
