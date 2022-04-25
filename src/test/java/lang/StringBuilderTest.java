package test.java.lang;

import java.util.Arrays;

public class StringBuilderTest {
    private char[] chars;
    public static void main(String[] args) {
        StringBuilderTest stringBuilderTest = new StringBuilderTest();
        stringBuilderTest.test2();
    }

    private void test3() {
        chars = new char[]{'y','c','h'};
        // 这种非复制的String对象创建方法，是default限定，即不允许用户使用，仅该package和子类中允许调用
        // 类似废弃，目前只在StringBuffer见过这种用法
        String str = new String(chars, true);
        System.out.println(str);
        chars = null;
        System.out.println(str);
        chars = new char[]{'1'};
        String str1 = new String(chars);
        System.out.println(str);
        System.out.println(str1);
    }

    private void test2() {
        chars = new char[]{'y','c','h'};
        final char[] arr1 = chars;
        System.out.println(Arrays.toString(arr1));
        // arr1指向的地址不变，但是数组内的内容可修改
        // 应该是这样不太安全，所以String创建时，都是复制了一份char[]
        // 由此 String(char[], boolean)方法(直接赋值) 禁止用户使用
        chars[1] = 'o';
        System.out.println(Arrays.toString(arr1));

        // 这种只会把栈中chars的值从堆地址变为null
        // 堆中的数据仍然被final arr1指向
        chars = null;
        System.out.println(Arrays.toString(arr1));
        chars = new char[]{'1'};
        System.out.println(Arrays.toString(arr1));
    }

    private void test1() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append("aaa");
            if (sb.length() > Integer.MAX_VALUE - 1000)
                System.out.println(sb.length());
        }
        System.out.println(sb.length());
    }
}
