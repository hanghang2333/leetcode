//给定一个字母顺序被打乱的英文string，string的内容保证是由一个数字序列的内容，虽然被打乱了顺序，要求输出数字序列，按照从小到打顺序。
//解决:不可能去匹配或者遍历了，观察到只需要考虑这十个单词，而且单词里有些字母很独特，例如z只在zeros里有，s只在six和seven里有。这样，我们只需要好好观察这些独特字母的数量，再根据一些数学公式，即可推到出每个数字出现的次数。
public class Solution {
    public String originalDigits(String s) {
int[] count = new int[10];
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (c == 'z') count[0]++;
        if (c == 'w') count[2]++;
        if (c == 'x') count[6]++;
        if (c == 's') count[7]++; //7-6
        if (c == 'g') count[8]++;
        if (c == 'u') count[4]++; 
        if (c == 'f') count[5]++; //5-4
        if (c == 'h') count[3]++; //3-8
        if (c == 'i') count[9]++; //9-8-5-6
        if (c == 'o') count[1]++; //1-0-2-4
    }
    count[7] -= count[6];
    count[5] -= count[4];
    count[3] -= count[8];
    count[9] = count[9] - count[8] - count[5] - count[6];
    count[1] = count[1] - count[0] - count[2] - count[4];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 9; i++){
        for (int j = 0; j < count[i]; j++){
            sb.append(i);
        }
    }
    return sb.toString();
        
    }
}
