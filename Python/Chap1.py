def is_multiple(n, m):
    if (n % m == 0):
        return True
    if (m % n == 0):
        return True
    else:
        return False


def is_even(n):
    if (n % 2 == 0):
        return True;
    else:
        return False;


def is_even_other(n):
    if (n & 1 == 0):
        return True;
    else:
        return False;


# n = int(input());
# m = int(input());
# print(is_even(n))
# print(is_multiple(n,m))
# print(is_even_other(n))
l = [2, 1, 4, 3, 0, 5, 10];


def min(li):
    if isinstance(li, list):
        min =li[0]
        for i in range(len(li)):
            #print(li[i]);
            if min > li[i]:
                min = li[i]
        print (min);
def max(li):
    if isinstance(li,list):
        max = li[0];
        for i in range(len(li)):
            if max< li[i]:
                max = li[i]
        print (max);


def getSquare(l):
    return l * l


def sum_positive_Square(data):
    sum=0
    i=0
    while (i < data):
        square=getSquare(i)
        sum=sum + square
        i = i+1
    print(sum)


#min(l);
#max(l);
def sum_odd_positive(data):
    if data>0:
        i =0;
        sum =0;
        while(i<data):
            if i%2!=0:
                square = getSquare(i)
                sum = sum+square
                i = i+1
        print(sum)

#data = int (input())
import random

#sum_positive_Square(data)
#j = random.randint(0,10)
def randmy():
    l =random.randrange(1,15)
    l = l+random.randint(0,14)
    print(l)
    return l
#print(j);
#j = randmy()
#print(j)

list2= [1,2,3,4,5,6,7,3,2]
#list2.reverse()
print(list2)
def myreverse(list2):
    list2[:]=list2[::-1]
    return list2


#list4 = myreverse(list2)

#print(list4)

lis = []
for i in list2:
    if i not in lis:
        lis.append(i)

#print(lis);

dict ={"Name":"Amit","Name":"MAP"}
print(dict.values())


for k in dict:
    print(k);
for k,v in dict.items():
    print(k,v);


a ='a'
count =1
while count<26:
#    print(chr(ord(a)+1))
    count = count+1
    a = chr(ord(a)+1)

lis2 = [1,2,3,5,5,6]
lis3 =[1,2,3,4,5,1]
#print(lis2[10]);
def mul(lis2,lis3):
    if len(lis2)==len(lis3):
        count =0
        c= []
        for i in range(len(lis2)):
            c.append(lis2[i]*lis3[count])
            count = count+1
        print(c);
#mul(lis2,lis3)
str = "amait";
count =0
print(str.find('a'));
for i in str:
    if(i =='a'):
        count = count+1;
print(count)
try :
    i = 10/0
except:
    print("Math error")
else:
    print("I am in else")
finally:
    print("I am in Finally");

str = "Let's try , Mike";
str = str.replace(",","")
str = str.replace("\'","")
print(str);
alist = [1,3,6,2,4]
print(alist)
alist.sort();
print(alist)
charlist = ['c','a','t','d','o','g']
from itertools import permutations
perms =[''.join(p) for p in permutations(charlist)]
print(perms);

blis = []
j =0;
while j<5:
    i = random.randrange(1,20);
    if i not in blis:
        blis.append(i)
        j = j+1;
print(blis);
def insertionSort(alist):
   for index in range(1,len(alist)):

     currentvalue = alist[index]
     position = index

     while position>0 and alist[position-1]>currentvalue:
         alist[position]=alist[position-1]
         position = position-1

     alist[position]=currentvalue


list = [2,4,7,5,1]
insertionSort(list)
print(list)

#sequential search and Binary search.

i = 10
clist=[1,20,2,3,5,7,10,11,12]

def seq_search(clist,i):
    count =0
    for c in clist:
        count = count+1
        if c == i:
            return count;
        else:
            print("Not found yet");


#print(seq_search(clist,i))
def binary_search(clist,i):
    low =0;
    clist.sort();
    high = len(clist)
    flag = False
    while low<high :
        mid = (low+high)/2

        if clist[mid]== i:
            flag = True
            return mid
        elif clist[mid]<i:
            low = mid
        elif clist[mid]>i:
            high =mid
    return flag;

#print(binary_search(clist,i))

def merge_sort(alist):
    print("spliting");

    if len(alist)>1:
        mid = len(alist)//2
        left = alist[:mid]
        right = alist[mid:]
        merge_sort(left)
        merge_sort(right)

        i =0
        j =0
        k =0
        while i< len(left) and j < len(right):
            if left[i] < right[i]:
                alist[k] = left[i]
                i += 1
            else:
                alist[k] = right[j]
                j+= 1
            k +=1
        while i<len(left):
            alist[k] = left[i]
            i +=1
            k +=1
        while j<len(right):
            alist[k] = right[j]
            j+=1
            k+=1
    print("merging",alist);


#merge_sort(clist)
#print(clist);
def swap(i):
    i =10;
    return i

def swap(i):
    i =210;
    return i

i =20;
i =swap(i)
#i =20;
#j =10;
#swap(i,j)
print(i);
def dswap(i,j):
    t = i
    i = j
    j = t
i =10;
j = 20;

i,j = j,i

print(i ,j)




class CreditCard:
    'base class for the credit card'
    def __init__(self, customer, balance,bank,limit,account):
        self._customer = customer
        self._bank = bank
        self._account = account
        self._balance = balance
        self._limit = limit
    def get_customer(self):
        return self._customer;
    def get_bank(self):
        return self._bank;

