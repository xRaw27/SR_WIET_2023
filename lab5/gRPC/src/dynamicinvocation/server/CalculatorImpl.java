package dynamicinvocation.server;

import dynamicinvocation.gen.*;
import dynamicinvocation.gen.CalculatorGrpc.CalculatorImplBase;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorImpl extends CalculatorImplBase {
    @Override
    public void add(ArithmeticOpArguments request, StreamObserver<ArithmeticOpResult> responseObserver) {
        System.out.println("addRequest (" + request.getArg1() + ", " + request.getArg2() + ")");

        double val = request.getArg1() + request.getArg2();

        ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void subtract(ArithmeticOpArguments request, StreamObserver<ArithmeticOpResult> responseObserver) {
        System.out.println("subtractRequest (" + request.getArg1() + ", " + request.getArg2() + ")");

        double val = request.getArg1() - request.getArg2();

        ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void multiply(ArithmeticOpArguments request, StreamObserver<ArithmeticOpResult> responseObserver) {
        System.out.println("multiplyRequest (" + request.getArg1() + ", " + request.getArg2() + ")");

        double val = request.getArg1() * request.getArg2();

        ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void divide(ArithmeticOpArguments request, StreamObserver<ArithmeticOpResult> responseObserver) {
        System.out.println("divideRequest (" + request.getArg1() + ", " + request.getArg2() + ")");

        double val = request.getArg1() / request.getArg2();

        ArithmeticOpResult result = ArithmeticOpResult.newBuilder().setRes(val).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void complexOperation(ComplexArithmeticOpArguments request, StreamObserver<ComplexArithmeticOpResult> responseObserver) {
        System.out.println("complexOperationRequest (" + request.getOptype() + ", " + request.getArgsList()+ ")");

        if (request.getArgsCount() == 0) {
            System.out.println("complexOperationRequest NO ARGUMENTS");
        }

        double res = 0;
        switch (request.getOptype()) {
            case SUM -> {
                for (Double d : request.getArgsList()) res += d;
            }
            case AVG -> {
                for (Double d : request.getArgsList()) res += d;
                res /= request.getArgsCount();
            }
            case MIN -> {
                res = request.getArgsList().get(0);
                for (Double d : request.getArgsList()) res = (d < res) ? d : res;
            }
            case MAX -> {
                res = request.getArgsList().get(0);
                for (Double d : request.getArgsList()) res = (d > res) ? d : res;
            }
            case UNRECOGNIZED -> throw new RuntimeException("complexOperationRequest UNRECOGNIZED OPERATION");
        }

        ComplexArithmeticOpResult result = ComplexArithmeticOpResult.newBuilder().setRes(res).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    @Override
    public void matrixOperation(MatrixOpArguments request, StreamObserver<MatrixOpResult> responseObserver) {
        System.out.println("matrixOperationRequest (" + request.getOptype() + ", " + request.getArg1().getMatrixList() + ", " + request.getArg2().getMatrixList() + ")");

        Matrix2D m1 = request.getArg1();
        Matrix2D m2 = request.getArg2();
        int rows1 = m1.getRows();
        int rows2 = m2.getRows();
        int cols1 = m1.getCols();
        int cols2 = m2.getCols();
        int len1 = m1.getMatrixCount();
        int len2 = m2.getMatrixCount();
        List<Double> matrix1 = m1.getMatrixList();
        List<Double> matrix2 = m1.getMatrixList();

        if (rows1 * cols1 != len1 || rows2 * cols2 != len2) {
            throw new IllegalArgumentException("matrixOperationRequest INVALID MATRIX SIZE");
        }

        List<Double> res = new ArrayList<>();

        switch (request.getOptype()) {
            case M_SUM -> res = matrixAdd(rows1, cols1, matrix1, rows2, cols2, matrix2);
            case M_MUL -> res = matrixMul(rows1, cols1, matrix1, rows2, cols2, matrix2);
            case UNRECOGNIZED -> throw new RuntimeException("matrixOperationRequest UNRECOGNIZED OPERATION");
        }

        Matrix2D resultMatrix = Matrix2D.newBuilder().setRows(rows1).setCols(cols2).addAllMatrix(res).build();
        MatrixOpResult result = MatrixOpResult.newBuilder().setRes(resultMatrix).build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    private List<Double> matrixAdd(int rowsA, int colsA, List<Double> matrixA, int rowsB, int colsB, List<Double> matrixB) throws IllegalArgumentException {
        if (rowsA != rowsB || colsA != colsB) {
            throw new IllegalArgumentException("matrixOperationRequest MATRICES HAVE DIFFERENT SIZES");
        }

        List<Double> result = new ArrayList<>(Collections.nCopies(rowsA * colsA, 0.0));

        for (int i = 0; i < rowsA * colsA; i++) {
            double sum = matrixA.get(i) + matrixB.get(i);
            result.set(i, sum);
        }

        return result;
    }

    private List<Double> matrixMul(int rowsA, int colsA, List<Double> matrixA, int rowsB, int colsB, List<Double> matrixB) throws IllegalArgumentException {
        if (colsA != rowsB) {
            throw new IllegalArgumentException("matrixOperationRequest INCORRECT DIMENSIONS FOR MATRIX MULTIPLICATION");
        }

        List<Double> result = new ArrayList<>(Collections.nCopies(rowsA * colsB, 0.0));

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    double elemA = matrixA.get(i * colsA + k);
                    double elemB = matrixB.get(k * colsB + j);
                    double prod = elemA * elemB;
                    double sum = result.get(i * colsB + j) + prod;
                    result.set(i * colsB + j, sum);
                }
            }
        }

        return result;
    }
}
