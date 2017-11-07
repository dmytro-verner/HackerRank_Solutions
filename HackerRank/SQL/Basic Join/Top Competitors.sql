SELECT h.hacker_id, h.name FROM hackers h 
    INNER JOIN submissions s ON h.hacker_id = s.hacker_id
    INNER JOIN challenges c ON s.challenge_id = c.challenge_id
    INNER JOIN difficulty d ON c.difficulty_level = d.difficulty_level
    WHERE s.score = d.score
    GROUP BY h.hacker_id, h.name
    HAVING COUNT(*) > 1
    ORDER BY COUNT(*) DESC, h.hacker_id;