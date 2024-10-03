package src.concurrency;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCollectionsAtomicVariables {


    /**
     * What are concurrent collections:
     * --> it is collections that allows locking per segment while reading
     * --> multi threads can get read access to the collection
     * --> assure data integrity
     * --> change collection while looping
     *
     * Interfaces in package java.util.concurrent:
     * --> concurrentMap, blockingQueue
     * Atomic operations and CAS (compare-and-swap) are techniques for ensuring concurrency and consistency in multithreaded applications.
     *
     * Synchronized collections:
     * --> Great way of turning an existing collection into a synchronized and memory safe one
     * --> Bad performance, better to choose concurrent collections
     * --> Cannot be modified in a loop
     *
     * Atomic variables:
     * --> java.util.concurrent.atomic.package
     * --> memory consistent
     * --> special methods
     *
     * Types of variables: atomicInteger, atomicLong, atomicBoolean
     * methods: get(), set(), compareAndSet(), weakCompareAndSet(), lazySet(), getAndIncrement(),
     * incrementAndGet(), getAndDecrement(), decrementAndGet(), getAndAdd(), addAndGet() ...
     *
     * Threading problems are a danger to the liveness, memory consistency and data integrity
     * Threading problems:
     * --> Deadlock and livelock i.e. multiple threads waiting indefinitely for each other or triggering each other in a loop
     * --> Starvation i.e. low priority thread cannot access to a resource due to high priority threads
     * --> Race condition i.e. multiple threads use the same resource and result depends on order of threads accessing
     */

    /**
     *
     * @param args
     */

    public static void main(String[] args){
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Hamouda", "DELL");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("Stella");
        queue.offer("Mouss");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue);

        // special for concurrent queues
        try {
            queue.offer("Jim", 200, TimeUnit.MILLISECONDS);
            queue.poll(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(queue);
        // set structure de donnees non ordonnee ne pouvant pas contenir de doublons

        //atomicExamples();

        //deadlock();
        livelock();

    }


    public void copyOnWrite(){
        List<String> myList = new CopyOnWriteArrayList<>();
        myList.add("Squirrel");
        myList.add("Cat");
        myList.add("Hamster");
    }

    public static void atomicExamples(){
        AtomicInteger ai = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i =0; i<5; i++){
            executorService.submit(() -> System.out.println(ai.incrementAndGet()));
        }
        executorService.shutdown();
    }

    /**
     * To avoid deadlock we should not give a lock to thread1 on resource1 at the same
     * time giving lock to thread2 on resource2 cause they wait for each other to
     * free the other resource in other to themself free the resource
     */
    public static void deadlock(){
        final String resource1 = "stuck";
        final String resource2 = "forever";

        Thread thread1 = new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread1 has a lock on resource1");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized(resource2){
                    System.out.println("Thread1 has a lock on resource2");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread2 has a lock on resource1");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized(resource2){
                    System.out.println("Thread2 has a lock on resource2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * livelock is two threads triggering each other so the operation never end
     * To prevent livelock in this case we can set a counter. When the counter arrives we can end the call
     * with hangUp.end();
     */
    public static void livelock(){
        PhoneCall buddy1 = new PhoneCall("Patricia");
        PhoneCall buddy2 = new PhoneCall("Hamouda");
        HangUp hangUp = new HangUp(buddy1);

        new Thread(() -> buddy1.endCallWith(hangUp, buddy2)).start();
        new Thread(() -> buddy2.endCallWith(hangUp, buddy1)).start();
    }

    static class HangUp{
        private PhoneCall caller;
        public HangUp(PhoneCall d){
            caller = d;
        }

        public void setCaller(PhoneCall c){
            this.caller = c;
        }

        public void end(){
            System.out.println(caller.name + " has hang up");
        }
    }

    static class PhoneCall{
        private String name;
        private boolean isDone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean done) {
            isDone = done;
        }

        public PhoneCall(String nameE){
            this.name = nameE;
            this.isDone = false;
        }


        public void endCallWith(HangUp hangUp, PhoneCall pc){
            while (! isDone){
                if(hangUp.caller != this){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }
                if(!pc.isDone()){
                    System.out.println(name + ": No you hang up, buddy " + pc.getName());
                    hangUp.setCaller(pc);
                    continue;
                }
                hangUp.end();
                pc.isDone = true;
                isDone = true;
            }
        }

    }
}
