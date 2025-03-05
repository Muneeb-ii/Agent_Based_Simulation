/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Linked List
 */

public class LinkedList<T>{

    private Node<T> head;
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
        Node<T> currNode = head;
        
        while(currNode.next != null){
            stringRepresentation += currNode.item + "";
            currNode = currNode.next;
        }

        return stringRepresentation;
    }

    public boolean contains(Object o){
        Node<T> currNode = head;
        
        while(currNode.next != null){
            if (currNode.item.equals(o)){
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void add(T item){
        Node<T> newNode = new Node(item);
        newNode.next = head.next;
        head.next = newNode;
    }

    public T get(int index){
        int currIndex = 0;
        Node<T> currNode = head;
        while(currIndex < index){
            currNode = currNode.next;
            currIndex++;
        }
        return currNode.item;
    }

    private class Node<T>{
        private Node<T> next;
        private T item;

        public Node(T item){
            next = null;
            this.item = item;
        }

        public T getData(){
            return this.item;
        }

        public void setNext (Node<T> n){
            next = n;
        }

        public Node<T> getNext(){
            return next;
        }
    }
}