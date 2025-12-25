class mythreaddd extends Thread{
    public void run(){
        System.out.println("No Arg run method");
    }
    public void run(int i){
        System.out.println("Int Arg run method");
    }
}
class Threadd {
    public static void main(String[] args) {
        mythreaddd t = new mythreaddd();
        t.start();
        t.run(5);
    }
}
