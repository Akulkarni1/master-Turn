/*
Find k such that kth row is all zero and kth col is all one in a matrix.
A trivial solution would be to find all rows that has sum at most 1 and then check corresponding columns to check if column has sum at least 4 (why?). This is a O(n^2) solution however.
*/

public int findKthRowCol(int mat[][]){
	int n = mat.length;
	int m = mat[0].length;
	int i = 0;
	int j = 0;
	int candidate =-1;
	while(i<n&&j<m){
		if(mat[i][j]==0){
			int k = j+1;
			while(k<m&&mat[i][k]==0){
				k++;
			}
			if(k==m){
				candidate =i;
				break;
			}
			else{
				i++;
			}
		}
		else{
			int k=i+1;
			while(k<n&& mat[k][j]==0){
				k++;
			}
			if(k == n){
				candidate = i;
				break;
			}
			//if not all are 1 then this col can't be the candidate
			else{
				j++;
			}
		}
	}
	
	//we found a row/cold candidate, validate the rowand columnd
	if(candidate != -1){
		for(j = 0; j<n; j++){
			if(j != candidate && mat[candidate][j] != 0){
				return -1;
			}
		}
		
		for(i = 0; i<n; i++){
			if(i != candidate && mat[i][candidate] != 1){
				return -1;
			}
		}
		
		return candidate;
	}
	
	return candidate;
}