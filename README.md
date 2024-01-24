The objective of my project is to deepen understanding and proficiency in Java, focusing on tree data structures like Binary Search Trees (BST) and AVL Trees. I aim to explore how these structures function and manage data, especially in terms of insertion, deletion, and balancing algorithms in AVL Trees.

<br>

The AVLTree.java is an implementation of an AVL Tree, a type of binary search tree. Here's an overview of its key functionalities:
<br>
Class Declaration: AVLTree class that implements the BSTInterface.
<br>
Properties:
<br>
root: Root node of the tree.
<br>
size: Tracks the number of elements in the tree.
<br>
Constructor: Initializes an empty AVL Tree.
<br>

Methods:
<br>
isEmpty(): Checks if the tree is empty.
<br>
size(): Returns the size of the tree.
<br>
getRoot(): Retrieves the root node.
<br>
printTree(): Prints the tree structure.
<br>
remove(T element): A placeholder for remove functionality (not implemented).
<br>
get(T element): A placeholder for get functionality (not implemented).
<br>
height(): Calculates the height of the tree.
<br>
updateHeight(BSTNode<T> node): Updates the height of a given node.
<br>
balanceFactor(BSTNode<T> node): Computes the balance factor of a node for rotations.
<br>
rotateRight(BSTNode<T> node): Performs a right rotation on a node.

<br>
<br>

The BSTInterface.java file defines an interface for binary search trees (BST).
<br>


Methods:
<br>
isEmpty(): Checks if the tree contains no elements.
<br>
size(): Returns the number of elements stored in the tree.
<br>
remove(T element): Attempts to remove one copy of an element from the tree. Throws a NullPointerException if the element is null.
<br>
get(T element): Returns the element in the tree that equals the argument, or null if no such element exists. Throws a NullPointerException if the element is null.
<br>
add(T element): Adds an element to the tree, ensuring the tree still obeys the BST rule. Throws a NullPointerException if the element is null.
<br>
height(): Returns the height of the tree, or -1 if the tree is empty.
<br>
getRoot(): Returns the root BSTNode of this tree. This is a utility method for grading and testing.
<br>
printTree(): Prints a string representation of the tree.

<br>
<br>

The BSTNode.java file defines the structure of a node used in a binary search tree (BST). 

Class Declaration: BSTNode class with a generic type T that extends Comparable<T>.
<br>
<br>
Properties:
<br>
data: The data stored in the node.
<br>
height: The height of the node.
<br>
left: Reference to the left child node.
<br>
right: Reference to the right child node.
<br>
parent: Reference to the parent node.
<br>
<br>
Constructor:
<br>
Initializes a node with the given data, left and right children.
<br>
Sets the parent of the left and right children if they are not null.
<br>
Initializes the parent as null and height as 0.
<br>
<br>
Methods:
<br>
Getters and setters for data, height, left, right, and parent.
<br>
printSubtree(int spaces): A method to print the subtree rooted at this node, useful for visualizing the tree structure.
<br>







