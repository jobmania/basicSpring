package CH19_Exception;

import java.util.Scanner;

public class NullPoint {
    public static void main(String[] args) {
        Scanner scanner = null; // nullpointexception
        scanner.nextLine();
    }
}
