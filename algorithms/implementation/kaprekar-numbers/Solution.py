import sys

def kaprekar(n):
    n_digit_count = len(str(n))
    m_str = str(n*n)
    r_str = m_str[-n_digit_count:]
    l_str = m_str[:-n_digit_count]
    l = 0 if len(l_str) == 0 else int(l_str)
    r = int(r_str)
    return l + r == n

p = int(sys.stdin.readline())
q = int(sys.stdin.readline())

exists = False
for i in range(p,q+1,1):
    if kaprekar(i):
        print(i, end=' ')
        exists = True
if not exists:
    print('INVALID RANGE')
