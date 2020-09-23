import java.util.ArrayList;
import java.util.List;

public class DFSerach {

    /**
     * 深度遍历
     * DFSearch
     * @param node
     * 			当前节点
     * @param visited
     * 			被访问过的节点列表
     */
    public static void searchTraversing(GraphNode node, List<GraphNode> visited) {
        // 判断是否遍历过
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.println("节点：" + node.getLabel());
        for (int i = 0; i < node.edgeList.size(); i++) {
            searchTraversing(node.edgeList.get(i).getNodeRight(), visited);
            // left -> right
        }
    }

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        myGraph.initGraph();
        List<GraphNode> list = new ArrayList<>();
        searchTraversing(myGraph.getGraphNodes().get(0), list);
        List<GraphNode> graphNodes = myGraph.getGraphNodes();
        for (GraphNode graphNode : graphNodes) {
            System.out.println(graphNode.getLabel());
        }
    }
}