import sys

n = int(sys.stdin.readline().strip())
l = list(map(int, sys.stdin.readline().split()))

m = max(l)

counts = [0 for i in range(m+1)]

for x in l:
    counts[x] += 1

cut_count = n

print(cut_count, end='\n')

for x in counts:
    if x == 0: continue
    cut_count -= x
    if cut_count == 0: break
    print(cut_count, end='\n')
