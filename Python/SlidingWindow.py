
temp ={}

i=0
j=1;
while j<10:
    while i<10:
        temp[j] =i
        i+=1
        j+=1

print temp

t={}
i=0
#for i in range(0,10):
while i<10:
    for j in range(20,30):
        #s =i
        t[j]=i
        i+=1
print t

def slidingWindow(n,w):
    min_left = []
    min_right = []
    min_left[0] = n[0]
    min_right[len[n]-1]= n[len[n]-1]
    for i in range(len(n)):
        if i%w==0:
            min_left[i]= n[i]
        else:
            min_left[i] = min(min_left[i-1],n[i])
        j = len(n)-i-1
        if j%w ==0:
            min_right[j] =n[j]
        else:
            min_right= min(min_right[j+1],n[j])
    sliding_min=[]
    for i ,j range(i+w,len(n)):
        sliding_min[j] = min(min_right[i],min_left[i+w-1])
    return sliding_min

def min (min1,min2):
    if min1<min2:
        return min1
    else:
        min2





