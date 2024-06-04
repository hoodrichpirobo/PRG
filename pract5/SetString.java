package pract5;
import java.util.Scanner;
/**
 * SetString class. Implementation of a set of String by means of 
 * a lexicographically ordered linked sequence.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Academic Year 2023/24)
 */
public class SetString {
    
    // TO COMPLETE ATTRIBUTES
    private NodeString first;
    private int size;
    
    /**
     * Constructor method that creates a new empty set.
     */
    public SetString() {
        // TO COMPLETE
        first = null;
        size = 0;
    }

    /**
     * Method that adds s to the set.
     * If s belongs to the set, the set itself remains unchanged.
     * @param s String
     */
    public void add(String s) {
        // TO COMPLETE
        int compare = -1;
        NodeString aux = first;
        NodeString prev = null;
        while(aux != null && compare < 0){
            compare = aux.data.compareTo(s);
            if(compare == 0) return;
            else if(compare < 0){
                prev = aux;
                aux = aux.next;
            }
        }

        if(prev == null) first = new NodeString(s,aux);
        else prev.next = new NodeString(s,aux);
        size++;    
    }
    
    /**
     * Checks if s belongs to the set.
     * @param s String.
     * @return returns true if and only if s belongs to the set..
     */
    public boolean contains(String s) {
        boolean answer = false;
        // TO COMPLETE
        for(NodeString i = first; i != null && !answer && i.data.compareTo(s) <= 0; i = i.next){
            if(i.data.compareTo(s) == 0) answer = true;
        }
        return answer;
    }

    /**
     * Removes s from the set
     * If s does not belong to the set, the set itself remains unchanged.
     * @param s String.
     */
    public void remove(String s) {
        // TO COMPLETE
        if(this.contains(s)){
            NodeString aux = first;
            NodeString prev = null;
            while(!(aux.data.compareTo(s) == 0)){
                prev = aux;
                aux = aux.next;
            }
            if(prev != null) prev.next = aux.next;
            else first = aux.next;
            aux = null;
            size--;
        }
    }
    
    /**
     * Returns the set size (or cardinal).
     * @return int the set size.
     */
    public int size() { 
        int result = 0;
        // TO COMPLETE
        NodeString aux = first;
        while(aux != null) {
            aux = aux.next;
            result++;
        }
        return result;
    }    
    
    /**
     * Returns the set resulting of the intersection of the current set 
     * and the argument set.
     * @param other SetString.
     * @return the resulting interseccion set.
     */
    public SetString intersection(SetString other) {
        SetString result = new SetString();
        // TO COMPLETE
        NodeString i1 = this.first;
        NodeString i2 = other.first;
        while(i1 != null && i2 != null){
            if(i1.data.equals(i2.data)){
                result.add(i1.data);
                i1 = i1.next;
                i2 = i2.next;
            }
            else if(i1.data.compareTo(i2.data) < 0){
                i1 = i1.next;
            }
            else if(i1.data.compareTo(i2.data) > 0){
                i2 = i2.next;
            }
        }
        
        return result;
    }
    
    /**
     * Returns the set resulting of the union of the current set and the 
     * argument set .
     * @param other SetString.
     * @return the resulting union set.
     */
    public SetString union(SetString other) {
        SetString result = new SetString();
        // TO COMPLETE
        NodeString i1 = this.first;
        NodeString i2 = other.first;
        
        while(i1 != null && i2 != null){
            if(i1.data.equals(i2.data)){
                result.add(i1.data);
                i1 = i1.next;
                i2 = i2.next;
            }
            else if(i1.data.compareTo(i2.data) < 0){
                result.add(i1.data);
                i1 = i1.next;
            }
            else if(i1.data.compareTo(i2.data) > 0){
                result.add(i2.data);
                i2 = i2.next;
            }
        }
        if(i1 == null){
            while(i2 != null){
                result.add(i2.data);
                i2 = i2.next;
            }
        }
        else{
            while(i1 != null){
                result.add(i1.data);
                i1 = i1.next;
            }
        }
        return result;
    }   
    
    /**
     * Method that returns a String with the set list of words 
     * in ascending order.
     * @return String with the list of words of the set
     */
    public String toString() {
        String result = "";
        NodeString aux = this.first;
        while (aux != null) {
            result += aux.data + "\n"; 
            aux = aux.next; 
        }
        return result;
    }
  
    /** 
     * Method that returns the SetString of the words read from 
     * Scanner s according to the separators by means of which
     * the Scanner has been configured.
     * @param s Scanner.
     * @return a new SetString of words read from Scanner s.
     */
    public static SetString setReading(Scanner s) {
        SetString setS = new SetString();
        while (s.hasNext()) {
            String word = s.next();
            setS.add(word);
        }
        return setS;
    }
    
}
