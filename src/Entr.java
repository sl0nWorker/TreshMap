import java.util.Map;

/**
 * TRESHMAP CREATED BY SL0N
 */
public class Entr  {

    private int key;
    private int value;
    private Entr next;
    private Entr prev;

    Entr(int k, int v){
        key = k;
        value = v;
        next = null;
        prev = null;
    }
    Entr(int k, int v, Entr temp){
        key = k;
        value = v;
        next = temp;
        temp.addPrev(this);
    }

    public void addPrev(Entr temp){
        prev = temp;
    }
    public void addNext(Entr temp){
        next = temp;
    }

    public String toString(){
        return "key = " + key + " value = " + value + " ";
    }

    public Entr hasNext(){
        if (next != null)
            return next;
        else return null;
    }
    public Entr hasPrev(){
        if (prev != null)
            return prev;
        else return null;
    }


    public int getValue(){
        return value;
    }
    public int getKey(){
        return key;
    }
}
