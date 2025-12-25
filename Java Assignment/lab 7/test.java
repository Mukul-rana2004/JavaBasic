class test{
    public static void main(String[] args) {
        test obj = new test();
        obj.m1();
    }

    public void m1(){
    m2();
    System.out.println(10/0);
 }
    public void m2(){
    System.out.println();
 }
}
