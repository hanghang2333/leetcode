//题意是给定一些墙壁的高度，求可以蓄水的量
//方法原本是打算找出主要隔板，但是最终也没有好的办法。。
//参考别人的回答，可以看到是通过：从两头依次遍历，记录两头的最高值，然后遍历比较，如果移动后的墙壁比之前低，则易知此处可以蓄水，记录下。否则则直接更新最高值。这样即可。
public class Solution {
    public int trap(int[] height) {
int res=0;
	int len=height.length;
	if(len<=2)
		return 0;
	int s=0,e=len-1;
	int lh=height[s],rh=height[e];
	while(s<e){
		if(lh>=rh){
			int ch=height[e-1];
			if(ch<rh){
				res+=rh-ch;
				e--;
			}
			else{
				rh=ch;
				e--;
			}
		}
		else if(lh<rh){
			int ch=height[s+1];
			if(ch<lh){
				res+=lh-ch;
				s++;
			}
			else{
				lh=ch;
				s++;
			}
		}
	}	
	return res;  
    }
}
