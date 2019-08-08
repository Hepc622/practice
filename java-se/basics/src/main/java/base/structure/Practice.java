package base.structure;

import java.util.*;
public class Practice{
	public static void main(String[] args) {
		//maxNumber();
		ListNode node = new ListNode(20);
		node.next = new ListNode(21); 
		node.next.next = new ListNode(22); 
		node.next.next.next = new ListNode(24); 
		node.next.next.next.next = new ListNode(25); 
		node.next.next.next.next.next = new ListNode(32); 
		node.next.next.next.next.next.next = new ListNode(31); 
		node.next.next.next.next.next.next.next = new ListNode(12); 
		ListNode n =  findKthToTail(node,9);
		System.out.println(n.val);
	}

	//组拼最大的数字
	public static void maxNumber(){
		//设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
		//如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
		//如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
		int[] ints = new int[]{12,32,723,412,4,22,5};
		Map map = getLinkedHashMap(ints);
		for (Object key : map.keySet()) {
			System.out.println(map.get(key));
		}

	}
	//获取一个有序的map
	public static Map getLinkedHashMap(int[] ints){
		Map linkedMap = new LinkedHashMap();
		for (int i : ints) {
			//将i变成字符并且切除第一个作为key
			String str = i+"";
			String key = str.substring(0,1);
			linkedMap.put(i,i);
		}
		return linkedMap;
	}

    public static boolean Find(int target, int [][] array) {
        //1,2,3,4,5,6,7
        //2,3,4,5,6,7,8
        //3,4,5,6,7,8,9
       	int outArrLen = array.length;
        int innerArrLen = array[0].length;
        int i,j;
        for(i=outArrLen-1,j=0;i>=0&&j<innerArrLen;){
            if(array[i][j]==target){
                return true;
            }
            if(target>array[i][j]){
                j--;
                continue;
            }
            if(target<array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }
     
 	public static ListNode findKthToTail(ListNode head,int k) {
        //方法一
        //使用堆栈的后进先出的结构完成。node1>node2>node3>node*
        //先将所有的node全部push到堆栈中，node1进栈，node2进栈,node3进栈，node*进栈
        //然后循环弹栈K次就能找到对应的node了，出栈的时候就是倒序了，node*,node3,node2,node1
        //方法二
        //算出节点总长度n
        //然后再循环出第(n-k)+1个节点就得到了倒序节点
        ListNode node = head;
        ListNode target = null;
        int count=0;
        do{
        	node = node.next;
        	count++;
        }while(node!=null);
        int count2 = 1;
		target = head.next;
        do{
        	target=target.next;
        	count2++;
        }while(count2<count-k&&target!=null);

        return target;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}