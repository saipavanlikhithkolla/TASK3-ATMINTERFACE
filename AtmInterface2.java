import java.util.*;
class Atm
{
    private double balance=10000.0;
    private double deposit;
    private double withdrawal;
    public double getbalance()
    {
        return balance;
    }
    public void setbalance(double balance)
    {
        this.balance=balance;
    }
    public double deposit()
    {
        return deposit;
    }
    public void setdeposit(double deposit)
    {
        this.deposit=deposit;
    }
    public double withdrawal()
    {
        return withdrawal;
    }
    public void setwithdrawal(double withdrawal)
    {
        this.withdrawal=withdrawal;
    }
}
interface AtmInterface
{
    public void viewbalance();
    public void withdrawMoney(double withdrawal);
    public void depositMoney(double deposit);
    public void transactions();
    public void transfer(double amount,AtmInterface customer2);
}
class AtmTask implements AtmInterface
{
    Atm sc=new  Atm();
    Map<Double,String>trans=new HashMap<>();
    public void viewbalance()
    {
        System.out.println("\nBalance available: "+sc.getbalance());
    }
    public void withdrawMoney(double withdrawal)
    {
        if(withdrawal<=sc.getbalance())
        {
            trans.put(withdrawal," Amount has been Withdrawn");
			sc.setbalance(sc.getbalance()-withdrawal);
			viewbalance();
        }
        else
		{
			System.out.println("\nYour transaction can't be done due to low balance !!");
		}
    }
    public void depositMoney(double deposit)
    {
        System.out.println("\n");
		trans.put(deposit," Amount Deposited");
		System.out.println(deposit+" Deposited Successfully !!");
		sc.setbalance(sc.getbalance()+deposit); 
		viewbalance();
    }
    public void transactions()
    {
        for(Map.Entry<Double,String>m: trans.entrySet())
        {
            System.out.println(m.getValue()+":"+m.getKey());
        }
    }
    public void transfer(double amount,AtmInterface customer2)
    {
        System.out.println("Transfered account details:");
        customer2.depositMoney(amount);
        System.out.println("Your Account details:");
        withdrawMoney(amount);
        System.out.println(amount+"has been transfered successfully");
    }
}
class AtmInterface2
{
    public static void main(String[] args)
    {
        AtmInterface customer=new AtmTask();
        AtmInterface customer1=new AtmTask();
        int number1=1122334455;
        int pin1=1798;
        Scanner s=new Scanner(System.in);
        System.out.println("\nWelcome!");
        System.out.println("\nEnter your Atm number:");
        int number=s.nextInt();
        System.out.println("\nEnter your pin number:");
        int pin=s.nextInt();
        if((number==number1)&&(pin==pin1))
        {
            while(true)
            {
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.print("\n1.View Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View transactions history\n5.Transfer to account\n6.Exit");
                System.out.println("\n");
                System.out.println("\nEnter Choice :");
                int ch=s.nextInt();
                if(ch==1)
                {
                    customer.viewbalance();
                }
                else if(ch==2)
                {
                    System.out.println("\nEnter amount to withdraw :");
                    double withdraw=s.nextDouble();
                    customer.withdrawMoney(withdraw); 
                }
                else if(ch==3)
                {
			        System.out.println("Enter Amount to Deposit :");
			        double deposit=s.nextDouble();
			        customer.depositMoney(deposit);
                }
                else if(ch==4)
		        {
			        customer.transactions();
		        }
                else if(ch==5)
		        {
			        System.out.println("\nEnter the account number you want to transfer money ");
			        int accno=s.nextInt();
			        System.out.println("\nEnter the amount you want to transfer :");
			        int amount=s.nextInt();
			        customer.transfer(amount,customer1);
				}
		        else if(ch==6)
		        {
			        System.out.println("\nRemove your ATM Card\nThank You for using ATM Machine !!\n Have a good day");
			        break;
		        }
		        else
		        {
			        System.out.println("Please enter correct choice");
		        }
            }
        }
        else
        {
            System.out.println("OOPS! INCORRECT PLEASE VERIFY");
        }
    }
}