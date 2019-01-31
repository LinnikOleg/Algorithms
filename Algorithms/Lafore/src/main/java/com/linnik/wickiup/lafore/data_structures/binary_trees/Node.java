package com.linnik.wickiup.lafore.data_structures.binary_trees;

/**
 * @author LinnykOleh
 */
public class Node {

    int iData;
    double dData;
    Node leftChild;
    Node rightChild;

    public void displayNode(){
        System.out.println("(" + iData + " " + dData + ") ");
    }

}
