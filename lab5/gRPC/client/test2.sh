grpcurl -d '{"optype": "SUM", "args": [3,5,7,1,3,8,5,3]}' -plaintext 127.0.0.1:50051 calculator.Calculator/ComplexOperation
grpcurl -d '{"optype": "AVG", "args": [3,5,7,1,3,8,5,3]}' -plaintext 127.0.0.1:50051 calculator.Calculator/ComplexOperation
grpcurl -d '{"optype": "MIN", "args": [3,5,7,1,3,8,5,3]}' -plaintext 127.0.0.1:50051 calculator.Calculator/ComplexOperation
grpcurl -d '{"optype": "MAX", "args": [3,5,7,1,3,8,5,3]}' -plaintext 127.0.0.1:50051 calculator.Calculator/ComplexOperation