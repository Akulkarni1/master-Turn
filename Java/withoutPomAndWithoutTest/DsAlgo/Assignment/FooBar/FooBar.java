public class FooBar {

    public static boolean isFoo(int value) {
        return (value % 3 == 0);
    }

    public static boolean isBar(int value) {
        return (value % 7 == 0);
    }

    public static void main(String[] args) {
        for (int i = 100; i > 0; i--) {
            if (isFoo(i) || isBar(i)) {
                if (isFoo(i)) {
                    System.out.println("foo");
                }
                if (isBar(i)) {
                    System.out.println("bar");
                }
                if (isFoo(i) && isBar(i)) {
                    System.out.println("foobar");
                }

            } else {
                System.out.println(i);
            }
        }
    }
}
