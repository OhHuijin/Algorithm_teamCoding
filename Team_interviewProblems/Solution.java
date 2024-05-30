package Team_interviewProblems;

import java.util.Arrays;
import java.util.Scanner;



public class Solution {
    public static int findNetworkDiameter(TreeNode root) {
        int answer =0;
        int maxDiameter = 0;
        for (TreeNode child : root.children) {
            int height = getHeight(child);
            for (TreeNode sibling : root.children) {
                if (child != sibling) {
                    int siblingHeight = getHeight(sibling);
                    maxDiameter = Math.max(maxDiameter, height + siblingHeight + 2);
                }
            }
        }
        for (TreeNode child : root.children) {
            maxDiameter = Math.max(maxDiameter, findNetworkDiameter(child));
        }
        answer = maxDiameter;
        return answer;
    }

    public static int getHeight(TreeNode node) {
        if (node == null) return -1;
        int maxHeight = -1;
        for (TreeNode child : node.children) {
            maxHeight = Math.max(maxHeight, getHeight(child));
        }
        return maxHeight + 1;
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

    public int numRegister(int voltage) {

        // DP: return the number of registers that decrease the voltage into 1 V.
        int OverLimit=voltage+1;
        int[] D =new int[voltage*3+1];
        Arrays.fill(D, OverLimit);
        D[voltage]=0;
        for(int i=voltage-1; i>0; i--){
            D[i]=FindSmallest(D[i*3],D[i*2],D[i+1])+1;
        }

        min = D[1];

        return min;
    }


    int FindSmallest(int a, int b, int c){
        return (a < b) ? (Math.min(a, c)) : (Math.min(b, c));
    }


    public int[] kmp(String paragraph, String pattern) {
        int n = paragraph.length();
        int m = pattern.length();

        if (n != m) {
            return new int[] {0, 1};
        }

        int[] lps = computeLPSArray(pattern);

        String combined = paragraph + paragraph;

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < 2 * n - 1) {
            if (pattern.charAt(j) == combined.charAt(i)) {
                i++;
                j++;
                if (j == m) {
                    count++;
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        int denominator = n;
        int numerator = count;

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return new int[] {numerator, denominator};
    }

    private int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int m = pattern.length();
        int[] lps = new int[m];
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    
}
