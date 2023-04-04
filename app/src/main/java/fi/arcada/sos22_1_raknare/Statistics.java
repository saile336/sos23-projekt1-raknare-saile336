package fi.arcada.sos22_1_raknare;

public class Statistics {

    public static String greet(){
        return "Hej";
    }

    public static double calculate(double[] values){
        int amount = values.length;
        double sum = 0;
        for(int i = 0; i<amount; i++){
            sum += values[i];
        }
        double mean = sum/amount;
        return mean;
    }
}
