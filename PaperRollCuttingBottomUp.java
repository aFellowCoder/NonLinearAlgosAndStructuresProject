//Non Linear Data and Algorithms. Assignment 2 Part 1
//David Irwin
//R00109532
//Math.round is used to omit accuracy errors when dealing with double arithmetic.

public class PaperRollCuttingBottomUp {

    private double[][] keyMatrix = {{0, 1, 2, 3, 5}, {0, 1.2, 3, 5.8, 10.1}}; //this acts like a dictionary, where each
                                                                            //element has a corresponding value.
    private double numToReturn = 0;         //final answer

    public double maximumProfit(int n) {
        double[][] priceMatrix = new double[5][n + 1];      //creating matrix to hold all optimal subproblem values

        for (int row = 1; row <= 4; row++) {                //loop for rows

            for (int coloumn = 1; coloumn <= n; coloumn++) {    //loop for columns

                if (row > n) {                              //row corresponds to values in keyMatrix
                    break;                                  //if value is bigger than size of piece, early exit improves
                }                                          // efficiency?

                double excluding_new_num = priceMatrix[row - 1][coloumn]; //calculate price excluding new value added
                double including_new_num = coloumn - keyMatrix[0][row];     //calculate price including new value

                if (including_new_num >= 0) {   //used to catch negative values
                    including_new_num =Math.round((keyMatrix[1][row]+priceMatrix[row][(int)including_new_num])*10)/10.0;
                }

                double answer = Math.max(including_new_num, excluding_new_num); //determine optimal sub-solution
                priceMatrix[row][coloumn] = answer;          //storing optimal sub-solution
                numToReturn = answer;
            }
        }
        return numToReturn;                             //returning final answer
    }
}
