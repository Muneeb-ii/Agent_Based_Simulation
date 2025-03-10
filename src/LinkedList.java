/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Linked List
 */

public class LinkedList<T>{

    private Node<T> head;
    private int size;

    /**
     * Constructor for the LinkedList class
     */
    public LinkedList(){
        clear();
    }

    /**
     * Returns the size of the linked list
     */
    public int size(){
        return size;
    }

    /**
     * Clears the linked list
     */
    public void clear(){
        head = new Node<>(null);
        size = 0;
    }

    /**
     * Returns true if the linked list is empty, false otherwise
     * 
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns a string representation of the linked list
     * 
     * @return a string representation of the linked list
     */
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

    /**
     * Returns true if the linked list contains the object o, false otherwise
     * @param o the object to be checked
     * @return true if the linked list contains the object o, false otherwise
     */
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
        
    /**
     * Adds an item to the linked list
     * @param item the item to be added
     */
    public void add(T item){
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    /**
     * Returns the item at the specified index
     * @param index the index of the item to be returned
     * @return the item at the specified index
     */
    public T get(int index){
        int currIndex = 0;
        Node<T> currNode = head;
        while(currIndex < index){
            currNode = currNode.getNext();
            currIndex++;
        }
        return currNode.item;
    }

    /**
     * Removes the first item from the linked list
     * @return the first item from the linked list
     */
    public T remove(){
        T firstItem = head.getData();
        Node<T> secondNode = head.getNext();
        Node<T> thirdNode = secondNode.getNext();
        head = secondNode;
        head.setNext(thirdNode);
        size--;
        return firstItem;
    }

    /**
     * Adds an item to the linked list at the specified index
     * @param index the index at which the item is to be added
     * @param item the item to be added
     */
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

    /**
     * Removes the item at the specified index
     * @param index the index of the item to be removed
     * @return the item at the specified index
     */
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

    /**
     * Returns true if the linked list is equal to the object o, false otherwise
     * @param o the object to be compared
     * @return true if the linked list is equal to the object o, false otherwise
     */
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
    
    /**
     * A private class representing a node in the linked list
     * @param <T> the type of the item stored in the node
     */
    private static class Node<T>{
        private Node<T> next;
        private T item;

        /**
         * Constructor for the Node class
         * @param item  the item to be stored in the node
         */
        public Node(T item){
            next = null;
            this.item = item;
        }

        /**
         * Returns the item stored in the node
         * @return the item stored in the node
         */
        public T getData(){
            return this.item;
        }

        /**
         * Sets the item stored in the node
         * @param item the item to be stored in the node
         */
        public void setNext (Node<T> n){
            next = n;
        }

        /**
         * Returns the next node in the linked list
         * @return the next node in the linked list
         */
        public Node<T> getNext(){
            return next;
        }
    }
}