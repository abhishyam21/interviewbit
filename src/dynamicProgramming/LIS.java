package dynamicProgramming;

// A naive Java based recursive implementation of LIS problem
class LIS
{
static int max_lis_length; // stores the final LIS
 
// Recursive implementation for calculating the LIS
static int _lis(int arr[], int n)
{
    // base case
    if (n == 1)
        return 1;
 
    int current_lis_length = 1;
    for (int i=0; i<n-1; i++)
    {
        // Recursively calculate the length of the LIS
        // ending at arr[i]
        int subproblem_lis_length = _lis(arr, i);
 
        // Check if appending arr[n-1] to the LIS
        // ending at arr[i] gives us an LIS ending at
        // arr[n-1] which is longer than the previously
        // calculated LIS ending at arr[n-1]
        if (arr[i] < arr[n-1] &&
            current_lis_length < (1+subproblem_lis_length))
            current_lis_length = 1+subproblem_lis_length;
    }
 
    // Check if currently calculated LIS ending at
    // arr[n-1] is longer than the previously calculated
    // LIS and update max_lis_length accordingly
    if (max_lis_length < current_lis_length)
        max_lis_length = current_lis_length;
 
    return current_lis_length;
}
 
// The wrapper function for _lis()
static int lis(int arr[], int n)
{    
    max_lis_length = 1; // stores the final LIS
 
    // max_lis_length is declared static above 
    // so that it can maintain its value
    // between the recursive calls of _lis()
    _lis( arr, n );
 
    return max_lis_length;
}
 
// Driver program to test the functions above
public static void main(String args[])
{
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
    int n = arr.length;
    System.out.println("Length of LIS is " + lis( arr, n ));
}
 
} // End of LIS class.