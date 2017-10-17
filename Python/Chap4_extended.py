data = [1,3,6,4,2];
max =0;
def get_max(data):
    global max;
    for numbers in data:
        if(max<numbers):
            max = numbers;
    print(max)
#iterrative get_max;
get_max(data);
#recrusive get_Max;

max1 =0;
size = data.__len__();
i =0;
def get_max_rec(data,t):
    global size;
    global max1;
    global i;
    if(i<size):
        if(max1<data[i]):
            max1 = data[i];
        i =i+1
        get_max_rec(data,i);

#get_max_rec(data,i)
#print("I am max1",max1);
result =1
def get_pow(base,multi):
    global result
    if(int(multi)>0):
        result = int(result)*int(base)
        multi = int(multi)-1;
        get_pow(base,multi)
    print("Ia m result",result);
#get_pow(2,3);

import os;
def disk_usage(path):
    total = os.path.getsize(path) # account for direct usage
    if os.path.isdir(path):
        for filename in os.listdir(path):
             childpath = os.path.join(path, filename) # compose full path to child
 #            total += disk usage(childpath) # add child’s usage to total
  #  print ( {0:<7} .format(total), path) # descriptive output (optional)
    return total
#path = "C:\Users\kulkaram\Downloads";
#disk_usage(path);
print(os.getcwd())
print(os.path.abspath('.py'))
print(os.path.curdir)
print(os.path.dirname('.py'))
