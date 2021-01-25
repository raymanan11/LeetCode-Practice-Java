import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DriveTime driveTime = new DriveTime();

        int[] nums = {5,13,11,0};
        int[] result = driveTime.shiftOne(nums, 2);
        for (int num : result) System.out.print(num + " ");
    }

}
