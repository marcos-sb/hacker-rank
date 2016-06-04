import sys

class anagram:
  def __init__(self, s):
    self.s = s
    self.d = dict()
    for c in s:
        if c not in self.d:
            self.d[c] = 1
        else:
            self.d[c] += 1

  def __eq__(self,other):
    return self.d == other.d

  def __hash__(self):
    return hash(frozenset(self.d.items()))

  def __repr__(self):
    return repr(self.s)

  def __str__(self):
    return self.s

n = int(sys.stdin.readline())

while n > 0:
  count = 0
  n -= 1
  word = sys.stdin.readline()

  subst_dict = dict()
  for i in range(len(word)):
    for d in range(i+1,len(word)+1):
      subst = word[i:d]
      anag = anagram(subst)
      if anag in subst_dict:
        #print(anag, "in")
        count += subst_dict[anag]
        subst_dict[anag] += 1
      else:
        #print(anag, "not in", subst_set)
        subst_dict[anag] = 1

  print(count)
