import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadData {
    public static void main(String[] args) {
     
        ReadData reader = new ReadData();

      
        double[] simulated4BHKHotels = reader.readAndStoreData("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\4BHK hotels_simulated.txt");
        ArrayList<Double> simulatedSingleMotels = reader.readAndStoreDataList("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\Single motels_simulated.txt");
        double[] simulated7BHKResorts = reader.readAndStoreData("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\7BHK resorts_simulated.txt");

       
        ArrayList<Double> groundTruth5BHKHotels = reader.readAndStoreDataList("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\5BHK hotels_GroundTruth.txt");
        double[] groundTruth3BHKMotels = reader.readAndStoreData("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\3BHK motels_GroundTruth.txt");
        ArrayList<Double> groundTruth12BHKResorts = reader.readAndStoreDataList("C:\\Users\\ACER\\IdeaProjects\\Real estate trajectory\\12BHK resorts_GroundTruth.txt");

      
        System.out.println("4BHK hotels_simulated.txt" + arrayToString(simulated4BHKHotels));
        System.out.println("Single motels_simulated.txt" + listToString(simulatedSingleMotels));
        System.out.println("7BHK resorts_simulated.txt" + arrayToString(simulated7BHKResorts));
        System.out.println("5BHK hotels_GroundTruth.txt" + listToString(groundTruth5BHKHotels));
        System.out.println("3BHK motels_GroundTruth.txt" + arrayToString(groundTruth3BHKMotels));
        System.out.println("12BHK resorts_GroundTruth.txt" + listToString(groundTruth12BHKResorts));
    }

    public double[] readAndStoreData(String fileName) {
        ArrayList<Double> dataList = readAndStoreDataList(fileName);
        return dataList.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public ArrayList<Double> readAndStoreDataList(String fileName) {
        ArrayList<Double> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
              
                String numericPart = line.replaceAll("[^\\d.]", "");

      
                int lastDotIndex = numericPart.lastIndexOf('.');
                numericPart = numericPart.substring(0, lastDotIndex) +
                        numericPart.substring(lastDotIndex).replaceAll("\\.", "");

                dataList.add(Double.parseDouble(numericPart));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }


    static String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (double value : array) {
            sb.append(value).append(", ");
        }
        if (array.length > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    static String listToString(ArrayList<Double> list) {
        return list.toString();
    }
}
