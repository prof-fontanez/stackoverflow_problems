import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysSteamOperatiions {
    public static void main(String[] args) {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        int[] combined = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();

        int middle = combined.length / 2;

        double median = 0;
        if (combined.length % 2 == 0) {
            int[] temp = Arrays.stream(combined, middle -1, middle).toArray();
            median = Arrays.stream(combined, middle -1, middle + 1).sum() / 2.0;
        } else {
            median = combined[middle];
        }
        System.out.println(median);
    }
}
