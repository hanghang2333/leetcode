import java.util.*;
public class ArrayFour {
    static boolean resolve2(int[] A) {
        int[] re=findValLocate(A);
        if(re==null)return false;
        System.out.println("寻找完毕，开始检查: "+Arrays.toString(re));
        re[2]=checkingFind(A,re[0],re[1]+1,re[3]-1); //减1是由于有4部分，最后一部分至少占用1个位置。
        System.out.println("检查: "+Arrays.toString(re));
        int v3=checkingFind(A,re[0],re[2]+1,re[3]);//检查第四部分，的分割点是否为re[3]
        if(v3==re[3]){
            return true;
        }
        return false;
    }
    static int checkingFind(int[] A ,int val,int begin,int end){
//从begin开始找到加和值为val的坐标，没找到则返回-1，返回坐标是下一位要去除的位置
        int s=0;
        for(int i=begin;i<end;++i){
            s=s+A[i];
            if(s==val){
                //返回要去除那个点。
                return i+1;
            }
        }
        return -1;
    }
static int[] findValLocate1(int[] A){
if(A.length<=7)return null;
//这个方法每当找到一个合适的第1和第3分割点的时候就进行判断是否可行
        int v1=0,v4=0;
        for(int i=0,j=A.length-1;i<j;){
            if(v1<v4){
                v1=v1+A[i];
                ++i;
            }else if(v1>v4){
                v4=v4+A[j];
                --j;
            }else{
                /*验证：2<=N-3-n<=2v*/
               int re[]={v1,i,0,j};
               re[2]=checkingFind(A,re[0],re[1]+1,re[3]-1); //减1是由于有4部分，最后一部分至少占用1个位置。
               System.out.println("检查: "+Arrays.toString(re));
               if(re[2]!=-1){
               int v3=checkingFind(A,re[0],re[2]+1,re[3]);//检查第四部分，的分割点是否为re[3]
               if(v3==re[3]){return re;}}
                v1=v1+A[i];++i;
                }
            }
        return null;
    }
    //方法二结束**********************************************
    public static void main(String[] args){
        /*原题解给出的答案是On的，但是不清楚原因为何。*/
        //int[] A={1,1,1,1,7,1,3,4,1,2,1,5,2,2};
        //int[] A={1,1,1,1,10,1,3,1,1,2,1,5,2,2};
        //int[] A={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
//int[] A={2,3,1,5,1,-1,6,1,1,1,1,1};
///int[] A={6,6,1,12,1,12,1,5,7};//这个证明原题解有误
int[] A={12,1,1,13,1,13,1,1,12};//这个证明原题解修正后+2也是有误的
for(int i=0;i<A.length;i++){System.out.print(A[i]);System.out.print(" ");}
System.out.println();
        Boolean res = resolve2(A);
        System.out.println(String.valueOf(res));
System.out.println("here:");
int[] res1=findValLocate1(A);
if(res1==null){System.out.println("False");return;}
else{System.out.println("True");
for(int i=0;i<res1.length;i++){System.out.print(res1[i]);System.out.print(" ");}}
System.out.println();
    }
}
