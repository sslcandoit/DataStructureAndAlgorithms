class Solution {
    public int countVowelStrings(int n) {
        int[] dp=new int[]{0,1,1,1,1,1};
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                dp[j]+=dp[j-1];
            }
        }
        return dp[5];
    }
}
/*
a   e            i                        o                                          u
aa  ae/ee        ai/ei/ii                 ao/eo/io/oo                                au/eu/iu/ou/uu
aaa aae/aee/eee  aai/aei/eei/aii/eii/iii  aao/aeo/eeo/aio/eio/iio/aoo/eoo/ioo/ooo  
                                                                      aau/aeu/eeu/aiu/eiu/iiu/aou/eou/iou/oou/auu/euu/iuu/ouu/uuu
*/