package Project;

// this class will allow us to create Node objects that represents the images in the BST
public class Node {

	int imgNumber;
	int ones;
	int[] hashcode;
	Node left;
	Node right;
	
	public Node (int count, int img, int[] hash) {
		ones = count;
		imgNumber = img;
		hashcode = hash;
		left = right = null;
	}
	
}