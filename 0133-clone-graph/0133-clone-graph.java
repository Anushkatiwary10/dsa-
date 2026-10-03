/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            Node currClone=map.get(curr);
            for(Node neighbor:curr.neighbors){
                if(!map.containsKey(neighbor)){
                    Node neighborClone = new Node(neighbor.val);

                    map.put(neighbor, neighborClone);

                    q.add(neighbor);
                }
                currClone.neighbors.add(map.get(neighbor));
            }
        }
        return clone;
    }
}