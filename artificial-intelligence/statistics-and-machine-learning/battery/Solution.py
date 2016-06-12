
# import matplotlib.pyplot as plt
# import numpy as np
# from scipy import stats
# import sys
#
# c = list()
# b = list()
# for line in sys.stdin:
#     linesp = list(map(float, line.strip().split(",")))
#     if(linesp[0] < 4):
#         c.append(linesp[0])
#         b.append(linesp[1])
#
# carr = np.array(c)
# barr = np.array(b)
#
# slope, intercept, r_value, p_value, std_err = stats.linregress(c,b)
#
# plt.figure()
# plt.plot(carr,barr, 's')
# plt.show()

# print(slope,intercept,r_value,p_value,std_err)
# 2.0 0.0 1.0 0.0 0.0

import sys

for line in sys.stdin:
    x = float(line.strip())
    y = x < 4 and 2*x or 8
    print(y)
