import java.lang.reflect.Array;
import java.util.Arrays;

public class DZ_3 {
    public static void main(String[] args) {
        double[] digits = new double[15];
        digits[0] = 1.1;
        digits[1] =2.2;
        digits[2] =-3.3;
        digits[3] =-4.4;
        digits[4] =5.5;
        digits[5] =-6.6;
        digits[6] =7.7;
        digits[7] =8.8;
        digits[8] =9.9;
        digits[9] =-10.0;
        digits[10] =11.1;
        digits[11] =-12.2;
        digits[12] =13.3;
        digits[13] =14.4;
        digits[14] =-15.5;

        boolean foundNegative = false;
        double sum = 0;
        int count = 0;

        for(Double digit: digits){
            if (foundNegative && digit > 0){
                sum += digit;
                count++;
            }else if(digit < 0){
                foundNegative = true;
            }

        }
        double result = sum / count;
        System.out.println(Arrays.toString(digits) + " = " + sum + "/" + count + " или " + result);

    }
}
