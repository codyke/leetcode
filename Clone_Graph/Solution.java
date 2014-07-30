/* Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode result = null; 
        List<UndirectedGraphNode> stack = new ArrayList<UndirectedGraphNode>(); 
        if(node == null) {
            return result; 
        }
        
        stack.add(node); 
        // clone the node 
        while(!stack.isEmpty()){
            UndirectedGraphNode n = stack.remove(0); 
            // if the last neighbors has the same lable but the node
            // does not equal to this neighbor, we know we already 
            // visit this node before
            int neighborsNum = n.neighbors.size(); 
            UndirectedGraphNode p = neighborsNum == 0 ? null : n.neighbors.get(neighborsNum - 1); 
            if(p != null && n.label == p.label && n != p) {
                continue; 
            }
            // otherwise we clone this node
            UndirectedGraphNode newNode = new UndirectedGraphNode(n.label); 
            // otherwise, we add the neighbors to the stack and to the new 
            // node's neighbors list
            for(int i = 0; i < neighborsNum; i++) {
                stack.add(n.neighbors.get(i)); 
                newNode.neighbors.add(n.neighbors.get(i)); 
            }
            // add new node to cur node's neighbors list
            n.neighbors.add(newNode); 
        }
        
        // set the neighbors for new node 
        stack.clear();
        stack.add(node);
        while(!stack.isEmpty()) {
            UndirectedGraphNode n = stack.remove(0); 
            int neighborsNum = n.neighbors.size(); 
            UndirectedGraphNode newNode = n.neighbors.get(neighborsNum - 1); 
            if(newNode.label == n.label && newNode.neighbors.size() == n.neighbors.size()) {
                // we already visit this node 
                continue;
            }
                       // otherwise, we go through each neigbors in the list, 
            // and set it to new value 
            neighborsNum = newNode.neighbors.size(); 
            for(int i = 0; i < neighborsNum; i++) {
                UndirectedGraphNode p2 = newNode.neighbors.get(i); 
                stack.add(p2); 
                p2 = p2.neighbors.get(p2.neighbors.size() - 1); 
                newNode.neighbors.set(i, p2); 
            }
            newNode.neighbors.add(n); 
        }
        
        // separate the two graph
        stack.clear(); 
        stack.add(node);
        while(!stack.isEmpty()) {
            UndirectedGraphNode n = stack.remove(0); 
            int neighborsNum = n.neighbors.size(); 
            UndirectedGraphNode newNode = neighborsNum == 0 ? null : n.neighbors.get(neighborsNum - 1); 
            if(!(newNode != null && n.label == newNode.label && n != newNode)) {
                continue; 
            }
            if(result == null) {
                result = newNode; 
            }
            // remove the last neighbors in both n and newNode
            n.neighbors.remove(neighborsNum - 1); 
            newNode.neighbors.remove(neighborsNum - 1); 
            for(int i = 0; i < neighborsNum - 1; i++) {
                stack.add(n.neighbors.get(i)); 
            }
        }
        
        return result; 
    }
}