class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        triangle = []
        for i in range(numRows):
            row = [1] * (i + 1)
            triangle.append(row)
            for j in range(1, i):
                row[j] = triangle[i-1][j-1] + triangle[i-1][j]
        
        return triangle;
