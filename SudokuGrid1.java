import java.awt.Point;

public class SudokuGrid1 {
	
	public static final int SIZE=9;
	public static final int DIGIT_RANGE=9;
	public int[][]grid= {
			{1,9,5,7,3,8,4,6,2},
			{2,6,8,4,0,9,5,7,3},
			{3,7,4,5,2,6,9,1,0},
			{7,5,1,3,8,2,0,4,9},
			{4,0,9,6,5,1,2,8,7},
			{8,2,6,9,0,7,3,5,1},
			{5,8,2,1,9,4,7,0,6},
			{9,0,7,8,6,3,1,2,5},
			{6,1,3,2,0,5,8,9,4}
			
	};

	
	public SudokuGrid1(int[][]grid) {
		this.grid=new int[SIZE][SIZE];
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				this.grid[i][j]=grid[i][j];
			}
		}
	}
	public SudokuGrid1 copy() { //mevcut izgaranin bir kopyasi
		return new SudokuGrid1(this.grid);
	}
	public Point findEmptyCell() { //izgarada bos bir hucre bulmaya calisip onun koordinatlarini dondurur
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(this.grid[i][j]==0) {
					return new Point(i,j);
				}
			}
		}
		return new Point(-1,-1);
	}
	
	public void fillCell(int r,int c, int num) {//belirli bir hucreye belirli bir sayinin yerlestirir
		this.grid[r][c]=num;
	}
	public int getCellValue(int r, int c) {
	    return this.grid[r][c];
	}
	
	public boolean givesConflict(int r,int c,int num) {//belirli bir hucreye belirli bir sayinin yerlestirilmesinin bir cakismaya neden olup olmadigini kontrol eder.
		return rowConflict(r,num)||colConflict(c,num)||boxConflict(r,c,num);
	}
	
	private boolean rowConflict(int r,int num) {//belirli bir satirda belirli bir sayinin olup olmadigini kontrol eder
		for(int i=0;i<SIZE;i++) {
			if(this.grid[r][i]==num) {
				return true;
			}
		}
		return false;
	}
	
	private boolean colConflict(int c,int num) {//belirli bir sutunda belirli bir sayinin olup olmadigini kontrol eder
		for(int i=0;i<SIZE;i++) {
			if(this.grid[i][c]==num) {
				return true;
			}
		}
		return false;
	}
	private boolean boxConflict(int r,int c,int num) {//belirli bir kutuda belirli bir sayinin olup olmadigini kontrol eder
		int startRow=r-r%3;
		int startCol=c-c%3;
		
		for(int i=startRow;i<startRow+3;i++) {
			for(int j=startCol;j<startCol+3;j++) {
				if(this.grid[i][j]==num) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
	    int[][] grid = {
	        {1,9,5,7,3,8,4,6,2},
	        {2,6,8,4,0,9,5,7,3},
	        {3,7,4,5,2,6,9,1,0},
	        {7,5,1,3,8,2,0,4,9},
	        {4,0,9,6,5,1,2,8,7},
	        {8,2,6,9,0,7,3,5,1},
	        {5,8,2,1,9,4,7,0,6},
	        {9,0,7,8,6,3,1,2,5},
	        {6,1,3,2,0,5,8,9,4}
	    };

	    SudokuGrid1 sudokuGrid = new SudokuGrid1(grid);
	    SudokuSolver1 sudokuSolver = new SudokuSolver1(sudokuGrid);

	    if (sudokuSolver.solve()) {
	        for (int i = 0; i < SudokuGrid1.SIZE; i++) {
	            for (int j = 0; j < SudokuGrid1.SIZE; j++) {
	                System.out.print(sudokuGrid.getCellValue(i, j) + " ");
	            }
	            System.out.println();
	        }
	    } else {
	        System.out.println("Bu Sudoku çözülemez.");
	    }
	}

}

