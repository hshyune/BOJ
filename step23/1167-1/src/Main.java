import java.io.*;
import java.util.*;

class Node {
	int num;
	Node parent;
	ArrayList<Node> child;
	int weight;

	public Node(int num) {
		this.num = num;
		this.parent = null;
		this.child = new ArrayList<Node>();
		weight = 0;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in, 1);
		int edges = Integer.parseInt(br.readLine());
		// set root node
		String[] sp = br.readLine().split(" ");
		Node root = new Node(1);
		
	}
//http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220961873786&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
}
