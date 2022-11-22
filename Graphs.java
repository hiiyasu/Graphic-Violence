import java.io.File;
import java.util.Scanner;

public class Graphs {

    public static void main(String[] args) {
        String filename = "graphInput1.txt";
        try {
            Graph graph = new Graph(filename);
        } catch (Exception e) {}

        Scanner in = new Scanner(System.in);
        int choice = 0;
        while(choice != 8){
            System.out.println("1. Is Connected\n" +
                    "2. Minimum Spanning Tree\n" +
                    "3. Shortest Path\n" +
                    "4. Is Metric\n" +
                    "5. Make Metric\n" +
                    "6. Traveling Salesman Problem\n" +
                    "7. Approximate TSP\n" +
                    "8. Quit\n" +
                    "Make your choice (1-8): ");
            choice = in.nextInt();
            if(choice < 0 || choice > 8) {
                System.out.println("Please choose a valid option. \n");
            }
        }
    }
}
