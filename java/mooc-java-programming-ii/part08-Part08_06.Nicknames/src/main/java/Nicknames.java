
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        long start = System.nanoTime();
        HashMap<String, String> nicknames = new HashMap<>();
        nicknames.put("matthew", "matt");
        nicknames.put("michael", "mix");
        nicknames.put("arthur", "artie");
        System.out.println(nicknames.get("matthew"));

        long end = System.nanoTime();
        double durationInMilliseconds = 1.0 * (end - start) / 1000000;
        System.out.println("Time: " + durationInMilliseconds);

    }

}
