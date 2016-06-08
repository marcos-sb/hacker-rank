import re, sys

n = int(sys.stdin.readline())
phone_re = re.compile(r"(\d{1,3})[\s\-](\d{1,3})[\s\-](\d{4,10})")

while n > 0:
    m = phone_re.match(sys.stdin.readline().strip())
    print('CountryCode={0},LocalAreaCode={1},Number={2}'.format(m.group(1), m.group(2), m.group(3)), end='\n')
    n -= 1
