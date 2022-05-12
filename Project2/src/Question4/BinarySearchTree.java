/**
 * Joseph de la Viesca
 * CSC 201
 * Project 2, Question 4
 * 3/25/22
 */
package Question4;

public class BinarySearchTree { 
  class TreeNode{
        int item;
        TreeNode left;
        TreeNode right;

        TreeNode(int item){
            this.item = item;
            this.left = null;
            this.right = null;

        }

    }
    private static TreeNode root;

    //Takes an array sorted in decreasing order and converts it to a binary search tree
    public TreeNode arrayToTree(int array[], int low, int high){
        if(low > high){
            return null;
        }

        //Set middle element of array as the root
        int mid = (low + high)/2;
        TreeNode node = new TreeNode(array[mid]);

        //Recursively call arrayToTree on the right side of the array to create the
        //left side of the tree so the nodes on the left side of the tree will be less
        //than the root.
        node.left = (arrayToTree(array, mid + 1, high));
        //Recursively call arrayToTree on the left side of the array to create the
        //right side of the tree so the nodes on the right side of the tree will be greater
        //than the root.
        node.right = (arrayToTree(array, low, mid - 1));

        return node;
    }

   
    public void preorderTraversal(TreeNode root){
        if(root == null){
           return; 
        }
        System.out.print(root.item + " ");
        //Visit root then traverse left then right
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
    }
    public void postorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        //Traverse left then right then visit root
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.item + " ");
        
    }
    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        //Traverse left, visit root, then raverse right
        inorderTraversal(root.left);
        System.out.print(root.item + " ");
        inorderTraversal(root.right);
        
    }

}
