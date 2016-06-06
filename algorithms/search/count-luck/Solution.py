import sys, pdb

mov2camefrom = {'l':'r', 'r':'l','u':'d', 'd':'u'}

def validpos(pos, mat, n, m):
    return 0 <= pos[0] < n and 0 <= pos[1] < m and mat[pos[0]][pos[1]] != 'X'

def cal4pos(pos):
    return {'l': [pos[0],pos[1]-1], 'r': [pos[0], pos[1]+1], 'u': [pos[0]-1, pos[1]], 'd':[pos[0]+1, pos[1]]}

def findpath(pos, mat, n, m):
    def fp_rec(pos, mat, mov, movs):
        new_pos = cal4pos(pos)[mov]
        if not validpos(new_pos, mat, n, m):
            return []
        movs.append([pos, mov])
        if mat[new_pos[0]][new_pos[1]] == '*':
            return movs

        next_movs = cal4pos(new_pos)
        next_movs.pop(mov2camefrom[mov])
        for next_mov in next_movs:
            path = fp_rec(new_pos, mat, next_mov, movs)
            if path:
                return path
        movs.pop()
        return []

    movs = ['l','r','u','d']
    for mov in movs:
        path = fp_rec(pos, mat, mov, list())
        if path:
            return path

def starting_pos(mat, n, m):
    for i in range(n):
        for j in range(m):
            if mat[i][j] == 'M':
                  return [i, j]

def multiplePaths(pos, camefrom, mat, n, m):
    next_movs = cal4pos(pos)
    if camefrom:
        next_movs.pop(camefrom)
    pathcount = 0
    for mov in next_movs:
        next_pos = next_movs[mov]
        if validpos(next_pos, mat, n, m):
            pathcount += 1
    return pathcount > 1

def exitForest(start, mat, n, m, path):
    wwand = 0
    camefrom = None
    for posmov in path:
        if multiplePaths(posmov[0], camefrom, mat, n, m):
            wwand += 1
        camefrom = mov2camefrom[posmov[1]]
    return wwand

t = int(sys.stdin.readline())
while t > 0:
    t -= 1
    line = sys.stdin.readline().split(' ')
    n = int(line[0])
    m = int(line[1])
    mat = list()
    for i in range(n):
        mat.append(sys.stdin.readline())
    k = int(sys.stdin.readline())

    start = starting_pos(mat, n, m)
    path = findpath(start, mat, n, m)
    if exitForest(start, mat, n, m, path) == k:
        print('Impressed')
    else:
        print('Oops!')
