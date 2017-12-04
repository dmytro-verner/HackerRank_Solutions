SELECT f1.x AS x, f1.y FROM functions f1 JOIN functions f2 ON f1.x = f2.y AND f1.y = f2.x AND f1.x < f2.x
UNION ALL
SELECT f11.x, f11.y FROM functions f11 WHERE f11.x = f11.y 
    GROUP BY f11.x, f11.y 
    HAVING COUNT(*) > 1
ORDER BY x;