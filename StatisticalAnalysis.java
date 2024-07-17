import java.util.Arrays;
import java.util.stream.DoubleStream;

public class StatisticalAnalysis {

    public double min(double[] data) {
        return Arrays.stream(data).min().getAsDouble();
    }

    public double max(double[] data) {
        return Arrays.stream(data).max().getAsDouble();
    }

    public double mean(double[] data) {
        return DoubleStream.of(data).average().getAsDouble();
    }

    public double variance(double[] data) {
        double mean = mean(data);
        return DoubleStream.of(data).map(d -> Math.pow(d - mean, 2)).average().orElse(0.0);
    }

    public double standardDeviation(double[] data) {
        return Math.sqrt(variance(data));
    }

    public double total(double[] data) {
        return DoubleStream.of(data).sum();
    }
}
