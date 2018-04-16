package graphtheory.dfs;
import java.util.ArrayList;
import java.util.List;

/**
 * 问题：将字符串：25525511135，分割得到合法的IP，求结果列表
 * @author Administrator
 * 解法：通过DFS遍历所有可能结果，排除掉非法IP即得到最终结果
 */
public class NineThree {
	
	public List<String> restoreIpAddresses(String s) {
        List<String> resultList=new ArrayList<String>();
        dfs(s, resultList, 0,0,"");
        return resultList;
    }
	/**
	 * 
	 * @param ipStr 原始的IP字符串
	 * @param ipList 存有解的集合
	 * @param index 原始IP字符串的index索引
	 * @param count IP段计数
	 * @param tempIpStr 临时IP解
	 */
	private void dfs(String ipStr,List<String> ipList,int index,int count,String tempIpStr){
		if(index>=ipStr.length()||count>=4){
			if(count==4&&index==ipStr.length()){
				ipList.add(tempIpStr);
			}
			return;
		}
		//因为每一段IP最多不超过3位
		for(int i=1;i<4;i++){
			if(index+i>ipStr.length()){
				continue;
			}
			String temp=ipStr.substring(index,index+i);
			//过滤掉以'0'开头且位数多于1的数据
			if(temp.charAt(0)=='0'&&i>1){
				continue;
			}
			//过滤掉大于255的数据
			if(Integer.parseInt(temp)>255){
				continue;
			}
			String tempS=tempIpStr.equals("")?tempIpStr+temp:tempIpStr+"."+temp;
			dfs(ipStr, ipList, index+i, count+1, tempS);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NineThree three=new NineThree();
		String s="25525511135";
		System.out.println(three.restoreIpAddresses(s));
	}

}
