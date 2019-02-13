public class KnightBoard{
  private int[][] board;


  //@throws IllegalArgumentException when either parameter is negative.
  //Initialize the board to the correct size and make them all 0's
  public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        board[rows][columns]=0;
      }
    }
  }




  public String toString(){
    String visual = "";
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board.length;columns++){
        if (board[rows][columns]==0){
          visual += "_ ";
        }
      }
      visuals += "\n";
    }
    return visual;
  }
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
  //public boolean solve(int startingRow, int startingCol)

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  //public int countSolutions(int startingRow, int startingCol)

  //Suggestion:
  //private boolean solveH(int row ,int col, int level)
  // level is the # of the knight


  public static void main (String[] args){
    KnightBoard board = new KnightBoard(args[0], arg[1]);
    System.out.println(board);
  }

}
