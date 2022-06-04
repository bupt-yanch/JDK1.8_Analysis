package test.java.lang;

interface testInterface {
    String genMark();
}

public enum EnumTest1 implements testInterface{
    FIRST("ych",1102) {
        @Override
        public String getInfo() {
            return "first: " + this.genMark();
        }
    },
    SECOND("yan", 1303) {
        @Override
        public String getInfo() {
            return "second: " + this.genMark();
        }
    };

    EnumTest1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract String getInfo();
    public String name;
    public int id;

    @Override
    public String genMark() {
        return this.name + " " + id;
    }

    public static void main(String[] args) {
        EnumTest1 f = EnumTest1.FIRST;
        EnumTest1 s = EnumTest1.SECOND;
        System.out.println(f.getInfo());
        System.out.println(s.getInfo());
    }
}
