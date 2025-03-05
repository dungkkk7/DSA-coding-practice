#include <unordered_map>
#include <string>
#include <stack>
using namespace std;
class Solution
{
public:
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