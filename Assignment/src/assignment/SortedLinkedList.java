package assignment;

import assignment.SortedListInterface;
import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {

  private Node firstNode;
  private int count;

  public SortedLinkedList() {
    firstNode = null;
    count = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);

    Node beforeNode = null;
    Node currentNode = firstNode;
    while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
      beforeNode = currentNode;
      currentNode = currentNode.next;
    }

    if ( (beforeNode == null) || isEmpty()) { // CASE 1: add at beginning
      newNode.next = firstNode;
      firstNode = newNode;
    } else {	// CASE 2: add in the middle or at the end, i.e. after beforeNode
      newNode.next = currentNode;
      beforeNode.next = newNode;
    }
    count++;
    return true;
  }

  @Override
  public boolean delete(T anEntry) {
    if(isEmpty()){
       return false;
    }
    
    else{
        Node beforeNode=null;
        Node currentNode=firstNode;

        while(currentNode != null && currentNode.data.compareTo(anEntry)<0){
            beforeNode=currentNode;
            currentNode=currentNode.next;
        }
        if(currentNode.data.equals(anEntry)){
            if(currentNode==firstNode){
                firstNode = firstNode.next;
                count--;
            }
            else{
                beforeNode.next= currentNode.next;
                count--;
                
                }
            return true;
        }
    }
    return false;
    
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node tempNode = firstNode;

    while (!found && (tempNode != null)) {
      if (anEntry.compareTo(tempNode.data) <= 0) {
        found = true;
      } else {
        tempNode = tempNode.next;
      }
    }
    if (tempNode != null && tempNode.data.equals(anEntry)) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
    public boolean modify(T oldEntry, T newEntry){
        if(delete(oldEntry)){
            add(newEntry);
            return true;
        }
        else
            return false;
    }

  @Override
  public int getTotal() {
    return count;
  }

  @Override
  public boolean isEmpty() {
    return (count == 0);
  }

  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

    @Override
    public Iterator<T> getIterator() {
      return new ListIterator(); 
      
    }
    
    private class ListIterator implements Iterator<T>{
        Node currentNode = firstNode;
        @Override
        public boolean hasNext() {
            return currentNode != null; //checked the list got data or not
        }

        @Override
        public T next() {
            T currentData = null;
            if(hasNext()){
                currentData = currentNode.data;
                currentNode = currentNode.next;
                
            }
            return currentData;
        }
    
    }

    

  
  

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}