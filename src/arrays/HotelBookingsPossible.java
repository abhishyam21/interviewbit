package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 8/19/2016.
 */
public class HotelBookingsPossible {
    public static void main(String[] args) {

       /* Integer[] temp = {9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27};
        Integer[] temp1 = {32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38};*/
       Integer[] temp = {11, 24, 36, 15, 16, 23, 20, 19};
       Integer[] temp1 = {14, 32, 67, 25, 21, 54, 61, 34};
        ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(temp));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(temp1));

        int k = 4;
        HotelBookingsPossible hotelBookingsPossible = new HotelBookingsPossible();
        System.out.println(hotelBookingsPossible.hotel(arrive,depart,k));
    }

    private boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        System.out.println(arrive.toString());
        System.out.println(depart.toString());
        int roomCount = 0;
        int ac=0,dc=0;
        while (ac < arrive.size() && dc < depart.size()){
            if( arrive.get(ac) < depart.get(dc)){
                    roomCount++;
                if(roomCount >K)
                    return false;
                    ac++;
            }else {
                dc++;
                roomCount--;
            }
        }
        return roomCount <= K;
    }
}
