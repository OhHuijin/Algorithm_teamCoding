package Team_interviewProblems;
public class Problem {
    public static void main(String[] args) {

            

            Solution s = new Solution();

            //brute force
            Solution.Rectangle rectangle = s.getInput();
            int minSquares = s.minSquares(rectangle.width, rectangle.height);
            System.out.println("Minimum number of squares: " + minSquares);



            // Greedy
            int[] power = {10, 20, 20};
            int max = s.maxWeight(power);
            System.out.println("Maximum weight that the ropes can lift " + max);
    



    }
    

    //알아서 자기 부분 채우세요.
}