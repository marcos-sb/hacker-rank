import sys

t = int(sys.stdin.readline())

while t > 0:
    #m = a + b <-> m-a = b
    dif2pos = dict()
    t -= 1
    m = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split(' ')))

    for i in range(n): #put m-a
        if arr[i] < m:
            dif2pos[m-arr[i]] = i+1
    for i in range(n): #locate b (= m-a)
        if arr[i] < m and arr[i] in dif2pos and i+1 != dif2pos[arr[i]]:
            print(i+1, dif2pos[arr[i]], end='\n')
            break
