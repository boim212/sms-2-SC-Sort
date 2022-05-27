package Sorting;
//Nama : Fx Bima Yudha Pratama
//NIM : 205314020
import java.util.Arrays;

public class TimSort {

    static int RUN = 4;

    int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public <T extends Comparable> void Insertion(T[] array, int bawah, int atas, int n) {
        if (n <= 0) {
            for (int i = bawah + 1; i <= atas; i++) {
                T temp = array[i];
                int j = i - 1;
                while (j >= bawah && temp.compareTo(array[j]) <= 0) {
                    array[j + 1] = array[j];
                    --j;
                }
                array[j + 1] = temp;
            }
        } else {
            for (int i = bawah + 1; i <= atas; i++) {
                T temp = array[i];
                int j = i - 1;
                while (j >= bawah && temp.compareTo(array[j]) >= 1) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = temp;
            }
        }
    }

    <T extends Comparable> void merge(T[] array, int mulai, int tengah, int end, int b) {
        int i, j, k;
        int n1 = tengah - mulai + 1;
        int n2 = end - tengah;
        //temporary arrays    
        
        T[] left  = (T[])new Comparable[tengah - mulai + 1];
        T[] right = (T[])new Comparable[end - tengah];
        /* copy data to temp arrays */
        for (i = 0; i < n1; i++) {
            left[i] = array[mulai + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = array[tengah + 1 + j];
        }
        i = 0; j = 0; k = mulai;
        while (i < n1 && j < n2) {
            if (b < 0) {
                if (((T) left[i]).compareTo(right[j]) < 0) {
                    array[k] = (T) left[i];
                    i++;
                } else {
                    array[k] = (T) right[j];
                    j++;
                }
                k++;
            } else if (b > 0) {
                if (((T) left[i]).compareTo(right[j]) > 0) {
                    array[k] = (T) left[i];
                    i++;
                } else {
                    array[k] = (T) right[j];
                    j++;
                }
                k++;
            } else if (b == 0) {
                if (((T) left[i]).compareTo(right[j]) == 0) {
                    array[k] = (T) left[i];
                    i++;
                } else {
                    array[k] = (T) right[j];
                    j++;
                }
                k++;
            }
        }
        while (i < n1) {
            array[k] = (T) left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = (T) right[j];
            j++;
            k++;
        }
    }

   
    public <T extends Comparable> void timSort(T[] array, int b) {
        int p = array.length, i, size;
        for (i = 0; i < p; i += RUN) {
            Insertion(array, i, min((i + RUN - 1), (p - 1)), b);
        }

        for (size = RUN; size < p; size = 2 * size) {
            for (int left = 0; left < p; left += 2 * size) {
                int tengah = (left + size) - 1;
                int right = min((left + 2 * size - 1), (p - 1));

                if (tengah < right) {
                    merge(array, left, tengah, right, b);
                }
            }
        }
    }

    <T> void printAr(T[] a) {
        for (int i = 0; i < a.length; i++) {

            System.out.print(((Mahasiswa) a[i]).getNim() + " ");
            System.out.print(((Mahasiswa) a[i]).getNama() + ",");
        }
    }

    public static void main(String args[]) {
        
        Integer[] test1 = {1, 5, 2, 56, 2, 8,67,69,28,95,0,57,85, 56, 78, 42, 367, 65, 46, 43,6};
        Character[] test2 = {'n','a', 'y','j', 'm', 'w', 'q','f','g','s','k', 'u', 'e','l', 'o','z','i', 't','h','r', 'v', 'w','c','d','b'};
        String[] test3 = {"Yulius", "Agung", "Paimin", "Paijo", "Xaverius", "Bima", "Yudha","Yulius","Young lee","Renda","Nanda"};
        
        Integer[] test4 = {1, 5, 2, 56, 2, 8,67,69,28,95,0,57,85, 56, 78, 42, 367, 65, 46, 43,6};
        Character[] test5 = {'n','a', 'y','j', 'm', 'w', 'q','f','g','s','k', 'u', 'e','l', 'o','z','i', 't','h','r', 'v', 'w','c','d','b'};
        String[] test6 = {"Yulius", "Agung", "Paimin", "Paijo", "Xaverius", "Bima", "Yudha","Yulius","Young lee","Renda","Nanda"};
        Mahasiswa m1,m2,m3,m4,m5,m6;
        m1 = new Mahasiswa("Yudha",19);
        m2 = new Mahasiswa("Bambank",20);
        m3 = new Mahasiswa("Pratama",9);
        m4 = new Mahasiswa("Bima",7);
        m5 = new Mahasiswa("Fx",8);
        m6 = new Mahasiswa("Frans",3);
        
        TimSort t1 = new TimSort();
        Mahasiswa[] ms1 = {m1, m2, m3, m4, m5, m6};
        Mahasiswa[] ms2 = {m1, m2, m3, m4, m5, m6};

        System.out.println("Pengurutan Descending");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test1));
        t1.timSort(test1, 1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test1));

        System.out.println("");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test2));
        t1.timSort(test2, 1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test2));

        System.out.println("");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test3));
        t1.timSort(test3, 1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test3));

        System.out.println("");
        System.out.print("Sebelum Soring Array  : " ); 
        t1.printAr(ms1);
        t1.timSort(ms1, 1);
        System.out.print("\nSesudah Sorting Array : " ); 
        t1.printAr(ms1);
        System.out.println("");
        
        System.out.println("");
        System.out.println("Pengurutan Ascending");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test4));
        t1.timSort(test4, -1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test4));

        System.out.println("");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test5));
        t1.timSort(test5, -1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test5));

        System.out.println("");
        System.out.println("Sebelum Soring Array  : " + Arrays.toString(test6));
        t1.timSort(test6, -1);
        System.out.println("Sesudah Sorting Array : " + Arrays.toString(test6));

        System.out.println("");
        System.out.print("Sebelum Soring Array  : " ); 
        t1.printAr(ms2);
        t1.timSort(ms2, -1);
        System.out.print("\nSesudah Sorting Array : " ); 
        t1.printAr(ms2);
        System.out.println("");
    }
}
