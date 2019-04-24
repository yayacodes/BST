
import java.util.*;
import java.io.*;


public class SortedSet {
	
	
	//BST constructor
	SortedSet(){
		root = null;
	}
	
	//initialization
	static int[] newArray;
	static Node root;
	static SortedSet BST = new SortedSet();
	
	
	/***check if it is empty***/
	public static boolean isEmpty(){
		if (root == null){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	/******Contains functions *******/
	public void add(int value){
		root = addRecersively(root, value);
	}
	
	public static Node addRecersively(Node current, int value){
		
		if(current == null){
			current = new Node(value);
			return current;
		}
		
		if(value < current.element){
			current.left = addRecersively(current.left, value);
		}
		else if(value > current.element){
			current.right = addRecersively(current.right, value);
		}
		else{
			return current;
		}

		return current;
	}
	

	/******Contains functions *******/
	public boolean contains(int value){
		 return containsRecursively(root, value);
	}
	
	public static boolean containsRecursively(Node current, int value){
		if(current == null)
			return false;
		if(current.element == value)
			return true;
		
		if(current.element > value)
			return containsRecursively(current.left, value);
		
		return containsRecursively(current.right, value);
	}
	

	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		Scanner input = new Scanner(new File("infile.dat"));
		String[] array = input.nextLine().split(",");
		
		newArray = new int[array.length];
		
		for(int i = 0; i < array.length; i ++){
			newArray[i] = Integer.valueOf(array[i].trim());
		}
		
		System.out.print("Sorted Set A Contains ");
		
		for(int i = 0; i < newArray.length; i++){ //print sorted array as well as populate BST		
			BST.add(newArray[i]);
			if(i == newArray.length - 1){
				System.out.print(newArray[i]);
			}
			
			else{
				System.out.print(newArray[i] + ", ");
			}
		}
		System.out.println();


		System.out.printf("User Input = ");
		int user_input = scan.nextInt();
		System.out.println();
		//check if input is in BST
		if(BST.contains(user_input) == true)
			System.out.println("Yes");
		
		if(BST.contains(user_input) == false)
			System.out.println("No");
	}
}


class Node{
	
	int element;
	Node left;
	Node right;
	
	Node(int e){
		element = e;
		right = null;
		left = null;
	}
}


