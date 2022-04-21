package test.java.lang;

public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append("aaa");
            if (sb.length() > Integer.MAX_VALUE - 1000)
                System.out.println(sb.length());
        }
        System.out.println(sb.length());
    }
}
