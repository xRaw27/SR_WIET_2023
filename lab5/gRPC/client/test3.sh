grpcurl -d \
'{"optype": "M_SUM", "arg1": {"rows": 3, "cols": 3, "matrix": [1, 2, 3, 4, 5, 6, 7, 8, 9]}, "arg2": {"rows": 3, "cols": 3, "matrix": [1, 2, 3, 4, 5, 6, 7, 8, 9]}}' \
-plaintext 127.0.0.1:50051 calculator.Calculator/MatrixOperation

grpcurl -d \
'{"optype": "M_MUL", "arg1": {"rows": 3, "cols": 3, "matrix": [1, 2, 3, 4, 5, 6, 7, 8, 9]}, "arg2": {"rows": 3, "cols": 3, "matrix": [1, 2, 3, 4, 5, 6, 7, 8, 9]}}' \
-plaintext 127.0.0.1:50051 calculator.Calculator/MatrixOperation
