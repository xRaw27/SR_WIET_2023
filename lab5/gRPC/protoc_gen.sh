protoc -I. --java_out=gen --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java.exe --grpc-java_out=gen proto/calculator.proto
protoc -I. --java_out=gen --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java.exe --grpc-java_out=gen proto/primes.proto
