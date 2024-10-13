-- 코드를 작성해주세요

SELECT distinct D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D JOIN SKILLCODES S
ON S.NAME IN ('Python', "C#")
WHERE S.CODE & D.SKILL_CODE = S.CODE
ORDER BY D.ID;