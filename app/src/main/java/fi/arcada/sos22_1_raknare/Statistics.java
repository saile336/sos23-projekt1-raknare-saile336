package fi.arcada.sos22_1_raknare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Statistics {

    public static String greet() {
        return "Hej";
    }

    public static double calculateMean(ArrayList<Double> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum / values.size();
    }

    public static ArrayList<Double> sortValues(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        return sorted;
    }

    public static double calculateMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = sortValues(values);
        int amount = sorted.size();
        if (amount % 2 == 0) {
            double sum = (sorted.get(amount / 2) + sorted.get(amount / 2 - 1)) / 2;
            return sum;
        } else {
            double sum = sorted.get((amount + 1) / 2 - 1);
            return sum;
        }
    }

    public static double calculateSD(ArrayList<Double> values) {
        double stDev = 0;
        double mean = calculateMean(values);
        for (double value : values) {
            stDev += Math.pow(value - mean, 2);
        }
        return Math.sqrt(stDev / values.size());
    }
}


