/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( root == null) return result;

        nlevel(root , result);
        return result;
    }
    void nlevel( Node root ,List<List<Integer>> result){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i < size ; i++){
            Node tempp = queue.poll();
            temp.add(tempp.val);
            if(tempp.children != null)
            queue.addAll(tempp.children);
        }
        result.add(temp);
        }
    }
}