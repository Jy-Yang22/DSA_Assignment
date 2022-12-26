package assignment;

import java.util.Iterator;
        
public interface SortedListInterface<T extends Comparable<T>> {


  public boolean add(T newEntry); // add new entry to the sorted linked list.

  public boolean delete(T anEntry);  //remove anEntry in a specific position.

  public boolean contains(T anEntry); //check whether the input contains the same as anEntry
  
  public boolean modify(T oldEntry, T newEntry); //remove oldEntry then replace it with newEntry.

  public int getTotal(); //get the total number of entries inside the sorted linked list.

  public boolean isEmpty(); //check whether the sorted linked list is empty.
  
  public Iterator<T> getIterator(); //an abstract method that return Iterator as return value.

} 
