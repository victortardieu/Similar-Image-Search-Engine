package Project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.Raster;

// In this class we will have the functions that will produce the hashcode of a given image
public class Image {
	
	// it creates a virtual window that will move through the image matrix to get the average value of predefined patches
	public static int[] windowPatch (int patch, int width, int arr[][]) {
		int[][] imgArr = arr;
		// holds from where the next patch should start
		int tempC = 0;
		// holds from where the next patch should start
		int tempR = 0;
		int sum = 0;
		// average value of the current patch
		int avg = 0;
		// to move each time to the next empty slot in avgArray
		int counter = 0 ;
		int[] avgArr = new int[(width/patch)*(width/patch)];
		for (int rows = 1 ; rows<=width/patch ; rows++) {
			tempC = 0 ;
			for (int columns = 1 ; columns<=width/patch ; columns++) {
				for (int i = tempR ; i<=(rows*patch)-1 ; i++){
					for (int j = tempC ; j<=(columns*patch)-1 ; j++) {
						sum+=imgArr[i][j];
					}
				}
				avg = sum/(patch*patch);
				tempC = (patch*columns);
				avgArr[counter++] = avg;
				sum = 0;
			}
			tempR = (patch*rows);
		}
		return avgArr;
	}
	
	// prints a 1 dimension array
	public static void print(int[] array) {
		for (int i = 0 ; i<array.length ; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
		
	// Sort the given array from min to max
	public static int[] sort(int[] array){
		Arrays.sort(array);
		return array;
	}
	
	
	// Finds the median in the given array
	public static int median (int[] array) {
		int median;
		if (array.length % 2 == 0) {
		    median = ((int)array[array.length/2] + (int)array[array.length/2 - 1])/2;
		} else {
		    median = (int) array[array.length/2];
		}
		System.out.println("Median is " + median);
		return median;
	}
	
	// Generates the image hashcode
	public static int[] hashcode(int[] array, int median) {
		for (int i = 0 ; i<array.length ; i++){
			if (array[i] >= median){
				array[i] = 1;
			} else { 
				array[i] = 0;
			}
		}
		return array;
	}

	// loads the image into the java program
	public static int[][] load(String name) throws IOException{
		
		File file = new File (name);
		BufferedImage img = ImageIO.read(file);
		int width = img.getWidth();
		int height = img.getHeight();
		int[][] imgArr = new int[width][height];
		Raster raster = img.getData();
		for (int j = 0 ; j<width ; j++) {
			for (int k = 0 ; k<height ; k++) {
				imgArr[j][k] = raster.getSample(j, k, 0);
			}
		}
		return imgArr;
	}
	
	// this function takes all the above functions and use them to print the hashcode
	public static int[] hash (int patch, int width, int[][] array) {
		System.out.println("Average array: ");
		print(windowPatch(patch, width, array));
		
		System.out.println("Sorted Array ");
		print(sort(windowPatch(patch, width,array)));
		
		int m = median(sort(windowPatch(patch, width, array)));
		
		System.out.println("Hashcode of the image: ");
		print(hashcode(windowPatch(patch, width,array), m));
		
		return (hashcode(windowPatch(patch, width,array), m));
	}
	
	// counts the number of ones in the array
	public static int oneCount(int[]array) {
		int count = 0 ;
		for (int i = 0 ; i < array.length ; i++) {
			if (array[i] == 1) {
				count++;
			}
		}
		return count;
	}
	
}
