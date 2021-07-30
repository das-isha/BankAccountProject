/*Developer: Isha Das 
  This Date class is a simple representation of Date with functionality to increment day, check if two dates are same
  and provide a stricng representation of the data class */

public class Date extends Object
{
  //This field stores day of the month 1 to 31
  private int day;
  
  //This fiels store number for a month 1 to 12
  private int month;
  
  //A constructor that creates a Date with daye of the month and a number for the month
  public Date(int day, int month)
  {
    this.day = day;
    this.month = month;
  }
  
  //This method returns the day of the month
  public int getDay() 
  {
    return this.day;
  }
  
  //This method returns the number for the month
  public int getMonth() 
  {
    return this.month;
  }
  
  //This method increments the day and if the day is greater than 31, it increaments the month and sets the day to 1, 
  // when month is more than 12, it sets the month to 1
  public void incrementDay()
  {
    this.day++;
    
    if(this.getDay() > 31)
    {
      this.day = 1;
      this.month++;
    }
    
    if(this.getMonth() > 12)
    {
      this.month = 1;
    }
  }
  
  //Overrides the equals menthod to check if two date as same and returns truw if day and month are same for both dates
  @Override
  public boolean equals(Object o)
  {
    if (o instanceof Date) 
    {
      Date d = (Date)o;
      return (this.getDay() == d.getDay() && this.getMonth() == d.getMonth());
    }
    return false;
  }

  //Overrides toString method and returns a text representation of the date
  @Override
  public String toString()
  {
    String s;
    s = "Month: " + this.getMonth() + " and " + "Day: "+ this.getDay();
    return s;
  }
}