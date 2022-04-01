package iLAB.database;

import java.util.Random;

public class phoneNumber {

    public String num(){


        Random num = new Random();
        int firstNum = 0;
        int[] carrierId = {6,7,8};
        int afterCarrierId = num.nextInt(10);
        int randomIndexForCarrierId = num.nextInt(carrierId.length);
        String first3 = firstNum + "" + carrierId[randomIndexForCarrierId] + "" + afterCarrierId;
        int upperBoundForSecondThree = 1000;
        int second3 =  num.nextInt(upperBoundForSecondThree);
        int upperBoundForLastFour = 10000;
        int last4 = num.nextInt(upperBoundForLastFour);
        String phoneNumber = first3 + " " + second3 + " " + last4;
        return phoneNumber;

    }

}
