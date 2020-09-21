import java.util.Random;

public class IntArrayTester {
    public static int[] parseToArray(String str) {
        str = str.substring(1, str.length() - 1);
        if (str.isEmpty()) {
            return new int[0];
        }
        str = str.replace(" ", "");
        String[] split = str.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    public static int[] createRandomIntArray() {
        Random random = new Random(System.currentTimeMillis());
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            result[i] = random.nextInt(20);
        }
        return result;
    }

    public static void check(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            assert nums1 == null;
            assert nums2 == null;
            return;
        }
        assert nums1.length == nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            assert nums1[i] == nums2[i];
        }
    }
}
