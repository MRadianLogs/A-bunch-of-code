package reyesProjects;

public class MaximumSubarray
{
	//Needs explanation/changes!
	public int maxSubArray(int[] nums) 
    {
        int globalMax = 0; //Changes needed here...
        int currentMax = 0; // and here?
        for(int i : nums)
        {
            currentMax += i;
            globalMax = Math.max(currentMax, globalMax);
            
            if( currentMax < 0)
            {
                currentMax = 0;
            }
        }
        return globalMax;
    }
}
