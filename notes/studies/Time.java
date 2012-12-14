//row left to right
// column up and down
// read row first and then column when reading arrays

public class Time
{
 private int hour;
 private int minute;
 
 public Time( int h, int m)
 { 
 this.hour = h;
 this. minute = m;
 }// end contructor
 
 public String toString()
 {
 return hour + ":" + minute;
 }//end method toString
}