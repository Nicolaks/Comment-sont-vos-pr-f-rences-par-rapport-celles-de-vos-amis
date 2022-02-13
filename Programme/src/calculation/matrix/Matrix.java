package calculation.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Matrix class.
 */
public class Matrix {

	/** The rows. */
	private int rows;

	/** The columns. */
	private int columns;

	/** The matrix. */
	Double[][] matrix;

	/**
	 * Instantiates a new matrix.
	 *
	 * @param mat a matrix of double
	 */
	public Matrix(Double[][] mat) {
		this.rows = mat.length;
		this.columns = mat.length;
		this.matrix = new Double[mat.length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				matrix[i][j] = mat[i][j];
			}
		}
	}

	/**
	 * method to display the matrix.
	 */
	public void display() {
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix.length; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * method to square a matrix.
	 *
	 * @param matrix the matrix
	 * @return a matrix
	 */
	public Matrix squareMatrix(Matrix matrix) {
		Double[][] squaredMatrix;
		squaredMatrix = new Double[matrix.getRows()][matrix.getColumns()];
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				squaredMatrix[i][j] = matrix.getMatrix()[i][j] * matrix.getMatrix()[i][j];
			}
		}
		return new Matrix(squaredMatrix);
	}

	/**
	 * method to substract 2 matrixs.
	 *
	 * @param matrix1 the matrix 1
	 * @param matrix2 the matrix 2
	 * @return a matrix
	 */
	public static Matrix substractMatrix(Matrix matrix1, Matrix matrix2) {
		Double[][] substractedMatrix;
		substractedMatrix = new Double[matrix1.getRows()][matrix1.getColumns()];
		for (int i = 0; i < matrix1.getRows(); i++) {
			for (int j = 0; j < matrix1.getColumns(); j++) {
				substractedMatrix[i][j] = matrix1.getMatrix()[i][j] - matrix2.getMatrix()[i][j];
			}
		}
		return new Matrix(substractedMatrix);
	}

	/**
	 * method that compute the average of a list of matrixs.
	 *
	 * @param matrixs the matrixs
	 * @return a matrix
	 */
	public static Matrix averageMatrix(ArrayList<Matrix> matrixs) {
		Double[][] averageMatrix = new Double[matrixs.get(0).getRows()][matrixs.get(0).getColumns()];
		for (int i = 0; i < matrixs.get(0).getRows(); i++) {
			for (int j = 0; j < matrixs.get(0).getColumns(); j++) {
				averageMatrix[i][j] = 0d;
				for (int k = 0; k < matrixs.size(); k++) {
					averageMatrix[i][j] += matrixs.get(k).getMatrix()[i][j];
				}
				if (averageMatrix[i][j] != 0) {
					averageMatrix[i][j] = averageMatrix[i][j] / matrixs.size();
				}
			}
		}
		return new Matrix(averageMatrix);
	}

	/**
	 * method to find the maximum value of a matrix.
	 *
	 * @param matrix the matrix
	 * @return the maximum value, a double
	 */
	public static Double maximumValue(Matrix matrix) {
		Double max = matrix.getMatrix()[0][0];
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				if (matrix.getMatrix()[i][j] > max) {
					max = matrix.getMatrix()[i][j];
				}
			}
		}
		return max;
	}

	/**
	 * method to find the maximum value of a matrix.
	 *
	 * @param matrix the matrix
	 * @return the maximum value, a double
	 */
	public static Double maximumValueAbs(Matrix matrix) {
		Double max = Math.abs(matrix.getMatrix()[0][0]);
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				if (Math.abs(matrix.getMatrix()[i][j]) > max) {
					max = Math.abs(matrix.getMatrix()[i][j]);
				}
			}
		}
		return max;
	}

	/**
	 * method to find the minimum value of a matrix.
	 *
	 * @param matrix the matrix
	 * @return the minimum value, a double
	 */
	public Double minimumValue(Matrix matrix) {
		Double min = matrix.getMatrix()[0][0];
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				if (matrix.getMatrix()[i][j] < min) {
					min = matrix.getMatrix()[i][j];
				}
			}
		}
		return min;
	}

	/**
	 * method to get the frobenius number of a matrix.
	 *
	 * @param matrix the matrix
	 * @return frobenius number, a double
	 */
	public static Double getFrobenius(Matrix matrix) {
		Double total = 0.0;
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				total = total + (matrix.getMatrix()[i][j]) * (matrix.getMatrix()[i][j]);
			}
		}
		return total;

	}

	/**
	 * method that multiply a matrix by a double.
	 *
	 * @param matrix1 the matrix 1
	 * @param number   the number
	 * @return a matrix
	 */
	public static Matrix multiplyMatrixByDouble(Matrix matrix1, Double number) {
		Double[][] multipliedMatrix;
		multipliedMatrix = new Double[matrix1.getRows()][matrix1.getColumns()];
		for (int i = 0; i < matrix1.getRows(); i++) {
			for (int j = 0; j < matrix1.getColumns(); j++) {
				multipliedMatrix[i][j] = matrix1.getMatrix()[i][j] * 0.5;
			}
		}
		return new Matrix(multipliedMatrix);
	}

	/**
	 * Gets the sum of rows.
	 *
	 * @param matrix1 the matrix 1
	 * @return the sum of rows
	 */
	public static List<Double> getSumOfRowsSquared(Matrix matrix1) {
		List<Double> sumsOfRows = new ArrayList<>();
		Double sumLine = 0.0;
		for (int i = 0; i < matrix1.getRows(); i++) {
			for (int j = 0; j < matrix1.getColumns(); j++) {
				sumLine += ((matrix1.getMatrix()[i][j]) * (matrix1.getMatrix()[i][j]));
			}
			sumsOfRows.add(sumLine);
			sumLine = 0.0;
		}
		return sumsOfRows;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Gets the columns.
	 *
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Sets the columns.
	 *
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Gets the matrix.
	 *
	 * @return the matrix
	 */
	public Double[][] getMatrix() {
		return matrix;
	}

	/**
	 * Sets the matrix.
	 *
	 * @param matrix the matrix to set
	 */
	public void setMatrix(Double[][] matrix) {
		this.matrix = matrix;
	}

}
