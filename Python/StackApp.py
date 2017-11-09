'''
Best example of backtracking.
'''
class Stack:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def size(self):
        return len(self.items)

s = Stack()
sumInStack=0
targetSum=15
DATA = [1,3,4,5,6,2,7,8,9,10,11,13,14,15]
def populateSubset (data, fromIndex,endIndex,sumInStack,targetSum):
    if sumInStack == targetSum:
        print(s)
    currentIndex=fromIndex
    while currentIndex < endIndex :
        if sumInStack + data[currentIndex] <= targetSum:
            s.push(data[currentIndex])
            sumInStack += data[currentIndex]
            populateSubset(data, currentIndex + 1, endIndex,sumInStack,targetSum)
        currentIndex = currentIndex + 1
        sumInStack = sumInStack- s.pop()

print(DATA.__len__()-1);
populateSubset(DATA,0,13,0,15)