package utilities;
import java.util.Random;
import java.util.UUID;

public class TestDataUtil {

    private static final String[] ROLES = {
            "Admin",
            "User",
            "Manager",
            "Reviewer"
    };

    // ✅ Random Name
    public static String generateRandomName() {
        return "User_" + System.currentTimeMillis();
    }

    // ✅ Random Email
    public static String generateRandomEmail() {
        return "user" + System.currentTimeMillis() + "@testmail.com";
    }

    // ✅ Random Role
    public static String generateRandomRole() {
        Random random = new Random();
        return ROLES[random.nextInt(ROLES.length)];
    }
}
