import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorder(Node root) {
        // Use LinkedList for efficient addFirst()
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // Add the node to the FRONT of the list
            result.addFirst(node.val);

            // Loop FORWARD through children
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return result;
    }
}