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
        //ѕроверка на коллизии; ≈сли коллизи€ есть сохран€ем в темп значение table[index],
        // вставл€ем в голову новое значение и присваеваем следущему за головой элемент = table[index]
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
              //ѕроверка на наличии коллизий, есть ли ещЄ элементы с данным индексом (совпадение hash);
              //hasNext() возвращает следущий элемент типа Entr, если он есть, иначе возвращает null;
              Entr field = table[i].hasNext();
              while(field != null){
                  System.out.println(field.toString() + " index = " + i);
                  field = field.hasNext(); //пробегаем до конца списка коллизий;
              }
          }
       }
   }
}
