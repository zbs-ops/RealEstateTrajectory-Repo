import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       
        ReadData reader = new ReadData();

     
        String[] roomModelsSimulated = {"4BHK hotels_simulated.txt", "5BHK hotels_simulated.txt", "6BHK hotels_simulated.txt",
                "Single motels_simulated.txt", "2BHK motels_simulated.txt", "3BHK motels_simulated.txt",
                "8BHK resorts_simulated.txt", "7BHK resorts_simulated.txt", "12BHK resorts_simulated.txt"};
        String[] roomModelsGroundTruth = {"4BHK hotels_GroundTruth.txt", "5BHK hotels_GroundTruth.txt", "6BHK hotels_GroundTruth.txt",
                "Single motels_GroundTruth.txt", "2BHK motels_GroundTruth.txt", "3BHK motels_GroundTruth.txt",
                "8BHK resorts_GroundTruth.txt", "7BHK resorts_GroundTruth.txt", "12BHK resorts_GroundTruth.txt"};

      
        StatisticalAnalysis stats = new StatisticalAnalysis();


        
        ArrayList<Double> hotelsDataSimulated = new ArrayList<>();
        ArrayList<Double> motelsDataSimulated = new ArrayList<>();
        ArrayList<Double> resortsDataSimulated = new ArrayList<>();
        ArrayList<Double> hotelsDataGroundTruth = new ArrayList<>();
        ArrayList<Double> motelsDataGroundTruth = new ArrayList<>();
        ArrayList<Double> resortsDataGroundTruth = new ArrayList<>();

        for (String roomModel : roomModelsSimulated) {
            double[] simulatedData = reader.readAndStoreData("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\" + roomModel);
            System.out.println("\n" + roomModel + ": " + ReadData.arrayToString(simulatedData));

           
            if (roomModel.startsWith("4BHK") || roomModel.startsWith("5BHK") || roomModel.startsWith("6BHK")) {
                for (double value : simulatedData) {
                    hotelsDataSimulated.add(value);
                }
            } else if (roomModel.startsWith("Single") || roomModel.startsWith("2BHK") || roomModel.startsWith("3BHK")) {
                for (double value : simulatedData) {
                    motelsDataSimulated.add(value);
                }
            } else {
                for (double value : simulatedData) {
                    resortsDataSimulated.add(value);
                }
            }
        }

        
        for (String roomModel : roomModelsGroundTruth) {
            double[] groundTruthData = reader.readAndStoreData("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\" + roomModel);
            System.out.println("\n" + roomModel + ": " + ReadData.arrayToString(groundTruthData));

    
            if (roomModel.startsWith("4BHK") || roomModel.startsWith("5BHK") || roomModel.startsWith("6BHK")) {
                for (double value : groundTruthData) {
                    hotelsDataGroundTruth.add(value);
                }
            } else if (roomModel.startsWith("Single") || roomModel.startsWith("2BHK") || roomModel.startsWith("3BHK")) {
                for (double value : groundTruthData) {
                    motelsDataGroundTruth.add(value);
                }
            } else {
                for (double value : groundTruthData) {
                    resortsDataGroundTruth.add(value);
                }
            }
        }

        
        double[] hotelsArraySimulated = hotelsDataSimulated.stream().mapToDouble(Double::doubleValue).toArray();
        double[] motelsArraySimulated = motelsDataSimulated.stream().mapToDouble(Double::doubleValue).toArray();
        double[] resortsArraySimulated = resortsDataSimulated.stream().mapToDouble(Double::doubleValue).toArray();
        double[] hotelsArrayGroundTruth = hotelsDataGroundTruth.stream().mapToDouble(Double::doubleValue).toArray();
        double[] motelsArrayGroundTruth = motelsDataGroundTruth.stream().mapToDouble(Double::doubleValue).toArray();
        double[] resortsArrayGroundTruth = resortsDataGroundTruth.stream().mapToDouble(Double::doubleValue).toArray();

       
        System.out.println("Hotels Simulated:" + analyzeCategory(stats, hotelsArraySimulated, hotelsArrayGroundTruth, "Hotels"));
        System.out.println("Motels Simulated:" + analyzeCategory(stats, motelsArraySimulated, motelsArrayGroundTruth, "Motels"));
        System.out.println("Resorts Simulated:" + analyzeCategory(stats, resortsArraySimulated, resortsArrayGroundTruth, "Resorts"));
        System.out.println("Hotels Ground Truth:" + analyzeCategory(stats, hotelsArrayGroundTruth, hotelsArrayGroundTruth, "Hotels"));
        System.out.println("Motels Ground Truth:" + analyzeCategory(stats, motelsArrayGroundTruth, motelsArrayGroundTruth, "Motels"));
        System.out.println("Resorts Ground Truth:" + analyzeCategory(stats, resortsArrayGroundTruth, resortsArrayGroundTruth, "Resorts"));


    }


    private static String analyzeCategory(StatisticalAnalysis stats, double[] data, double[] groundTruthData, String category) {
       
        ComparativeAnalysis comp = new ComparativeAnalysis();

        
        double minPrice = stats.min(data);
        double maxPrice = stats.max(data);
        double meanPrice = stats.mean(data);
        double variance = stats.variance(data);
        double stdDev = stats.standardDeviation(data);
        double total = stats.total(data);

        System.out.println("RMSD: " + comp.calculateRMSD(groundTruthData, data) + "\n" +
                "MAE: " + comp.calculateMAE(groundTruthData, data) + "\n" +
                "MSE: " + comp.calculateMSE(groundTruthData, data));

  
        displayOutput(category, minPrice, maxPrice, meanPrice, variance, stdDev, total);
        return null;
    }
    public static void displayOutput(String model, double minPrice, double maxPrice, double meanPrice, double variance, double stdDev, double total) {
        System.out.format("%-15s %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f\n", model, minPrice, maxPrice, meanPrice, variance, stdDev, total);
    }

}

