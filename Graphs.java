import java.util.Scanner;

public class Graphs {

    public static void main(String[] args) {
        String filename = "graphInput1.txt";
        File file = new File(filename);
        Scanner fileReader = null;
        try {
             fileReader = new Scanner(file);
        } catch(Exception e){}

        int numNodes = fileReader.nextInt();

        Graph graph = new Graph(numNodes);
        int counter = 0;
        while (fileReader.hasNext()) {
           String nextLine = fileReader.nextLine();
           String[] lines = nextLine.split("\\s+");
           for (int i = 1; i < lines.length; i+=2) {
               try {
                   graph.addWeightedConnection(counter, lines[i], lines[i+1]);
               } catch (ArrayIndexOutOfBoundsException e) {
                   System.out.print("Improperly formatted file");
               }
           }
           counter++;
        }
        
        
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
