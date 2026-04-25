import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the array: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter " + n + " elements of the array: ");
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the target element to find lower bound in the array: ");
		int x = sc.nextInt();

		int low = 0;
		int high = n-1;
		int ans = n;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid]>x) {
				ans = mid;
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		System.out.println(ans);
	}
}