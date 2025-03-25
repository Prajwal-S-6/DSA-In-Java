public class Pattern {

    /*

     * * *
     * * *
     * * *

     */
    public static void printPattern1(int n) {
        for(int i=0; i< n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println("\n");
        }
    }


    /*

     *
     * *
     * * *

     */
    public static void printPattern2(int n) {
        for(int i = n; i > 0; i--) {
            for(int j = 0; j <= n-i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }



    /*

        1
        1 2
        1 2 3

     */
    public static void printPattern3(int n) {
        for(int i = n; i >= 0; i--) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print(j +  " ");
            }
            System.out.print("\n");
        }
    }


    /*
        1
        22
        333
        4444
        55555
     */

    public static void printPattern4(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

    /*
     * * * * *
     * * * *
     * * *
     * *
     *
     */
    public static void printPattern5(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = n; j > i; j--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    /*

    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2
    1

     */
    public static void printPattern6(int n) {
        for(int i = n; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j +" ");
            }
            System.out.print("\n");
        }
    }


    /*
                  *
                 ***
                *****
               *******
              *********
     */
    public static void printPattern7(int n) {
        int count = 1;
        for(int i=1; i <= n; i++) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            int counter = 0;
            for(int k = 1; k <= count; k++) {
                System.out.print("*");
            }
            count = count + 2;
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");

        }
    }

    /*
                ***********
                 *********
                  *******
                   *****
                    ***
                     *

     */
    public static void printPattern8(int n) {
        int count = (2*n) - 1;
        for(int i=n; i > 0; i--) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 1; k <= count; k++) {
                System.out.print("*");
            }
            count = count - 2;
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");

        }
    }
}
