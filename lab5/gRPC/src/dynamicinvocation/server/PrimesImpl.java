package dynamicinvocation.server;

import dynamicinvocation.gen.Number;
import dynamicinvocation.gen.Report;
import dynamicinvocation.gen.PrimesGrpc.PrimesImplBase;
import dynamicinvocation.gen.Task;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class PrimesImpl extends PrimesImplBase {
    @Override
    public void generatePrimeNumbers(Task request, StreamObserver<Number> responseObserver) {
        System.out.println("generatePrimeNumbers IS STARTING (MAX=" + request.getMax() + ")");
        for (int i = 0; i < request.getMax(); i++) {
            if (isPrime(i)) {
                Number number = Number.newBuilder().setValue(i).build();
                responseObserver.onNext(number);
            }
        }
        responseObserver.onCompleted();
        System.out.println("generatePrimeNumbers COMPLETED");
    }

    @Override
    public StreamObserver<Number> countPrimeNumbers(StreamObserver<Report> responseObserver) {
        System.out.println("countPrimeNumbers BEGIN");
        return new StreamObserver<>() {
            private int count = 0;
            private final long startTime = System.nanoTime();

            @Override
            public void onNext(Number number)
            {
                System.out.println("countPrimeNumbers RECEIVED NUMBER: " + number.getValue());
                if (PrimesImpl.isPrime(number.getValue())) {
                    count++;
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("countPrimeNumbers ERROR");
            }

            @Override
            public void onCompleted() {
                long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                responseObserver.onNext(Report.newBuilder().setCount(count).setElapsedTime((int) seconds).build());
                responseObserver.onCompleted();
                System.out.println("countPrimeNumbers END");
            }
        };
    }

    public static boolean isPrime(int val)
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        if (val <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }
}



