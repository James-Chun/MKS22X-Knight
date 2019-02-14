public class KnightBoard{
  private int[][] board;
  private int[][] moves;


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
          visual += "_ ";
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

  public String moves(){    //debug methods to show moves
    String visual = "";
    for (int rows=0;rows<moves.length;rows++){
      for (int columns=0;columns<moves[rows].length;columns++){
          visual += moves[rows][columns]+" ";
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


  /*
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.
   */
  public boolean solve(int startingRow, int startingCol){
    if (!checkBoard()) {throw new IllegalStateException("ATTEMPTING TO WORK ON NON-EMPTY BOARD");}
    if (startingRow >= board.length || startingCol >= board[startingRow].length){throw new IllegalArgumentException("INDEX IS OUT OF BOUNDS");}

    return solveH(startingRow,startingCol,0);
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

  private boolean solveH(int row ,int col, int level){    //need to call possibleMOves somewhere here
    if (solved())return true;

    for (int m=0;m<moves.length;m++){       //simply a temp psuedo code
      if (moves[m]== solveH(startingRow+moves[m][0],startingCol+moves[m][1],level+1) ){   //remember, some values in moves will be null so check for that
        return sol
      }

      removeQueen(rows,column);       //Do the same as queens except instead of going through all the rows, go through all possible moves
    }
    return false;
  }



  private void possibleMoves(int currentRow, int currentCol){   //takes current coords of the knight and finds all possible moves.
    moves = new int[8][2];    //clearing the moves array [simply makes a list the size of all possible moves]
    int temp=0;   //keeping track of location in moves
    if (currentRow-2>=0){   //each array in moves is possible routes, each number in each subarray are specific directions (first is moving up or down[- || +] and second is moving left or right[- || +])
      if (currentCol-1>=0){
        moves[temp][0]=-2;
        moves[temp][1]=-1;
        temp++;
      }
      if (currentCol+1<=board[0].length){
        moves[temp][0]=-2;
        moves[temp][1]=1;                       //this works just make it cleaner later I guess
        temp++;
      }
    }

    if (currentRow+2<=board[0].length){
      if (currentCol-1>=0){
        moves[temp][0]=2;
        moves[temp][1]=-1;
        temp++;
      }
      if (currentCol+1<=board[0].length){
        moves[temp][0]=2;
        moves[temp][1]=1;
        temp++;
      }
    }

    if (currentRow-1>=0){
      if (currentCol-2>=0){
        moves[temp][0]=-1;
        moves[temp][1]=-2;
        temp++;
      }
      if (currentCol+2<=board[0].length){
        moves[temp][0]=-1;
        moves[temp][1]=2;
        temp++;
      }
    }

    if (currentRow+1<=board[0].length){
      if (currentCol-2>=0){
        moves[temp][0]=1;
        moves[temp][1]=-2;
        temp++;
      }
      if (currentCol+2<=board[0].length){
        moves[temp][0]=1;
        moves[temp][1]=2;
        temp++;
      }
    }

  }




  // level is the # of the knight


  public static void main (String[] args){
    KnightBoard board = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));


    System.out.println(board.toStringDebug());
    //System.out.println(board);


    System.out.println(board.moves());
  }

}
