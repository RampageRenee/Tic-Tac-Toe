import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String urlInput = scanner.nextLine();

        boolean pass = "pass".matches(urlInput), port = "port".matches(urlInput), cookie = "cookie".matches(urlInput),
                host = "host".matches(urlInput);

        String[] middleSplit = urlInput.split("\\?");
        String[] parts = middleSplit[1].split("&");
        String[][] words = new String[parts.length][2];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < 2; j++) {
                words[i][j] = "empty";
            }

        }

        for (int i = 0; i < parts.length; i++) {
            words[i] = parts[i].split("=", -1);
        }


        for (int i = 0; i < words.length; i++) {
            if (words[i][1].equals("")) {
                words[i][1] = "not found";
            }
        }


        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < 2; j++) {

            }
            System.out.print(words[i][0] + " : ");
            System.out.println(words[i][1]);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i][0].equals("pass")) {
                System.out.println("password : " + words[i][1]);
            }
        }
    }

}