import java.util.Map;

/**
 * TRESHMAP CREATED BY SL0N
 */
public class Entr  {

    private int key;
    private int value;
    private Entr next;

    Entr(int k, int v){
        key = k;
        value = v;
    }
    Entr(int k, int v, Entr temp){
        key = k;
        value = v;
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

    public int getValue(){
        return value;
    }
}
