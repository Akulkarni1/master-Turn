a =[23,12,11,2,1,3,4]
for numbers in a:
    print(numbers);
a = sorted(a);
for numbers in a:
    print(numbers);

for numbers in range(len(a)):
    print (a[numbers])

dicti={"It":1,"Is":2, "again":3, "A":1};
for elements in dicti :
    print(elements, dicti[elements]);

for key ,value in dicti.items():
    print(key, value)

import collections

for k, v in sorted(dicti.items()):
    print (k , v);

dicti={"It":1,"Is":2, "again":3, "A":1};

items = sorted(dicti.values())
for id in items:
    print(id)

sorted_names=sorted(dicti, key=lambda x: dicti[x])
for k in sorted_names:
    print("{} : {}".format(k, dicti[k]))


print(int("29.442"))
#import pip
#installed_packages = pip.get_installed_distributions()
#installed_packages_list = sorted(["%s==%s" % (i.key, i.version)
 #    for i in installed_packages])
#print(installed_packages_list)