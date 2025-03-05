#include <unordered_map>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;
class Solution
{
public:
    vector<string> generateParenthesis(int n)
    {
        vector<string> result;
        string sample;
        for (int i = 0; i < n; i++)
        {
            sample += '(';
            sample += ')';
        }
        sort(sample.begin(), sample.end());

        // Generate all possible permutations
        do
        {
            if (isValid(sample))
            {
                result.push_back(sample);
            }
            next_permutation(sample.begin(), sample.end());
        } while (true);

        return result;
    }

    bool isValid(string s)
    {
        if (!s.size() > 1)
        {
            return false;
        }
        unordered_map<char, char> hashMap = {{'{', '}'}, {'(', ')'}, {'[', ']'}};
        stack<char> stack;

        for (char c : s)
        {
            if (hashMap.find(c) != hashMap.end())
            {
                stack.push(c);
            }
            else
            {
                if (stack.empty())
                {
                    return false;
                }
                char top = stack.top();
                stack.pop();
                if (hashMap[top] != c)
                {
                    return false;
                }
            }
        }
        if (!stack.empty())
        {
            return false;
        }

        return true;
    }
};