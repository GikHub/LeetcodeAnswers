package doublepointer;

public class Onefourone {
	  private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public boolean hasCycle(ListNode head) {
		if(head==null){
			return false;
		}
		ListNode head1=head;
		ListNode head2=head.next;
		while (head1!=null&&head2!=null) {
			if(head1==head2){
				return true;
			}
			head1=head1.next;
			if(head2.next==null){
				break;
			}
			head2=head2.next.next;
		}
		return false;
    }
	public static void main(String[] args) {

	}

}
