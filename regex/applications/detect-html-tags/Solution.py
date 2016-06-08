import sys, re

n = int(sys.stdin.readline())
tags = dict()

regex_att = re.compile(r'\<\s*([^\s\/\>\<]+).*?\>')

while n > 0:
    n -= 1
    line = sys.stdin.readline().strip()
    for tag in regex_att.findall(line):
        tags[tag] = True

print(';'.join(sorted(tags.keys())))
    
