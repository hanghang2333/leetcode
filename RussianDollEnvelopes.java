//给定一组数组的数组，相当于信封的长宽，若长宽都大于则可以嵌套，问嵌套最长长度
//先按照长排序，对于长相等的则将宽大的放在前面，因为如果反了会导入后续认为宽大的可以嵌套小的
//而实际上二者是无法嵌套的。而后只需要比较宽即可。从排好序的宽之中找出宽的最大增长长度
//这里采用了:对于新的宽，在宽数组里查看是否有其应当插入位置，如果其很大，则将之放在最后，并且长度加1.
//如果其不是最大，则随便将之插在前面即可。因为这时它并不会影响最长嵌套长度。这时就只需要找出最长的宽增长序列即可。

if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });
    int dp[] = new int[envelopes.length];
    int len = 0;
    for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
        if(index < 0)
            index = -(index + 1);
        dp[index] = envelope[1];
        if(index == len)
            len++;
    }
    return len;
