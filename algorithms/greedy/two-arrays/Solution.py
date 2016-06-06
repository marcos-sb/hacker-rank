import sys

t = int(sys.stdin.readline())

for i in range(t):
    n_k = list(map(int, sys.stdin.readline().split()))
    a = sorted(list(map(int, sys.stdin.readline().split())))
    b = sorted(list(map(int, sys.stdin.readline().split())), reverse=True)

    res = 'YES'
    for j in range(len(a)):
        if a[j] + b[j] < n_k[1]:
            res = 'NO'
            break
    print(res, end='\n')
