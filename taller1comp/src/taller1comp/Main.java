package taller1comp;

/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */
public class Main {

    public static void main(String[] args) {

        CSVreader reader = new CSVreader();
        long[] volumes = new long[reader.getInfo().length];
        for (int i = 0; i < reader.getInfo().length; i++) {
            volumes[i] = reader.getInfo()[i].getVolume();
        }
        long startTime = System.nanoTime();
        inSort(volumes);
        long stopTime = System.nanoTime();
        System.out.println("El tiempo que demora en ordenar mediante Insertion Sort es: " + (stopTime - startTime) / 1000000 + " ms");
        startTime = System.nanoTime();
        quickSort(volumes);
        stopTime = System.nanoTime();
        System.out.println("El tiempo que demora en ordenar mediante Quick Sort es: " + (stopTime - startTime) / 1000000 + " ms");
    

         /*----QUEUE----*/
      
        Queue cola = new Queue(reader.getInfo().length);
        for (int i=0;i<reader.getInfo().length;i++){
            cola.insert(reader.getInfo()[i].getVolume());
        }

        System.out.println("Muestra del frente de la cola: ");
        System.out.println(cola.peekFront());

        System.out.println("Borrando item del frente");
        cola.remove();

        System.out.println("Muestra del frente de la cola: ");
        System.out.println(cola.peekFront());

         /*----QUEUE----*/
}

    

    /*-------INSORT------*/
    public static void inSort(long[] volumes) {
        int in, out;

        for (out = 1; out < volumes.length; out++) // out is dividing line
        {
            long temp = volumes[out];                   // remove marked item
            in = out;                                           // start shifts at out
            while (in > 0 && volumes[in - 1] >= temp) // until one is smaller,
            {
                volumes[in] = volumes[in - 1];            // shift item to right
                --in;                                               // go left one position
            }
            volumes[in] = temp;                            // insert marked item
        }  // end for
    }

    /*-------INSORT------*/

 /*-------QUICKSORT------*/
    public static void quickSort(long[] volumes) {
        recQuickSort(0, volumes.length - 1, volumes);
        // insertionSort(0, nElems-1); // the other option
    }

    //--------------------------------------------------------------
    public static void recQuickSort(int left, int right, long[] volumes) {
        int size = right - left + 1;
        if (size < 10) // insertion sort if small
        {
            insertionSort(left, right, volumes);
        } else // quicksort if large
        {
            long median = medianOf3(left, right, volumes);
            int partition = partitionIt(left, right, median, volumes);
            recQuickSort(left, partition - 1, volumes);
            recQuickSort(partition + 1, right, volumes);
        }
    }  // end recQuickSort()
    //--------------------------------------------------------------

    public static long medianOf3(int left, int right, long[] volumes) {
        int center = (left + right) / 2;
        // order left & center
        if (volumes[left] > volumes[center]) {
            swap(left, center, volumes);
        }
        // order left & right
        if (volumes[left] > volumes[right]) {
            swap(left, right, volumes);
        }
        // order center & right
        if (volumes[center] > volumes[right]) {
            swap(center, right, volumes);
        }

        swap(center, right - 1, volumes);           // put pivot on right
        return volumes[right - 1];        // return median value
    }  // end medianOf3()
    //--------------------------------------------------------------

    public static void swap(int dex1, int dex2, long[] volumes) // swap two elements
    {
        long temp = volumes[dex1];        // A into temp
        volumes[dex1] = volumes[dex2];   // B into A
        volumes[dex2] = temp;             // temp into B
    }  // end swap(
    //--------------------------------------------------------------

    public static int partitionIt(int left, int right, long pivot, long[] volumes) {
        int leftPtr = left;             // right of first elem
        int rightPtr = right - 1;       // left of pivot
        while (true) {
            while (volumes[++leftPtr] < pivot)  // find bigger
                ;                                  // (nop)
            while (volumes[--rightPtr] > pivot) // find smaller
                ;                                  // (nop)
            if (leftPtr >= rightPtr) // if pointers cross,
            {
                break;                    //    partition done
            } else // not crossed, so
            {
                swap(leftPtr, rightPtr, volumes);  // swap elements
            }
        }  // end while(true)
        swap(leftPtr, right - 1, volumes);         // restore pivot
        return leftPtr;                 // return pivot location
    }

    public static void insertionSort(int left, int right, long[] volumes) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            long temp = volumes[out];    // remove marked item
            in = out;                     // start shifts at out
            // until one is smaller,
            while (in > left && volumes[in - 1] >= temp) {
                volumes[in] = volumes[in - 1]; // shift item to right
                --in;                      // go left one position
            }
            volumes[in] = temp;          // insert marked item
        }  // end for
    }

    /*-------QUICKSORT------*/
}

