import sys, re
regexTitleId = re.compile(".*<h3>.*questions\/(\d+)\/.*question-hyperlink.>(.+)<\/a.*")
regexRelTime = re.compile(".*class=.relativetime.\>(.+)\<.*")

part = list()
for line in sys.stdin:
    m = regexTitleId.match(line)
    if m:
        part = [m.group(1), m.group(2)]
        continue
    m = regexRelTime.match(line)
    if m:
        part.append(m.group(1))
        print('{0[0]};{0[1]};{0[2]}'.format(part))
    
