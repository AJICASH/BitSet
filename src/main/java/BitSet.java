import java.util.ArrayList;
import java.util.List;


public class BitSet<T>  {
    private ArrayList<T> bitSet;
    private int size ;
    public BitSet(int size) {
        this.size = size;
        this.bitSet =  new ArrayList<T>(size);
    }
    public ArrayList<T> returnSet(){
        return bitSet;
    }
    public int counter(){
        int n = 0;
        for (T el : bitSet) {
            if (el != null) {
                n++;
            }
        }
        return n;
    }
    public void addElement(T element){
        bitSet.add(element);
    }
    public void addListOfElements( List<T> elements){
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


    public boolean contains(T element){
        for (int i = 0; i < bitSet.size(); i++){
            if (element.equals(bitSet.get(i))){
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> intersect(BitSet bitSet2) {
        ArrayList<T> bs2 = bitSet2.returnSet();
        int minsize = Math.min(size, bs2.size());
        ArrayList<T> interarr = new ArrayList<T>();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < bs2.size(); j++) {
                if (bitSet.get(i).equals(bs2.get(j))){
                    interarr.add(bitSet.get(i));
                }
            }
        }
        return interarr;
    }
    public ArrayList<T> unite (BitSet bitSet2) {
        ArrayList<T> bs2 = bitSet2.returnSet();
        int unitesize = size + bs2.size();
        ArrayList<T> unitearr = new ArrayList<T>();
        unitearr.addAll(bitSet);
        unitearr.addAll(bs2);
        return unitearr;
    }
    public ArrayList<T> dopolnenie (BitSet bitSet2) {
        ArrayList<T> dopoln = this.unite(bitSet2);
        ArrayList<T> interarr = this.intersect(bitSet2);
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