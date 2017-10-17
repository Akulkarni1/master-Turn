from __future__ import print_function

def main():
    name = input("Your name: ")
    print (name);
import sys
def main1():
    if sys.version_info.major <3:
        name = raw_input("your name");
    else:
        name = input("your anem");
    print(name);

#a = input ();
#b =input ();
#print(a+b);
#if isinstance(a,str):
#    print("A is string")
if isinstance(12,int):
    print("A is int")
a ="2312dfsd"
if a.isalpha():
    print("it is char")
'''
program to write the code for rectangle.
'''
a = input();
b = input();
if int(a)<0 or int(b)<0:
    print("the side can't be -ve")
else:
    print(int(a)*int(b));

number1 = input();
number2 = input();
print(number1, "+", number2 ,"= " ,int(number1)+int(number2));
print(number1, "-", number2 ,"= " ,int(number1)-int(number2));
print(number1, "*", number2 ,"= " ,int(number1)*int(number2));
print(number1, "/", number2 ,"= " ,int(number1)/int(number2));
