import java.math.BigInteger;

public class Analyser {

    long trialOne = 1;
    long trialTwo;
    long trialThree;

    long[] trials;
    long[] orgTrials;
    double total = 0;

    private static double[] linear;
    private static double[] constant;
    private static double[] log;
    private static double[] nlog;
    private static double[] squared;
    private static double[] factorial;

    Analyser(long[] trials, int trialOneSize, int trialTwoSize, int trialThreeSize) {
        this.trials = trials.clone();
        orgTrials = trials.clone();
        findRelative(this.trials);

        trialTwo = trialTwoSize / trialOneSize;
        trialThree = trialThreeSize / trialOneSize;

        for (long current : this.trials) {
            total += current;
        }

        linear = new double[] {trialOne, trialTwo, trialThree};
        findRelative(linear);

        constant = new double[] {1, 1, 1};

        log = new double[] {trialOne, Math.log(trialTwo), Math.log(trialThree)};
        findRelative(log);

        nlog = new double[] {trialOne, trialTwo * Math.log(trialTwo), trialTwo * Math.log(trialThree)};
        findRelative(nlog);

        squared = new double[] {trialOne, Math.pow(trialTwo, 2), Math.pow(trialThree, 2)};
        findRelative(squared);

        factorial = new double[] {trialOne, 
            factorial(new BigInteger(String.valueOf(trialTwo))).doubleValue(), 
            factorial(new BigInteger(String.valueOf(trialTwo))).doubleValue()};
        findRelative(factorial);
    }

    public static BigInteger factorial(BigInteger number) { 
        if (number == BigInteger.ZERO || number == BigInteger.ONE) { 
            return BigInteger.ONE; 
        }

        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    } 

    private void findRelative(double[] input) {
        // this and the next method just finds the relative time of each trial with trial1 being the baseline
        input[1] /= input[0];
        input[2] /= input[0];
        input[0] = 1;
    }

    private void findRelative(long[] input) {
        input[1] /= input[0];
        input[2] /= input[0];
        input[0] = 1;
    }

    private double difference(double[] expected, long[] observed) {
        // for each trial in observed, compare it to an expected time
        // then square the difference for absolute value  
        double output = 0;

        for (int i = 0; i < observed.length; i++) {
            output += Math.pow(observed[i] - expected[i], 2);
        }

        return output;
    }

    public String test() {
        // finds the difference of the observed trial time to the expected trial time for each complexity
        double[] results = new double[] {
            difference(linear, trials),
            difference(constant, trials),
            difference(log, trials),
            difference(nlog, trials),
            difference(squared, trials),
            difference(factorial, trials)
        };


        // largest is actually the index expected time with the lowest difference
        int largest = 0;
        
        for ( int i = 1; i < results.length; i++ ) {
            if ( results[i] < results[largest] ) largest = i;
        }

        String output = "";

        switch(largest) {
            case 0:
                output = "n";
                break;

            case 1:
                output = "Constant";
                break;

            case 2:
                output = "Log(n)";
                break;

            case 3:
                output = "nLog(n)";
                break;

            case 4:
                output = "n-squared";
                break;

            case 5:
                output = "n!";
                break;

            default:
        }
        

        return output;
    }

    

}
