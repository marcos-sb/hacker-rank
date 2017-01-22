select h.hacker_id, h.name, t2.total
from hackers h join
 (select t1.hacker_id, sum(t1.score) as total
  from
   (select hacker_id, challenge_id, max(score) as score
    from submissions
    where score > 0
    group by hacker_id, challenge_id) t1
  group by t1.hacker_id) t2
  on h.hacker_id = t2.hacker_id
order by 3 desc, 1 asc
