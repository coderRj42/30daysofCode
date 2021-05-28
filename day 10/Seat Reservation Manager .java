/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 

Example 1:

Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
*/
class SeatManager {
    
    private Queue<Integer> queue;
    private int i = 1;
  
    public SeatManager(int n) {
        queue = new PriorityQueue<>();  // Step 1- Initialize the queue but will not put values in it
    }
    
    public int reserve() {
        if (queue.isEmpty())            // Step 2- We return i and increment it as i will 
            return i++;                 // always be smallest if queue is empty

        return queue.poll();            // Step 4- Queue will have smallest number if it is non empty
    }                                   // as i wil be ahead of any unreserved value
    
    public void unreserve(int seatNumber) {
        queue.offer(seatNumber);        // Step 3- Adding element which are not present in queue
    }
}
