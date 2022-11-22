import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph();
    }

    private RedBlackTree<Integer, Integer> adj[];
    Graph(int V){
        adj = new RedBlackTree[V];
        for(int i = 0; i < adj.length; ++i){
            adj[i] = new RedBlackTree<>();
        }
    }

    Graph(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        int V = in.nextInt();
        adj = new RedBlackTree[V];
        for(int i = 0; i < adj.length; ++i){
            adj[i] = new RedBlackTree<>();
        }
        int firstVert = 0;
        while (in.hasNext()) {
            String nextLine = in.nextLine();
            String[] lines = nextLine.split("\\s+");
            for (int i = 1; i < lines.length; i+=2) {
                try {
                    int secondVert = Integer.parseInt(lines[i]);
                    int weight = Integer.parseInt(lines[i+1]);
                    this.addEdge(firstVert, secondVert, weight);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("Improperly formatted file");
                }
            }
            firstVert++;
        }
    }

    public Iterable<Integer> edgeTo(int v){
        return new Queue<>();
    }

    public int V(){
        return adj.length;
    }

    public String toString() {
        return "";
    }

    public int weight(int a, int b){
        return 0;
    }

    public void addEdge(int v, int w, int weight){
    }
}


