//Find maximum volume of a cuboid

//You are given a perimeter & the area. Your task is to return the maximum volume that can be made in the form of a cuboid from the given perimeter and surface area.
//Note: Round off to 2 decimal places and for the given parameters, it is guaranteed that an answer always exists.
//Examples
//Input: perimeter = 22, area = 15
//Output: 3.02
//Explanation: The maximum attainable volume of the cuboid is 3.02

public class MaxVolume {

    double maxVolume(double perimeter, double area) {
        // code here

        // Compute intermediate terms to find dimensions
        double sqrtTerm = Math.sqrt(perimeter * perimeter - 24 * area);
        double dimension1 = (perimeter - sqrtTerm) / 12.0;
        double dimension2 = (perimeter / 4.0) - 2 * dimension1;

        // Calculate the volume
        double volume = Math.pow(dimension1, 2) * dimension2;

        // Round the result to two decimal places
        return Math.round(volume * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        MaxVolume maxVolume = new MaxVolume();
        double perimeter = 22, area = 15;
        double volume = maxVolume.maxVolume(perimeter, area);
        System.out.println(volume);
    }
}
