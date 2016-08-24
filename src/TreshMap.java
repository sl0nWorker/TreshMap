import java.util.Map.Entry;

/**
 * TRESHMAP CREATED BY SL0N
 */
public class TreshMap  {

    int capicity;
    Entr[] table;

    TreshMap(){
       capicity = 16;
       table = new Entr[capicity];
    }

    public void put(int key, int value){
        int hash = key * 13 + 11;
        int index = hash % capicity;
        //�������� �� ��������; ���� �������� ���� ��������� � ���� �������� table[index],
        // ��������� � ������ ����� �������� � ����������� ��������� �� ������� ������� = table[index]
        if (table[index]!= null) {
            Entr temp = table[index];
            table[index] = new Entr(key, value,temp);
        }
        else table[index] = new Entr(key,value);
    }

   public void show(){
       for (int i = 0; i < table.length; i++) {
          if (table[i] != null) {
              System.out.println(table[i].toString() + " index = " + i);
              //�������� �� ������� ��������, ���� �� ��� �������� � ������ �������� (���������� hash);
              //hasNext() ���������� �������� ������� ���� Entr, ���� �� ����, ����� ���������� null;
              Entr field = table[i].hasNext();
              while(field != null){
                  System.out.println(field.toString() + " index = " + i);
                  field = field.hasNext(); //��������� �� ����� ������ ��������;
              }
          }
       }
   }
}
