import sys

def isort(arr):
    arr_len = len(arr)
    count = 0
    for i in range(arr_len):
        for j in range(i,0,-1):
            if arr[j] > arr[j-1]:
                break
            else:
                arr[j-1],arr[j] = arr[j],arr[j-1]
                count = count + 1
    return count


def __partition__(arr, lo, hi, count):
    i = lo
    pivot = arr[hi]

    for j in range(lo, hi):
        if arr[j] <= pivot:
            arr[j], arr[i] = arr[i], arr[j]
            count = count + 1
            i = i + 1

    arr[i], arr[hi] = arr[hi], arr[i]
    count = count + 1

    return i, count


def qsort(arr, lo, hi, count):
    if lo >= hi:
        return count
    j, count = __partition__(arr, lo, hi, count)
    count = qsort(arr, lo, j-1, count)
    count = qsort(arr, j+1, hi, count)
    return count



n = int(sys.stdin.readline())
iarr = list(map(int, sys.stdin.readline().split()))
qarr = list(iarr)  # it creates a copy

print(isort(iarr) - qsort(qarr, 0, len(qarr)-1, 0))
