import sys

def dist(a,b):
    return abs(a[0]-b[0]) + abs(a[1]-b[1])

def valid(m,n):
    return True if m[0] >= 0 and m[0] < n and m[1] >= 0 and m[1] < n else False

def end_conditions(m,p,n, current_dist):
    return valid(m,n) and dist(m,p) < current_dist

def nextMove(m,p,n):
    current_dist = dist(m,p)

    _m = [m[0],m[1]-1]
    if end_conditions(_m,p,n,current_dist):
        return 'LEFT'

    _m = [m[0],m[1]+1]
    if end_conditions(_m,p,n,current_dist):
        return 'RIGHT'

    _m = [m[0]-1,m[1]]
    if end_conditions(_m,p,n,current_dist):
        return 'UP'

    _m = [m[0]+1,m[1]]
    if end_conditions(_m,p,n,current_dist):
        return 'DOWN'

    return 'WOPS!'

n = int(sys.stdin.readline())
m = list(map(int, sys.stdin.readline().split(" ")))

for i in range(n):
    line = sys.stdin.readline()
    for j in range(n):
        if(line[j] == 'p'):
            p = [i,j]

print(nextMove(m,p,n))
