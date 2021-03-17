import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                arr[i][j] = Math.abs(j - i); /// de hele berekening 0-0=0 || 0-1=1 enz


            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}