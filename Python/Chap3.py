def fact(n):
    if n ==0 :
        return 1;
    else:
        return n* fact(n-1);
#print(fact (5))
def rec_bin_search(data, target, low , high):
    if low > high :
        return False;
    else:
        mid = (low+high)/2;
        if target == data[mid]:
            return True;
        elif target < data[mid]:
            return rec_bin_search(data, target,low,mid-1);
        else:
            return rec_bin_search(data, target,mid+1, high);
list =[1,2,4,5,7,8,9]
print(rec_bin_search(list,4,0,len(list)))
import os.path
print(os.path.isdir("C:\\Python"));

def good_fibo(n):
    if(n<=1):
        return (n,0)
    else:
        (a,b) = good_fibo(n-1)
        return (a+b,a)
print(good_fibo(10))

def reverse(s,start,stop):
    if start<stop-1:
        s[start],s[stop] = s[stop],s[start]
        reverse(s,start+1,stop-1)
def power(x,n):
    if n==0 :
        return 1;
    else:
        return x*power(x,n-1)

print(power(3,2))

def binary_sum(s,start,stop):
    if start >= stop :
        return 0
    elif start == stop-1:
        return s[start]
    else :
        mid = (start+stop)//2
        return binary_sum(s, start,mid) + binary_sum(s,mid, stop)
list = [4,2,5,1,3]
#print(binary_sum(list,0,len(list)))
min = list[0]
max =0
"""def rec_get_min(list,low, high,min):
    if low == high-1 :
        return min;
    elif low <high-1:
        low=low + 1
        if min > list[low]:
            min=list[low]
    rec_get_min(list, low, high, min)
    return min
"""

#This function is wrong , need to check.
def rec_get_min(list,low,high,min):
    if low<high:
        if min>list[low]:
            min = list[low]
        rec_get_min(list,low+1,high,min)
    elif low==high-1:
        temp = min
        return temp;
    return min


def get_min(list):
    min = list[0]
    i=0
    while i < len(list):
        if min > list[i] :
            min = list[i]
        i+=1
    return min;

#print(get_min(list))
#print(rec_get_min(list,0,len(list),min))

def get_product_by_sum(m,n,count):
    if n==0:
        return 0;
    if count == n:
        return m-m
    elif count<n:
        count = count+1
        m = m+get_product_by_sum(m,n,count)
        return m;
print(get_product_by_sum(4,4,0))

import itertools
itertools.permutations([1,2,3,4])

#print(list(itertools.permutations(set([1,2,3,4,5]))))
list3=[]
def unique_permutations(elements):
    if len(elements) == 1:
        yield (elements[0],)
    else:
        unique_elements = set(elements)
        for first_element in unique_elements:
            remaining_elements = list(elements)
            remaining_elements.remove(first_element)
            for sub_permutation in unique_permutations(remaining_elements):
                yield (first_element,) + sub_permutation

print(list3(unique_permutations((1,2,3,1))))


list1 =[1,2,3,2,1]
list = []
