--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below
delete from Person where Id not IN (
select * from (select min(Id) from Person group by Email) t
)
-- @lc code=end

