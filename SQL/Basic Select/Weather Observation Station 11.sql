SELECT DISTINCT city FROM station 
    WHERE NOT LOWER(SUBSTRING(city, 1, 1)) IN ('a', 'e', 'i', 'o', 'u') OR NOT
        SUBSTRING(city, LENGTH(city), 1) IN ('a', 'e', 'i', 'o', 'u');