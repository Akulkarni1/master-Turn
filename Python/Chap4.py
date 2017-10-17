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

print(list(unique_permutations((1,2,3,1))))
from itertools import combinations
lis = [1, 2, 3, 4]
for i in xrange(1, len(lis) + 1):  #  xrange will return the values 1,2,3,4 in this loop
    print list(combinations(lis, i))

def draw_line(tick_length, tick_label=''):
    line = '-'*tick_length
    if tick_label:
        line+=''+tick_label
    print(line)
def draw_interval(center_length):
    if center_length >0:
        draw_interval(center_length-1)
        draw_line(center_length)
        draw_interval(center_length-1)
def draw_ruler(number_inches, major_length):
    draw_line(major_length,'0')
    for j in range(1,1+number_inches):
        draw_interval(major_length-1)
        draw_line(major_length,str(j))

import os

def disk_Usage (path):
    total = os.path.getsize(path)
    if(os.path.isdir(path)):
        for filename in os.listdir(path):
            childpath= os.path.join(path,filename)
            total += disk_Usage(childpath)
    print('{0:<7}',format(total),path)
    return total

#disk_Usage("C:\Users\kulkaram\Downloads")
getlist=[]
def isPalindrome(s):
    if len(s) <= 1:
        return True
    return s[0] == s[-1] and isPalindrome(s[1:-1])

print(isPalindrome("abatba"))


l1 = [1,2,3,4,5,6]
l1.append(7)
l1.remove(6)
t = l1.__getitem__(3)
print(t)
print(l1)

def hanoi(n,source,helper,target):
    if n >0 :
        hanoi(n-1,source, target,helper)
        if source :
            target.append(source.pop())
        hanoi(n-1,helper,source,target)
source =[4,3,2,1]
target = []
helper = []
#hanoi(len(source),source,helper,target)

#print source,helper, target

temp_list1 = []
def reverse(str):
    for i in str:
        temp_list1.appen(str(i))
    for i in len(temp_list1):
        print(temp_list1)
reverse("AMIT")