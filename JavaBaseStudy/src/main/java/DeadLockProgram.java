import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeadLockProgram {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            for(;;) {
                DeadLockProgram.sharedMethod();
            }
        },"wzythread1");

        Thread thread2=new Thread(()->{
            for(;;) {
                DeadLockProgram.sharedMethod();
            }
        },"wzythread2");
        Thread thread3=new Thread(()->{
            for(;;) {
                DeadLockProgram.sharedMethod();
            }
        },"wzythread3");
        Thread thread4=new Thread(()->{
            for(;;) {
                DeadLockProgram.sharedMethod();
            }
        },"wzythread4");
        Thread thread5=new Thread(()->{
            for(;;) {
                DeadLockProgram.sharedMethod();
            }
        },"wzythread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static void sharedMethod()  {
        System.out.println("线程"+Thread.currentThread().getId()+"等待锁...."+DeadLockProgram.class);
        synchronized (DeadLockProgram.class){
            System.out.println("线程"+Thread.currentThread().getId()+"获得锁"+DeadLockProgram.class);

            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("线程"+Thread.currentThread().getId()+"释放锁"+DeadLockProgram.class);
        }
    }
}
