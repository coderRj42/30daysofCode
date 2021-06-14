import java.io.*;

class remove {
	
 
	static int deleteElement(int arr[], int n, int x)
	{
	 
		int i;
		for (i=0; i<n; i++)
			if (arr[i] == x)
				break;

	 
		if (i < n)
		{
			 
			n = n - 1;
			for (int j=i; j<n; j++)
				arr[j] = arr[j+1];
		}

		return n;
	}
	
	 
