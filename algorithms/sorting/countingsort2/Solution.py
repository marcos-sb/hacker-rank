import sys

n = int(sys.stdin.readline().strip())
l = list(map(int, sys.stdin.readline().split()))

counts = [0 for i in range(100)]

for x in l:
    counts[x] += 1

for i in range(len(counts)):
    times = counts[i]
    while times > 0:
        print(i, end=" ")
        times -= 1
    
