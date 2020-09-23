public class BFSearch {

    /**
     * 广度优先搜索
     * BFSearch
     * @param node
     * 			搜索的入口节点
     */
    public void searchTraversing(GraphNode node) {
        List<GraphNode> visited = new ArrayList<GraphNode>(); // 已经被访问过的元素
        Queue<GraphNode> q = new LinkedList<GraphNode>(); // 用队列存放依次要遍历的元素
        q.offer(node);

        while (!q.isEmpty()) {
            GraphNode currNode = q.poll();
            if (!visited.contains(currNode)) {
                visited.add(currNode);
                System.out.println("节点：" + currNode.getLabel());
                for (int i = 0; i < currNode.edgeList.size(); i++) {
                    q.offer(currNode.edgeList.get(i).getNodeRight());
                }
            }
        }
    }
}