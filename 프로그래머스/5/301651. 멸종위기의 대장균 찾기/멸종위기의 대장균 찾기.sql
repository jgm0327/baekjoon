-- 코드를 작성해주세요
WITH RECURSIVE cte AS (
    SELECT id, 1 AS GENERATION
    FROM ecoli_data
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT e.id, c.GENERATION + 1 as GENERATION
    FROM ecoli_data e
    INNER JOIN cte c
    ON e.parent_id = c.id
)

SELECT COUNT(*) AS 'COUNT', GENERATION
FROM cte c
LEFT JOIN ecoli_data e
ON c.id = e.parent_id
WHERE e.id IS NULL
GROUP BY 2
ORDER BY 2;