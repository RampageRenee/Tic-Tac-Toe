package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int playersTurn = 1;  String game=""; char playerOne = 'X', playerTwo = 'O'; boolean playerLoop=!false;
        char[] current = new char[9];
        fillCompleteCentence(current);


        char[][] gameBoard = new char[9][9];
        FillArray(gameBoard);

         //ready to start the game on an empty board!


        while (playerLoop) {

            if (playersTurn % 2 == 1) {
                PrintBoard(gameBoard);
                InputCoordinates(scanner, gameBoard, playerOne, current);  //playerLoop
                game = String.valueOf(current);
                    if (!CheckStatusGame(game, playerLoop, gameBoard)){
                        break;
                    };
                playersTurn++;
            } else {
                PrintBoard(gameBoard);
                InputCoordinates(scanner, gameBoard, playerTwo,current);  //playerLoop
                game = String.valueOf(current);
                    if (!CheckStatusGame(game, playerLoop, gameBoard)){
                        break;
                    };
                playersTurn++;
            }

        }




    }

    private static void fillCompleteCentence(char[] current) {
        for (int i =0; i < 9; i++){
            current[i] = '_';
        }
    }

    private static void CurrentGameState(char[][] gameBoard) {
        int teller=0;
        char[] current = new char[9];

        for (int i=2; i< 7;i+=2){
            for (int j=2; j< 7; j+=2){
                current[teller] = gameBoard[i][j];
                teller++;
            } // I put the usable version in the putPlayInOrder method, nested in the InputCoordinates
        }  /// this one filled the _ places with nothing while looping trough it, we don't wat that for checking the X and O
    }

    public static void FillArray(char[][] gameBoard) {
        for (int i = 0; i < 9; i++) {
            gameBoard[0][i] = '-';
            gameBoard[8][i] = '-';

        }
        for (int i = 2; i < 7; i += 2) {
            gameBoard[i][0] = '|';
            gameBoard[i][8] = '|';
        }
        for (int i = 2; i < 7; i += 2) {
            for (int j = 1; j < 8; j += 2) {
                gameBoard[i][j] = ' ';
            }
        }
        for (int i=2; i<7; i+=2){
            for (int j=2; j<7; j+=2){
                gameBoard[i][j]=' ';
            }
        }

    }

    public static void FillGamePlay(String game, char[][] gameBoard) {
        int teller = 0;
        for (int i = 2; i < 7; i += 2) {
            for (int j = 2; j < 7; j += 2) {
                gameBoard[i][j] = game.charAt(teller);
                teller++;
            }
        }
    }  /// not relevant in the end project

    public static void PrintBoard(char[][] gameBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean CheckStatusGame(String game, boolean playerLoop, char[][] gameBoard ) {
        boolean winner = false;


            String rijEen= game.substring(0,3), rijTwee = game.substring(3,6), rijDrie = game.substring(6);

            int x=0, o=0;
            boolean aantal=false, exex = false, oos = false;

            for (int i=0; i<game.length(); i++){
                if(game.charAt(i)=='X'){
                    x++;
                }else if(game.charAt(i)== 'O'){
                    o++;
                }
            }

            if ((x-o)>=2 || (o-x)>=2){
                aantal=true;
            }


            if (rijEen.equals("XXX") || rijTwee.equals("XXX") || rijDrie.equals("XXX")) {
                exex =true;
            } else if (game.charAt(0) == 'X' && game.charAt(3) == 'X' && game.charAt(6) == 'X' || game.charAt(1) == 'X' && game.charAt(4) == 'X' && game.charAt(7) == 'X' || game.charAt(2) == 'X' && game.charAt(5) == 'X' && game.charAt(8) == 'X') {
                exex =true;
            } else if (game.charAt(0) == 'X' && game.charAt(4) == 'X' & game.charAt(8) == 'X' || game.charAt(2) == 'X' && game.charAt(4) == 'X' && game.charAt(6) == 'X') {
                exex =true;
            }
            if (rijEen.equals("OOO") || rijTwee.equals("OOO") || rijDrie.equals("OOO")) {
                oos = true;
            } else if (game.charAt(0) == 'O' && game.charAt(3) == 'O' && game.charAt(6) == 'O' || game.charAt(1) == 'O' && game.charAt(4) == 'O' && game.charAt(7) == 'O' || game.charAt(2) == 'O' && game.charAt(5) == 'O' && game.charAt(8) == 'O') {
                oos = true;
            } else if (game.charAt(0) == 'O' && game.charAt(4) == 'O' && game.charAt(8) == 'O' || game.charAt(2) == 'O' && game.charAt(4) == 'O' && game.charAt(6) == 'O') {
                oos = true;
            }

            /*if ((exex && oos) || aantal){
                System.out.println("Impossible"); //NOT Nesesary at this point anymore

            }else if(exex){
                System.out.println("X wins");
            }else if (oos){
                System.out.println("O wins");
            }else if(!exex && !oos && !game.contains("_")){
                System.out.println("Draw");
            }else{
                System.out.println("Game not finished");
            }*/





            if(exex){
                PrintBoard(gameBoard);
                System.out.println("X wins");
                playerLoop = false;

            }else if (oos) {
                PrintBoard(gameBoard);
                System.out.println("O wins");
                playerLoop = false;
            }else if (!game.contains("_")){
            PrintBoard(gameBoard);
                System.out.println("Draw");
                playerLoop = false;
            }

        return playerLoop;

        }

    public static void InputCoordinates(Scanner scanner, char[][] gameboard, char player, char[] current){
        boolean repeat = true;

        while (repeat) {
            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();

            String rowsAndCollum = coordinates.replace(" ", "");
            //int r = rowsAndCollum.charAt(0) -48, c=rowsAndCollum.charAt(1) - 48;

            if ((rowsAndCollum.matches("\\d+"))) {
                if ((!(rowsAndCollum.matches("[123]+")))) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    //InputCoordinates(scanner, gameboard);
                } else {
                    int r = (rowsAndCollum.charAt(0) - 48) * 2, c = (rowsAndCollum.charAt(1) - 48) * 2;

                    if (gameboard[r][c] == 'X' || gameboard[r][c] == 'O') {
                        System.out.println("This Cell is occupied! Choose another one!");
                        //InputCoordinates(scanner, gameboard);
                    } else {
                        gameboard[r][c] = player;
                        // current[]
                        putPlayInOrder(player, current, r, c);
                        repeat = false;
                    }
                }
            } else {
                System.out.println("You should enter numbers!");
                //InputCoordinates(scanner, gameboard);
            }
        }

    }

    private static void putPlayInOrder(char player, char[] current, int r, int c) {
        if (r ==2){
            if(c ==2){
                current[0] = player;
            }else if(c ==4){
                current[1] = player;
            }else{
                current[2] = player;
            }
        }else if (r ==4){
            if(c ==2){
                current[3] = player;
            }else if(c ==4){
                current[4] = player;
            }else{
                current[5] = player;
            }
        }else{
            if(c ==2){
                current[6] = player;
            }else if(c ==4){
                current[7] = player;
            }else{
                current[8] = player;
            }
        }
    }

}

////16-03-2021
