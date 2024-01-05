public class Solution
{
    public IList<IList<int>> FindMatrix(int[] nums)
    {
        Array.Sort(nums);
        IList<IList<int>> result = new List<IList<int>>();
        int currentNumber = nums[0];
        int nextRow = 0;
        int upperBound = -1;

        for (int i = 0; i < nums.Length; i++)
        {
            if (currentNumber == nums[i])
            {
                if (nextRow <= upperBound)
                {
                    result[nextRow].Add(currentNumber);
                } else
                {
                    result.Add(new List<int> { currentNumber });
                    upperBound = nextRow;
                }

                nextRow++;
            } else
            {
                currentNumber = nums[i];
                result[0].Add(currentNumber);
                nextRow = 1;
            }
        }

        return result;
    }
}
