SELECT PRODUCT_CODE, SUM(p.PRICE * o.SALES_AMOUNT) AS SALES
FROM PRODUCT p, OFFLINE_SALE o
WHERE p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE;
