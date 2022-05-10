package bank_Management;
import java.util.*;
public class withdrawal_Amount 
{
 protected static void  ReduceAmount(Long id,int amount)
 {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter your Password ");
	 String str=sc.nextLine();
	 if(AccountCreation.getAuthenticated(id,str))
	 {
	 if((AccountCreation.mp.get(id).getBalance()-AccountCreation.MINBALANCE)>=amount) 
	 {
	 int originalamount=AccountCreation.mp.get(id).getBalance()-amount;
	 AccountCreation.mp.get(id).setBalance(originalamount);
	 System.out.println("Amount was withdrawan from Account: "+AccountCreation.mp.get(id).AccountId);
	 }
	 else
	 {
		 System.out.println("You don't have an suffient balance");
	 }
	 }
	 else
		 System.out.println("Password Was Incorrect");
 }
}
