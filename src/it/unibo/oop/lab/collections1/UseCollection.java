package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int FIRST = 0;
	private static final int ADJUST_LAST = 1;

	private static final int ELEMS = 100_000;
	 private static final int TO_MS = 1_000_000;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	List<Integer> arrayList = new ArrayList<>();
    	for(int i = 1000; i < 2000; i++) {
    		arrayList.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int temporaryVariable = arrayList.get(FIRST);
    	arrayList.set(FIRST, arrayList.get(arrayList.size() - ADJUST_LAST));
    	arrayList.set(arrayList.size() - ADJUST_LAST, temporaryVariable);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(int elem : arrayList) {
    		System.out.println(elem);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	/* ArrayList performance test */
    	
    	long time = System.nanoTime();
    	
    	for (int i = 1; i <= ELEMS; i++) {
            arrayList.set(FIRST, i);
        }
    	
    	time = System.nanoTime() - time;
    	
        System.out.println("Inserting " + ELEMS
                + " in an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println(arrayList);
        
        /* LinkedList performance test */
        
        time = System.nanoTime();
    	
    	for (int i = 1; i <= ELEMS; i++) {
            linkedList.set(FIRST, i);
        }
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Inserting " + ELEMS
                + " in a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println(linkedList);
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        /* ArrayList */
        
        time = System.nanoTime();
        
        for(int i = 1; i <= 1000; i++) {
        	arrayList.get((arrayList.size() - ADJUST_LAST) / 2);
        }
        
        time = System.nanoTime() - time;
    	
        System.out.println("Finding the middle element in an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println("Middle element: " + arrayList.get((arrayList.size() - ADJUST_LAST) / 2));
        
        /* LinkedList */
        
        time = System.nanoTime();
        
        for(int i = 1; i <= 1000; i++) {
        	linkedList.get((linkedList.size() - ADJUST_LAST) / 2);
        }
        
        time = System.nanoTime() - time;
    	
        System.out.println("Finding the middle element in an LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println("Middle element: " + linkedList.get((linkedList.size() - ADJUST_LAST) / 2));
        
        /*
         * 7) Build a new Map that associates to each continent's name its population:
         *       
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        Map<String, Long> map = new TreeMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for(long continentPopulation : map.values()) {
        	worldPopulation = worldPopulation + continentPopulation;
        }
        System.out.println("World population: " + worldPopulation);
    }
}
