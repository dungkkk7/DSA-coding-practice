class Solution {

    /**
     * @param Integer $x
     * @return Boolean
     */
    function isPalindrome($x) {
        return strrev(strval($x)) === strval($x); 
    }
}
