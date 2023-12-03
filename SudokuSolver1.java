public class SudokuSolver1 {
	private SudokuGrid1 grid;
	public SudokuSolver1(SudokuGrid1 grid) {
		this.grid=grid;
	}
	public boolean solve() {
		for(int row=0;row<SudokuGrid1.SIZE;row++) {
			for(int col=0;col<SudokuGrid1.SIZE;col++) {
				if(grid.getCellValue(row,col)==0) {//eger hucre bossa
					
					for(int num=1;num<=SudokuGrid1.DIGIT_RANGE;num++) {
						if(!grid.givesConflict(row, col, num)) {
							//eger sayi cakisma yaratmiyorsa
							grid.fillCell(row, col, num);
							//hucreyi doldur
							if(solve()) {//ozyinelemeli cagri
								return true;
							}else {
								grid.fillCell(row, col,0);//geri al
							}
						}
					}
					return false;//eger hic bir sayi uygun degilse false dondur.
				}
			}
		}
		return true;//tum hucreler doluysa true dondur.
	}
}
