import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Sử dụng mẫu thiết kế Strategy
        int[] array = {5, 2, 8, 1, 7};
        Context sortingContext = new Context(new BubbleSort());
        int[] sortedArray = sortingContext.applySort(array);
        System.out.println("Bubble Sort: " + Arrays.toString(sortedArray));

        sortingContext.setStrategy(new SelectionSort());
        sortedArray = sortingContext.applySort(array);
        System.out.println("Selection Sort: " + Arrays.toString(sortedArray));
    }
}