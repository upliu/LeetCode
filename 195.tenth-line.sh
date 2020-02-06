#
# @lc app=leetcode id=195 lang=bash
#
# [195] Tenth Line
#

# @lc code=start
# Read from the file file.txt and output the tenth line to stdout.
awk '{if(NR == 10) print $0}' file.txt
# @see https://www.cnblogs.com/grandyang/p/5376902.html
# awk 'NR == 10' file.txt
# sed -n 10p file.txt
# tail -n +10 file.txt | head -n 1
# @lc code=end

