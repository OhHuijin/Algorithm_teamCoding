package Team_interviewProblems;

import java.util.Scanner;

import Team_interviewProblems.Solution.MyFraction;

class TreeNode {
    int val;
    List<TreeNode> children;

    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}



public class Problem {

    static int N;
    public static void main(String[] args) {

        

        Solution s = new Solution();

            // //Tree
            // int N = 7;
            // TreeNode[] nodes = new TreeNode[N + 1];
            // int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {5, 7}};
            // for (int i = 1; i <= N; i++) {
            //     nodes[i] = new TreeNode(i);
            // }
            // for (int[] list : edges) {
            //     int parent = list[0]; int child = list[1];
            //     nodes[parent].children.add(nodes[child]);
            // }
            
            // System.out.println("The diameter of the network: " + Solution.findNetworkDiameter(nodes[1]));

            // //String
            // System.out.println(new MyFraction(s.kmp("B", "A")));
            // // 1/1
            // System.out.println(new MyFraction(s.kmp("A", "A")));
            // // 1/3
            // System.out.println(new MyFraction(s.kmp("AABAAB", "BAABAA")));
            // // 1/9
            // System.out.println(new MyFraction(s.kmp("EATIWANTM", "IWANTMEAT")));
            // // 1/16
            // System.out.println(new MyFraction(s.kmp("ABABCABCABCABCAB", "ABCABCABCABCABAB")));



            

            

            // Brute force
            Solution.Rectangle rectangle = s.getInput();
            int minSquares = s.minSquares(rectangle.width, rectangle.height);
            System.out.println("Minimum number of squares: " + minSquares);



            // Greedy
            int[] power = {10, 20, 20};
            int max = s.maxWeight(power);
            System.out.println("Maximum weight that the ropes can lift " + max);

            

            //Dynamic
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your voltage size : ");

            N = scanner.nextInt();

            System.out.println("Minimum number of registers:" + s.numRegister(N));


    }
}
