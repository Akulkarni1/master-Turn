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
#countTwentyPrime()
arr =[[]]
def temp(arr):
    product=1
    max =0
    for i in range(1,10):
        for j in range(1,4):
            product =product*arr[i][j]
        if max<product:
            max = product
        product =1

def findabc():
    for a in range(1,31):
        for b in range(1,31):
            for c in range(1,31):
                powa = pow(a,2)
                powb =pow(b,2)
                powc = pow(c,2);
                if powa+powb==powc:
                    print(a,b,c)
#findabc()

def sumOfPrimes(n):
    sum =0
    for i in range(1,n):
        if isprime(i):
          sum =sum+i
    print(sum)
#sumOfPrimes(9)
def arrayRotation(arr, n):
    temparr =[]
    i =n

    count=0
    while i<len(arr):
        temparr[count] = arr[i]
        print(arr[i])
        count=count+1
        i = i+1
    j=0
    while j<n:
        temparr[count] = arr[j]
        count=count+1
        j=j+1
    print(temparr)
arr = [1,2,3,4,5,6]
n= 2
#arrayRotation(arr,n)
def arrRot(arr,n):
    temparr = []
    i =n

    while i<len(arr):
        temparr.append(arr[i])
        print(i)
        #count=count+1
        i = i+1
    for i in range(len(temparr)):
        print(temparr[i])
        i=i+1;

#arrRot(arr,n)
def longestCollatzSeq(num):
    list = []
    while num>1:
        if num%2==0 :
            list.append(num)
            num = num/2
        else:
            num = num*3+1
    print(list.__len__())
    list.clear()
i=0
for i in range(3,10):
    longestCollatzSeq(i)
    i =i+1
