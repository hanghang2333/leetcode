public class factorial172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n>0){
            n=(int)n/5;
            res+=n;
        }   
        return res;
    }

}