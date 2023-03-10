import java.util.List;
import static java.awt.AWTEventMulticaster.remove;

public class BitSet {
    private List<Integer> bitSet;

    public void addElement(Integer element){
        bitSet.add(element);
    }
    public void addListOfElements( List<Integer> elements){
        bitSet.addAll(elements);
        //for (int i = 0; i < elements.size(); i++){
        //            bitSet.add(elements.get(i));
        //        }
    }

    public void removeElement(Integer element){
        bitSet.remove(element);
    }
    public void removeEListOfElements(List<Integer> elements){
        for (int i = 0; i < elements.size(); i++){
            bitSet.remove(elements.get(i));
        }
    }
    public boolean contains(Integer element){
        for (int i = 0; i < bitSet.size(); i++){
            if (element == bitSet.get(i)){
                return true;
            }
        }
        return false;
    }

    public void intersect(List<Integer> elements) {
//        for (int i = 0; i <)

    }

}
