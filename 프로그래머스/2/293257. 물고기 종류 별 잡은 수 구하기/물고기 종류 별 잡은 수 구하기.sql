-- 코드를 작성해주세요

SELECT COUNT(*) AS FISH_COUNT, FISH_NAME
FROM FISH_INFO I JOIN FISH_NAME_INFO NI
ON I.FISH_TYPE = NI.FISH_TYPE
GROUP BY 2
ORDER BY 1 DESC;