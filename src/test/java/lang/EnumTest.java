package test.java.lang;

public enum EnumTest {
    First("ych", 1);

    public final String name;
    private int id;
    EnumTest(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        EnumTest f = EnumTest.First;
        String name = f.name();
        System.out.println(name);
        String name1 = f.name;
        System.out.println(name1);
    }
}

