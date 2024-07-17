import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static final Random rand = new Random();

    public static void main(String[] args) {
        generateAndWriteSimulatedData();
        generateAndWriteGroundTruthData();
    }

    public static void generateAndWriteSimulatedData() {
        generateAndWriteHotelData("4BHK hotels_simulated.txt", "4BHK", 350, 3, 4, 730);
        generateAndWriteHotelData("5BHK hotels_simulated.txt", "5BHK", 450, 3, 4, 730);
        generateAndWriteHotelData("6BHK hotels_simulated.txt", "6BHK", 550, 3, 4, 730);

        generateAndWriteMotelData("Single motels_simulated.txt", "Single", 100, 2, 5, 730);
        generateAndWriteMotelData("2BHK motels_simulated.txt", "2BHK", 175, 2, 5, 730);
        generateAndWriteMotelData("3BHK motels_simulated.txt", "3BHK", 250, 2, 5, 730);

        generateAndWriteResortData("8BHK resorts_simulated.txt", "8BHK", 900, 1, 3, 730);
        generateAndWriteResortData("7BHK resorts_simulated.txt", "7BHK", 800, 1, 3, 730);
        generateAndWriteResortData("12BHK resorts_simulated.txt", "12BHK", 1200, 1, 3, 730);
    }

    public static void generateAndWriteGroundTruthData() {
        generateAndWriteHotelData("4BHK hotels_GroundTruth.txt", "4BHK", 350, 2, 3, 730);
        generateAndWriteHotelData("5BHK hotels_GroundTruth.txt", "5BHK", 450, 2, 3, 730);
        generateAndWriteHotelData("6BHK hotels_GroundTruth.txt", "6BHK", 550, 2, 3, 730);

        generateAndWriteMotelData("Single motels_GroundTruth.txt", "Single", 100, 2, 4, 730);
        generateAndWriteMotelData("2BHK motels_GroundTruth.txt", "2BHK", 175, 2, 4, 730);
        generateAndWriteMotelData("3BHK motels_GroundTruth.txt", "3BHK", 250, 2, 4, 730);

        generateAndWriteResortData("8BHK resorts_GroundTruth.txt", "8BHK", 900, 2, 3, 730);
        generateAndWriteResortData("7BHK resorts_GroundTruth.txt", "7BHK", 800, 2, 3, 730);
        generateAndWriteResortData("12BHK resorts_GroundTruth.txt", "12BHK", 1200, 2, 3, 730);
    }

    private static void generateAndWriteHotelData(String fileName, String roomType, double price, int minRooms, int maxRooms, int numSimulations) {
        generateAndWriteData(fileName, roomType, price, minRooms, maxRooms, numSimulations);
    }

    private static void generateAndWriteMotelData(String fileName, String roomType, double price, int minRooms, int maxRooms, int numSimulations) {
        generateAndWriteData(fileName, roomType, price, minRooms, maxRooms, numSimulations);
    }

    private static void generateAndWriteResortData(String fileName, String roomType, double price, int minRooms, int maxRooms, int numSimulations) {
        generateAndWriteData(fileName, roomType, price, minRooms, maxRooms, numSimulations);
    }

    private static void generateAndWriteData(String fileName, String roomType, double price, int minRooms, int maxRooms, int numSimulations) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < numSimulations; i++) {
                int roomsRented = rand.nextInt((maxRooms - minRooms) + 1) + minRooms;
                double totalPrice = price * roomsRented;
                writer.write(roomType + " " + price + " " + "*" + roomsRented + " " + "=" + "\t" + totalPrice + "\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
