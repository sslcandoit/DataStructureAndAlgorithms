class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
} 
/*                         
round                                ：只有以下位置可以整除round数的地方：灯泡会被换开关
1:    [O, O, O, O, O, O, O, O, O, O]:1,2,3,4,5,6,7,8,9,10
2:    [O, X, O, X, O, X, O, X, O, X]:2,4,6,8,10
3:    [O, X, X, X, O, O, O, X, X, X]:3,6,9
4:    [O, X, X, O, O, O, O, O, X, X]:4,8
5:    [O, X, X, O, X, O, O, O, X, O]:5,10
6:    [O, X, X, O, X, X, O, O, X, O]:6
7:    [O, X, X, O, X, X, X, O, X, O]:7
8:    [O, X, X, O, X, X, X, X, X, O]:8
9:    [O, X, X, O, X, X, X, X, O, O]:9
10:   [O,X, X, O, X, X, X, X, O, X]:10

on -> off -> on:所以如果这个灯泡被换开关偶数次，那么它始终是关闭的，如果它被换开关奇数次，它最终是开的
第几个灯泡：1，2，3，4，5，6，7，8，9，10
更换开关数：1，2，2，3，2，4，2，4，3，4
最终开的是：1       4            9

问题变成：如何知道这些灯泡会有几个地方被换奇数次开关？

任何数的因数都是成对出现的，也就是偶数个因数，只有当它是某个数的平方的时候，它的因数是奇数个，例如：
10的因数有： 1，10； 2，5
9的因数有：1，9；3
*/


