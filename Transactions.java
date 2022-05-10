package bank_Management;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Map;
public class Transactions 
{
	protected static void performTransaction(Long id)
	{
		try 
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Account to tranfer");
		AccountCreation obj=AccountCreation.mp.get(id);
		long transferId=Long.parseLong(br.readLine());
		  boolean available=false;
  	     for(Map.Entry<Long,AccountCreation>obj1:AccountCreation.mp.entrySet())      
		  {
  	    	  if(obj1.getKey()==transferId)
                {
  	    		  available=true;
	            }
  	      }
   	      if(!(available))
   	      {
   	    	  System.out.println("Given Account is not Available");
   	    	  return;
   	      }	 
   	      else 
   	      {
   	    	System.out.println("Enter the Amount to transfer");
			int amount=Integer.parseInt(br.readLine());
			if(AccountCreation.mp.get(id).getBalance()>=amount) {
			withdrawal_Amount.ReduceAmount(id, amount);
			Deposit_Amount.UpdateAmount(transferId, amount);
			}
			else
				System.out.println("You Don't have sufficient amount to transfer");
		  }
		}
		catch(IOException  e)
		{
		  System.out.println("Enter Correct Account Value");
		}
	}
}
