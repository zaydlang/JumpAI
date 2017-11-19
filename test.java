import java.lang.*;

public class test {

   public static boolean checkNaN(double d) {
      Double d1 = new Double(0.0);
      d1 = new Double(d);
      return d1.isNaN(d1);
   }
} 
