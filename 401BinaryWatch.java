//一个时钟，时由四个LEd为8,4,2,1，分为6个LED为32,16,8,4,2,1.给定亮的LED数目，求出可能的时间
//针对时钟和分钟亮的个数，枚举出可能指代的值，而后直接输出
public List<String> readBinaryWatch(int num) {
    int hour[][] = {{0},{1,2,4,8},{3,5,6,9,10},{7,11}};
    int minutes[][] = {{0},{1,2,4,8,16,32},{3,5,6,9,10,12,17,18,20,24,33,34,36,40,48},
        {7,11,13,14,19,21,22,25,26,28,35,37,38,41,42,44,49,50,52,56},
        {15,54,23,27,29,30,39,51,43,45,46,57,58,53},{31,47,55,59}
    };
    List<String> result = new LinkedList<String>();
    int boundary = num>=4?4:num+1;
    for(int i=0;i<boundary;i++){
        int index = num-i;
        if(index>5) continue;
        for(int j=0;j<hour[i].length;j++){
            for(int k=0;k<minutes[index].length;k++){
                String minute;
                if(minutes[index][k]/10==0){
                    minute = "0"+minutes[index][k];
                }else{
                    minute = ""+minutes[index][k];
                }
                String temp = hour[i][j]+":"+minute;
                result.add(temp);
            }
        }
    }
    return result;
}
