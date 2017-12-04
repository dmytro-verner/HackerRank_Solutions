SELECT cnt.contest_id, cnt.hacker_id, cnt.name, SUM(total_submissions), SUM(total_accepted_submissions), SUM(total_views),                 SUM(total_unique_views) FROM contests cnt
    INNER JOIN colleges clg ON cnt.contest_id = clg.contest_id
    INNER JOIN challenges chlg ON chlg.college_id = clg.college_id
    LEFT JOIN (
        SELECT challenge_id, sum(total_views) total_views, sum(total_unique_views) total_unique_views
            FROM view_stats 
            GROUP BY challenge_id) v_st ON v_st.challenge_id = chlg.challenge_id
    LEFT JOIN (
        SELECT challenge_id, sum(total_submissions) total_submissions, sum(total_accepted_submissions) total_accepted_submissions
        FROM submission_stats
        GROUP BY challenge_id) sbm_st ON sbm_st.challenge_id = chlg.challenge_id
    GROUP BY cnt.contest_id, cnt.hacker_id, cnt.name
    HAVING (SUM(total_submissions) + SUM(total_accepted_submissions) + SUM(total_views) + SUM(total_unique_views)) <> 0
    ORDER BY cnt.contest_id;