import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Проверка HashSet");
        HashSet<MyObject> testCollection = new HashSet<>();
        System.out.println("добавляем в HashSet два разных объекта с одинаковым хэшкодом...");
        MyObject first = new MyObject(4);
        MyObject second = new MyObject(5);
        System.out.println("Хэшкоды: первый "+ first.hashCode() + " второй: "+ second.hashCode());
        testCollection.add(first);
        testCollection.add(second);
        System.out.println("Проверяем размер HashSet...");
        System.out.println("размер:" + testCollection.size());

        System.out.println("Проверка HashMap");
        HashMap<MyObject, Object> hashMapCollection = new HashMap<>();
        System.out.println("добавляем в HashMap в качестве ключа два разных объекта с одинаковым хэшкодом...");
        hashMapCollection.put(first, new Object());
        hashMapCollection.put(second, new Object());
        System.out.println("Проверяем размер HashMap...");
        System.out.println("размер:" + hashMapCollection.size());
    }

    private static class MyObject {
        private int field;

        private MyObject(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        @Override
        public int hashCode() {
            //захардкожено одинаковое значение для всех объектов
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyObject && ((MyObject) obj).field == field){
                return true;
            }
            return false;
        }
    }
}
