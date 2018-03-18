import java.util.*;

public class Perfect_Array {

	static int[] data,odd,even;
	static int length;
	static long ans=0;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),c_odd=0,c_even=0,temp=0;
		data = new int[n];
		odd = new int[n/2];
		even = new int[n/2];
		Queue<Integer> iPQ_odd = new PriorityQueue<>(n/2+1);
		Queue<Integer> iPQ_even = new PriorityQueue<>(n/2+1);
		
		length=n;
		
		for(int i=0;i<n;i++)
		{
			data[i]=sc.nextInt();
			if(data[i]%2==1)
			{
				if(i%2==0)
					odd[i/2]=data[i];//c_odd++
				else
				{
					iPQ_odd.add(data[i]);
					if(!iPQ_even.isEmpty())
					{
						//c_even=0;
						while(even[c_even]!=0 && c_even<n/2)
							c_even++;
						//System.out.println("Hii "+c_even+" data "+iPQ_even.peek());
						even[c_even++]=iPQ_even.remove();
					}
				}
			}
			else
			{
				if(i%2==1)
					even[(i-1)/2]=data[i];//c_even++
				else
				{
					iPQ_even.add(data[i]);
					if(!iPQ_odd.isEmpty())
					{
						//c_odd=0;
						while(odd[c_odd]!=0 && c_odd<n/2)
							c_odd++;
						odd[c_odd++]=iPQ_odd.remove();
					}
				}
			}
			if((data[i]%2==0 && i%2==0) || (data[i]%2==1 && i%2==1))
				temp++;
		}
		
		c_even=0;
		while(!iPQ_even.isEmpty())
		{
			while(even[c_even]!=0 && c_even<n/2)
				c_even++;
			if(!iPQ_even.isEmpty())
				even[c_even++]=iPQ_even.remove();
		}
		
		c_odd=0;
		while(!iPQ_odd.isEmpty())
		{
			while(odd[c_odd]!=0 && c_odd<n/2)
				c_odd++;
			if(!iPQ_odd.isEmpty())
				odd[c_odd++]=iPQ_odd.remove();
		}
		
		
		for(int i=0;i<n/2;i++)
			System.out.print(odd[i]+" ");
		System.out.println();
		
		for(int i=0;i<n/2;i++)
			System.out.print(even[i]+" ");
		System.out.println();
		
		
		ans+=temp/2;
		sort(odd);
		sort(even);
		
		System.out.println(ans);
		sc.close();
	}
	
	public static void sort(int[] inputArr) {
        
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        length = inputArr.length;
        quickSort(0, length - 1,inputArr);
    }
 
    private static void quickSort(int lowerIndex, int higherIndex,int[] array) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j,array);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j,array);
        if (i < higherIndex)
            quickSort(i, higherIndex,array);
    }
 
    private static void exchangeNumbers(int i, int j,int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        if(i!=j && array[i]!=array[j])
        	ans++;
    }
    
}
