import sys

t = int(sys.stdin.readline())
for _ in range(t):
    chars = dict()
    a = sys.stdin.readline().strip()
    b = sys.stdin.readline().strip()
    for c in a:
        chars[c] = 1
    found = False
    for c in b:
        if c in chars:
            print('YES')
            found = True
            break
    if not found:
        print('NO')
