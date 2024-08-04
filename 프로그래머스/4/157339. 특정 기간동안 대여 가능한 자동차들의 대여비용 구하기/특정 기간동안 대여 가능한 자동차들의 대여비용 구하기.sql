WITH POSSIBLE_CAR AS(
    SELECT c.CAR_ID, c.CAR_TYPE, c.DAILY_FEE * 30 as 'ORI_FEE' 
    FROM 
        CAR_RENTAL_COMPANY_CAR c
        JOIN 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
        on c.car_id = h.car_id
    where 
        c.CAR_ID NOT IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE <= '2022-11-30'
            AND
            END_DATE >= '2022-11-01'
        )
        and
        c.car_type in ('SUV', '세단')
),

DISCOUNT AS (
    SELECT * 
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE duration_TYPE = '30일 이상'
)

SELECT p.CAR_ID, p.CAR_TYPE, round(p.ORI_FEE * (1 - 0.01 * d.discount_rate)) as 'FEE'
FROM POSSIBLE_CAR p
JOIN DISCOUNT d ON p.CAR_TYPE = d.CAR_TYPE
GROUP BY p.CAR_ID
HAVING FEE between 500000 and 2000000
ORDER BY round(p.ORI_FEE * (1 - 0.01 * d.discount_rate)) desc, p.CAR_TYPE, p.CAR_ID desc;