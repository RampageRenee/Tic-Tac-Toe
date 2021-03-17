import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int counter=0;
        int size = scanner.nextInt();
        int [] arrrr = new int[size];

        for(int i=0;i<size; i++){
            arrrr[i] = scanner.nextInt();
        }


        ArrayList<Integer> temp = new ArrayList<>();
        int start= arrrr[0];

        if(arrrr.length>1) {
            for (int i = 1; i < arrrr.length; i++) {

                if (start < arrrr[i]) {
                    counter++;
                    start = arrrr[i];
                } else {
                    temp.add(counter);
                    counter = 0;
                    start = arrrr[i];
                }
                temp.add(counter);
            }
        }else{
            temp.add(0);
        }

        Collections.sort(temp);
        int lastFromArray = temp.size()-1;
        int insideLastFromArray= temp.get(0);

        if (lastFromArray>0) {
            insideLastFromArray = temp.get(lastFromArray);
        }


        System.out.println(insideLastFromArray + 1);
    }
}