package bank_Management;
import java.io.*;
import java.util.regex.*;
import java.util.*;
 class AccountCreation {
	protected long AccountId;
	private int balance;
	private String Name;
    final int MINBALANCE=1000;
    protected static Map<Long,AccountCreation> mp=new HashMap<>();
    private String acctype;
    private String password;
    enum Accounttype
    {
    	CUURENT_ACCOUNT,
    	SALARY_ACCOUNT,
    	FIXEDDEPOSIT_ACCOUNT,
    	RECURRING_ACCOUNT,
    	NRI_ACCOUNT
    }
    void setId(Long s)
    {
    	this.AccountId=s;
    }
    Long getId()
    {
    	return AccountId;
    }
    void setpassword(String name) {
    	this.password=name;
    }
    String getpassword()
    {
    	return password;
    }
    void setBalance(int s)
    {
    	this.balance=s;
    }
    int getBalance()
    {
    	return balance;
    }
    void setName(String name)
    {
    	this.Name=name;
    }
    String getName()
    {
    	return Name;
    }
    void setAccountType(String s)
    {
    	this.acctype=s;
    }
    String getAccountType()
    {
    	return acctype;
    }
    protected static boolean getAuthenticated(Long id,String str)
    {
    	if(str.equals(mp.get(id).getpassword()))
    	{
    		return true;
    	}
    	else
    		return false;
    }
    public void CreateAccount() throws IOException, InterruptedException
    {
    	AccountCreation obj=new AccountCreation();
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	Thread.sleep(100);
    	long id=System.currentTimeMillis();
    	obj.setId(id);
    	System.out.println("Choose account type");
    	System.out.println("1.CUURENT_ACCOUNT,\n"
    			+ "2.SALARY_ACCOUNT,\n"
    			+ "3.FIXEDDEPOSIT_ACCOUNT,\n"
    			+ "4.RECURRING_ACCOUNT,\n"
    			+ "5.NRI_ACCOUNT\n"
    			+ "    ");
         String str=br.readLine();
    	for (Accounttype type:Accounttype.values()) { 
    	    if(type.toString().equalsIgnoreCase(str))
    	    obj.setAccountType(type.toString());
    	}
    	//obj.setAccountType(Accounttype.valueOf(str).toString());
    	//Console con=System.console();
    	System.out.println("Enter your Name");
    	String name=br.readLine();
    	obj.setName(name);
    	System.out.println("Enter The password For your Account.Password should contains Uppercase Lowercase Alphanumberic");;
    	String passstr=br.readLine();
    	Pattern pattern =  Pattern.compile("^(?=.*[0-9])\"\n"
    			+ "        + \"(?=.*[a-z])(?=.*[A-Z])\"\n"
    			+ "        + \"(?=.*[@#$%^&+=])\"\n"
    			+ "        + \"(?=\\\\S+$).{8,20}$");
        Matcher mtch = pattern.matcher(passstr);
        boolean istrue=true;
        while(istrue) 
        {
        if(!(mtch.matches())&&(passstr.length()<=8))
        {
        	System.out.println("Password should contains upppercase,lowercase,Alphanumberic,length should greater than 8");
            istrue=true;
            passstr=br.readLine();
        }
        else
        {
        	System.out.println("Reenter the password");
        	String reenterpass=br.readLine();
        	if(reenterpass.equals(passstr)) 
        	{
        		obj.setpassword(passstr);
        		System.out.println("Password Created");
        	    istrue=false;
        	}
        	else 
        	{
        		System.out.println("Password Mismatch");
        	    istrue=true;
        	}
        }
        }
    	System.out.println("Enter the first deposit Amount.Minimum balance should be 2000");
    	int amount=Integer.parseInt(br.readLine());
    	while(amount<=MINBALANCE)
    	{
    		System.out.println("Please enter the Amount above 2000");
    		amount=Integer.parseInt(br.readLine());
    	}
    	obj.setBalance(amount);
    	mp.put(obj.getId(), obj); 	
    	 System.out.println("Account Created Successfully with id-"+obj.getId());	
    }
}
