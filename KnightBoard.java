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



  /*
  blank boards display 0's as underscores
  you get a blank board if you never called solve or --(Im guessing when you call solve it changes the board so I can leave this as is)
  when there is no solution
  */
  public String toString(){
    String visual = "";
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        if (board[rows][columns]==0){
          visual += "_ ";
        }
      }
      visual += "\n";
    }
    return visual;
  }

  public String toStringDebug(){    //displays the board in its raw state (with all the numbers)
    String visual = "";
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){

          visual += board[rows][columns]+" ";

      }
      visual += "\n";
    }
    return visual;
  }


  private boolean checkBoard(){   //simply checks the board and sees if it contains only zeroes
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        if (board[rows][columns]!=0) return false;
      }
    }
    return true;
  }


  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    if (!checkBoard()) {throw new IllegalStateException("ATTEMPTING TO WORK ON NON-EMPTY BOARD");}
    if (startingRow >= board.length || startingCol >= board[startingRow].length){throw new IllegalArgumentException("INDEX IS OUT OF BOUNDS");}
    return true;
  }

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
    KnightBoard board = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

    //board.board[0][0]=1;

    //System.out.println(board.toStringDebug());
    //System.out.println(board);

    board.solve(0,3);
  }

}