package dynamicinvocation.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: proto/primes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrimesGrpc {

  private PrimesGrpc() {}

  public static final String SERVICE_NAME = "primes.Primes";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.Task,
      dynamicinvocation.gen.Number> getGeneratePrimeNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GeneratePrimeNumbers",
      requestType = dynamicinvocation.gen.Task.class,
      responseType = dynamicinvocation.gen.Number.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.Task,
      dynamicinvocation.gen.Number> getGeneratePrimeNumbersMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.Task, dynamicinvocation.gen.Number> getGeneratePrimeNumbersMethod;
    if ((getGeneratePrimeNumbersMethod = PrimesGrpc.getGeneratePrimeNumbersMethod) == null) {
      synchronized (PrimesGrpc.class) {
        if ((getGeneratePrimeNumbersMethod = PrimesGrpc.getGeneratePrimeNumbersMethod) == null) {
          PrimesGrpc.getGeneratePrimeNumbersMethod = getGeneratePrimeNumbersMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.Task, dynamicinvocation.gen.Number>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GeneratePrimeNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.Task.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.Number.getDefaultInstance()))
              .setSchemaDescriptor(new PrimesMethodDescriptorSupplier("GeneratePrimeNumbers"))
              .build();
        }
      }
    }
    return getGeneratePrimeNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.Number,
      dynamicinvocation.gen.Report> getCountPrimeNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CountPrimeNumbers",
      requestType = dynamicinvocation.gen.Number.class,
      responseType = dynamicinvocation.gen.Report.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.Number,
      dynamicinvocation.gen.Report> getCountPrimeNumbersMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.Number, dynamicinvocation.gen.Report> getCountPrimeNumbersMethod;
    if ((getCountPrimeNumbersMethod = PrimesGrpc.getCountPrimeNumbersMethod) == null) {
      synchronized (PrimesGrpc.class) {
        if ((getCountPrimeNumbersMethod = PrimesGrpc.getCountPrimeNumbersMethod) == null) {
          PrimesGrpc.getCountPrimeNumbersMethod = getCountPrimeNumbersMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.Number, dynamicinvocation.gen.Report>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CountPrimeNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.Number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.Report.getDefaultInstance()))
              .setSchemaDescriptor(new PrimesMethodDescriptorSupplier("CountPrimeNumbers"))
              .build();
        }
      }
    }
    return getCountPrimeNumbersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrimesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimesStub>() {
        @java.lang.Override
        public PrimesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimesStub(channel, callOptions);
        }
      };
    return PrimesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrimesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimesBlockingStub>() {
        @java.lang.Override
        public PrimesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimesBlockingStub(channel, callOptions);
        }
      };
    return PrimesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrimesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimesFutureStub>() {
        @java.lang.Override
        public PrimesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimesFutureStub(channel, callOptions);
        }
      };
    return PrimesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generatePrimeNumbers(dynamicinvocation.gen.Task request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.Number> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGeneratePrimeNumbersMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<dynamicinvocation.gen.Number> countPrimeNumbers(
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.Report> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCountPrimeNumbersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Primes.
   */
  public static abstract class PrimesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PrimesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Primes.
   */
  public static final class PrimesStub
      extends io.grpc.stub.AbstractAsyncStub<PrimesStub> {
    private PrimesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimesStub(channel, callOptions);
    }

    /**
     */
    public void generatePrimeNumbers(dynamicinvocation.gen.Task request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.Number> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGeneratePrimeNumbersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<dynamicinvocation.gen.Number> countPrimeNumbers(
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.Report> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCountPrimeNumbersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Primes.
   */
  public static final class PrimesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PrimesBlockingStub> {
    private PrimesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<dynamicinvocation.gen.Number> generatePrimeNumbers(
        dynamicinvocation.gen.Task request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGeneratePrimeNumbersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Primes.
   */
  public static final class PrimesFutureStub
      extends io.grpc.stub.AbstractFutureStub<PrimesFutureStub> {
    private PrimesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GENERATE_PRIME_NUMBERS = 0;
  private static final int METHODID_COUNT_PRIME_NUMBERS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_PRIME_NUMBERS:
          serviceImpl.generatePrimeNumbers((dynamicinvocation.gen.Task) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.Number>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COUNT_PRIME_NUMBERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.countPrimeNumbers(
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.Report>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGeneratePrimeNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              dynamicinvocation.gen.Task,
              dynamicinvocation.gen.Number>(
                service, METHODID_GENERATE_PRIME_NUMBERS)))
        .addMethod(
          getCountPrimeNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              dynamicinvocation.gen.Number,
              dynamicinvocation.gen.Report>(
                service, METHODID_COUNT_PRIME_NUMBERS)))
        .build();
  }

  private static abstract class PrimesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrimesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dynamicinvocation.gen.PrimesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Primes");
    }
  }

  private static final class PrimesFileDescriptorSupplier
      extends PrimesBaseDescriptorSupplier {
    PrimesFileDescriptorSupplier() {}
  }

  private static final class PrimesMethodDescriptorSupplier
      extends PrimesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrimesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrimesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrimesFileDescriptorSupplier())
              .addMethod(getGeneratePrimeNumbersMethod())
              .addMethod(getCountPrimeNumbersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
