/*Developer: Isha Das 
  The primary purpose of the BankAccount Class is to keep track of the balance in the bank and keep track of fees
  and charges if certain specfications are not maintained by the user.*/

public class BankAccount extends Object
{
  //this field stores the balance that is currently in the bank account
  private double currentBalance;
  
  //this field stores the minimum balance allowed on the bank account
  private int minBalance;
  
  //this field stores the interest rate of the bank account
  private double interestRate;
  
  //this field stores the ATM Fee of the bank account
  private double atmFee;
  
  //this field stores the overdraft fee on the bank account
  private double overDraftFee;
  
  //this field stores the bounced check fee on the bank account
  private double bouncedCheckFee;
  
  //this field stores the withdraw fee that is on the bank account
  private double withdrawFee;
  
  //this field stores the withdraw limit on the bank account
  private int withdrawLimit;
  
  //this field is set to true when the bank account is allowed unlimited number of withdraw limits without any fee on the bank account
  private boolean unlimitedAccount;
  
  //this field stores the withdraw count associated with bank account
  private int monthWithdrawCount;
  
  //this field stores the total earned interest earned so far this month on the bank account
  private double interestEarned;
  
  //this field is set to  true if the over draft fee has been charged on the bank account
  private boolean overdraftFlag;
  
  /*These are all the user-defined constants to set the default value in the BankAccount constructor. 
   *This can be used to configure the deafult values for the bank account.*/
  private final double CURRENT_BLALANCE = 0.0;
  private final int MIN_BLALANCE = 10;
  private final double INTEREST_RATE = 2.1;
  private final double ATM_FEE = 5.0;
  private final double OVERDRAFT_FEE = 10.0;
  private final double BOUNCEDCHECK_FEE = 30.0;
  private final double WITHDRAW_FEE = 20.0;
  private final int WITHDRAW_LIMIT = 4;
  private final boolean UNLIMITED_ACCOUNT = false;
  private final int MONTH_WITHDRAW_COUNT = 0;
  private final double INTEREST_EARNED = 0.0;
  private final boolean OVERDRAFT_FLAG = false;
  
  //A generic constructor that makes a bank account and allows acess all the fields set to their default user-defined constants.
  public BankAccount()
  {
    this.currentBalance = CURRENT_BLALANCE;
    this.minBalance = MIN_BLALANCE;
    this.interestRate = INTEREST_RATE;
    this.atmFee = ATM_FEE;
    this.overDraftFee = OVERDRAFT_FEE;
    this.bouncedCheckFee = BOUNCEDCHECK_FEE;
    this.withdrawFee = WITHDRAW_FEE;
    this.withdrawLimit = WITHDRAW_LIMIT;
    this.unlimitedAccount = UNLIMITED_ACCOUNT;
    this.monthWithdrawCount = MONTH_WITHDRAW_COUNT;
    this.interestEarned = INTEREST_EARNED; 
    this.overdraftFlag = OVERDRAFT_FLAG;
  }
  
  //A constructor to make a bank account with the given interest rate, minimum balance, overdraft fee, atm fee,and bounced check fee.
  public BankAccount(double interestRate, int minBalance, double overdraftFee, double atmFee, double bouncedCheckFee)
  {
    this.setInterestRate(interestRate);
    this.setMinimumBalance(minBalance);
    this.setOverDraftFee(overdraftFee);
    this.setATMFee(atmFee);
    this.setBouncedCheckFee(bouncedCheckFee);
  }
  
  //A method to get the balance of the bank account
  public double getBalance() 
  {
    return this.currentBalance;   
  }
  
  //A method to get the interest rate of the bank account
  public double getInterestRate()
  {
    return this.interestRate;
  }
    
  //A method to set the interest rate of the bank account
  public void setInterestRate(double interestRate)
  {
    this.interestRate = interestRate;
  }
  
  //A method to get the minimum balance of the bank account
  public int getMinimumBalance()
  {
    return this.minBalance;
  }
  
  //A method to set the minimum balance of the bank account.
  public void setMinimumBalance(int minBalance)
  {
    this.minBalance = minBalance;
  }
  
  //A method to get the ATM fee of the bank account.
  public double getATMFee()
  {
    return this.atmFee;
  }
  
  //A method to set the ATM fee of the bank account.
  public void setATMFee(double atmFee)
  {
    this.atmFee = atmFee;
  }
  
  //A method to get the overdraft fee of the bank account.
  public double getOverDraftFee()
  {
    return this.overDraftFee;
  }
  
  //A method to set the overdraft fee of the bank account.
  public void setOverDraftFee(double overDraftFee)
  {
    this.overDraftFee = overDraftFee;
  }  
  
  //A method to get the bounced check fee of the bank account.
  public double getBouncedCheckFee()
  {
    return this.bouncedCheckFee;
  }
  
  //A method to set the bounced check fee of the bank account.
  public void setBouncedCheckFee(double bouncedCheckFee)
  {
    this.bouncedCheckFee = bouncedCheckFee;
  }
  
  //A method to get the withdraw fee of the bank account.
  public double getWithdrawFee()
  {
    return this.withdrawFee;
  }
  
  //A method to set the withdraw fee of the bank account.
  public void setWithdrawFee(double withdrawFee)
  {
    this.withdrawFee = withdrawFee;
  }
  
  //A method to get the withdraw limit of the bank account.
  public int getWithdrawLimit()
  {
    return this.withdrawLimit;
  }
  
  //A method to set the withdraw limit of the bank account.The limit is set to 0 if the account allows an unlimited number of withdraws.
  //Otherwise, the limit is the maximum number of free withdrawals allowed per month.
  public void setWithdrawLimit(int withdrawLimit)
  {
    if(this.unlimitedAccount)
    {
      this.withdrawLimit = 0;
    }
    else
    {
      this.withdrawLimit = withdrawLimit;
    }
  }
  
  // Takes a single double as input and adds this value to the account's balance. There is no return value.
  public void deposit(double depositValue)
  {
    this.currentBalance += depositValue;
  }
  
  /*Takes a single double as input. If the current balance is greater or equal to the input amount, 
  then method returns true after the balance is reduced by this amount, the total number of withdrawals
  for the month is incremented, and the withdraw fee is applied (if the total number of withdrawals exceeds
  the limit). Otherwise, the method returns false and nothing is removed from the account's balance. */
  
  // #### If after the withdraw and the withdrawls exceeds the limit, the balance is less than the withdraw fee, can we have theaccount balance nagative after charging fee 
  
  public boolean withdraw(double withdrawAmount)
  {
    if(this.getBalance() >= withdrawAmount)
    {
      this.currentBalance -= withdrawAmount;
      this.monthWithdrawCount++;
      if((this.monthWithdrawCount > this.getWithdrawLimit()) && (this.getWithdrawLimit() != 0))
      {
        this.currentBalance -= this.getWithdrawFee();
      }
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean withdrawDraft(double withdrawAmount)
  {
    if(this.getBalance() >= withdrawAmount)
    {
      this.currentBalance -= withdrawAmount;
      this.monthWithdrawCount++;
      if((this.monthWithdrawCount > this.getWithdrawLimit()) && (this.getWithdrawLimit() != 0))
      {
        this.currentBalance -= this.getWithdrawFee();
      }
      return true;
    }
    else
    {
      this.currentBalance -= this.getBouncedCheckFee();
      return false;
    }
  }

  
  
  public boolean withdrawATM(double withdrawAmount)
  {
    //this calculates the sum of the aroumt withdrawn and the 
    double totalWithdrawAmount = withdrawAmount + this.getATMFee();
    return this.withdraw(totalWithdrawAmount);
  }
  
  
  public void incrementDay()
  {
    if((this.getBalance() < (double)this.getMinimumBalance()) && (this.overdraftFlag == false))
    {
      this.currentBalance -= this.getOverDraftFee();
      this.overdraftFlag = true;
    }
    else if((this.getBalance() < (double)this.getMinimumBalance()) && (this.overdraftFlag == true))
    {
      //if the overdraft flag is true then do nothing
    }
    else
    {
      //interestEarnedBalance is the sum of balance plus the interest earned so far
      double interestEarnedBalance = this.getBalance() + this.interestEarned;
      this.interestEarned = this.interestEarned + ((interestEarnedBalance*this.getInterestRate()/100.0)/365.0);
    }
  }

  
  public void incrementMonth()
  {
    this.currentBalance += this.interestEarned;
    this.interestEarned = 0.0;
    this.overdraftFlag = false;
  }
  
}
