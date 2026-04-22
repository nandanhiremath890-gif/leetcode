class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node curr = root;

        while (curr != null) {
            Node dummy = new Node(0); // dummy node for next level
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next; // move within same level
            }

            curr = dummy.next; // move to next level
        }

        return root;
    }
}