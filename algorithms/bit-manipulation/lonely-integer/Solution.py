import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(' ')))
xor = 0

for num in arr:
    xor ^= num

print(xor, end='\n')
