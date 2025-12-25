class Test{
    Test(double a)
    {
        this(10);
        System.out.println("Double Method");
    }
    Test(int i)
    {
        this();
        System.out.println("Int Method");
    }
    Test()
    {
        System.out.println("No Args Method");
    }
}
public class InheritanceDemo2 {
    public static void main(String[] args) {
        Test t1 = new Test(10.5);
        Test t2 = new Test(10);
        Test t3 = new Test();
    }
}
