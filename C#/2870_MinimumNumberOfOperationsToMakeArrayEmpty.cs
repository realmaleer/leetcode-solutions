public class Solution
{
    public int MinOperations(int[] nums)
    {
        var ans = 0;
        var numberOfOccurrence = new Dictionary<int, int>();

        for (var i = 0; i < nums.Length; i++)
        {
            if (numberOfOccurrence.ContainsKey(nums[i]))
            {
                numberOfOccurrence[nums[i]]++;
            } else
            {
                numberOfOccurrence.Add(nums[i], 1);
            }
        }

        foreach (int occurrence in numberOfOccurrence.Values)
        {
            if (occurrence == 1)
            {
                return -1;
            } else if (occurrence % 3 == 0)
            {
                ans += occurrence / 3;
            } else
            {
                ans += occurrence / 3 + 1;
            }
        }

        return ans;
    }
}
