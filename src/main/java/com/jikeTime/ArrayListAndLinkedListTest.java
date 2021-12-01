package com.jikeTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListAndLinkedListTest {
    /***
     * 测试arraylist和linkedlist  的 随机访问和随机插入的性能
     * 发现linkedList在随机访问和随机插入测试中性能都不如arraylist
     * 这是因为只有在下标确定的情况下，插入linkedlist性能才会高，而循着下表的过程，其实也很消耗新能，所以在一般场景中使用arraylist
     *
     *
     * 在一个装有Integer类型的ArrayList集合中，使用remove方法传入int类型参数和Integer类型的参数，结果是不一样的，
     * 传入int类型，这时的参数代表下标，而传入Integer类型的参数，代表要删除的元素本身
     * */

    //对arraylist进行随机访问
    private static void getFromArrayList(int elementCount,int loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1,loopCount).forEach(x->arrayList.get(ThreadLocalRandom.current().nextInt(1, elementCount)));
    }

    //对arraylist进行随机插入
    private static void insertintoArrayList(int elementCount,int loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1,loopCount).forEach(x->arrayList.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }


    //对linkedlist进行随机访问
    private static void getFromLinkedlist(int elementCount,int loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1,loopCount).forEach(x->arrayList.get(ThreadLocalRandom.current().nextInt(1, elementCount)));
    }

    //对linkedlist进行随机插入
    private static void insertintoLinkedlist(int elementCount,int loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1,loopCount).forEach(x->arrayList.add(ThreadLocalRandom.current().nextInt(elementCount),1));
    }

    private static void removeTest(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList.toString());
        arrayList.remove(Integer.valueOf(2));
        System.out.println(arrayList.toString());
        arrayList.remove(3);
        System.out.println(arrayList.toString());

    }


    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        insertintoArrayList(10000000,1000);
        final long end = System.currentTimeMillis();
        System.out.print("随机插入arrayList：");
        System.out.println(end- start);
        insertintoLinkedlist(10000000,1000);
        final long endNew = System.currentTimeMillis();
        System.out.print("随机插入LinkedList：");
        System.out.println(endNew - end);

        final long startInsert = System.currentTimeMillis();
        getFromArrayList(10000000,1000);
        final long endtInsert = System.currentTimeMillis();
        System.out.print("随机访问arrayList：");
        System.out.println(endtInsert- startInsert);
        final long startInsert2 = System.currentTimeMillis();
        getFromLinkedlist(10000000,1000);
        final long endtInsert2 = System.currentTimeMillis();
        System.out.print("随机访问linkedList：");
        System.out.println(endtInsert2- startInsert2);

        removeTest();

    }


}
