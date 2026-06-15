/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Start a DFS from the 'node'
    // and store a ref to old node to new cloned node in the map
    // because its a undirected graph and  when we visit the
    // same node again for a neighbor we should return the same node
    // instead of creating a new node
    Map<Integer, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (nodes.containsKey(node.val))
            return nodes.get(node.val);

        Node clone = new Node(node.val);
        nodes.put(node.val, clone);

        for (Node neighbor: node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }

        return clone;
    }
}