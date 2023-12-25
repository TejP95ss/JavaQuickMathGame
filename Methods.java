import java.util.ArrayList;

public class Methods{
    static long calculateAverage(ArrayList<Long> values) {
        long sum = 0;
        long sizeofvalues = values.size();
        if (!values.isEmpty()) {
            for (long v : values) {
                sum += v;
            }
        }
         return sum/sizeofvalues;
    }
    
    static int sumsArray(ArrayList<Integer> values) {
        int sum = 0;
        if (!values.isEmpty()) {
            for (long v: values) {
                sum += v;
            }
        }
         return sum;
    }
    
    static String FormatString(Long str) {
      String Converted = String.valueOf(str);
      String formatted = "";
      for (int n = 0; n < Converted.length() - 6; n++) {
        if (n == Converted.length() - 9) {
          formatted = formatted + "." + Converted.charAt(n); 
        } 
        else {formatted = formatted + Converted.charAt(n);}
      }
      return formatted;
    }
    
}