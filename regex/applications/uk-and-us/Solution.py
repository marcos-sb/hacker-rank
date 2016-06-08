import sys, re

n = int(sys.stdin.readline())

lines = list()
while n > 0:
    n -= 1
    lines.append(sys.stdin.readline().strip())

m = int(sys.stdin.readline())
while m > 0:
    m -= 1
    w = sys.stdin.readline().strip()
    w_regex = '{0}{1}|{0}{2}'.format(w[:-2],'se','ze')
    matcher = re.compile(w_regex)
    matches = 0
    for line in lines:
        matches += len(matcher.findall(line))
    print(matches, end='\n')
