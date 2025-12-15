class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = 1_000_000_007;
        int[] dp = new int[n+1];
        int[] prefix = new int[n+1];
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        dp[0]=1;
        prefix[0]=1;
        int j= 0;
        

for(int i= 0; i<n; i++){
    
    while(!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]){
        maxQ.pollLast();
    }
    maxQ.offerLast(i);
    
    
    while(!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]){ 
        minQ.pollLast();
    }
    minQ.offerLast(i);
    
   
    while(!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k){
        
        if(maxQ.peekFirst() == j) {
             maxQ.pollFirst();
        }
        
        
        if(minQ.peekFirst() == j) { 
             minQ.pollFirst();
        }
        
        j++; 
    }
    
    
    long term = prefix[i] -(j>0 ? prefix[j-1] : 0 );
    dp[i+1]=(int)((term % mod + mod) % mod);
    prefix[i+1] = (prefix[i] + dp[i+1]) % mod;
}
        return dp[n];
        
    }
}
