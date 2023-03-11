import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class BitSetTest {
    BitSet bitSet;

    @Test
    void addElement(){
        bitSet = new BitSet(5);
        bitSet.addElement(1);
        bitSet.addElement(2);
        bitSet.addElement(3);
        bitSet.addElement(4);
        bitSet.addElement(5);
        assertEquals(5, bitSet.counter());
        assertEquals(List.of(1, 2, 3, 4, 5), bitSet.returnSet());
    }
    @Test
    void addListOfElements(){
        bitSet = new BitSet(10);
        bitSet.addListOfElements(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(10, bitSet.counter());
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), bitSet.returnSet());
    }
    @Test
    void removeByIndex(){
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 3, 4, 5 ,6));
        assertEquals(5, bitSet.counter());
        bitSet.removeByIndex(1);
        assertEquals(List.of(1, 4, 5, 6), bitSet.returnSet());
    }
    @Test
    void removeElement(){
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 3, 4, 5 ,6));
        assertEquals(5, bitSet.counter());
        bitSet.removeElement(5);
        assertEquals(List.of(1, 3, 4, 6), bitSet.returnSet());
    }
    @Test
    void removeListOfElements(){
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 3, 4, 5 ,6));
        assertEquals(5, bitSet.counter());
        bitSet.removeListOfElements(List.of(1,3,4));
        assertEquals(List.of(5, 6), bitSet.returnSet());
    }
    @Test
    void contains(){
        bitSet = new BitSet(5);
        bitSet.addElement(1);
        bitSet.addElement(2);
        bitSet.addElement(3);
        bitSet.addElement(4);
        bitSet.addElement(5);
        assertEquals(5, bitSet.counter());
        assertTrue(bitSet.contains(5));
    }
    @Test
    void intersect() {
        BitSet bitSet2 = new BitSet(5);
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 2, 3, 4, 5));
        bitSet2.addListOfElements(List.of(1, 2, 3, 6, 7));
        assertEquals(List.of(1, 2, 3), bitSet.intersect(bitSet2));
    }
    @Test
    void unite() {
        BitSet bitSet2 = new BitSet(5);
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 2, 3, 4, 5));
        bitSet2.addListOfElements(List.of(1, 2, 3, 6, 7));
        assertEquals(List.of(1, 2, 3, 4, 5, 1, 2, 3, 6, 7), bitSet.unite(bitSet2));
    }
    @Test
    void dopolnenie() {
        BitSet bitSet2 = new BitSet(5);
        bitSet = new BitSet(5);
        bitSet.addListOfElements(List.of(1, 2, 3, 4, 5));
        bitSet2.addListOfElements(List.of(1, 2, 3, 6, 7));
        assertEquals(List.of(4, 5, 6, 7), bitSet.dopolnenie(bitSet2));
    }
}
