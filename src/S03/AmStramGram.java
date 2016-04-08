package S03;

public class AmStramGram {

	public static void main(String[] args) {

		System.out.println(winnerAmStramGram(4, 3));
	}

	public static int winnerAmStramGram(int n, int k) {
		List l = new List();
		ListItr li = new ListItr(l);
		for (int i = 1; i <= n; i++) {
			li.insertAfter(i);
			li.goToNext();
		}
		li.goToFirst();
		while (l.size() > 1) {
			for (int i = 0; i < k-1; i++) {
				if(li.isLast()){
					li.goToFirst();
					li.goToNext();
				}else{
					li.goToNext();
				}
			}
			li.removeAfter();
		}
		if(l.size()==1){
			li.goToFirst();
			return li.consultAfter();
		}
		return -1;
	}
}
