-- 코드를 작성해주세요

WITH LENGTH_TABLE AS (
    SELECT 
    CASE 
    WHEN LENGTH IS NULL THEN 10
    ELSE LENGTH
    END AS 
    LENGTH,
    FISH_TYPE
    FROM FISH_INFO
)

# SELECT * FROM LENGTH_TABLE;

SELECT COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM LENGTH_TABLE
GROUP BY 3
HAVING AVG(LENGTH) >= 33
ORDER BY 3