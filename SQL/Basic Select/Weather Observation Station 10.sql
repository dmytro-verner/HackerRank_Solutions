SELECT DISTINCT city FROM station WHERE NOT
    SUBSTRING(city, LENGTH(city), 1) IN ('a', 'e', 'i', 'o', 'u');