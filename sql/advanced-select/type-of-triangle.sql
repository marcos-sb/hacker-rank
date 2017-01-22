select case
  when a + b <= c or b + c <= a or c + a <= b then 'Not A Triangle'
  when a = b and a = c then 'Equilateral'
  when a = b or a = c or b = c then 'Isosceles'
  else 'Scalene'
end
from triangles
