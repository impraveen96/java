/*
Balbir singh is working with Binary Trees.
The elements of the tree is given in the level order format.
Balbir is looking the tree from right side. 
So, he can view only rightmost nodes only (one node per level).

You will be given the root of the binary tree.
Your task is to find the nodes which can be viewed by Balbir from right side.
And print the nodes from top to bottom order.

Your task is to implement the class Solution:
	- public List<Integer> rightSideView(BinaryTreeNode root):
	return the list of node values.
	
NOTE: 
Please do consider the node with data=-1 as null node in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
1 2 3 5 -1 -1 5

Sample Output-1:
----------------
[1, 3, 5]



Sample Input-2:
---------------
3 2 4 3 2

Sample Output-2:
----------------
[3, 4, 2]


******* Testcases *******
case =1
input =1 2 3 5 -1 -1 5
output =[1, 3, 5]

case =2
input =3 2 -1 1 -1 -1 -1 4 5
output =[3, 2, 1, 5]

case =3
input =1 2 3 4 5 -1 7 8 9 10 11 -1 -1 -1 -1 16 17 18 19 20 21 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 32 33 -1 35 36
output =[1, 3, 7, 11, 21, 36]

case =4
input =7 4 3 5 6 2 3 8 4 5 6 7 5 5 6
output =[7, 3, 3, 6]

case =5
input =7 4 3 5 6 2 -1 8 4 5 6 7
output =[7, 3, 2, 7]

case =6
input =1 2 -1 3 4 -1 -1 5 -1 -1 -1 -1 -1 -1 -1 -1 6 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 4 8
output =[1, 2, 4, 5, 6, 8]

case =7
input =1 2 3 4 5 6 -1 12 14 13 -1 -1 15
output =[1, 3, 6, 15]

case =8
input =1 2 3 4 5 6 7 15 14 13 12 10 11 9 7
output =[1, 3, 7, 7]

*/

import java.util.*;

class BinaryTree
{
	public int val; 
	public BinaryTree left, right; 
	public BinaryTree(int val){
		this.val = val; 
		left = null; 
		right = null; 
	}
}

public class RightSideView 
{
	static BinaryTree root;
	static BinaryTree temp = root;
	void insert(BinaryTree node, int key)
    { 
        if (node == null) {
            node = new BinaryTree(key);
            return;
        }
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.add(node);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
            node = q.remove();
 
            if (node.left == null) {
                node.left = new BinaryTree(key);
                break;
            }
            else
                q.add(node.left);				 
 
            if (node.right == null) {
                node.right = new BinaryTree(key);
                break;
            }
            else
                q.add(node.right);
        }
	}

	public List<Integer> rightSideView(BinaryTree root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(BinaryTree curr, List<Integer> result, int currDepth){
		if(curr == null || curr.val == -1)
		{
            return;
        }
        if(currDepth == result.size())
		{
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);       
    }

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(" ");
		RightSideView rsv  =new RightSideView();
		root = new BinaryTree(Integer.parseInt(str[0]));

		for(int i = 1; i < str.length; i++)
			rsv.insert(root,Integer.parseInt(str[i]));

		System.out.println(rsv.rightSideView(root));
	}
}