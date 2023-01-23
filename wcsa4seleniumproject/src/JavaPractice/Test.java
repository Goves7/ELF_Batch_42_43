package JavaPractice;

public class Test {

	public static void main(String[] args) {
		int a []= {1,1,2,2,2,3,3,4,4,5,5,6,6};
       int count=0;
		for(int i=0; i<a.length-1; i++) {
			if(a[i] == a[i+1]) {
				count ++;
			}
		}
		int k=0;
		int b[]=new int[a.length-count];
		for(int i=0; i<a.length-1; i++) {
			if(a[i] != a[i+1]) {
				b[k++]=a[i];
			}
		}
		b[k]=a[a.length-1];
		
		for(int num : b) {
			System.out.print(num);
		}
	}

}
