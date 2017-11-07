SELECT id, (SELECT age FROM wands_property WHERE code = w.code) AS age,
    coins_needed, power 
    FROM wands w
    WHERE w.code IN (SELECT code FROM wands_property WHERE is_evil = 0) 
        AND coins_needed = (SELECT MIN(coins_needed) FROM wands WHERE code = w.code AND power = w.power) 
    ORDER BY power DESC, age DESC;