import java.util.*;
public class numofboom447 {
    public int numberOfBoomerangs(int[][] points) {
        int numofpoints = points.length;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0;i<numofpoints;i++){
            for(int j=0;j<numofpoints;j++){
                if(j==i)continue;
                int dis = distance(points[i],points[j]);
                map.put(dis,map.getOrDefault(dis,0)+1);
            }
            for(int val:map.values()){
                res+= val*(val-1);
            }
            map.clear();
        }
        return res;
    }
    public static int distance(int[] point1,int[] point2){
        int res =0;
        res = (int)(Math.pow((point1[0]-point2[0]),2)+Math.pow((point1[1]-point2[1]),2));
        return res;
    }
}