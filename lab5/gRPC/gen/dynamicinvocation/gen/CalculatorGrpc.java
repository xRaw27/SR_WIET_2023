package dynamicinvocation.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: proto/calculator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CalculatorGrpc {

  private CalculatorGrpc() {}

  public static final String SERVICE_NAME = "calculator.Calculator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = dynamicinvocation.gen.ArithmeticOpArguments.class,
      responseType = dynamicinvocation.gen.ArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getAddMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult> getAddMethod;
    if ((getAddMethod = CalculatorGrpc.getAddMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getAddMethod = CalculatorGrpc.getAddMethod) == null) {
          CalculatorGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("Add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getSubtractMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subtract",
      requestType = dynamicinvocation.gen.ArithmeticOpArguments.class,
      responseType = dynamicinvocation.gen.ArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getSubtractMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult> getSubtractMethod;
    if ((getSubtractMethod = CalculatorGrpc.getSubtractMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getSubtractMethod = CalculatorGrpc.getSubtractMethod) == null) {
          CalculatorGrpc.getSubtractMethod = getSubtractMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subtract"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("Subtract"))
              .build();
        }
      }
    }
    return getSubtractMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getMultiplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Multiply",
      requestType = dynamicinvocation.gen.ArithmeticOpArguments.class,
      responseType = dynamicinvocation.gen.ArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getMultiplyMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult> getMultiplyMethod;
    if ((getMultiplyMethod = CalculatorGrpc.getMultiplyMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getMultiplyMethod = CalculatorGrpc.getMultiplyMethod) == null) {
          CalculatorGrpc.getMultiplyMethod = getMultiplyMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Multiply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("Multiply"))
              .build();
        }
      }
    }
    return getMultiplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getDivideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Divide",
      requestType = dynamicinvocation.gen.ArithmeticOpArguments.class,
      responseType = dynamicinvocation.gen.ArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments,
      dynamicinvocation.gen.ArithmeticOpResult> getDivideMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult> getDivideMethod;
    if ((getDivideMethod = CalculatorGrpc.getDivideMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getDivideMethod = CalculatorGrpc.getDivideMethod) == null) {
          CalculatorGrpc.getDivideMethod = getDivideMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.ArithmeticOpArguments, dynamicinvocation.gen.ArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Divide"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("Divide"))
              .build();
        }
      }
    }
    return getDivideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.ComplexArithmeticOpArguments,
      dynamicinvocation.gen.ComplexArithmeticOpResult> getComplexOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComplexOperation",
      requestType = dynamicinvocation.gen.ComplexArithmeticOpArguments.class,
      responseType = dynamicinvocation.gen.ComplexArithmeticOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.ComplexArithmeticOpArguments,
      dynamicinvocation.gen.ComplexArithmeticOpResult> getComplexOperationMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.ComplexArithmeticOpArguments, dynamicinvocation.gen.ComplexArithmeticOpResult> getComplexOperationMethod;
    if ((getComplexOperationMethod = CalculatorGrpc.getComplexOperationMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getComplexOperationMethod = CalculatorGrpc.getComplexOperationMethod) == null) {
          CalculatorGrpc.getComplexOperationMethod = getComplexOperationMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.ComplexArithmeticOpArguments, dynamicinvocation.gen.ComplexArithmeticOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComplexOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ComplexArithmeticOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.ComplexArithmeticOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("ComplexOperation"))
              .build();
        }
      }
    }
    return getComplexOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamicinvocation.gen.MatrixOpArguments,
      dynamicinvocation.gen.MatrixOpResult> getMatrixOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MatrixOperation",
      requestType = dynamicinvocation.gen.MatrixOpArguments.class,
      responseType = dynamicinvocation.gen.MatrixOpResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamicinvocation.gen.MatrixOpArguments,
      dynamicinvocation.gen.MatrixOpResult> getMatrixOperationMethod() {
    io.grpc.MethodDescriptor<dynamicinvocation.gen.MatrixOpArguments, dynamicinvocation.gen.MatrixOpResult> getMatrixOperationMethod;
    if ((getMatrixOperationMethod = CalculatorGrpc.getMatrixOperationMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getMatrixOperationMethod = CalculatorGrpc.getMatrixOperationMethod) == null) {
          CalculatorGrpc.getMatrixOperationMethod = getMatrixOperationMethod =
              io.grpc.MethodDescriptor.<dynamicinvocation.gen.MatrixOpArguments, dynamicinvocation.gen.MatrixOpResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MatrixOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.MatrixOpArguments.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamicinvocation.gen.MatrixOpResult.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("MatrixOperation"))
              .build();
        }
      }
    }
    return getMatrixOperationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorStub>() {
        @java.lang.Override
        public CalculatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorStub(channel, callOptions);
        }
      };
    return CalculatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorBlockingStub>() {
        @java.lang.Override
        public CalculatorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorBlockingStub(channel, callOptions);
        }
      };
    return CalculatorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalculatorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalculatorFutureStub>() {
        @java.lang.Override
        public CalculatorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalculatorFutureStub(channel, callOptions);
        }
      };
    return CalculatorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void add(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    default void subtract(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubtractMethod(), responseObserver);
    }

    /**
     */
    default void multiply(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMultiplyMethod(), responseObserver);
    }

    /**
     */
    default void divide(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDivideMethod(), responseObserver);
    }

    /**
     */
    default void complexOperation(dynamicinvocation.gen.ComplexArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ComplexArithmeticOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComplexOperationMethod(), responseObserver);
    }

    /**
     */
    default void matrixOperation(dynamicinvocation.gen.MatrixOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.MatrixOpResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMatrixOperationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Calculator.
   */
  public static abstract class CalculatorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CalculatorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Calculator.
   */
  public static final class CalculatorStub
      extends io.grpc.stub.AbstractAsyncStub<CalculatorStub> {
    private CalculatorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorStub(channel, callOptions);
    }

    /**
     */
    public void add(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subtract(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubtractMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void multiply(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void divide(dynamicinvocation.gen.ArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDivideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void complexOperation(dynamicinvocation.gen.ComplexArithmeticOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.ComplexArithmeticOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComplexOperationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void matrixOperation(dynamicinvocation.gen.MatrixOpArguments request,
        io.grpc.stub.StreamObserver<dynamicinvocation.gen.MatrixOpResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMatrixOperationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Calculator.
   */
  public static final class CalculatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CalculatorBlockingStub> {
    private CalculatorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public dynamicinvocation.gen.ArithmeticOpResult add(dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamicinvocation.gen.ArithmeticOpResult subtract(dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubtractMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamicinvocation.gen.ArithmeticOpResult multiply(dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMultiplyMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamicinvocation.gen.ArithmeticOpResult divide(dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDivideMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamicinvocation.gen.ComplexArithmeticOpResult complexOperation(dynamicinvocation.gen.ComplexArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComplexOperationMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamicinvocation.gen.MatrixOpResult matrixOperation(dynamicinvocation.gen.MatrixOpArguments request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMatrixOperationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Calculator.
   */
  public static final class CalculatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<CalculatorFutureStub> {
    private CalculatorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalculatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.ArithmeticOpResult> add(
        dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.ArithmeticOpResult> subtract(
        dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubtractMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.ArithmeticOpResult> multiply(
        dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.ArithmeticOpResult> divide(
        dynamicinvocation.gen.ArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDivideMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.ComplexArithmeticOpResult> complexOperation(
        dynamicinvocation.gen.ComplexArithmeticOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComplexOperationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamicinvocation.gen.MatrixOpResult> matrixOperation(
        dynamicinvocation.gen.MatrixOpArguments request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMatrixOperationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_SUBTRACT = 1;
  private static final int METHODID_MULTIPLY = 2;
  private static final int METHODID_DIVIDE = 3;
  private static final int METHODID_COMPLEX_OPERATION = 4;
  private static final int METHODID_MATRIX_OPERATION = 5;

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
        case METHODID_ADD:
          serviceImpl.add((dynamicinvocation.gen.ArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult>) responseObserver);
          break;
        case METHODID_SUBTRACT:
          serviceImpl.subtract((dynamicinvocation.gen.ArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult>) responseObserver);
          break;
        case METHODID_MULTIPLY:
          serviceImpl.multiply((dynamicinvocation.gen.ArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult>) responseObserver);
          break;
        case METHODID_DIVIDE:
          serviceImpl.divide((dynamicinvocation.gen.ArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.ArithmeticOpResult>) responseObserver);
          break;
        case METHODID_COMPLEX_OPERATION:
          serviceImpl.complexOperation((dynamicinvocation.gen.ComplexArithmeticOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.ComplexArithmeticOpResult>) responseObserver);
          break;
        case METHODID_MATRIX_OPERATION:
          serviceImpl.matrixOperation((dynamicinvocation.gen.MatrixOpArguments) request,
              (io.grpc.stub.StreamObserver<dynamicinvocation.gen.MatrixOpResult>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.ArithmeticOpArguments,
              dynamicinvocation.gen.ArithmeticOpResult>(
                service, METHODID_ADD)))
        .addMethod(
          getSubtractMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.ArithmeticOpArguments,
              dynamicinvocation.gen.ArithmeticOpResult>(
                service, METHODID_SUBTRACT)))
        .addMethod(
          getMultiplyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.ArithmeticOpArguments,
              dynamicinvocation.gen.ArithmeticOpResult>(
                service, METHODID_MULTIPLY)))
        .addMethod(
          getDivideMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.ArithmeticOpArguments,
              dynamicinvocation.gen.ArithmeticOpResult>(
                service, METHODID_DIVIDE)))
        .addMethod(
          getComplexOperationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.ComplexArithmeticOpArguments,
              dynamicinvocation.gen.ComplexArithmeticOpResult>(
                service, METHODID_COMPLEX_OPERATION)))
        .addMethod(
          getMatrixOperationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamicinvocation.gen.MatrixOpArguments,
              dynamicinvocation.gen.MatrixOpResult>(
                service, METHODID_MATRIX_OPERATION)))
        .build();
  }

  private static abstract class CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dynamicinvocation.gen.CalculatorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculator");
    }
  }

  private static final class CalculatorFileDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier {
    CalculatorFileDescriptorSupplier() {}
  }

  private static final class CalculatorMethodDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getSubtractMethod())
              .addMethod(getMultiplyMethod())
              .addMethod(getDivideMethod())
              .addMethod(getComplexOperationMethod())
              .addMethod(getMatrixOperationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
