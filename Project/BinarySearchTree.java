package Project;

import java.util.Stack;
import java.util.Vector;
import java.util.Iterator;

// This class contains the function to build a binary search tree of object Node
public class BinarySearchTree {
	
	static Node root;

	// takes an object Node as argument and put it in the Binary tree
	public void insert(Node n){
		int ones = n.ones;
		int[] hc = n.hashcode;
		int nb = n.imgNumber;
		Node newNode = new Node(ones, nb, hc);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(ones<current.ones){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	// prints the tree from leftmost value to rightmost value
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.imgNumber);
			display(root.right);
		}
	}
	
	// counts the number of one in the array and compares it to the entered error percent 
	public static boolean errorCount(int[] array, int error) {
		int errorCount = 0;
		for (int i = 0 ; i < array.length ; i++) {
			if (array[i] == 1) {
				errorCount +=1;
			}
		}
		if (errorCount <= error*(array.length)/100) {
			return true;
		} else {
			return false;
		}
	}
	
	// compare two arrays, it is the equivalent of the logical XOR, 
	//  A	B	Y
	//	0	0	0		|0-0| = 0
	//	0	1	1		|0-1| = 1
	//	1	0	1		|1-0| = 1
	//	1	1	0		|1-1| = 0
	public static boolean compare (int[] hash1, int[] cue, int error) {
		int[] xor = new int[cue.length];
		for(int i = 0 ; i<cue.length ; i++) {
			xor[i] = Math.abs(hash1[i] - cue[i]);
		}
		if (errorCount(xor, error) == true) {
			return true;
		} else {
			return false;
		}
	}
	
	// Apply a modified DFS to the binary search tree, it also adds the Node object to similarVector if the Node object passes the test of the compare function
	public Vector<Integer> DFS(Node root, int[] cue, int error) {
		Vector<Integer> similarVector = new Vector<Integer>();
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if (compare(x.hashcode, cue, error ) == true) {
				similarVector.addElement(x.imgNumber);
			}
			if(x.right!=null) {
				s.add(x.right);
			}
			if(x.left!=null) {
				s.add(x.left);			
			}
		}
		return similarVector;
	}
	
	// prints a given vector
	public static void printVector(Vector<Integer> v) {
		Iterator i = v.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
    
}