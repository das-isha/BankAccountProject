/*Developer: Isha Das 
  The primary purpose of the Account Class is to keep track of account holders personal information and various bank 
  and credit card accounts.It also provides ways to apply daily and monthly processes on varous accounts */

public class Account extends Object
{
  //this field stores the first name
  private String firstName;
  
  //this field stores the last name
  private String lastName;
  
  //this field stores the street address
  private String streetAddress;
  
  //this field stores the zip code
  private String zipCode;
  
  //this field stores the date
  private Date date;
  
  //This field stores the savings account
  private BankAccount savingsAccount;
  
  //This field stores the checking account
  private BankAccount checkingAccount;
  
  //This field stores the money market account
  private BankAccount moneyMarketAccount;
  
  //This field stores the credit card account
  private CreditCardAccount creditCardAccount;
  
  //A constructor that creates an account with first name, last name,street address, zip code and date 
  public Account(String firstName, String lastName, String streetAddress, String zipCode, Date date)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.zipCode = zipCode;
    this.date = date;
  }
  
  //this method gets the first name in the account
  public String getFirstName() 
  {
    return this.firstName;
  }
  
  //this method sets the first name in the account
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  //this method gets the last name in the account
  public String getLastName() 
  {
    return this.lastName;
  }
  
  //this method sets the name in the account
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  
  //this method gets the street address in the account
  public String getStreetAddress() 
  {
    return this.streetAddress;
  }
  
  //this method sets the street address in the account
  public void setStreetAddress(String streetAddress)
  {
    this.streetAddress = streetAddress;
  }
  
  //this method gets the street address in the account
  public String getZipCode() 
  {
    return this.zipCode;
  }
  
  //this method sets the street address in the account
  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }
  
  //This method gets the savings account and is of type BankAccount 
  public BankAccount getSavingsAccount()
  {
    return this.savingsAccount;
  }
  
  //This method sets the savings account and is of type BankAccount 
  public void setSavingsAccount(BankAccount savingsAccount)
  {
    this.savingsAccount = savingsAccount;
  }
  
  //This method gets the checking account and is of type BankAccount
  public BankAccount getCheckingAccount() 
  {
    return this.checkingAccount;
  }
  
  //This method sets the savings account and is of type BankAccount 
  public void setCheckingAccount(BankAccount checkingAccount)
  {
    this.checkingAccount = checkingAccount;
  }
  
   //This method gets the money market account and is of type BankAccount
  public BankAccount getMoneyMarketAccount() 
  {
    return this.moneyMarketAccount;
  }
  
  //This method sets the money market account and is of type BankAccount
  public void setMoneyMarketAccount(BankAccount moneyMarketAccount) 
  {
    this.moneyMarketAccount = moneyMarketAccount;
  }
  
  //This method gets the credit card account and is of type CreditCardAccount
  public CreditCardAccount getCreditCardAccount() 
  {
    return this.creditCardAccount;
  }
  
  //This method sets the credit card account and is of type BankAccount
  public void setCreditCardAccount(CreditCardAccount creditCardAccount) 
  {
    this.creditCardAccount = creditCardAccount;
  }
  
  //This method sets the date and is of type Date
  public void setDate(Date date) 
  {
    this.date = date;
  }

  //This method gets the date and is of type Date
  public Date getDate()
  {
    return this.date;
  }
  
  //This method takes no input and increments the day
  public void incrementDay() 
  {
    this.getDate().incrementDay();
    
    if(this.getSavingsAccount() != null)
    {
      this.getSavingsAccount().incrementDay();
    }
    
    if(this.getCheckingAccount() != null)
    {
      this.getCheckingAccount().incrementDay();
    }
        
    if(this.getMoneyMarketAccount() != null)
    {
      this.getMoneyMarketAccount().incrementDay();
    }
    
    if(this.getCreditCardAccount() != null)
    {
      this.getCreditCardAccount().incrementDay();
    }
    
    if(this.getDate().getDay() == 1)
    {
      if(this.getSavingsAccount() != null)
      {
        this.getSavingsAccount().incrementMonth();
      }
      
      if(this.getCheckingAccount() != null)
      {
        this.getCheckingAccount().incrementMonth();
      }
      
      if(this.getMoneyMarketAccount() != null)
      {
        this.getMoneyMarketAccount().incrementMonth();
      }
      
      if(this.getCreditCardAccount() != null)
      {
        this.getCreditCardAccount().incrementMonth();
      }
    }
  }
  
  // Overide the equals method which return true when first name, last name, stree address and zipcode are same for two accounts
  @Override
  public boolean equals(Object o) {
    if (o instanceof Account) {
      Account a = (Account)o;
      return (this.getFirstName().equals(a.getFirstName()) && this.getLastName().equals(a.getLastName()) && this.getStreetAddress().equals(a.getStreetAddress()) && this.getZipCode().equals(a.getZipCode()));
    }
    return false;
  }
  
  // Returns first name, last name, street address and balanace of all attached accounts
  @Override
  public String toString()
  {
    String s;
    s = this.getFirstName() + " " + this.getLastName() + " " + this.getStreetAddress() + ". ";
    
    if(this.getSavingsAccount() != null)
    {
      s = s + "Savings: " + this.getSavingsAccount().getBalance();
    }
    
    if(this.getCheckingAccount() != null)
    {
      s = s + ", Checking: " + this.getCheckingAccount().getBalance();
    }
        
    if(this.getMoneyMarketAccount() != null)
    {
      s = s + ", Money Market: " + this.getMoneyMarketAccount().getBalance();
    }
    
    if(this.getCreditCardAccount() != null)
    {
      s = s + ", Credit Card: " + this.getCreditCardAccount().getBalance();
    }
    
    return s;
  }
  
}