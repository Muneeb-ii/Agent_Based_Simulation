/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Linked List
 */

import java.util.Iterator;    // defines the Iterator interface

public class LinkedList<E>{

    private Node head;
    private int size;

    public LinkedList(){
        clear();
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        if (head==null){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String stringRepresentation = " ";
        Node currNode = head;
        
        while(currNode.next != null){
            stringRepresentation += currNode.item + "";
            currNode = currNode.next;
        }

        return stringRepresentation;
    }

    private class Node<T>{
        private Node next;
        private T item;

        public Node(T item){
            next = null;
            this.item = item;
        }

        public T getData(){
            return this.item;
        }

        public void setNext (Node n){
            next = n;
        }

        public Node getNext(){
            return next;
        }
    }
}