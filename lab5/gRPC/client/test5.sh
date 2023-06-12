grpcurl -d @ -plaintext 127.0.0.1:50051 primes.Primes/CountPrimeNumbers

# { "value": 5 }
# { "value": 8 }
# { "value": 15 }
# { "value": 17 }
# { "value": 20 }