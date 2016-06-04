import sys

def check_adjs(matrix, i, j):
    to_check = matrix[i][j]
    return (to_check > matrix[i-1][j] and to_check > matrix[i][j-1] and
        to_check > matrix[i+1][j] and to_check > matrix[i][j+1])

n = int(sys.stdin.readline().strip())

matrix = list()
for i in range(n):
    line_str = sys.stdin.readline().strip()
    line_int = list()
    for char in line_str:
        line_int.append(int(char))
    matrix.append(line_int)

out_matrix = [[el for el in line] for line in matrix]

for i in range(1,n-1):
    for j in range(1, n-1):
        if check_adjs(matrix, i, j):
            out_matrix[i][j] = 'X'

for line in out_matrix:
    for el in line:
        print(el, end='')
    print()
