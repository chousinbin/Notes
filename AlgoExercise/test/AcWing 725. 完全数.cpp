#include<iostream>
using namespace std;
int main()
{
	int n,ret=0,x;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>x;
		ret=0;
		for(int j=1;j*j<x;j++){
			if(x%j==0){
				if(x!=x/j&&x/j!=j){
				    ret+=x/j;
		    	}
			    if(j<x){
			        ret+=j;
		    	}
			}
			
		}
		if(ret==x){
	        cout<<x<<" is perfect"<<endl;
		}else{
        	cout<<x<<" is not perfect"<<endl;
		}
}	
	return 0;
} 
