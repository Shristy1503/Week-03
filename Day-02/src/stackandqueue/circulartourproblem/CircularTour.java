package stackandqueue.circulartourproblem;

public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            // Calculate surplus at the current pump
            int surplus = petrol[i] - distance[i];
            totalSurplus += surplus;
            currentSurplus += surplus;

            // If current surplus is negative, reset the starting point
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        //ternary operator
        return (totalSurplus >= 0) ? start : -1;
    }
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startingPoint = findStartingPoint(petrol, distance);
        if (startingPoint != -1) {
            System.out.println("The starting petrol pump is: " + startingPoint);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
