-- 코드를 작성해주세요
with
front as (select sum(code) as 'CODE' from skillcodes where category = 'Front End')

select d.id, d.email, d.first_name, d.last_name
from developers d, front f
where d.skill_code & f.CODE != 0
order by d.id;