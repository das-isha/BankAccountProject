/*Developer: Isha Das 
  The primary purpose of the CreditCard Account class is to keep track of the credit card account and access the balance 
  and keep track of any interest rates, fees, or payments made */

public class CreditCardAccount extends Object
{
  //this field stores the current balance of the credit card
  private double currentBalance; 
 
  //this field stores the interest rate of the credit card
  private double interestRate;
  
  //this field stores the credit limit of the credit card
  private int creditLimit;
  
  //this field stores the minimum montly payment of the credit card
  private int minMonthlyPayment;
  
  //this field stores the late payment penalty of the credit card
  private int latePaymentPenalty;
  
  //this field stores the monthly payment of the credit card
  private double monthlyPayment;
  
  //this field stores the total payment made monthly of the credit card
  private double monthlyPaid;

  //this field sets the interest charged of the credit card to 0.0 
  private double interestCharged = 0.0;
  
  //this field sets the paid in full of the credit card as true
  private boolean paidInFullFlag = true;

  //These are all the default values for the fields above and the generic BankAccount constructor with no inputs lets you use the account with all the fields set to their default values.
  private final double CURRENT_BLALANCE = 0.0;
  private final double INTEREST_RATE = 10.0;
  private final int CREDIT_LIMIT = 1000;
  private final int MINIMUM_MONTHLY_PAYMENT = 50;
  private final int LATE_PAYMENT_FEE = 30;
  private final double MONTHLY_PAYMENT = 100.0;
  private final int MOTHLY_PAID = 200;

  //This is the default constructor that just allows us to use the credit card account with all fields set to their default user-defined values
  public CreditCardAccount()
  {
    this.currentBalance = CURRENT_BLALANCE;
    this.interestRate = INTEREST_RATE;
    this.creditLimit = CREDIT_LIMIT;
    this.minMonthlyPayment = MINIMUM_MONTHLY_PAYMENT;
    this.latePaymentPenalty = LATE_PAYMENT_FEE;
    this.monthlyPayment = MONTHLY_PAYMENT;
    this.monthlyPaid = MOTHLY_PAID;
  }
  
  //This is a constructor to make a credit card account with the given credit limit, interest rate, mimimum monthly payment, and late payment penalty
  public CreditCardAccount(int creditLimit, double interestRate, int minMonthlyPayment, int latePaymentPenalty )
  {
    this.setCreditLimit(creditLimit);
    this.setInterestRate(interestRate);
    this.setMinMonthlyPayment(minMonthlyPayment);
    this.setLatePaymentPenalty(latePaymentPenalty);
    
  }
  
  //A method to get the credit limit of the credit card
  public int getCreditLimit()
  {
    return this.creditLimit;
  }
  
  //A method to set the credit limit of the credit card
  public void setCreditLimit(int creditLimit)
  {
       this.creditLimit = creditLimit;
  }
  
  //A method to get the interest rate of the credit card
  public double getInterestRate()
  {
    return this.interestRate;
  }
  
  //A method to set the interest rate of the credit card
  public void setInterestRate(double interestRate)
  {
    this.interestRate = interestRate;
  }
  
  //A method to get the minimum monthly payment of the credit card
  public int getMinMonthlyPayment()
  {
    return this.minMonthlyPayment;
  }
  
  //A method to set the minimum monthly payment of the credit card
  public void setMinMonthlyPayment(int minMonthlyPayment)
  {
       this.minMonthlyPayment = minMonthlyPayment;
  }
  
  //A method to get the late payment penalty of the credit card
  public int getLatePaymentPenalty()
  {
    return this.latePaymentPenalty;
  }

  //A method to set the late payment penalty of the credit card
  public void setLatePaymentPenalty(int latePaymentPenalty)
  {
       this.latePaymentPenalty = latePaymentPenalty;
  }
  
  //A method to get the current balance of the credit card
  public double getBalance()
  {
    return this.currentBalance;
  }

  //A method get the monthly payment amount of the credit card
  public double getMonthlyPayment()
  {
    return this.monthlyPayment;
  }

  /*A method that is used to charge an amount on the credit card only if the the sum of the current balance and the amount that
   *was taken as the input is less than or equal to the credit limit. Otherwise it should return false.*/
  public boolean charge(double chargeAmount)
  {
    if((this.getBalance() + chargeAmount) <= (double)this.getCreditLimit())
    {
      this.currentBalance += chargeAmount;
      return true;
    }
    else
    {
      return false;
    }
  }

  //A method that is used to make a amount of payment on the credit card by updating the current balance and total payment made monthly of the credit card 
  public void payment(double paymentAmount)
  {
    this.currentBalance -= paymentAmount;
    this.monthlyPaid += paymentAmount;
  }
  
  //A method that is used to check if previous month's balance was not paid in full and if that is met it charges interest on 
  //the current balance after each day on the credit card
  public void incrementDay()
  {
    if(this.paidInFullFlag == false)
    {
      //interestChargeBalance is the sum of balance plus the interest charged so far
      double interestChargeBalance = this.getBalance() + this.interestCharged;
      this.interestCharged = this.interestCharged + ((interestChargeBalance*this.getInterestRate()/100.0)/365.0);
    }
  }

  //A method that is used to add the intrest charged monthly to the current Balance and apply monthly process 
  public void incrementMonth()
  {
    this.currentBalance += this.interestCharged;
    this.interestCharged = 0.0;
    
    if(monthlyPaid >= monthlyPayment)
    {
      this.paidInFullFlag = true;
    }
    else
    {
      this.paidInFullFlag = false;
    }
    
    if((this.getMinMonthlyPayment() < this.getMonthlyPayment()) && (this.monthlyPaid < this.getMinMonthlyPayment()))
    {
      this.currentBalance += getLatePaymentPenalty();
      this.monthlyPaid = 0.0;
      this.monthlyPayment = this.getBalance();
    }
  }
}