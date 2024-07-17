public class ComparativeAnalysis {
    public double calculateRMSD(double[] actualValues, double[] predictedValues) {
        int length = actualValues.length;
        double sumOfSquares = 0.0;
        for (int i = 0; i < length; i++) {
            double difference = actualValues[i] - predictedValues[i];
            sumOfSquares += difference * difference;
        }
        return Math.sqrt(sumOfSquares / length);
    }

    public double calculateMAE(double[] actualValues, double[] predictedValues) {
        int length = actualValues.length;
        double sumOfAbsolutes = 0.0;
        for (int i = 0; i < length; i++) {
            sumOfAbsolutes += Math.abs(actualValues[i] - predictedValues[i]);
        }
        return sumOfAbsolutes / length;
    }

    public double calculateMSE(double[] actualValues, double[] predictedValues) {
        int length = actualValues.length;
        double sumOfSquares = 0.0;
        for (int i = 0; i < length; i++) {
            double difference = actualValues[i] - predictedValues[i];
            sumOfSquares += difference * difference;
        }
        return sumOfSquares / length;
    }
}
