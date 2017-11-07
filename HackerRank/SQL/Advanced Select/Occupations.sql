SET @d=0, @a=0, @p=0, @s=0; 

SELECT MIN(doctor), MIN(professor), MIN(singer), MIN(actor) FROM
    (SELECT IF(occupation='Actor', name, NULL) AS actor, 
        IF(occupation='Doctor', name, NULL) AS doctor,  
        IF(occupation='Professor',name, NULL) AS professor,
        IF(occupation='Singer',name, NULL) AS singer, 
        CASE occupation 
            WHEN 'Actor' THEN @a:=@a+1 
            WHEN 'Doctor' THEN @d:=@d+1 
            WHEN 'Professor' THEN @p:=@p+1 
            WHEN 'Singer' THEN @s:=@s+1 
        END AS idn
     FROM occupations ORDER BY name) AS temp GROUP BY temp.idn;