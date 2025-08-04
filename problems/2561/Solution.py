class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        b1 = Counter(basket1)
        b2 = Counter(basket2)
        smallest_num = 10**9 + 1

        all_keys = b1.keys() | b2.keys()
        nums_to_move = []
        for key in all_keys:
            if b1[key] + b2[key] % 2 == 1:
                return -1

            smallest_num = min(smallest_num, key)
            diff = abs(b1[key] - b2[key])
            nums_to_move.extend([key] * (diff // 2))

        nums_to_move.sort()
        total = 0
        for i in range(len(nums_to_move) // 2):
            total += min(nums_to_move[i], smallest_num * 2)

        return total;
        