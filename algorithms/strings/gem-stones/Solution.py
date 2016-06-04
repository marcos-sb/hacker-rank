import sys, string

n = int(sys.stdin.readline())

d = [{} for i in range(n)]

for i in range(n):
    for c in sys.stdin.readline().strip():
        d[i][c] = True

gemelement_count = 0
for c in string.ascii_lowercase:
    gemel = True
    for i in range(n):
        if c not in d[i]:
            gemel = False
            break
    if gemel:
        gemelement_count += 1
print(gemelement_count)
