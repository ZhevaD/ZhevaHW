package zheva.com;

import java.util.*;

public class HumanMain {
    public static void main(String[] args) {
        String[] hobbies = new String[3];
        hobbies[0] = "Football";
        hobbies[1] = "Java";
        hobbies[2] = "Kek";

        String[] hobbiesAnother = new String[] {
                "Football","Java","Kek"
        };

        int[][] intArray = new int[][] {
         new int[] {1,2,3},
         new int[] {10,20,30}
        };

        int length = hobbiesAnother.length;

        List<String> hobbiesList = new ArrayList<>();
        hobbiesList.add("Football");
        hobbiesList.add("Java");
        hobbiesList.add("Kek");

        List<String> hobbiesListAnother = List.of(
                "Football","Java","Kek"
        );
        Human zheva = new Human("Zheva",32, hobbies);
        Human zheva1 = new Human("Zheva",32, hobbies);

        Set<Human> hobbiesSet = new HashSet<>();
        hobbiesSet.add(zheva);
        hobbiesSet.add(zheva1);

        Set<String> hobbiesSetAnother = Set.of(
                "Football","Java","Kek"
        );

        Map<String, Human> humans = new HashMap<>();
        humans.put("123423412", zheva);
        humans.put("324123",zheva1);

        for(int i = 0; i< hobbies.length; i++){
            System.out.println(hobbies[i]);
        }

        for (String hobby: hobbies) {
            System.out.println(hobby);

        }
        for (String hobby: hobbiesList) {

        }
        boolean arrayContainJava = false;
        int index = 0;
        while (!arrayContainJava && index < hobbies.length) {
            if (!hobbies[index].equals("Java")){
                arrayContainJava = true;

            }
            index++;
        }

        do {
            if (hobbies[index].equals("Java")){
                arrayContainJava = true;
            }
            index++;
        } while (!arrayContainJava && index < hobbies.length);




    }

}
