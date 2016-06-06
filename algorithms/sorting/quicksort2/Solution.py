import sys

def print_arr(arr, lo, hi):
    for n in range(lo,hi+1):
        print(arr[n], end=" ")
    if hi != lo:
        print()


def partition(arr, lo, hi, lo_list, hi_list):
    lo_k, hi_k = 0,0
    pivot = arr[lo]
    for i in range(lo+1, hi+1):
        if arr[i] < pivot:
            lo_list[lo_k] = arr[i]
            lo_k = lo_k + 1
        else:
            hi_list[hi_k] = arr[i]
            hi_k = hi_k + 1
    for i in range(lo_k):
        arr[lo+i] = lo_list[i]
    arr[lo+lo_k] = pivot
    for i in range(hi_k):
        arr[lo+lo_k + i + 1] = hi_list[i]
    return lo+lo_k


def sort(arr, lo, hi, lo_list, hi_list):
    if lo >= hi: return
    j = partition(arr, lo, hi, lo_list, hi_list)
    sort(arr, lo, j-1, lo_list, hi_list)
    sort(arr, j+1, hi, lo_list, hi_list)
    print_arr(arr, lo, hi)


n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

sort(arr, 0, len(arr)-1, [0 for i in range(n)], [0 for i in range(n)])
