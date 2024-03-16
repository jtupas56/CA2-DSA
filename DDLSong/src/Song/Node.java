/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Song;

/**
 *
 * @author joshuatupas
 */

public class Node {
    private Object element;
    private Node next, prev;

    // Constructor with the element and the next and previous nodes
    public Node(Object element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    // Getter and setter methods for the element and the next and previous nodes
    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    // Returns a toString of the node
    @Override
    public String toString() {
        return "Node{" + " element= " + element + '}';
    }
}
