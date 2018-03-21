package pers.li.model.structure.model_composite;

public class Tree {
      
        TreeNode root = null;  
      
        public Tree(String name) {  

            root = new TreeNode(name);
            System.out.println(root.toString());
        }  
      
        public static void main(String[] args) {  
            Tree tree = new Tree("A");  
            TreeNode nodeB = new TreeNode("B");  
            TreeNode nodeC = new TreeNode("C");  
              
            nodeB.add(nodeC);  
            tree.root.add(nodeB);

            System.out.println(tree.root.toString());
            System.out.println("build the tree finished!");
        }
    }  
