SELECT ROUND(s1.lat_n, 4) FROM station s1, station s2
    GROUP BY s1.lat_n
    HAVING SUM(SIGN(1-SIGN(s2.lat_n-s1.lat_n)))/COUNT(*) > .5
    LIMIT 1;