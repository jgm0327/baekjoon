with
python as
(select code from skillcodes where name='Python'),

C as (select code from skillcodes where name='C#'),
front as (select sum(code) as 'code' from skillcodes where category = 'Front End')

select
case
when skill_code & front.code and skill_code & python.code then 'A'
when skill_code & C.code then 'B'
when skill_code & front.code then 'C'
end as 'GRADE',
id,
email
from developers, python, c, front
having GRADE is not null
order by GRADE, id;