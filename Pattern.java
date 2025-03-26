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


    /*
              *
             ***
            *****
            *****
             ***
              *
     */

    public static void printPattern9(int n) {
        printPattern7(n);
        printPattern8(n);
    }



    /*
             *
             **
             ***
             ****
             *****
             ****
             ***
             **
             *
     */

    public static void printPattern10(int n) {
        int count1 = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j=0; j <= i; j++) {
                System.out.print("*");
            }
            for(int k=0; k < count1; k++) {
                System.out.print(" ");
            }
            count1--;
            System.out.print("\n");
        }

        int count2 = 0;
        for(int i = n - 1; i > 0; i--) {
            for(int j=0; j < i; j++) {
                System.out.print("*");
            }

            for(int k=0; k < count2; k++) {
                System.out.print(" ");
            }
            count2++;
            System.out.print("\n");
        }
    }


    /*
                    1
                    0 1
                    1 0 1
                    0 1 0 1
     */

    public static void printPattern11(int n) {
        for(int i=1; i<=n; i++) {
            if(i%2 == 0) {
                for(int j=1; j<=i; j++) {
                    if(j%2==0) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }

                    System.out.print(" ");
                }
            } else {
                for(int j=1; j<=i; j++) {
                    if(j%2==0) {
                        System.out.print("0");
                    } else {
                        System.out.print("1");
                    }
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


    /*
            1      1
            12    21
            123  321
            12344321
     */

    public static void printPattern12(int n) {
        int numberOfSpaces = (n*2) - 2;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }


            for(int k = 0; k < numberOfSpaces; k++) {
                System.out.print(" ");
            }

            for(int j = i; j > 0; j--) {
                System.out.print(j);
            }
            System.out.print(" ");

            numberOfSpaces = numberOfSpaces -2;
            System.out.print("\n");
        }
    }


    /*
                1
                2 3
                4 5 6
                7 8 9 10
     */

    public static void printPattern13(int n) {
        int counter = 0;
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j<=i; j++) {
                counter = counter + 1;
                System.out.print(counter+ " ");
            }
            System.out.print("\n");
        }
    }

    /*
                A
                A B
                A B C
                A B C D
                A B C D E
     */

    public static void printPattern14(int n) {
        int counter = 'A';
        for(int i = 1; i <=n; i++) {
            for(int j = 0; j<i; j++) {
                System.out.print((char)(counter +j) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
                A B C D E
                A B C D
                A B C
                A B
                A
     */

    public static void printPattern15(int n) {
        int counter = 'A';
        for(int i = n; i > 0; i--) {
            for(int j = 0; j<i; j++) {
                System.out.print((char)(counter +j) + " ");
            }
            System.out.print("\n");
        }
    }

    /*
            A
            B B
            C C C
            D D D D
            E E E E E
     */

    public static void printPattern16(int n) {
        int counter = 'A';
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print((char)(counter) + " ");
            }
            counter++;
            System.out.print("\n");
        }
    }




}
