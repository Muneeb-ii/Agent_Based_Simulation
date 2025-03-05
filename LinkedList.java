/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Linked List
 */

import java.util.Iterator;    // defines the Iterator interface

public class LinkedList<E>{

    private class Node<T>{
        public Node next;
        public T item;

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