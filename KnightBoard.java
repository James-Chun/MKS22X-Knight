public class KnightBoard{
  private int[][] board;
  private int[][] moves;


  //@throws IllegalArgumentException when either parameter is negative.
  //Initialize the board to the correct size and make them all 0's
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){throw new IllegalArgumentException("BOARD DIMENSIONS CANNOT BE NEGATIVE");}
    board = new int[startingRows][startingCols];
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        board[rows][columns]=0;
      }
    }
    moves = new int[][]{
      {1,-2},{2,-1},{1,2},{2,1},{-2,-1},{-1,-2},{-1,2},{-2,1}
    };
  }



//------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
          visual += " _";
        }
        else{
          if (board[rows][columns]/10==0) {visual = visual + "  " + board[rows][columns];}
          else{visual = visual + " " + board[rows][columns];}
        }
      }
      visual += "\n";
    }
    return visual;
  }

  public String toStringDebug(){    //displays the board in its raw state (with all the numbers)
    String visual = "";             //keep in mind that adding a number in board will not be accounted for by the toStrings as it only checks for 0's and adds something if there are
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){

          visual += board[rows][columns]+" ";

      }
      visual += "\n";
    }
    return visual;
  }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

  private boolean checkBoard(){   //simply checks the board and sees if it contains only zeroes
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        if (board[rows][columns]!=0) return false;
      }
    }
    return true;
  }

  private boolean solved(){   //checks if the board is solved (if it contains no 0's then it is solved)
    for (int rows=0;rows<board.length;rows++){
      for (int columns=0;columns<board[rows].length;columns++){
        if (board[rows][columns]==0) return false;
      }
    }
    return true;
  }




  private boolean addK(int r, int c, int l){
    if (r<0 || c<0 || r>=board.length || c>=board[0].length)return false;
    if (board[r][c]==0){
      board[r][c]=l;
      return true;
    }
    return false;
  }
  private boolean removeK(int r, int c){
    if (r<0 || c<0 || r>=board.length || c>=board[0].length)return false;
    if (board[r][c]!=0){
      board[r][c]=0;
      return true;
    }
    return false;
  }


  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    if (!checkBoard()) {throw new IllegalStateException("ATTEMPTING TO WORK ON NON-EMPTY BOARD");}
    if (startingRow >= board.length || startingCol >= board[startingRow].length){throw new IllegalArgumentException("INDEX IS OUT OF BOUNDS");}
    board[startingRow][startingCol]=1;
    solveH(startingRow,startingCol,2);
    if ( solved() ) {
        return true;
    }
    board[startingRow][startingCol]=0;
    return false;
  }

  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public int countSolutions(int startingRow, int startingCol){
    if (!checkBoard()) {throw new IllegalStateException("ATTEMPTING TO WORK ON NON-EMPTY BOARD");}
    if (startingRow >= board.length || startingCol >= board[startingRow].length){throw new IllegalArgumentException("INDEX IS OUT OF BOUNDS");}
    return 0;
  }


  //Suggestion:

  private boolean solveH(int row ,int col, int level){

    if (row<0 || col<0 || row>board.length || col>board[0].length)return false;
    if (level>board.length * board[0].length)return true;

    for (int m=0;m<moves.length;m++){
      if (addK(row+moves[m][0],col+moves[m][1],level)) {
       if (solveH(row+moves[m][0],col+moves[m][1],level+1)){
          return true;
        }
        removeK(row+moves[m][0],col+moves[m][1]);
      }
      //Do the same as queens except instead of going through all the rows, go through all possible moves
    }
    return false;
  }




  // level is the # of the knight


  public static void main (String[] args){
    KnightBoard board = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));


    //System.out.println(board.toStringDebug());
    //System.out.println(board);
    //System.out.println(board.moves());
  //  System.out.println(board);
    board.solve(0,0);
    System.out.println(board);
    //System.out.println(board.toStringDebug());
  }

}
