class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        row = [set() for _ in range(n)]
        col = [set() for _ in range(n)]
        grid = [set() for _ in range(n)]


        for i in range(n):
            for j in range(n):
                g = (i // 3) * 3 + (j // 3)
                num = board[i][j]
                if num == ".": continue
                if (num in row[i] or num in col[j] or num in grid[g]): return False
                row[i].add(num)
                col[j].add(num)
                grid[g].add(num)
        return True