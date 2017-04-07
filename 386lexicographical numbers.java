//给定一个n，求这n个数按字典排序
//首先需要明确知道字典排序是指按照字母表类似的方法排序。
//方法是针对一个数，求解其按照字典排序的下一位。
//如果可以在后面加0，显然直接加0是下一位
//否则如果未超过范围且最后一位还未到达9，显然下一位是该数加1
//否则(超到范围或者末尾为9),如果末尾为9则需要回退到没有9的那一位，而后加1为下一个数。如果是超范围的情况也是应该除以10而后加1作为下一个数，两种情况一起考虑，则需要每次考虑该数除以10后末尾是否为9，是的话则真的除以10，否则退出。而后对于得到的这个数除以10再加1.这样的做法实际上对于末尾为0的情况多留了一位9，从而在下一步需要除以10时再去掉
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<Integer>();
        int curr=1;
        for(int i=1;i<=n;i++){
            list.add(curr);
            if(curr*10<=n){
                curr=curr*10;
            }
            else if(curr+1<=n&&curr%10!=9){
                curr++;
            }
            else{
                while((curr/10)%10==9){
                    curr/=10;
                }
                curr=curr/10+1;
            }
        }
        return list;
    }
    
}
