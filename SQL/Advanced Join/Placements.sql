SELECT st.name FROM Students st JOIN Friends fr 
    ON st.id = fr.id 
    JOIN (SELECT id, salary AS friend_salary FROM Packages) p1 ON fr.friend_id = p1.id
    JOIN (SELECT id, salary AS own_salary FROM Packages) p2 ON st.id = p2.id
    WHERE p1.friend_salary > p2.own_salary
    ORDER BY p1.friend_salary;