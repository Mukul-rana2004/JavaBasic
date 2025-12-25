class mythread extends Thread{
    public void run(){
        for(int i =0; i<10; i++){
            System.out.println("Child Thread");
        }
    }
}

class Demo1{
    public static void main(String[] args) {
        mythread t = new mythread();
        t.start();
        for(int i =0; i<10; i++){
            System.out.println("Main Thread");
        }
    }
}