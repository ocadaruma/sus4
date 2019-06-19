import java.util.*;

class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            nums[i] = n;
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
