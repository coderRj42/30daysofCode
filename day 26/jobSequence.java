

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
          Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job a, Job b){
                if(b.deadline == a.deadline)
                    return b.profit > a.profit ? 1 : (b.profit < a.profit ? -1 : 0);
                else
                    return b.deadline > a.deadline ? 1 : -1;
            }
        });
       
        
        int temp[] = new int[arr[0].deadline];
        int ans[] = new int[2];
        
        int k = temp.length;
        
        for(int j=0, i=0; j<k && i<n; j++, i++){
            
            int deadline = arr[i].deadline;
            int profit = arr[i].profit;
            
            ans[0]++;
            ans[1] += profit;
            
            if(deadline == 1)
                break;
        }
        
        return ans;
        
        
    }
}
