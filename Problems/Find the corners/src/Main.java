class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        int a = twoDimArray.length-1; //aantal rijen
        int b = twoDimArray[0].length-1; //collommen

        System.out.print(twoDimArray[0][0] + " ");
        System.out.println(twoDimArray[0][b]);
        System.out.print(twoDimArray[a][0] + " ");
        System.out.println(twoDimArray[a][b]);

    }
}