import sys

t = int(sys.stdin.readline())

while t > 0:
    t -= 1
    s = sys.stdin.readline().strip()
    a = s[:len(s)//2]
    b = s[len(s)//2:]

    if len(a) != len(b):
        print(-1)
        continue

    count = 0
    ord_a = ord('a')
    freqs = [0 for i in range(ord('z')-ord_a+1)]
    for letter in a:
        freqs[ord(letter) - ord_a] += 1
    for letter in b:
        freqs[ord(letter) - ord_a] -= 1
    for n in freqs:
        if n != 0: count += abs(n)

    print(count//2)
