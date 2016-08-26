import java.util.Map.Entry;

/**
 * TRESHMAP CREATED BY SL0N
 */
public class TreshMap {

    int capicity;
    Entr[] table;

    TreshMap() {
        capicity = 16;
        table = new Entr[capicity];
    }

    public int hash(int x) {
        return x * 13 + 11;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        int index = hash % capicity;
        //Проверка на коллизии; Если коллизия есть сохраняем в темп значение table[index],
        // вставляем в голову новое значение и присваеваем следущему за головой элемент = table[index]
        if (table[index] != null) {
            Entr temp = table[index];
            table[index] = new Entr(key, value, temp);
        } else table[index] = new Entr(key, value);
    }

    public boolean containsKey(int key) {
        Entr field;
        int hash = hash(key);
        int index = hash % capicity;
        if (table[index] != null) {
            field = table[index];
            //Пробегаем по списку элементов
            while (field != null) {
                if (field.getKey() == key) return true;
                field = field.hasNext();
            }
        }
        return false;
    }

    public boolean remove(int key) {

        if (this.containsKey(key)) {
            int hash = hash(key);
            int index = hash % capicity;
            Entr field = table[index];
            Entr temp = table[index];
            //Пробегаем по списку элементов
            while (field != null) {
                if (field.getKey() == key) {
                    // Если нет коллизий, и список состоит только из головы, тогда заменяем голову на null
                    if (field.hasPrev() == null && field.hasNext() == null) {
                        table[index] = null;
                        return true;
                    }
                    //Если есть коллизии и элемент с заданным ключом находится в голове списка
                    else if (field.hasPrev() == null && field.hasNext() != null) {
                        temp = field.hasNext();
                        temp.addPrev(null);
                        table[index] = temp;
                        field = null;
                        return true;
                        // Если элемент находится в конце списка
                    } else if (field.hasNext() == null) {
                        field = null;
                        return true;
                        // Если элемент находится в середине ( есть следущий и предыдущий)
                    } else if (field.hasNext() != null && field.hasPrev() != null) {
                        temp = field.hasPrev();
                        temp.addNext(field.hasNext());
                        field = null;
                        return true;
                    }
                    return false;
                }
                field = field.hasNext();
            }

        }
        return false;
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(table[i].toString() + " index = " + i);
                //Проверка на наличии коллизий, есть ли ещё элементы с данным индексом (совпадение hash);
                //hasNext() возвращает следущий элемент типа Entr, если он есть, иначе возвращает null;
                Entr field = table[i].hasNext();
                while (field != null) {
                    System.out.println(field.toString() + " index = " + i);
                    field = field.hasNext(); //пробегаем до конца списка коллизий;
                }
            }
        }
    }

}
