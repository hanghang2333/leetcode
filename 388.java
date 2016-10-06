//������������Ŀ¼·�����ļ�����ַ��������Ƕ���
//���õ��ǣ���split���������\t�ĸ������жϸ߶ȣ����ڸ���·���ַ������ص㣬���Կ���
//�����������α�������ָ����ȵĳ��ȴ洢��map�
//��Ϊ�ļ�����ֱ�ӱȽ��Ƿ����ִ���ġ�
//ע��\t��ת���ַ�������һ���ַ���
public class Solution {
    public int lengthLongestPath(String input) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        int result=0;
        for(String s:input.split("\n")){
            int level=s.lastIndexOf("\t")+1;
            int len=s.substring(level).length();
            if(s.contains(".")){
                result=Math.max(result,map.get(level)+len);
            }
            else{
                map.put(level+1,map.get(level)+len+1);
            }
        }
        return result;
    }
}