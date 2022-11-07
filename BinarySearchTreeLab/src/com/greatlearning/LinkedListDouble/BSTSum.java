package com.greatlearning.LinkedListDouble;

import java.util.ArrayList;
import java.util.Scanner;

public class BSTSum {
	ArrayList<Integer> nodelist = new ArrayList<>();
	public static Node newNode(int z) 
	{
		Node temp = new Node();
		temp.left =null;
		temp.data = z;
		temp.right = null;
		return temp;
	}
	public static void insert(Node root, Node nn)
	{
		if(nn.data< root.data) 
		{
			if(root.left == null)
			{
			root.left = nn;
			}
			else 
			{
				insert(root.left,nn);
			}
		}
		else {
			if(root.right == null)
			{
			root.right = nn;
			}
			else {
				insert(root.right,nn);
			}
			
		}
	}
	//function to perform inlist traversal
	private void traverse(Node root) {
		if(root!= null)
		{
		traverse(root.left);
		nodelist.add(root.data);
		traverse(root.right);
		}
	}
	public static void main(String args[]) {
		Node root = null;
		Node nn = null;
		BSTSum bst = new BSTSum();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Nodes");
		int k =  sc.nextInt();
		int i;
		for(i=1;i<=k;i++) {
			System.out.println("Enter Data");
			int n=sc.nextInt();
			nn = newNode(n);
			if(root == null) {
				root = nn;
			}
			else 
			{
				bst.insert(root,nn);
			}
		}
		bst.traverse(root);
		System.out.println("Enter Sum");
		int sum = sc.nextInt();
		int flag=0;
		for(i=0; i<bst.nodelist.size();i++) {
			if(bst.nodelist.contains(sum-bst.nodelist.get(i)))
			{
				int a = bst.nodelist.get(i);
				int b = sum-bst.nodelist.get(i);
				System.out.println("Pair found [" +a +"," +b+"]");
				flag =1;
				break;
			}
		}
		if(flag == 0) 
		{
				System.out.println("Pair not found");
			
		}
	}
	
	
}