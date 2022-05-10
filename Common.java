package bank_Management;
import java.util.*;
public class Common {
	static List<AccountCreation> Accobj=new ArrayList<>();
	public static void main(String[] args) 
	{
      int n;
      Scanner sc=new Scanner(System.in);
      try
      { 
        boolean con=true;
        while(con) 
    	{
         try 
    	 {
    	 System.out.println("\n....ENTER YOUR CHOICE...\n1.Create An Account\n2.Login\n3.exit");
    	 n=sc.nextInt();
    	 }
    	 catch(InputMismatchException e)
    	 {
    		 System.out.println("Please enter the valid input");
    		 continue;
    	 }
    	 switch(n) 
    	 {
             case 1:
             
    		 AccountCreation acc=new AccountCreation();
    		 acc.CreateAccount();
            // for(Map.Entry<Long,AccountCreation> mp:AccountCreation.mp.entrySet()) 
             //{
             Accobj.add(acc);
    		 break;
             
             
    	     case 2:
    	     {
    	      System.out.println("Enter your AccountId"); 	 
    	      long accid=sc.nextLong();
    	      boolean available=false,con2=true;
    	      while(con2) 
    	     {
    	      System.out.println("1.Bank Withdrawal \\n2.Bank Deposit \\n3.Transaction \\n4.View Account Balance \\n5.Delete an Account\\n6.Exit");
    	      int sn=sc.nextInt();
    	      switch(sn)
    	      {
    	      case 1:
    	    	  for(Map.Entry<Long,AccountCreation> mp:AccountCreation.mp.entrySet()) 
        	      {
    	    		 
    	    		  if(mp.getKey()==accid)
                      {
        	    		  System.out.println("Enter the Amount");
        	    		  int amount=sc.nextInt();
        	    		  withdrawal_Amount.ReduceAmount(mp.getKey(), amount);
                    	  available=true;
    	              }
        	      }
    	    	  break;
    	      case 2:  	  
    	      for(Map.Entry<Long,AccountCreation> mp:AccountCreation.mp.entrySet()) 
    	      {
    	    	  if(mp.getKey()==accid) 
    	    	  {
    	    	   System.out.println("Enter the Amount");
   	    		   int amount=sc.nextInt();
   	    		   Deposit_Amount.UpdateAmount(mp.getKey(),amount);
               	   available=true;
    	    	  }
	              }
    	      break;
    	      case 3:
    	    	  
    	    	  for(Map.Entry<Long,AccountCreation> mp:AccountCreation.mp.entrySet()) 
      	          {
      	    	    if(mp.getKey()==accid)
                    {
          	    		available=true;
          	    		Transactions.performTransaction(mp.getKey());
          	    	}
          	      }
          	      if(!(available))
          	      {
          	    	  System.out.println("Given Account is not Available");
          	      }
    	    	  break;
    	      case 4:
    	    	  int balance=AccountCreation.mp.get(accid).getBalance();
    	          System.out.println("Your Account Balance "+balance);
    	          available=true;
    	          break;
    	      case 5:
    	    	  for(Map.Entry<Long,AccountCreation> mp:AccountCreation.mp.entrySet()) 
           	      {
           	    	  if(mp.getKey()==accid)
                         {
             	    	  mp.getKey();	
           	    		  available=true;
             	    		System.gc();
             	    	 }
             	  }
    	    	  break;
    	      case 6:
    	           System.out.println("Logging Out");
    	           con2=false;
    	           break;
    	 
    	      default:
    	    	  System.out.println("Enter the valid input");
    	      }  
    	      if(!(available))
    	      {
    	    	  System.out.println("Given Account is not Available");
    	      }
    	     }
    	      break;
    	     }
    	        case 3:
    	     {
    	    	 con=false;
    	    	 System.gc();
    	    	 break;
    	     }
    	     default: System.out.println("Enter the Valid Input");
    	 }
    	}
    
   	 System.out.println("Program Terminating");
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     finally{
    	System.gc();
     } 
	}

}
