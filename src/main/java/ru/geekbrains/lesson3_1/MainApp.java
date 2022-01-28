package ru.geekbrains.lesson3_1;

import ru.geekbrains.lesson3_1.boxes.Box;
import ru.geekbrains.lesson3_1.fruits.Apple;
import ru.geekbrains.lesson3_1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        //№1
        String[] str = new String[10];
        for (int i = 0; i < str.length; i++) {
            str[i] = ""+i;
        }
        Integer[] numbers = new Integer[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }

        swap(str, 1, 9);
        swap(numbers, 1, 9);

        System.out.println("№1\n"+Arrays.toString(str)+"\n"+Arrays.toString(numbers));

        //№2
        ArrayList arrayList1 = toArrayList(str),
                arrayList2 = toArrayList(numbers);
        System.out.println("№2\n"+arrayList1+"\n"+arrayList2);

        //№3
        Box box1 = new Box();
        Box box2 = new Box();
        Apple[] apples = new Apple[15];
        Orange[] oranges = new Orange[10];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();

        }
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        box1.put(apples);
        box2.put(oranges);
        System.out.println(box1.getWeight());
        box2.pourContents(box1);
        System.out.println(box1.getWeight()+"\n" + box2.getWeight());
        System.out.println(box1.compare(box2));


    }
    public static <T> void swap(T[] t, int pos1, int pos2) {
        if (Math.max(pos1, pos2) < t.length) {
            T temp = t[pos1];
            t[pos1] = t[pos2];
            t[pos2] = temp;
        }
    }

    public static <T> ArrayList<T> toArrayList(T[] t) {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(t));
        return arrayList;
    }
}