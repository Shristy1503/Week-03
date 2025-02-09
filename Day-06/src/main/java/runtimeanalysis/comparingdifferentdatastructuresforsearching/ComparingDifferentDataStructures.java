package runtimeanalysis.comparingdifferentdatastructuresforsearching;
import java.util.*;
public class ComparingDifferentDataStructures {
        public static void main(String[] args) {
            int[] sizes = {1000, 100000};

            for (int size : sizes) {
                System.out.println("Dataset Size: " + size);

                int[] array = generateArray(size);
                HashSet<Integer> hashSet = generateHashSet(array);
                TreeSet<Integer> treeSet = generateTreeSet(array);

                int target = array[new Random().nextInt(size)];

                System.out.printf("Array Search Time: %.3f ms%n", searchArray(array, target));
                System.out.printf("HashSet Search Time: %.3f ms%n", searchHashSet(hashSet, target));
                System.out.printf("TreeSet Search Time: %.3f ms%n", searchTreeSet(treeSet, target));

                System.out.println();
            }
        }
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 10);
        }
        return array;
    }

    public static HashSet<Integer> generateHashSet(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : array) {
            hashSet.add(num);
        }
        return hashSet;
    }
    public static TreeSet<Integer> generateTreeSet(int[] array) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : array) {
            treeSet.add(num);
        }
        return treeSet;
    }

    public static double searchArray(int[] array, int target) {
        long start = System.nanoTime();
        for (int num : array) {
            if (num == target) break;
        }
        return (System.nanoTime() - start) / 1000000.0;
    }
    public static double searchHashSet(HashSet<Integer> hashSet, int target) {
        long start = System.nanoTime();
        hashSet.contains(target);
        return (System.nanoTime() - start) / 1000000.0;
    }

    public static double searchTreeSet(TreeSet<Integer> treeSet, int target) {
        long start = System.nanoTime();
        treeSet.contains(target);
        return (System.nanoTime() - start) / 1000000.0;
    }
}
