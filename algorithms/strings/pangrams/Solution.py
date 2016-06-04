import sys

s = sys.stdin.readline().lower()
d = dict()

for c in s:
    if c == ' ': continue
    d[c] = True

if len(d) == ord('z')-ord('a') + 1:
    print('pangram')
else:
    print('not pangram')
