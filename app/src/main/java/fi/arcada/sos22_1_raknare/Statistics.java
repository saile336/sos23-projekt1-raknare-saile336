package fi.arcada.sos22_1_raknare;

import java.util.Arrays;

public class Statistics {

    public static String greet(){
        return "Hej";
    }

    public static double calculateMean(double[] values){
        int amount = values.length;
        double sum = 0;
        for(int i = 0; i<amount; i++){
            sum += values[i];
        }
        double mean = sum/amount;
        return mean;
    }

    public static double calculateMedian(double[] values){
        int amount = values.length;
        Arrays.sort(values);
        int i = 0;
        double sum = 0;
        if(amount%2 == 0) {
            sum = (values[amount/2] + values[amount/2-1]) / 2;
            return sum;
        }
        else{
            sum = values[(amount+1)/2-1];
            return sum;
        }
    }
}


