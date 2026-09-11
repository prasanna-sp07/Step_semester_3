public class Experiment6 {

    static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {

            result[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int x : result)
            System.out.print(x + " ");
    }
}