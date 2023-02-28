package org.example;
import java.util.logging.Logger;
class BankAccount
{
    public static final Logger LOGGER =  Logger.getLogger("InfoLogging");
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
        String print="\nHolderName:"+name+"\nAccountNumber:"+accountNumber+"\nBalance:"+balance+"0\n";
        LOGGER.info(print);
    }
    public void deposite(int amount)
    {
        balance+=amount;
        String print="\nDeposite of Amount Rs "+amount+".00 is Successfully\n";
        LOGGER.info(print);
    }
    public void withdraw(int amount)
    {
        if(balance-amount>=100)
        {
            balance-=amount;
            String print="\nWithdraw of Amount Rs:"+amount+".00 is Successfully\n";
            LOGGER.info(print);
        }
        else
            LOGGER.info("\nWithdrawal Limit Above Rs:100");
    }

}
