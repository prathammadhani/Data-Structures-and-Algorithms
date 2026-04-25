#include<bits/stdc++.h>
using namespace std;

int check(int arr[], int mid, int x) {
	if(arr[mid]>x) return 1;
	else return 0;
}

int main() {
	cout<<"Enter the size of the array: ";
	int n;
	cin>>n;
	int arr[n];
	cout<<"Enter "<<n<< " elements of the array: ";
	for(int i = 0;i<n;i++) cin>>arr[i];
	int x;
	cout<<"Enter the target element to find lower bound in the array: ";
	cin>>x;
	int low = 0;
    int high = n-1;
    int ans = n;
    while(low<=high) {
    	int mid = low+(high-low)/2;
    	if(check(arr, mid, x)==1) {
    		ans = mid;
    		high = mid-1;
    	} else {
    		low = mid+1;
    	}
    }
    cout<<ans<<endl;
	return 0;
}