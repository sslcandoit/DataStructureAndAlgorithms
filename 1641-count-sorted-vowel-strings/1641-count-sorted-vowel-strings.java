class Solution {
    public int countVowelStrings(int n) {
        /*
        int[] dp=new int[]{0,1,1,1,1,1};
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                dp[j]+=dp[j-1];
            }
        }
        return dp[5];*/
        return (n+1)*(n+2)*(n+3)*(n+4)/24;
    }
}
/*
a   e            i                        o                                          u
aa  ae/ee        ai/ei/ii                 ao/eo/io/oo                                au/eu/iu/ou/uu
aaa aae/aee/eee  aai/aei/eei/aii/eii/iii  aao/aeo/eeo/aio/eio/iio/aoo/eoo/ioo/ooo  
                                                                aau/aeu/eeu/aiu/eiu/iiu/aou/eou/iou/oou/auu/euu/iuu/ouu/uuu
                                                                      
n=2: 1rt -> |XX,                          X|X,                        XX| 
     2nd -> ||XX,||XX,|X|X,|XX|          |X|X,X||X,X||X,X|X|          |XX|,X|X|,XX||,XX||
     3rd -> |||XX,|||XX,|||XX,||X|X,||XX|... ...
     4th -> ||||XX(uu),||||XX(uu),||||XX(uu),||||XX(uu),|||X|X(ou),|||XX|(oo)... ...
     

Now we have n characters, we are going to insert 4 | inside.
We can add in the front, in the middle and in the end.
How many ways do we have?
For the 1st |, we have n+1 position to insert.
For the 2nd |, we have n+2 position to insert.
For the 3rd |, we have n+3 position to insert.
For the 4th |, we have n+4 position to insert.
Also 4 | are the same,
there are (n + 1) * (n + 2) * (n + 3) * (n + 4) / 4! ways.
                                                                   
*/