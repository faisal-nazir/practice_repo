package temp;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] A) {
	    int n=A.length;
	    if(n==0)
	        return 1;
	    int k=partition(A)+1;
	    int temp=0;
	    int first_missing_Index=k;
	    for(int i=0;i<k;i++){
	        temp=Math.abs(A[i]);
	        if(temp<=k)
	            A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
	    }
	    for(int i=0;i<k;i++){
	        if(A[i]>0){
	            first_missing_Index=i;
	            break;
	        }
	    }
	    return first_missing_Index+1;
	}

	public static int partition(int[] A){
	    int n=A.length;
	    int q=-1;
	    for(int i=0;i<n;i++){
	        if(A[i]>0){
	            q++;
	            swap(A,q,i);
	        }
	    }
	    return q;
	}

	public static void swap(int[] A, int i, int j){
	    if(i!=j){
	        A[i]^=A[j];
	        A[j]^=A[i];
	        A[i]^=A[j];
	    }
	}
	
	public static void main(String[] args) {
		int[] A = {-3, -1, 3, -4, 1, 4 };
		System.out.println(firstMissingPositive(A));
	}
}
