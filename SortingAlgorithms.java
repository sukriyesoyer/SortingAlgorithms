//Þükriye SOYER 150116010
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SortingAlgorithms {
	private int[] Heap; 
    private int size; 
    private int maxsize; 
    public static void quickSort(int[] intArray) { //QuickSort
        recQuickSort(intArray, 0, intArray.length - 1);
      }

      public static void recQuickSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
          manualSort(intArray, left, right);
        else {
          double median = medianOf3(intArray, left, right);
          int partition = partitionIt(intArray, left, right, median);
          recQuickSort(intArray, left, partition - 1);
          recQuickSort(intArray, partition + 1, right);
        }
      }

      public static int medianOf3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
          swap(intArray, left, center);

        if (intArray[left] > intArray[right])
          swap(intArray, left, right);

        if (intArray[center] > intArray[right])
          swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1];
      }

      public static void swap(int[] intArray, int dex1, int dex2) {
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
      }

      public static int partitionIt(int[] intArray, int left, int right, double pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
          while (intArray[++leftPtr] < pivot)
            ;
          while (intArray[--rightPtr] > pivot)
            ;
          if (leftPtr >= rightPtr)
            break;
          else
            swap(intArray, leftPtr, rightPtr);
        }
        swap(intArray, leftPtr, right - 1);
        return leftPtr;
      }

      public static void manualSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
          return;
        if (size == 2) {
          if (intArray[left] > intArray[right])
            swap(intArray, left, right);
          return;
        } else {
          if (intArray[left] > intArray[right - 1])
            swap(intArray, left, right - 1);
          if (intArray[left] > intArray[right])
            swap(intArray, left, right);
          if (intArray[right - 1] > intArray[right])
            swap(intArray, right - 1, right);
        }
      }
  
   
    void sort22(int arr[], int low, int high) // Sellect first element as pivot 
    {
    	for(int i=1;i<arr.length;i++) {
    		if(arr[i]<arr[high]) {
    			System.out.print(arr[i]+" ");
    			
    		}}
    	System.out.print(arr[high]+" ");
    	for(int i=1;i<arr.length;i++) {
    		if(arr[i]>arr[high]) {
    			System.out.print(arr[i]+" ");
    		}}
    }
    
    public SortingAlgorithms(int maxsize)  //Insertion Sort
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  
    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos] < Heap[leftChild(pos)] ||  
            Heap[pos] < Heap[rightChild(pos)]) { 
  
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
    
  
    // Inserts a new element to max heap 
    public void insert(int element) 
    { 
        Heap[++size] = element; 
  
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    }
    public int extractMax() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
	void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort1(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort1(arr, l, m); 
            sort1(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
	  void sort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 1; i < n; ++i) { 
	            int key = arr[i]; 
	            int j = i - 1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j >= 0 && arr[j] > key) { 
	                arr[j + 1] = arr[j]; 
	                j = j - 1; 
	            } 
	            arr[j + 1] = key; 
	        } 
	    } 
	  
	    /* A utility function to print array of size n*/
	    static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n; ++i) 
	            System.out.print(arr[i] + " "); 
	  
	        System.out.println(); 
	    } 
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		  int[] annualIntRt = new int[10]; //should use size
		 fillArray(annualIntRt); 
		       int n = annualIntRt.length;
		       int a;
		       System.out.println("enter chose");
		       a=input.nextInt();
		       if(a==1) {
		    	   long startTime = System.nanoTime(); 
	       SortingAlgorithms ob = new SortingAlgorithms(15); 
	        ob.sort(annualIntRt); 
	        System.out.println("Insertion Sorted array"); 
	        printArray(annualIntRt); 
	        System.out.println("Middle in Insertion Sorted "+annualIntRt[n/2]); 
	        long endTime =System.nanoTime();;
	        long estimatedTime = endTime - startTime; // 
	        double seconds = (double)estimatedTime/1000000000; // from second to millisecond
	        System.out.println(seconds); 
	        }
		       else if(a==2) {
		    	   long startTime = System.nanoTime(); 
		    	   SortingAlgorithms ob1 = new SortingAlgorithms(15); 
	        ob1.sort1(annualIntRt, 0, annualIntRt.length-1); 
	        System.out.println("Merge Sorted array"); 
	        printArray(annualIntRt);
	        System.out.println("Middle in Merge Sorted "+annualIntRt[n/2]); 
	        long endTime =System.nanoTime();;
	        long estimatedTime = endTime - startTime; 
	        double seconds = (double)estimatedTime/1000000000; // from second to millisecond
	        System.out.println(seconds); }
		       else if(a==3) {
		    	   long startTime = System.nanoTime(); 
	        System.out.println("The Max Heap is "); 
	        SortingAlgorithms maxHeap = new SortingAlgorithms(n); 
	        for(int i=0;i<n;i++) {
	        	System.out.println(annualIntRt[i]);
	        	 maxHeap.insert(annualIntRt[i]); }
	        System.out.println("The max val is " + maxHeap.extractMax());
	        long endTime =System.nanoTime();
  	        long estimatedTime = endTime - startTime; 
  	        double seconds = (double)estimatedTime/1000000000; // from second to millisecond
  	        System.out.println(seconds);}
		       else if(a==4) {
		    	   long startTime = System.nanoTime(); 
		    	   SortingAlgorithms ob2 = new SortingAlgorithms(15); 
	        System.out.println("quick first sorted array");
	        ob2.sort22(annualIntRt, 0, 0);
	        long endTime =System.nanoTime();
  	        long estimatedTime = endTime - startTime; 
  	        double seconds = (double)estimatedTime/1000000000; // from second to millisecond
  	        System.out.println(seconds);
		       }
		       else if(a==5) {
		    	   long startTime = System.nanoTime(); 
		       for (int i : annualIntRt) {
		    	      System.out.println(i);
		    	    }
		       System.out.println("quick tree pivot sorted array"); 
		    	    quickSort(annualIntRt);
		    	    for (int i : annualIntRt) {
		    	      System.out.println(i);
		    	    }
		    	    long endTime =System.nanoTime();
		  	        long estimatedTime = endTime - startTime; 
		  	        double seconds = (double)estimatedTime/1000000000; // from second to millisecond
		  	        System.out.println(seconds);
		       }
	    } 
	 private static void fillArray(int[] ary) {
	        try {
	            File arrayInput = new File("int10.txt");
	            Scanner in = new Scanner(arrayInput);
	            int i = 0;  
	          
	            while (in.hasNextLine())
	                ary[i++] = in.nextInt();
	           
	            in.close();
	        }
	        catch (FileNotFoundException e) {
	            System.exit(1);
	        }
	        
	    }
	}


