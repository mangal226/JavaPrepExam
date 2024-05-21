package src.ooa;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Math.random;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class RadarTarget {
    private String callSign;
    private int flightLevel;
    private int requiredFlightLevel;
    private String model;


    public RadarTarget(String callSign, int flightLevel, String model){
        this.callSign = callSign;
        this.flightLevel = flightLevel;
        this.requiredFlightLevel = flightLevel;
        this.model = model;
    }

    public String getLabel(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.callSign)
                .append("__")
                .append(this.flightLevel)
                .append("__")
                .append(this.getClimbDescendIndicator())
                .append("__")
                .append(this.requiredFlightLevel)
                .append("__")
                .append(model);
        return sb.toString();
    }

    private String getClimbDescendIndicator() {
        if(this.requiredFlightLevel > this.flightLevel) return "increase";
        else if (this.requiredFlightLevel <this.flightLevel) return "decrease";
        else return "equal";
    }

    private void changeAltitude(int newFl){
        out.println(this.callSign + " change altitude " + newFl);
        out.println();

        this.requiredFlightLevel = newFl;

        // Simulate the long running operation
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {
            try {
                Thread.sleep((long) (random() * 5 * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.flightLevel = requiredFlightLevel;
        });

        /*ExecutorService exService  = new ExecutorService() {
            @Override
            public void shutdown() {

            }

            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return null;
            }

            @Override
            public <T> Future<T> submit(Runnable task, T result) {
                return null;
            }

            @Override
            public Future<?> submit(Runnable task) {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void execute(Runnable command) {

            }
        };*/
    }

    public static void main(String[] args) throws InterruptedException {
        RadarTarget rtgt = new RadarTarget("OS7", 280, "bobo47");
        out.println(rtgt.getLabel());
        out.println();
        rtgt.changeAltitude(500);
        rtgt.getLabel();
        out.println();
        for(int i=0; i<5; i++){
            Thread.sleep(1000);
            out.println(rtgt.getLabel());
            out.println();
        }
    }
}
