import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Graph graph = null;
        try {
            graph = new Graph("graphinput.txt");
        } catch(Exception e){}
        System.out.println(graph.toString());
        for (Integer i: graph.edgeTo(3)) {
            System.out.println("edge:" + i.toString());
        }
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
        int V = Integer.parseInt( in.nextLine() );
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
                    System.out.println("line = " + firstVert);
                    System.out.println("i=" + i);
                    int secondVert = Integer.parseInt(lines[i]);
                    int weight = Integer.parseInt(lines[i+1]);
                    //System.out.println(firstVert + "\t" + secondVert+ "\t" + weight);
                    this.addEdge(firstVert, secondVert, weight);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("Improperly formatted file");
                }
            }
            firstVert++;
        }
    }

    public Iterable<Integer> edgeTo(int v){
        return adj[v].keys();
    }

    public int V(){
        return adj.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph{" +
                "V=" + adj.length);
        for (RedBlackTree<Integer, Integer> r: adj) {
            sb.append(r.toString());
        }
        return sb.toString();
    }

    public int weight(int a, int b){
        return adj[a].get(b);
    }

    public void addEdge(int v, int w, int weight){
        adj[v].put(w, weight);
    }
    
    public boolean isConnected() {
		if (isConnected != null) return isConnected;
		DepthFirstSearch dfs = new DepthFirstSearch(this, 0);
		boolean isConnected = true;
		for (int i = 0; i < adj.length && isConnected; i++) {
			if (!dfs.marked(i)) isConnected = false;
		}
		this.isConnected = isConnected;
		return isConnected;
	}

	public String mst() {
		return "";
	}

	public String shortestPath(int v) {
		return "";
	}

	public boolean isMetric() {
		return false;
	}

	public String makeMetric() {
		return "";
	}
}


