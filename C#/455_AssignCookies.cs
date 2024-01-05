public class Solution
{
    public int FindContentChildren(int[] g, int[] s)
    {
        Array.Sort(g, (a, b) => b - a);
        Array.Sort(s, (a, b) => b - a);

        int nextChildren = 0;
        int numberOfContentChildren = 0;

        for (int i = 0; i < s.Length; i++)
        {
            for (int j = nextChildren; j < g.Length; j++)
            {
                if (s[i] >= g[j])
                {
                    numberOfContentChildren++;
                    if (j == g.Length - 1)
                    {
                        return numberOfContentChildren;
                    }
                    nextChildren = j + 1;
                    break;
                }

                if (j == g.Length - 1)
                {
                    return numberOfContentChildren;
                }
            }
        }

        return numberOfContentChildren;
    }
}
