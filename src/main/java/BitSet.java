import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.remove;

public class BitSet {
    public ArrayList<Integer> bitSet;
    public int size ;
    public BitSet(int size) {
        this.size = size;
        this.bitSet =  new ArrayList<Integer>(size);
    }
    public ArrayList<Integer> returnSet(){
        return bitSet;
    }
    public int counter(){
        int n = 0;
        for (Integer el : bitSet) {
            if (el != null) {
                n++;
            }
        }
        return n;
    }
    public void addElement(Integer element){
        bitSet.add(element);
    }
    public void addListOfElements( List<Integer> elements){
        bitSet.addAll(elements);
    }

    public void removeElement(Integer element){
        bitSet.remove(element);
    }

    public void removeListOfElements(List<Integer> elements){
        for (int i = 0; i < elements.size(); i++){
            bitSet.remove(elements.get(i));
        }
    }
    public void removeByIndex(int index) {
        bitSet.remove(bitSet.get(index));
    }


    public boolean contains(Integer element){
        for (int i = 0; i < bitSet.size(); i++){
            if (element.equals(bitSet.get(i))){
                return true;
            }
        }
        return false;
    }

    public boolean elementInList(int element){
        for (int i = 0; i < bitSet.size(); i++){
            if (bitSet.get(i).equals(element)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Integer> intersect(BitSet bitSet2) {
        ArrayList<Integer> bs2 = bitSet2.returnSet();
        int minsize = Math.min(size, bs2.size());
        ArrayList<Integer> interarr = new ArrayList<Integer>();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < bs2.size(); j++) {
                if (bitSet.get(i).equals(bs2.get(j))){
                    interarr.add(bitSet.get(i));
                }
            }
        }
        return interarr;
    }
    public ArrayList<Integer> unite (BitSet bitSet2) {
        ArrayList<Integer> bs2 = bitSet2.returnSet();
        int unitesize = size + bs2.size();
        ArrayList<Integer> unitearr = new ArrayList<Integer>();
        unitearr.addAll(bitSet);
        unitearr.addAll(bs2);
        return unitearr;
    }
    public ArrayList<Integer> dopolnenie (BitSet bitSet2) {
        ArrayList<Integer> dopoln = this.unite(bitSet2);
        ArrayList<Integer> interarr = this.intersect(bitSet2);
        for (int i = 0; i < dopoln.size(); i++){
            for (int j = 0; j < interarr.size(); j++){
                if (dopoln.get(i).equals(interarr.get(j))){
                    dopoln.remove(dopoln.get(i));
                }
            }
        }
        return dopoln;
    }

}
