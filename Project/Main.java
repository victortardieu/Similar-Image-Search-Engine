package Project;

import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;

// This is the main class where we will use the functions from the different defined classes
public class Main {
	
	public static void main (String[] args) throws IOException {
	
		// IMAGE SIZE = 300*300
		int size = 300;
		
		int patch = 0 ;
		
		Scanner keyboard = new Scanner(System.in);
		
		// The user decides the patch size and the program checks if it is a common divider to the width and the length
		// Hardcode: 30 is a good size patch
		do {
			System.out.println("Enter the patch size");
			patch = keyboard.nextInt();
		} while (size%patch != 0);
		
		// Hardcode: 23
		System.out.println("Enter the number of images: ");
		int nbImages = keyboard.nextInt();
		
		// User decides which image will be the reference
		// WARNING: change the path if computer changes
		// Hardcode: 5 is a good choice
		System.out.println("What image is the cue? Image are called from 0 to " + (nbImages-1));
		int cue = keyboard.nextInt();
		System.out.println("Cue image: ");
		String name1 = "C:\\Users\\V_TARDIE\\Desktop\\352_Final_Project_Tardieu_40021309\\352 images\\P" + String.valueOf(cue) + ".jpg";
		int[][] image1 =Image.load(name1);
		int[] h1 = Image.hash(patch, 300, image1);
		
		// The user inputs the error margin
		// Hardcode: 10 is a good choice
		System.out.println("What is the error margin? ");
		int error = keyboard.nextInt();
		
		keyboard.close();
		
		// each string will contain the path to go to the image
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0 ; i < nbImages ; i++ ) {
			System.out.println("Image P" + i);
			String name = "G:\\My Documents\\352 images\\P" + String.valueOf(i) + ".jpg";
			int[][] image =Image.load(name);
			int[] h = Image.hash(patch, 300, image);
			System.out.println();
			Node n = new Node(Image.oneCount(h), i, h);
			bst.insert(n);
		}
		// prints the BST
		System.out.println("\nDisplay the tree from left to right");
    	bst.display(bst.root);
    	
    	// prints similar images with the given parameters
    	System.out.println("\nSimilar images:");
    	Vector<Integer> similarVector = bst.DFS(bst.root, h1, error);
    	BinarySearchTree.printVector(similarVector);

	}
	
}
