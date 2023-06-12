grpcurl -d '{"arg1": 11, "arg2": 27}' -plaintext 127.0.0.1:50051 calculator.Calculator/Add
grpcurl -d '{"arg1": 11, "arg2": 27}' -plaintext 127.0.0.1:50051 calculator.Calculator/Subtract
grpcurl -d '{"arg1": 11, "arg2": 27}' -plaintext 127.0.0.1:50051 calculator.Calculator/Multiply
grpcurl -d '{"arg1": 11, "arg2": 27}' -plaintext 127.0.0.1:50051 calculator.Calculator/Divide