import sys, math

m = map(int, sys.stdin.readline().split(' '))
n = next(m)
k = next(m)
l = list(map(int, sys.stdin.readline().split(' ')))

num_k2one = dict()
pair_count = 0

for num in l:
    if num-k > 0: num_k2one[num-k] = 1

for num in l:
    if num in num_k2one:
        pair_count += 1

print(pair_count)
