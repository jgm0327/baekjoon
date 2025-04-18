-- 코드를 작성해주세요
WITH PARENT_TREE AS (
    SELECT ITEM_ID, PARENT_ITEM_ID AS PARENT FROM ITEM_TREE
)

SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM PARENT_TREE P RIGHT OUTER JOIN ITEM_INFO I
ON P.PARENT = I.ITEM_ID
WHERE PARENT IS NULL
ORDER BY 1 DESC;