package ru.geekbrains.lesson3_1.boxes;

import ru.geekbrains.lesson3_1.fruits.Apple;
import ru.geekbrains.lesson3_1.fruits.Fruit;
import ru.geekbrains.lesson3_1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> arrayList = new ArrayList<>();
    private float weight;

    public void put(T... t) {
        if (weight>0 && this.arrayList.get(0).getClass() != t[0].getClass()) {
            return;
        }
        this.arrayList.addAll(Arrays.asList(t));
        if (Apple.class.equals(t[0].getClass())) {
            this.weight += 1.0f * t.length;
        }
        if (Orange.class.equals(t[0].getClass())) {
            this.weight += 1.5f * t.length;
        }
    }

    public void put(ArrayList<T> list) {
        if (weight>0 && this.arrayList.get(0).getClass() != list.get(0).getClass()) {
            return;
        }
        this.arrayList.addAll(list);
        if (Apple.class.equals(list.get(0).getClass())) {
            this.weight += 1.0f*list.size();
        }
        if (Orange.class.equals(list.get(0).getClass())) {
            this.weight += 1.5f*list.size();
        }
    }


    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void clear() {
        arrayList.clear();
        weight = 0f;
    }

    public float getWeight() {
        return weight;
    }

    public boolean compare(Box box) {
        return (this.getWeight()- box.getWeight() < 0.00001);
    }

    public void pourContents(Box box) {
        if (weight>0 && this.arrayList.get(0).getClass() != box.getArrayList().get(0).getClass()) {
            return;
        }
        this.put(box.getArrayList());
        box.clear();
    }
}
