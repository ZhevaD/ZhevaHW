package zheva.com;

public class Main {
    public static void main(String args[]) {

        String s = "Zheva";

        switch (s) {
            case "Zheva": {
                System.out.println("This is Zheva");
                break;
            }
            case "Eba": {
                System.out.println("This is Eba");
                break;
            }
            default: {
                System.out.println("Default");
            }
        }
        if (s.equals("Zheva")) {
            System.out.println("Lobok");
        } else if (s.equals("Eba")) {
            System.out.println("Boba");
        } else {
            System.out.println("Default");
        }
    }
}