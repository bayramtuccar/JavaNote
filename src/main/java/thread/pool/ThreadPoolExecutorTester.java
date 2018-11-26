package thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTester {

    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFour();
        testFive();
        testSix();
    }

    public static class TestClass implements Runnable {
        private int id;

        public TestClass(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println(id + " starting...");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(id + " finished");
        }
    }

    private static void testOne() {
        System.out.println("\n\nTestOne starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestOne failed.");
        }
        System.out.println("TestOne finished.");
    }

    /*
    TestOne starting...
    TestOne finished.
    1 starting...
    2 starting...
    1 finished
    2 finished
    4 starting...
    3 starting...
    4 finished
    5 starting...
    3 finished
    6 starting...
    5 finished
    6 finished
    8 starting...
    7 starting...
    7 finished
    8 finished
    */

    private static void testTwo() {
        System.out.println("\n\nTestTwo starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestTwo failed.");
        }
        System.out.println("TestTwo finished.");
    }

    /*
    TestTwo starting...
    2 starting...
    3 starting...
    1 starting...
    4 starting...
    TestTwo failed.
    TestTwo finished.
    2 finished
    4 finished
    1 finished
    3 finished
    */

    private static void testThree() {
        System.out.println("\n\nTestThree starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestThree failed.");
        }
        System.out.println("TestThree finished.");
    }

    /*
    TestThree starting...
    TestThree finished.
    1 starting...
    1 finished
    2 starting...
    2 finished
    3 starting...
    3 finished
    4 starting...
    4 finished
    5 starting...
    5 finished
    6 starting...
    6 finished
    7 starting...
    7 finished
    8 starting...
    8 finished
    */

    private static void testFour() {
        System.out.println("\n\nTestFour starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 4, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestFour failed.");
        }
        System.out.println("TestFour finished.");
    }

    /*
    TestFour starting...
    1 starting...
    2 starting...
    4 starting...
    3 starting...
    TestFour failed.
    TestFour finished.
    1 finished
    4 finished
    2 finished
    3 finished
    */

    private static void testFive() {
        System.out.println("\n\nTestFive starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestFive failed.");
        }
        System.out.println("TestFive finished.");
    }

    /*
    TestFive starting...
    1 starting...
    3 starting...
    2 starting...
    4 starting...
    TestFive finished.
    3 finished
    4 finished
    5 starting...
    6 starting...
    2 finished
    7 starting...
    1 finished
    8 starting...
    8 finished
    7 finished
    6 finished
    5 finished
    */

    private static void testSix() {
        System.out.println("\n\nTestSix starting...");
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
            executor.execute(new TestClass(1));
            executor.execute(new TestClass(2));
            executor.execute(new TestClass(3));
            executor.execute(new TestClass(4));
            executor.execute(new TestClass(5));
            executor.execute(new TestClass(6));
            executor.execute(new TestClass(7));
            executor.execute(new TestClass(8));
        } catch (Exception e) {
            System.out.println("TestSix failed.");
        }
        System.out.println("TestSix finished.");
    }

    /*
    TestSix starting...
    1 starting...
    3 starting...
    4 starting...
    2 starting...
    TestSix failed.
    TestSix finished.
    1 finished
    3 finished
    4 finished
    2 finished
    */

}