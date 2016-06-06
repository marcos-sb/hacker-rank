import sys

n = int(sys.stdin.readline())
ordertimes = list()

for i in range(n):
    td = list(map(int, sys.stdin.readline().split(" ")))
    t,d = td[0], td[1]
    ordertimes.append([t+d,i+1])

ordertimes.sort()

for el in ordertimes:
    print(el[1], end=' ')
