package test.java.lang;

// 只有实现 Cloneable 接口才可使用 clone 方法，这里默认使用object的clone方法，是浅拷贝
// 看起来String，Integer这种被视为了基本类型，重新开辟了内存空间，与原对象的成员变量内存空间隔离
public class ObjectTest implements Cloneable {
    String name;
    Integer age;
    Message message;

    ObjectTest(String name, Integer age, String school, String phone) {
        this.name = name;
        this.age = age;
        this.message = new Message(school, phone);
        // 这里只print一次，说明clone不走构造方法
        System.out.println("constructor!");
    }

    @Override
    public String toString() {
        return this.name + " " + age + " " + message.phone + " " + message.school;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectTest obj1 = new ObjectTest("yanch", 123130, "aaa", "138");
        System.out.println(obj1);
        ObjectTest obj2 = (ObjectTest) obj1.clone();
        obj2.name = "yanch1";
        obj2.age = 1230;
        obj2.message.school = "bupt";
        obj2.message.phone = "159";
        System.out.println(obj1);
        System.out.println(obj2);
    }

    class Message {
        String school;
        String phone;
        Message(String school, String phone) {
            this.school = school;
            this.phone = phone;
        }
    }
}
