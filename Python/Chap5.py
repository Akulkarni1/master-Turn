import sys

data = []
for k in range(n):
    a = len(data)
    b = sys.getsizeof(data)
    print('Length: {0: 3d};  Size in bytes: {1: 4d}.format(a, b)')
    data.append(None)
class Dynamic_Array:

    def __init__(self):
        self._n = 0
        self._capacity =1
        self._A= self._make_Array(self._capacity)

# get the maximum from the array rec.
