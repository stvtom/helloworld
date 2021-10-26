package core.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class ConditionDemo2 {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {

       new Thread(()->{
           reentrantLock.lock();
           try{
               System.err.println("AAAA");
               condition.await();
               System.err.println("BBBB");
           }catch (Exception e){
           }finally {
               reentrantLock.unlock();
           }
       }).start();

       new Thread(()->{
           reentrantLock.lock();
           try{
               System.err.println("唤醒BBBB");
               condition.signal();
           }catch (Exception e){

           }finally {
               reentrantLock.unlock();
           }

       }).start();


    }
}
