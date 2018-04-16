package graphtheory.dfs;
import java.util.ArrayList;
import java.util.List;

/**
 * ���⣺���ַ�����25525511135���ָ�õ��Ϸ���IP�������б�
 * @author Administrator
 * �ⷨ��ͨ��DFS�������п��ܽ�����ų����Ƿ�IP���õ����ս��
 */
public class NineThree {
	
	public List<String> restoreIpAddresses(String s) {
        List<String> resultList=new ArrayList<String>();
        dfs(s, resultList, 0,0,"");
        return resultList;
    }
	/**
	 * 
	 * @param ipStr ԭʼ��IP�ַ���
	 * @param ipList ���н�ļ���
	 * @param index ԭʼIP�ַ�����index����
	 * @param count IP�μ���
	 * @param tempIpStr ��ʱIP��
	 */
	private void dfs(String ipStr,List<String> ipList,int index,int count,String tempIpStr){
		if(index>=ipStr.length()||count>=4){
			if(count==4&&index==ipStr.length()){
				ipList.add(tempIpStr);
			}
			return;
		}
		//��Ϊÿһ��IP��಻����3λ
		for(int i=1;i<4;i++){
			if(index+i>ipStr.length()){
				continue;
			}
			String temp=ipStr.substring(index,index+i);
			//���˵���'0'��ͷ��λ������1������
			if(temp.charAt(0)=='0'&&i>1){
				continue;
			}
			//���˵�����255������
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
