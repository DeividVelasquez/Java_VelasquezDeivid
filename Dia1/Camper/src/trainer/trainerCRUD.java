package trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class trainerCRUD {
    private List<trainer> trainers; 
    private Scanner sc;

    public trainerCRUD(){
        trainers = new ArrayList<>();
        sc = new Scanner(System.in);
    }

}
