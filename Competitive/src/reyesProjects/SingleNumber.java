package reyesProjects;

import java.util.HashMap;

public class SingleNumber
{
	//Time and space complexity is 0(n). n is the number of items in the array. Can be implemented using less memory with XOR! 
	public int singleNumber(int[] nums) 
	{
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums)
        {
        	if(map.containsKey(i))
        	{
        		map.put(i, map.get(i)+1);
        	}
        	else
        	{
        		map.put(i, 1);
        	}
        }
        
        for(Integer key : map.keySet())
        {
        	if(map.get(key)==1)
        	{
        		return key;
        	}
        }
        return -1;
    }
}
