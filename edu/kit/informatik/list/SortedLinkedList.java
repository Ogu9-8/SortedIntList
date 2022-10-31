package edu.kit.informatik.list;

/**
 * Implements a sorted doubly-linked list for {@code integer} values.
 * 
 * @author Oguz Han Yazici
 * @version 1.0
 */
public final class SortedLinkedList {
    
    /**
     * The index of a {@code non-existent} element.
     */
    private static final int NO_SUCH_ELEMENT = -1;
    
    /**
     * The first element of this list.
     */
    private Node first;
    
    /**
     * The last element of this list.
     */
    private Node last;
    
    /**
     * The current number of elements.
     */
    private int size;
    
    /**
     * Creates a new empty sorted linked list.
     */
    public SortedLinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }
    
    /**
     * Unlinks an {@code element node}. In other words, removes
     * the specified node from this list.
     * @param n The node to remove.
     * @return a message describing this operation.
     */
    private String unlink(Node n) {
        if (n.value == this.first.value) {
            this.first = this.first.next;
            if (this.first != null) this.first.prev = null;
            n.next = null;
        } else if (n.value == this.last.value) {
            this.last = this.last.prev;
            this.last.next = null;
            n.prev = null;
        } else {
            final Node prev = n.prev;
            final Node next = n.next;
        
            prev.next = next;
            next.prev = prev;
        
            n.prev = n.next = null;
        }
        this.size--;
        return "Successfully removed the element " + n.value + "!";
    }
    
    /**
     * @return the current number of elements inside this list.
     */
    public int size() {
        return this.size;
    }
    
    /**
     * @return {@code true} if this list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
         return this.size == 0;
    }

    /**
     * Checks if this list contains the specified element.
     * 
     * @param i The element to check.
     * @return {@code true} if this list contains the element,
     *  otherwise {@code false}.
     */
    public boolean contains(int i) {
        return indexOf(i) != NO_SUCH_ELEMENT;
    }
    
    /**
     * Adds the given element {@code i} to this list and returns
     * a message describing this operation.
     * 
     * @param i The element to add.
     * @return a message containing the state of this operation.
     */
    public String add(int i) {
        if (isEmpty()) {
            this.first = this.last = new Node(i, null, null);
        //If i is the biggest number, just append it.
        } else if (i > this.last.value) {    
            Node add = new Node(i, this.last, null);
            this.last.next = add;
            
            this.last = add;
        //If i is the smallest number, insert it at the front.
        } else if (i < this.first.value) {
            Node add = new Node(i, null, this.first);
            this.first.prev = add;
            
            this.first = add;
        } else {
            Iterator iter = new Iterator();
            Node current = iter.next();
            while(iter.hasNext() && current.next.value < i) {
                current = iter.next();
            }

            final Node next = current.next;
            
            Node add = new Node(i, current, next);
            current.next = add;
            next.prev = add;
        }
        
        this.size++;
        return "Added " + i + " to the list!";
    }
    
    /**
     * Returns the index of the <b>first occurence</b> of this
     * element. If the element does not exist, {@code -1} is returned.
     * 
     * @param i The element to get the index of.
     * @return the index of the element.
     */
    public int indexOf(int i) {
    	if (isEmpty())
    	    return NO_SUCH_ELEMENT;
        if (i == this.first.value)
            return 0;
        else if (i == this.last.value)
            return this.size - 1;
        
        int index = 0;
        for (Node n = this.first; n != null; n = n.next) {
            if (n.value == i)
                return index;
           index++;
        }
        return NO_SUCH_ELEMENT;
    }
    
    /**
     * Returns the index of the <b>last occurence</b> of this
     * element. If the element does not exist, {@code -1} is returned.
     * 
     * @param i The element to get the index of.
     * @return the index of the element.
     */
    public int lastIndexOf(int i) {
        int index = this.size - 1;
        for (Node n = this.last; n != null; n = n.prev) {
            if (n.value == i)
                return index;
            index--;
        }
        return NO_SUCH_ELEMENT;
    }
    
    /**
     * Removes the element {@code i}, if it <b>exists</b>. Returns a message
     * describing the result of the operation. 
     * 
     * @param i The element to remove.
     * @return whether the element was successfully removed or not.
     */
    public String remove(int i) {
        for (Node n = this.first; n != null; n = n.next) {
            if (n.value == i)
                return unlink(n);
            
        }
        return "The element " + i + " did not exist, so it was not removed!";
    }
    
    /**
     * Removes the element at the specified {@code index i} and
     * returns a descriptive message of the operation.
     * 
     * @param i The index of the element to remove.
     * @return a message if this operation was successful.
     * @throws IndexOutOfBoundsException If the index is invalid.
     */
    public String removeIndex(int i) {
        if (i < 0 || i >= this.size)
            throw new IndexOutOfBoundsException(i);
        
        Iterator iter = new Iterator();
        Node n = iter.next();
        int index = 0;
        while (index < i && iter.hasNext())  {
            n = iter.next();
            index++;
        }
        
        return unlink(n);
    }
    
    /**
     * Removes {@code all elements} from this list.
     */
    public String clear() {
        this.first = this.last = null;
        this.size = 0;
        
        return "Removed all elements from this list.";
    }
    
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        final StringBuilder sb = new StringBuilder("[");
        Iterator iter = new Iterator();
        
        for (;;) {
            final int i = iter.next().value;
            sb.append(i);
            if (!iter.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
    
    /**
     * An internal {@code iterator} to traverse the {@linkplain Node nodes}
     * of this list.
     */
    private class Iterator {
        /** The starting node. */
        private Node node;
        
        Iterator() {
            this.node = first;
        }
        
        /**
         * @return {@code true} if there is still elements left
         *  to traverse.
         */
        boolean hasNext() {
            return this.node != null;
        }
        
        /**
         * Moves the iterator to the next {@code node} inside this
         * list and returns the previous node.
         * 
         * @return the node the iterator previously pointed at.
         */
        Node next() {
            final Node old = this.node;
            this.node = this.node.next;
            return old;
        }
    }
    
    /**
     * An internal class representing a {@code node} inside
     * the list.
     */
    private class Node {
        private Node next;
        private Node prev;
        private int value;
        
        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}