#below are some example for iterating the List and dict.
a=[10,2,1,3,4,5,8]
for x in a:
    print(x);
for x in range(len(a)):
    print(x)
i=0
while i <len(a):
    print(i);
    print(a[i])
    i =i+1;
tempDict={'Name':'Amit','Occupation':'Job'}
for key in tempDict:
    print(key,tempDict[key])
for key in tempDict.items():
    print(key)
for key,value in tempDict.items():
    print(key,value)

#patching of the array.
def minPatches(nums, n):
    sum = 1
    i = 0
    count = 0
    while sum <= n:
        if i < nums.__len__() and nums[i] <= sum:
            sum = sum+nums[i]
            i =i+1
        else:
            sum <<= 1
            count= count+1
    print(count)
#this is the application for mulitplying big numbers.

def multiply(a,b):
    result =[]
    count =0;
    temp =0;
    if(b>10):
        while(b>10):
            temp = b%10
            result.insert(count,a*temp);
            count =count+1
            b=int(b/10)
        result.insert(count,a*b);
    print(result)
    add(result)
def add(result):
    res =0
    for x in range(len(result)):
        if x>0:
            result[x] = result[x]*10
        res= res+result[x]
        print(res)
    print(res)
