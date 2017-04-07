//给定一个数独图，判断是否合法(不去管是否有解)
//解:从行，列，方块依次遍历即可。
//使用了一个boolean[]来记录每个数字出现了与否
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean flag=true;
        for(int i=0;i<9;i++){
            boolean[] res=new boolean[10];
            for(int j=0;j<9;j++){
                if(!(board[i][j]=='.')){
                    if(res[board[i][j]-'0']==true){return false;}
                    else{res[board[i][j]-'0']=true;}
                }
            }
        }
        
        for(int i=0;i<9;i++){
            boolean[] res=new boolean[10];
            for(int j=0;j<9;j++){
                if(!(board[j][i]=='.')){
                    if(res[board[j][i]-'0']==true){return false;}
                    else{res[board[j][i]-'0']=true;}
                }
            }
        }
        
        for(int i=0;i<9;i++){
            //System.out.println("di"+" "+i+"ci:");
            boolean[] res=new boolean[10];
            int ii=0;
            if(i>=0&&i<=2){ii=0;}else if(i>=3&&i<=5){ii=3;}else{ii=6;}
            int ij=0;
            if(i%3==0){ij=0;}else if(i%3==1){ij=3;}else{ij=6;}
            for(int iic=0;iic<3;iic++)
                for(int ijc=0;ijc<3;ijc++){
              //      System.out.println(""+(ii+iic)+"+"+(ij+ijc));
                    if(!(board[ii+iic][ij+ijc]=='.')){
                    if(res[board[ii+iic][ij+ijc]-'0']==true){return false;}
                    else{res[board[ii+iic][ij+ijc]-'0']=true;}
                }
                    
                }
            
        }
        return true;
        
    }
}
