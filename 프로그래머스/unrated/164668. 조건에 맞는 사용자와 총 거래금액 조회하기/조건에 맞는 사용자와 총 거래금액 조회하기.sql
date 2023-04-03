SELECT u.USER_ID, u.NICKNAME, SUM(b.price) AS 'TOTAL_SALES'
FROM USED_GOODS_USER as u, USED_GOODS_BOARD as b
WHERE b.status = 'DONE' and b.WRITER_ID = u.USER_ID
GROUP BY USER_ID
HAVING SUM(b.price) >= 700000
ORDER BY sum(b.price);