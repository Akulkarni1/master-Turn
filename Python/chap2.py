class Flower:
    def __init__(self,name,number_petals, price):
        self.name = name
        self.number_petals = number_petals
        self.price = price
    def setName(self,name):
        if not name.isalpha():
            self.name=name
        else:
            print("Wrong input");
    def setNumber_petals(self,number):
        if isinstance(number, int):
            self.number_petals = number
        else:
            print" Wrong input";
    def setPrice(self,price):
        if isinstance(price,float):
            self.price = price
        else:
            print" Wrong input";
    def getName(self):
        return self.name;
    def getNumber_petals(self):
        return self.number_petals
    def getPrice(self):
        return self.pric

class CreditCard:
    def __init__(self,customer ,bank, account, limit,):
        self._customer = customer
        self._bank = bank
        self._account = account
        self._limit = limit
        self._balance =0
    def setCustomer(self, customer):
        self._customer = customer
    def setBank(self,bank):
        self._bank = bank
    def setAccount(self,account):
        self._account = account
    def setLimit(self, limit):
        self._limit = limit
    def getCustomer(self):
        return self._customer
    def charge(self,price):
        if price + self._balance > self._limit:  # if charge would exceed limit,
            return False  # cannot accept charge
        else:
            self._balance+=price
            return True
    def makePayment(self, amount):
        self._balance -=amount
class Vector:
    def __init__(self,x,y,z):
        self._x = x
        self._y = y
        self._z = z
    def __add__(self, another_vector):
        x = self._x+another_vector._x
        y = self._y+another_vector._y
        z = self._z+another_vector._z
        r = Vector(x,y,z)
        return r
    def __mul__(self, other):
        x = self._x*other._x
        y = self._y*other._y
        z = self._z*other._z
        r = Vector(x,y,z)
        return r
    def __sub__(self, other):
        x = self._x-other._x
        y = self._y- other._y
        z = self._z - other._z
        r = Vector(x,y,z)
        return r
    def __str__(self):
        s="%d , %d ,%d" % (self._x, self._y,self._z)
        return s
#v1 = Vector(1,2,3)
#v2 = Vector(1,2,3)
#print(v1+v2)

class First(object):
    def __init__(self):
        print("I am in First")
class Second(First):
    def __init__(self):
        super(Second,self).__init__()
        print("I am in Second ")
#Second()

def fibonacci(n):
    if n==0:
        return 1;
    elif n ==1:
        return 1;
    elif n == 2:
        return 2;
    else:
        return fibonacci(n-1)+ fibonacci(n-2);
#print(fibonacci(8))


#f = open("C:\\Python\\temp.txt","w+")
#f.write("Hello ");
#f.write(" This is write in temp.file");
#f.write(" ABCDEFGHIJKLMNOPQRSTUVWXYZ");
#f.close();
#os.chdir(r'C:\Folder')
#with open('C\\Python\\temp.txt') as f:
#    for line in f:
#        print line,

# for reading line use below.
for line in open("C:\\Python\\temp.txt","r").readlines():
    print(line)

dict={}
# for reading character use below.
#def populate_dict(ch):
    #temp=0
    #if ch
#    temp +=1
#    dict[ch] = temp
    #for k, v in dict.iteritems():
     #   print k, v

#for ch in open("C:\\Python\\temp.txt","r").read():
#    populate_dict(ch)
"""with open ("C:\\Python\\temp.txt", "r") as myfile:
    data = myfile.read().replace('\n', '')
    print(data)
    freq = 0
    for char in data:
        if char == data:
            freq = freq + 1
    print(freq)"""

"""with open ("C:\\Python\\temp.txt", "r") as myfile:
    data = myfile.read().replace('\n', '')
    print(data)
    for Symbol in data:
        freq = data.count(Symbol)
        print(Symbol)
        print(freq)
"""
import collections

c = collections.Counter()
with open("C:\\Python\\temp.txt", "r") as f:
    for line in f:
        c.update(line.rstrip().lower())

print 'Most common:'
for letter, count in c.most_common(3):
    print '%s: %7d' % (letter, count)


import string

wordcount = {}
with open("C:\\Python\\temp.txt", "r") as f:
    for line in f:
        line = line.lower() #I suppose you want boy and Boy to be the same word
        for word in line.split():
            #what if your word has funky punctuations chars next to it?
            word = word.translate(string.maketrans("",""), string.punctuation)
            #if it's already in the d increase the number
            try:
                wordcount[word] += 1
            #if it's not this is the first time we are adding it
            except:
                wordcount[word] = 1

print wordcount
class Temp_Emp:
    def __init__(self):
        print("I am inialize");
    def __del__(self):
        print("I am in delete");
i = Temp_Emp()
#to declare abstract class in python.
from abc import ABCMeta, abstractmethod

class Temp_Abstract:
    __metaclass__ = ABCMeta

    @abstractmethod
    def Temp_id(self):
        print(" I am in temp_id")
class Temp(Temp_Abstract):
    def Temp_id(self):
        super(Temp,self).temp_id()
        print("I am in new")

#t = Temp()
"""
In the below code we are checking the book purchasing , selling and reading optition.
"""

def book_interface():
    options ={1: purchase_book,
              2: read_book,
              3: sell_book}
def purchase_book():
        print("I am in purchase book")
def read_book():
    print("I am in readbook")
def sell_book():
    print("I am in sell book")

    print("Input 1 for purchasing the book")
    print("Input 2 for reading the book")
    print("Input 3 for selling the book")
