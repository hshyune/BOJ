import java.io.*;

class Node {
	String name;
	Node left, right;

	public Node(char name) {
		this.name = String.valueOf(name);
		left = null;
		right = null;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
			int n = Integer.parseInt(br.readLine());
			Node[] tree = new Node[n];
			for (int i = 0; i < n; i++) {
				tree[i] = new Node((char) ('A' + i));
			}

			for (int i = 0; i < n; i++) {
				String[] sp = br.readLine().split(" ");
				int index = sp[0].charAt(0) - 'A';
				Node cur = tree[index];
				if (!sp[1].equals(".")) {
					index = sp[1].charAt(0) - 'A';
					cur.left = tree[index];
				}
				if (!sp[2].equals(".")) {
					index = sp[2].charAt(0) - 'A';
					cur.right = tree[index];
				}
			}

			preorder(tree[0]);
			System.out.println();
			inorder(tree[0]);
			System.out.println();
			postorder(tree[0]);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void preorder(Node n) {
		System.out.print(n.name);
		if (n.left != null)
			preorder(n.left);
		if (n.right != null)
			preorder(n.right);
	}

	public static void inorder(Node n) {
		if (n.left != null)
			inorder(n.left);
		System.out.print(n.name);
		if (n.right != null)
			inorder(n.right);
	}

	public static void postorder(Node n) {
		if (n.left != null)
			postorder(n.left);
		if (n.right != null)
			postorder(n.right);
		System.out.print(n.name);
	}

}
