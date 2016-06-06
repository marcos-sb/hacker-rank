import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(' ')))

arr.sort()
min_dif = arr[len(arr)-1] + arr[len(arr)-2]

for i in range(n-1):
    min_dif = min(abs(arr[i]-arr[i+1]), min_dif)

for i in range(n-1):
    if min_dif == abs(arr[i]-arr[i+1]):
        print(arr[i], arr[i+1], end=' ')
