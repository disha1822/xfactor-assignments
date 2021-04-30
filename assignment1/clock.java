import java.util.*;

public class ClockAngle
{
    public static double findAngle(int hour, int minute)
    {
        double minutesDegree = 6.0 * minute;
        double hoursDegree = ((60 * hour) + minute) / 2.0;

        double angle = Math.abs(minutesDegree - hoursDegree);

        return angle;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter time in 12 hours format");

        String time = sc.nextLine();
        String[] properTime = time.split(":",time.length());
        int[] hourMinute = new int[2];

        hourMinute[0] = Integer.parseInt(properTime[0]);
        hourMinute[1] = Integer.parseInt(properTime[1]);

        System.out.println("Hour: "+hourMinute[0]);
        System.out.println("Minute: "+hourMinute[1]);

        System.out.println("Required angle is "+ClockAngle.findAngle(hourMinute[0],hourMinute[1])+"\u00B0");

        sc.close();
    }
}