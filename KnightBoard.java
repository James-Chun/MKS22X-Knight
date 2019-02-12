public class KnightBoard{
  private int[][] board;

  //@throws IllegalArgumentException when either parameter is negative.
  //Initialize the board to the correct size and make them all 0's
  public KnightBoard(int startingRows,int startingCols){
    for (int rows=0;rows<board.length)
  }




  public String toString()
  /*
  see format for toString below
  blank boards display 0's as underscores
  you get a blank board if you never called solve or
  when there is no solution
  */

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol)

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public int countSolutions(int startingRow, int startingCol)

  //Suggestion:
  private boolean solveH(int row ,int col, int level)
  // level is the # of the knight

}
