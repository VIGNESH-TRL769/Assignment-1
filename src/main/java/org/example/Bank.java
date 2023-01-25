package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class BankAccount
{
    private static final Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final String name;
    private final Long accountNumber;
    Double balance=0.0D;
    public BankAccount(String name,Long accountNumber)
    {
        this.name=name;
        this.accountNumber=accountNumber;
    }
    public void getAccountDetails()
    {
        LOGGER.log(Level.INFO,Double.toString(accountNumber),"\nAccountNumber:"+accountNumber);
        LOGGER.log(Level.INFO,Double.toString(balance),"\nBalance:"+balance+"0\n");
    }
    public void deposite(int amount)
    {
        balance+=amount;
        LOGGER.log(Level.INFO,Double.toString(amount),"\nDeposite of Amount Rs "+amount+".00 is Successfully\n");
    }
    public void withdraw(int amount)
    {
        if(balance-amount>=100)
        {
            balance-=amount;
            LOGGER.log(Level.INFO,Double.toString(amount),"\nWithdraw of Amount Rs:"+amount+".00 is Successfully\n");
        }
        else
            LOGGER.log(Level.INFO,"\nWithdrawal Limit Above Rs:100");
    }

}


public class Bank {
    private static final Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        LOGGER.log(Level.INFO,"\nEnter the HolderName:");
        String name=input.nextLine();
        LOGGER.log(Level.INFO,"\nEnter the AccountNumber:");
        long accountNumber=input.nextLong();
        BankAccount bankAccount=new BankAccount(name,accountNumber);

        while(true)
        {
            LOGGER.log(Level.INFO,"\n1.deposite\n2.withdraw\n3.balance\n4.Exit\n");
            LOGGER.log(Level.INFO,"\nEnter the Choice:");
            int value=input.nextInt();
            int temp1=0;
            switch (value) {
                case 1 -> {
                    LOGGER.log(Level.INFO,"\nEnter the deposite Amount:");
                    int depositeAmount = input.nextInt();
                    bankAccount.deposite(depositeAmount);
                }
                case 2 -> {
                    LOGGER.log(Level.INFO,"\nEnter the withdraw Amount:");
                    int withdrawAmount = input.nextInt();
                    if (bankAccount.balance >= 100)
                        bankAccount.withdraw(withdrawAmount);
                    else
                        LOGGER.log(Level.INFO,Double.toString(bankAccount.balance),"\nMinimum Balance Should be Rs:100 You having Balance Amount="+bankAccount.balance+"0 ");
                }
                case 3 -> bankAccount.getAccountDetails();
                case 4 -> temp1 = 1;
                default -> LOGGER.log(Level.INFO,"\nInvalid Choice Tryagin\n");
            }
            if(temp1==1)
            {
                LOGGER.log(Level.INFO,"\n------Thank You------");
                return;
            }


        }

    }
}
