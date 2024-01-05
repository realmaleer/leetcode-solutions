public class Solution
{
    public int NumberOfBeams(string[] bank)
    {
        var ans = 0;
        var previousDevices = 0;

        for (var i = 0; i < bank.Length; i++)
        {
            var numberOfDevices = bank[i].Count(c => c == '1');
            if (numberOfDevices != 0)
            {
                ans += numberOfDevices * previousDevices;
                previousDevices = numberOfDevices;
            }
        }

        return ans;
    }
}
