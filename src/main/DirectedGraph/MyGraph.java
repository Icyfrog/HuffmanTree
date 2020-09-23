import java.util.ArrayList;
import java.util.List;

public class MyGraph {

    private List<GraphNode> nodes = null;

    public void initGraph(int n) {
        if (nodes == null) {
            nodes = new ArrayList<GraphNode>();
        }

        GraphNode node = null;
        for (int i = 0; i < n; i++) {
            node = new GraphNode(String.valueOf(i));
            nodes.add(node);
        }

        node = new GraphNode("8");
        nodes.add(node);
    }

    public void initGraph(int n, boolean b) {

        /**
         * 他这个节点，默认是从左指向右，所以实际上是有向图！
         *
         * 他这个节点，默认是从左指向右，所以实际上是有向图！
         *
         * 他这个节点，默认是从左指向右，所以实际上是有向图！
         */
        initGraph(n);
        GraphEdge edge01 = new GraphEdge(nodes.get(0), nodes.get(1));
        GraphEdge edge02 = new GraphEdge(nodes.get(0), nodes.get(2));
        GraphEdge edge13 = new GraphEdge(nodes.get(1), nodes.get(3));
        GraphEdge edge14 = new GraphEdge(nodes.get(1), nodes.get(4));
        GraphEdge edge25 = new GraphEdge(nodes.get(2), nodes.get(5));
        GraphEdge edge26 = new GraphEdge(nodes.get(2), nodes.get(6));
        GraphEdge edge37 = new GraphEdge(nodes.get(3), nodes.get(7));
        GraphEdge edge47 = new GraphEdge(nodes.get(4), nodes.get(7));
        GraphEdge edge56 = new GraphEdge(nodes.get(5), nodes.get(6));
        GraphEdge edge84 = new GraphEdge(nodes.get(8), nodes.get(4));


        nodes.get(0).addEdgeList(edge01);
        nodes.get(0).addEdgeList(edge02);
        nodes.get(1).addEdgeList(edge13);
        nodes.get(1).addEdgeList(edge14);
        nodes.get(2).addEdgeList(edge25);
        nodes.get(2).addEdgeList(edge26);
        nodes.get(3).addEdgeList(edge37);
        nodes.get(4).addEdgeList(edge47);
        nodes.get(5).addEdgeList(edge56);
        nodes.get(4).addEdgeList(edge84);
    }

    public void initGraph() {
        initGraph(8, false);
    }

    public List<GraphNode> getGraphNodes() {
        return nodes;
    }
}