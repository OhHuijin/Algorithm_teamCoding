package Team_interviewProblems;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
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

    
}

