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
        head = new Node<>(null);
        size = 0;
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String stringRepresentation = "";
        Node<T> currNode = head;
        
        while(currNode.getNext() != null){
            stringRepresentation += currNode.getData() + " ";
            currNode = currNode.getNext();
        }
        stringRepresentation += currNode.getData();

        return stringRepresentation;
    }

    public boolean contains(Object o){
        Node<T> currNode = head;
        int currIndex = 0;
    
        for(currIndex = 0; currIndex<size; currIndex++){
            if (currNode.getData().equals(o)){
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }
        

    public void add(T item){
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public T get(int index){
        int currIndex = 0;
        Node<T> currNode = head;
        while(currIndex < index){
            currNode = currNode.getNext();
            currIndex++;
        }
        return currNode.item;
    }

    public T remove(){
        T firstItem = head.getData();
        Node<T> secondNode = head.getNext();
        Node<T> thirdNode = secondNode.getNext();
        head = secondNode;
        head.setNext(thirdNode);
        size--;
        return firstItem;
    }

    
    public void add(int index, T item){
        Node<T> newNode = new Node<>(item);
        Node<T> currNode = head;
        int currIndex = 0;

        if(index==0){
            add(item);
        }
        else{
            for(currIndex = 0; currIndex <= index-1; currIndex++){
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
            size++;
        }
    }

    public T remove(int index){
        Node<T> prevNode = null;
        Node<T> currNode = head;
        int currIndex = 0;

        if(index==0){
            return remove();
        }
        else{
            for(currIndex = 0; currIndex < index; currIndex++){
                prevNode = currNode;
                currNode = currNode.getNext();
            }
            T removedItem = currNode.getData();
            prevNode.setNext(currNode.getNext());
            size--;
            return removedItem;
        }
    }
    public boolean equals(Object o){
        if (!(o instanceof LinkedList)){
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList oAsALinkedList = (LinkedList) o;
        // Now I have a reference to something Java knows is a LinkedList!

        Node<T> currNodeList = head;
        Node<T> currNodeO = oAsALinkedList.head;

        for (int i=0; i<size; i++){
            if(currNodeList.getData()!=currNodeO.getData()){
                return false;
            }
            currNodeList = currNodeList.getNext();
            currNodeO = currNodeO.getNext();
        }
        return true;
    }
    

    private static class Node<T>{
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