SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM Book b, AUTHOR a
WHERE b.AUTHOR_ID = a.AUTHOR_ID AND b.CATEGORY = '경제'
ORDER BY b.PUBLISHED_DATE;