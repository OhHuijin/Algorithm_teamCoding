package Team_interviewProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class Solution {


//     public int[] kmp(String paragraph, String pattern) {
//         // String part: returns probability index 0 : numerator and index 1: denominator

//         int cnt = 0, n = pattern.length();

//         return new int[] {cnt, n};
//     }

//     public class MyFraction {
//         private int numerator, denominator;
    
//         MyFraction(int[] arr) {
//             if (arr[1] == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
//             if (arr.length != 2) throw new IllegalArgumentException("The array must be size 2.");
//             numerator = arr[0];
//             denominator = arr[1];
//             makeReducedFraction(numerator, denominator);
//         }
    
//         private void makeReducedFraction(int a, int b) {
//             int tmp;
//             while (b != 0) {
//                 tmp = a % b;
//                 a = b;
//                 b = tmp;
//             }
//             numerator /= a;
//             denominator /= a;
    
//         }
    
//         @Override
//         public String toString() {
//             if (numerator == 0)
//                 return "0";
//             return numerator + "/" + denominator;
//         }
//     }

    
//    public int findNetworkDiameter(TreeNode root) {

//         // Tree part: returns: maximum latency 

//         //* TreeNode class is
//    }

   class TreeNode {

    int val;

    List<TreeNode> children;

 

    public TreeNode(int val) {

        this.val = val;

        this.children = new ArrayList<>();

    }
}

    public int maxWeight(int[] ropes){
        //Greedy Algorithm: return maximum weight that the ropes can lift
        int maxWeight = 0;
        
        // Sort the power array in descending order
        Arrays.sort(ropes);
        for (int i = ropes.length - 1; i >= 0; i--) {
            // Calculate weight that all people can lift with current rope
            int weight = ropes[i] * (ropes.length - i);
            // Update maxWeight if current weight is greater
            maxWeight = Math.max(maxWeight, weight);
        }
        
        return maxWeight;
    }

    private Rectangle rectangle;

    public Solution() {
        this.rectangle = new Rectangle(0, 0); // Initialize with default values
    }

    public Rectangle getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width of the rectangle:");
        int width = scanner.nextInt();
        System.out.println("Enter the height of the rectangle:");
        int height = scanner.nextInt();
        this.rectangle.width = width;
        this.rectangle.height = height;
        return new Rectangle(width, height);
    }
    
    public int minSquares(int width, int height) {
        if (width == height) {
            return 1;
        }
    
        int minSquares = Integer.MAX_VALUE;
    
        for (int i = 1; i <= width / 2; i++) {
            minSquares = Math.min(minSquares, minSquares(i, height) + minSquares(width - i, height));
        }
    
        for (int j = 1; j <= height / 2; j++) {
            minSquares = Math.min(minSquares, minSquares(width, j) + minSquares(width, height - j));
        }
    
        return minSquares;
    }
    

    public class Rectangle {
        int width;
        int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    static int min;
    public int countRegisters(int N) {

        /* Complete this method */
        int OverLimit=N+1;
        int[] D =new int[N*3+1];
        Arrays.fill(D, OverLimit);
        D[N]=0;
        for(int i=N-1; i>0; i--){
            D[i]=FindSmallest(D[i*3],D[i*2],D[i+1])+1;
        }

        min = D[1];

        return min;
    }


    int FindSmallest(int a, int b, int c){
        return (a < b) ? (Math.min(a, c)) : (Math.min(b, c));
    }

}
