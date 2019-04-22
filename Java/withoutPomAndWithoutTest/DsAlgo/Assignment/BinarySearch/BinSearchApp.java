
public class BinSearchApp {
    public static void main(String[] args) {
        System.out.println(binarySearch(29, new Integer[]{3, 8, 22, 29, 43, 55, 61, 74, 78, 95, 96}));
    }

    static int binarySearch(int find, Integer[] numbers) {
        int left, right, middle;
        left = 0;
        right = numbers.length;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (numbers[middle] == find) {
                System.out.println(numbers[middle]);
                return middle;
            } else if (find < numbers[middle]) {
                System.out.println(numbers[middle]);
                right = middle - 1;
            } else {
                System.out.println(numbers[middle]);
                left = middle + 1;
            }
        }
        return -1;
    }

}
