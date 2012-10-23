//   Returns miles formatted to one decimal place and padded by spaces
//   on the left so that the String returned has length width

import java.text.*;

public class leftpad2
{
public static String leftpad2(double amount, int width)
{ String s;         // string that is returned
  int m;            // lenght of string (s)
  
  NumberFormat money = NumberFormat.getCurrencyInstance();
  
  // convert miles to a string with one decimal place
  s = money.format(amount);
  
  // determine the lenght of string (s)
  m = s.length();
  
  // pad s by spaces on the left so that te resulting lenght of s is width
  for(int i = 0; i < width-m; i++)
  {s = " " + s;       // one space between the " "
  }
  return s;
  }
}


