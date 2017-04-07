//给定一个unix的路径，输出正常路径，给定路径里会包含.  .. ...等杂余信息
//思路是:先抛头去尾，然后将路径的每一项放在数组里，如果该项为。或者为空，则跳//
//过，如果为..,则删除list之前加进去的那一项。否则，则加入到list里。最后
//输出的时候每一项后面再加一个/即可
public class Solution {
    public String simplifyPath(String path) {
        if(path.length()==1)return "/";
        String pathd="";
        if(path.endsWith("/")){
pathd+=path.substring(1,path.length()-1);}
        else{pathd+=path.substring(1,path.length());}
        System.out.println(pathd);
        String[] aa=pathd.split("/");
        List<String>list=new ArrayList<String>();
        for(String i: aa){
            if(!i.equals(".")&&!i.equals("")){
                if(i.equals("..")){
                    if(list.size()>=1){
                    list.remove(list.size()-1);}
                }
                else{list.add(i);}
            }
        }
        String res="/";
        for(int i=0;i<list.size();i++){
            String j=list.get(i);
            res+=j;
            if(i<=list.size()-2)
            res=res+"/";
        }
        return res;
    }
}
