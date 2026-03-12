package Strategy;

import java.util.Random;

public class AlgorithmComparison {
    public static void main(String[] args) {
        SortContext context = new SortContext();
        SortingStrategy[] strategies = { new BubbleSort(), new MergeSort(), new QuickSort() };

        int[] smallSet = generateData(30);
        int[] largeSet = generateData(100000);

        System.out.println("--- Small Data Set (30 elements) ---");
        runTests(context, strategies, smallSet);

        System.out.println("\n--- Large Data Set (100,000 elements) ---");
        runTests(context, strategies, largeSet);
    }

    private static void runTests(SortContext context, SortingStrategy[] strategies, int[] original) {
        for (SortingStrategy s : strategies) {
            int[] dataCopy = original.clone();
            context.setStrategy(s);

            long startTime = System.nanoTime();
            context.sortArray(dataCopy);
            long endTime = System.nanoTime();

            double durationMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-12s: %.4f ms\n", s.getClass().getSimpleName(), durationMs);
        }
    }

    private static int[] generateData(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }
}
