package app;

public class AVLTree <T extends Comparable<T>> implements BSTInterface<T> {
		protected BSTNode<T> root;
		private int size;

		public AVLTree() {
			root = null;
			size = 0;
		}

		public boolean isEmpty() {
			// DO NOT MODIFY
			return root == null;
		}

		public int size() {
			// DO NOT MODIFY
			return size;
		}

		public BSTNode<T> getRoot() {
			// DO NOT MODIFY
			return root;
		}
		
		public void printTree() {
			System.out.println("------------------------");
			if (root != null) root.printSubtree(0);
		}

		public boolean remove(T element) {
			// Do not need to implement this method.
			return false;
		}

		public T get(T element) {
			// Do not need to implement this method.
			return null;
		}

		public int height() {
			return height(this.root);
		}

		public int height(BSTNode<T> node) {
			// return the node height
			return node != null ? node.getHeight() : -1;
		}
		
		public void updateHeight(BSTNode<T> node) {
			
				// TODO: update node height to 1 + the maximal height between left and right subtree
				int lstHeight = -1;
				if(node.getLeft() != null){
					lstHeight = node.getLeft().getHeight();
				}
				int rstHeight = -1;
				if(node.getRight() != null){
					rstHeight = node.getRight().getHeight();
				}
				node.setHeight(1 + Math.max(lstHeight,rstHeight));

		}	
		
		public int balanceFactor(BSTNode<T> node) {
			
				// TODO: implement left rotation algorithm
				int lstHeight = -1;
				if(node.getLeft() != null){
					lstHeight = node.getLeft().getHeight();
				}
				int rstHeight = -1;
				if(node.getRight() != null){
					rstHeight = node.getRight().getHeight();
				}

				return rstHeight - lstHeight;
		}
		
		public BSTNode<T> rotateRight(BSTNode<T> node) {
			
				// TODO: implement right rotation algorithm
				BSTNode<T> LRChild = null;
				if(node.getLeft().getRight() != null){
					LRChild = node.getLeft().getRight();
				}
				if(node.getParent() != null){
					treeNewChild(node.getParent(), node, node.getLeft());
				}
				else{
					root = node.getLeft();
					root.setParent(null);
				}

				treeSetChildHelper(node.getLeft(), "right", node);
				treeSetChildHelper(node, "left",LRChild);
				return node.getParent();
		}







		public BSTNode<T> rotateLeft(BSTNode<T> node) {
				// TODO: implement left rotation algorithm
				BSTNode<T> RLChild = null;
				if(node.getRight().getLeft() != null){
					RLChild = node.getRight().getLeft();
				}
				if(node.getParent() != null){
					treeNewChild(node.getParent(), node, node.getRight());
				}
				else{
					root = node.getRight();
					root.setParent(null);
				}
				treeSetChildHelper(node.getRight(), "left", node);
				treeSetChildHelper(node, "right", RLChild);

				return node.getParent();
		}



		private boolean treeNewChild(BSTNode<T> parent, BSTNode<T> existingChild, BSTNode<T> newChild){
			if(parent.getLeft() == existingChild){
				return treeSetChildHelper(parent, "left", newChild);
			}
			else if(parent.getRight() == existingChild){
				return treeSetChildHelper(parent, "right", newChild);
			}
			return false;
		}


		public boolean treeSetChildHelper(BSTNode<T> parent, String wChild, BSTNode<T> child){
			if(!wChild.equals("left") && !wChild.equals("right")){
				return false;
			}
			if(wChild.equals("left")){
				parent.setLeft(child);
			}
			else {
				parent.setRight(child);
			}
			if (child != null){
				child.setParent(parent);
			}
			updateHeight(parent);
			return true;
		}


		public BSTNode<T> treeModification(BSTNode<T> node){
			updateHeight(node);
			if (balanceFactor(node) == 2){
				if(balanceFactor(node.getRight()) == -1){
					rotateRight(node.getRight());
				}
				return rotateLeft(node);
			}
			else if(balanceFactor(node) == -2){
				if (balanceFactor(node.getLeft()) == 1){
					rotateLeft(node.getLeft());
				}
				return rotateRight(node);
			}
			return node;
		}





		// When inserting a new node, updating the height of each node in the path from root to the new node.
		// Check the balance factor of each updated height and run rebalance algorithm if the balance factor
		// is less than -1 or larger than 1 with following algorithm
		// 1. if the balance factor is less than -1
		//    1a. if the balance factor of left child is less than or equal to 0, apply right rotation
	    //    1b. if the balance factor of left child is larger than 0, apply left rotation on the left child,
		//        then apply right rotation
		// 2. if the balance factor is larger than 1
		//    2a. if the balance factor of right child is larger than or equal to 0, apply left rotation
	    //    2b. if the balance factor of right child is less than 0, apply right rotation on the right child,
		//        then apply left rotation
		public void add(T t) {
			
			
				// TODO
				if(t == null){
					throw new NullPointerException();
				}
				BSTNode<T> node = new BSTNode<T> (t, null, null);
				if(root == null)
				{
					root = node;
					node.setParent(null);
					size++;
					return;
				}

				BSTNode<T> curr = root;
				while(curr != null){
					if(node.getData().compareTo(curr.getData())<0){
						if(curr.getLeft() == null){
							curr.setLeft(node);
							node.setParent(curr);
							curr = null;
						}
						else{
							curr = curr.getLeft();
						}
					}
					else{
						if(curr.getRight() == null){
							curr.setRight(node);
							node.setParent(curr);
							curr = null;	
						}
						else{
							curr = curr.getRight();
						}
					}
				}

				node = node.getParent();
				while(node != null)
				{
					treeModification(node);
					node = node.getParent();
				}
				size++;
		}


		public static void main(String[] args) {
			BSTInterface<String> avlTree = new AVLTree<String>();
			// add a few nodes
			avlTree.add("M");
			avlTree.add("D");
			avlTree.add("A");
			avlTree.printTree();
            // add more code to test- use the debugger as well.

		}

	}
