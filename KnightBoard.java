public class KnightBoard{
  private int[][] board;
  private int[][] moves;
  private int count;


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
    solveHelper(startingRow,startingCol,2);
    if ( solved() ) {return true;}
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
    board[startingRow][startingCol]=1;
    countHelper(startingRow,startingCol,2);
    if ( solved() ) {return count;}
    board[startingRow][startingCol]=0;
    return count;
  }


  //Suggestion:

  private boolean solveHelper(int row ,int col, int level){

    if (row<0 || col<0 || row>board.length || col>board[0].length)return false;
    if (level>board.length * board[0].length)return true;

    for (int m=0;m<moves.length;m++){
      if (addK(row+moves[m][0],col+moves[m][1],level)) {
       if (solveHelper(row+moves[m][0],col+moves[m][1],level+1)){
          return true;
        }
        removeK(row+moves[m][0],col+moves[m][1]);
      }
      //Do the same as queens except instead of going through all the rows, go through all possible moves
    }
    return false;
  }


  private void countHelper(int row ,int col, int level){

    if (level>board.length * board[0].length){count ++;}

    for (int m=0;m<moves.length;m++){
      if (addK(row+moves[m][0],col+moves[m][1],level)) {
       countHelper(row+moves[m][0],col+moves[m][1],level+1);

        removeK(row+moves[m][0],col+moves[m][1]);
      }
      //Do the same as queens except instead of going through all the rows, go through all possible moves
    }
  }

  // level is the # of the knight


//------------------------------------------------------------------------------------------------------------------------------------------------------------------
//TESTING
  //testcase must be a valid index of your input/output array
  public static void runTest(int i){

    KnightBoard b;
    int[]m =   {4,5,5,5,5};
    int[]n =   {4,5,4,5,5};
    int[]startx = {0,0,0,1,2};
    int[]starty = {0,0,0,1,2};
    int[]answers = {0,304,32,56,64};
    if(i >= 0 ){
      try{
        int correct = answers[i];
        b = new KnightBoard(m[i%m.length],n[i%m.length]);

        int ans  = b.countSolutions(startx[i],starty[i]);

        if(correct==ans){
          System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
        }else{
          System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
        }
      }catch(Exception e){
        System.out.println("FAIL Exception case: "+i);

      }
    }
  }

  public static void main (String[] args){
    /*
    runTest(0);
    runTest(1);
    runTest(2);
    runTest(3);
    runTest(4);
    */
  }

}
