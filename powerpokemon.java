import java.util.*;

public class Solution {
    
    static final int MOD = 1000000007;
    
    // function to check if a number is a power of two
    static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }
    
    // function to calculate the number of power pokemon couples
    static int countPowerCouples(int[] power) {
        int n = power.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        long ans = 0;
        for (int p : freq.keySet()) {
            for (int i = 0; i <= 30; i++) {
                int q = (1 << i) - p;
                if (q == p) {
                    ans += (long) freq.get(p) * (freq.get(p) - 1) / 2;
                } else if (q > p && freq.containsKey(q) && isPowerOfTwo(p + q)) {
                    ans += (long) freq.get(p) * freq.get(q);
                }
            }
        }
        return (int) (ans % MOD);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        System.out.println(countPowerCouples(power));
    }
}
