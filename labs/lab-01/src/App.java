import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    private static final int NUM_RAND_LISTS = 10;
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws Exception {
    }

    private static int[] getRandomList(int length) {
        int[] list = new int[length];

        for (int i = 0; i < length; i++) {
            list[i] = random.nextInt(length);
        }

        return list;
    }

    private static int[][] getRandomLists(int length) {
        int[][] lists = new int[NUM_RAND_LISTS][length];

        for (int i = 0; i < NUM_RAND_LISTS; i++) {
            lists[i] = getRandomList(length);
        }

        return lists;
    }

    private static long timeBubbleSort(int[][] lists) {
        long start = System.currentTimeMillis();

        for (int[] list : lists) {
            // bubblesort(list);
        }

        return System.currentTimeMillis() - start;
    }

    private static long timeSort(int[][] lists) {
        long start = System.currentTimeMillis();
        for (int[] list : lists) {
            Arrays.stream(list).sorted().toArray();
        }
        return System.currentTimeMillis() - start;
    }

    private static void testSorts() {
        double maxTime = 0;
        int len = 10000;

        while (maxTime < 1) {
            int[][] lists = getRandomLists(len);

            double sTime = ((double) timeSort(lists)) / 1000;
            double bsTime = ((double) timeBubbleSort(lists)) / 1000;

            System.out.println("Time to bubblesort " + len + " items: bs(" + bsTime + "), s(" + sTime + ")");
            len += 100;

            maxTime = maxTime < bsTime ? bsTime : maxTime < sTime ? sTime : maxTime;
        }
    }

    private static void printList(int[] list) {
        System.out.println('[' + Arrays.stream(list).mapToObj(String::valueOf).collect(Collectors.joining(", ")) + ']');
    }
}
