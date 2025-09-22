class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int i = 0;
        int s =0;
        for(int id =0; id < k ; id++){
            s = s + arr[id];
        }
        double avg = s/k;
        int res = 0;

        while(true){
            if( avg >= threshold) res +=1;
            i++;

            if(i+k-1 > n-1) break;
            
            s = s - arr[i-1] + arr[i+k-1];
            avg = s/k;
        }
        return res;
    }
}