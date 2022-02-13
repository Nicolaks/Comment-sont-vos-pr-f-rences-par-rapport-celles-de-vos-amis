package calculation;

import java.util.ArrayList;
import java.util.List;

import calculation.matrix.Matrix;
import data.Group;
import data.Person;
import data.sushiSet.User;

/**
 * Deviation calculation with quality measures.
 */
public class Deviation {

	/**
	 * Labelwise measures.
	 *
	 * @param subGroup the sub group
	 * @return the double
	 */
	public static Double labelwiseMeasures(Group subGroup) {
		Double s = (double) subGroup.getPop().size();
		Double n = (double) subGroup.getOriginal().size();
		Matrix LS = getLS(subGroup);

		List<Double> sumsOfRows = Matrix.getSumOfRowsSquared(LS);
		Double max = Math.sqrt(sumsOfRows.get(0));
		for (int i = 1; i < sumsOfRows.size(); i++) {
			if (Math.sqrt(sumsOfRows.get(i)) > max) {
				max = Math.sqrt(sumsOfRows.get(i));
			}
		}
		Double sn = (s / n);
		Double sqrt = Math.sqrt(sn);
		//Double sqrtBis = Math.sqrt(max);
		Double res = sqrt * max;
		return res;
	}

	/**
	 * Pairwise measures.
	 *
	 * @param subGroup the sub group
	 * @return the double
	 */
	public static Double pairwiseMeasures(Group subGroup) {
		Double s = (double) subGroup.getPop().size();
		Double n = (double) subGroup.getOriginal().size();
		Matrix LS = getLS(subGroup);

		Double max = Matrix.maximumValueAbs(LS);
		Double sn = (s / n);
		Double sqrt = Math.sqrt(sn);
		Double res = sqrt * max;
		return res;
	}

	/**
	 * Ranking wise measure.
	 *
	 * @param subGroup the sub group
	 * @return the double
	 */
	public static Double rankingWiseMeasures(Group subGroup) {
		Double s = (double) subGroup.getPop().size();
		Double n = (double) subGroup.getOriginal().size();
		Matrix LS = getLS(subGroup);
		Double LSf = Matrix.getFrobenius(LS);
		Double sn = (s / n);
		Double sqrt = Math.sqrt(sn);
		Double res = sqrt * LSf;
		return res;
	}

	/**
	 * method that compute the distance matrix LS between the subgroup and the
	 * population, ls = 1/2 * (MD- MS).
	 *
	 * @param subGroup the subGroup
	 * @return distance matrix LS
	 */
	public static Matrix getLS(Group subGroup) {
		Matrix matricemoyennessgroupe = calculateAverageMatrix(subGroup.getPop());
		Matrix matricemoyennesspopulation = calculateAverageMatrix(subGroup.getOriginal());
		Matrix mdminusms = Matrix.substractMatrix(matricemoyennesspopulation, matricemoyennessgroupe);
		Double demi = 0.5;
		Matrix res = Matrix.multiplyMatrixByDouble(mdminusms, demi);
		return res;
	}

	/**
	 * Calculate average matrix.
	 *
	 * @param group the group
	 * @return the matrix
	 */
	public static Matrix calculateAverageMatrix(List<Person> group) {
		ArrayList<Matrix> matrixList = new ArrayList<Matrix>();
		if (group.size() != 0) {
			for (Person p : group) {
				// a revoir genereqieu lucie actuelement je met pas la novelle version entiere
				// juste celle pour pouvoir faire beamserach
				User u = (User) p;
				if (u.getSushiMatrix() == null) {
					System.out.println("vide");
				} else {
					Matrix matrix = new Matrix(u.getSushiMatrix());
					matrixList.add(matrix);
				}
			}
		} else {
			System.out.println("error for average matrix");
		}
		Matrix moyenne = Matrix.averageMatrix(matrixList);
		return moyenne;
	}

	/**
	 * Compute score.
	 *
	 * @param g             the g
	 * @param typeOfScoring the type of scoring
	 * @return the double
	 */
	public static Double computeScore(Group g, int typeOfScoring) {
		Double score = 0.0;
		if (typeOfScoring == 1) {
			score = labelwiseMeasures(g);
		} else if (typeOfScoring == 2) {
			score = pairwiseMeasures(g);
		} else if (typeOfScoring == 3) {
			score = rankingWiseMeasures(g);
		} else {
			System.out.print("You need to put 1,2 or 3 as typeOfScoring method");
		}
		return score;
	}

}
