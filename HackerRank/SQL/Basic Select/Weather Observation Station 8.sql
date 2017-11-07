SELECT DISTINCT city FROM station 
    WHERE LOWER(SUBSTRING(city, 1, 1)) IN ('a', 'e', 'i', 'o', 'u') AND
        SUBSTRING(city, LENGTH(city), 1) IN ('a', 'e', 'i', 'o', 'u');