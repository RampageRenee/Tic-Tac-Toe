import java.sql.SQLOutput;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //rij
        int m = scanner.nextInt(); //collom
        scanner.nextLine();
        int[][] matrix = new int[n][m];

        int[] tijdelijk = new int[m];
        int teller = 0;
        String inhoud = "";

        for (int i = 0; i < n; i++) {
            inhoud = scanner.nextLine();
            inhoud = inhoud.replace(" ", "");
            for (int j = 0; j < m; j++) {
                int nummer = Character.digit(inhoud.charAt(j), 10);
                matrix[teller][j] = nummer;   //inhoud.charAt(j);
            }
            teller++;
        }

        int k = scanner.nextInt();


        // controleer of er "k" aantal nullen naast elkaar staan
        teller=0;
        int rij = 0;
        boolean gevonden=false;

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (gevonden == false) {
                    if (matrix[i][j] == 0) {
                        teller++;
                        if (teller >= k) {
                            rij = i + 1;
                            gevonden = true;
                        }else{
                            rij = 0;
                            //teller=0;
                        }
                    } else {
                        teller = 0;
                    }
                }
            }
            teller = 0;

        }
       System.out.println(rij);

        /*for (int[] printArray:matrix) {
            for (int spring: printArray) {
                System.out.print(spring + " ");
            }
            System.out.println();
        }*/


    }
}
