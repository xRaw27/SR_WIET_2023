// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/calculator.proto

package dynamicinvocation.gen;

public interface MatrixOpArgumentsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:calculator.MatrixOpArguments)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.calculator.MatrixOperationType optype = 1;</code>
   * @return The enum numeric value on the wire for optype.
   */
  int getOptypeValue();
  /**
   * <code>.calculator.MatrixOperationType optype = 1;</code>
   * @return The optype.
   */
  dynamicinvocation.gen.MatrixOperationType getOptype();

  /**
   * <code>.calculator.Matrix2D arg1 = 2;</code>
   * @return Whether the arg1 field is set.
   */
  boolean hasArg1();
  /**
   * <code>.calculator.Matrix2D arg1 = 2;</code>
   * @return The arg1.
   */
  dynamicinvocation.gen.Matrix2D getArg1();
  /**
   * <code>.calculator.Matrix2D arg1 = 2;</code>
   */
  dynamicinvocation.gen.Matrix2DOrBuilder getArg1OrBuilder();

  /**
   * <code>.calculator.Matrix2D arg2 = 3;</code>
   * @return Whether the arg2 field is set.
   */
  boolean hasArg2();
  /**
   * <code>.calculator.Matrix2D arg2 = 3;</code>
   * @return The arg2.
   */
  dynamicinvocation.gen.Matrix2D getArg2();
  /**
   * <code>.calculator.Matrix2D arg2 = 3;</code>
   */
  dynamicinvocation.gen.Matrix2DOrBuilder getArg2OrBuilder();
}
