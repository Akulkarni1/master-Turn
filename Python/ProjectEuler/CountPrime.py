def isprime(num):
    if num< 2:
        return False
    if num == 2:
        return True
    if num % 2 == 0:
        return False
    for i in range(2,num):
        if num % i == 0:
            return False
        return True
def countTwentyPrime():
    count = 0;
    for i in range(2, 1000):
        if isprime(i):
            count = count + 1
            if count == 20:
                print(i)
                break
countTwentyPrime()