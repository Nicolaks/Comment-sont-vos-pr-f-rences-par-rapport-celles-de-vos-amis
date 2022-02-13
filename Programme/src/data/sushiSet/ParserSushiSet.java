package data.sushiSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import data.Item;
import data.Parser;
import data.Person;

/**
 * The Class ParserSushiSet. Parser specific for sushi dataset
 */
public class ParserSushiSet extends Parser {

	/** The itemset sushi. */
	Integer itemsetSushi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Parser#generatePersonList()
	 */
	@Override
	public void generatePersonList() {
		ArrayList<String> linesRead = this.getLines(filePathPersons);

		Set<Integer> genderDesc = new HashSet<>();
		Set<Integer> ageDesc = new HashSet<>();
		Set<Integer> timepassedDesc = new HashSet<>();
		Set<Integer> idPrefectureYoungDesc = new HashSet<>();
		Set<Integer> idRegionYoungDesc = new HashSet<>();
		Set<Integer> idEastWestYoungDesc = new HashSet<>();
		Set<Integer> idPrefectureNowDesc = new HashSet<>();
		Set<Integer> idRegionNowDesc = new HashSet<>();
		Set<Integer> idEastWestNowDesc = new HashSet<>();
		Set<Integer> stillInPrefectureDesc = new HashSet<>();

		int lineCount = 0;
		for (String line : linesRead) {
			lineCount += 1;
			String[] tab = line.split("\t", -1);
			Integer idUser = Integer.parseInt(tab[0]);
			Integer gender = Integer.parseInt(tab[1]);
			Integer age = Integer.parseInt(tab[2]);
			Integer timepassed = Integer.parseInt(tab[3]);
			Integer idPrefectureYoung = Integer.parseInt(tab[4]);
			Integer idRegionYoung = Integer.parseInt(tab[5]);
			Integer idEastWestYoung = Integer.parseInt(tab[6]);
			Integer idPrefectureNow = Integer.parseInt(tab[7]);
			Integer idRegionNow = Integer.parseInt(tab[8]);
			Integer idEastWestNow = Integer.parseInt(tab[9]);
			Integer stillInPrefecture = Integer.parseInt(tab[10]);
			String name = "NoName";
			String lastName = "NoLastName";
			User respondent = new User(lineCount, name, lastName, idUser, gender, age, timepassed, idPrefectureYoung,
					idRegionYoung, idEastWestYoung, idPrefectureNow, idRegionNow, idEastWestNow, stillInPrefecture);

			HashMap<Integer, Integer> listeDescriptorsUser = new HashMap<Integer, Integer>();
			listeDescriptorsUser.put(0, gender);
			listeDescriptorsUser.put(1, age);
			listeDescriptorsUser.put(2, timepassed);
			listeDescriptorsUser.put(3, idPrefectureYoung);
			listeDescriptorsUser.put(4, idRegionYoung);
			listeDescriptorsUser.put(5, idEastWestYoung);
			listeDescriptorsUser.put(6, idPrefectureNow);
			listeDescriptorsUser.put(7, idRegionNow);
			listeDescriptorsUser.put(8, idEastWestNow);
			listeDescriptorsUser.put(9, stillInPrefecture);

			respondent.setDescriptors(listeDescriptorsUser);

			this.listPersons.add(respondent);

			genderDesc.add(gender);
			ageDesc.add(age);
			timepassedDesc.add(timepassed);
			idPrefectureYoungDesc.add(idPrefectureYoung);
			idRegionYoungDesc.add(idRegionYoung);
			idEastWestYoungDesc.add(idEastWestYoung);
			idPrefectureNowDesc.add(idPrefectureNow);
			idRegionNowDesc.add(idRegionNow);
			idEastWestNowDesc.add(idEastWestNow);
			stillInPrefectureDesc.add(stillInPrefecture);

		}
		this.dictionnaryDescriptors.put(0, genderDesc);
		this.dictionnaryDescriptors.put(1, ageDesc);
		this.dictionnaryDescriptors.put(2, timepassedDesc);
		this.dictionnaryDescriptors.put(3, idPrefectureYoungDesc);
		this.dictionnaryDescriptors.put(4, idRegionYoungDesc);
		this.dictionnaryDescriptors.put(5, idEastWestYoungDesc);
		this.dictionnaryDescriptors.put(6, idPrefectureNowDesc);
		this.dictionnaryDescriptors.put(7, idRegionNowDesc);
		this.dictionnaryDescriptors.put(8, idEastWestNowDesc);
		this.dictionnaryDescriptors.put(9, stillInPrefectureDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Parser#generateItemList()
	 */
	@Override
	public ArrayList<Item> generateItemList() {
		ArrayList<String> linesRead = this.getLines(this.filePathItems);
		// id, name, style,
		// major group, minor group,
		// oiliness rating,
		// frequency eat, normalized price, sold frequency
		for (String line : linesRead) {
			String[] tab = line.split("\t", -1);
			Integer idSushi = Integer.parseInt(tab[0]);
			String name = tab[1];
			Integer style = Integer.parseInt(tab[2]);
			Integer majorGroup = Integer.parseInt(tab[3]);
			Integer minorGroup = Integer.parseInt(tab[4]);
			Double oiliness = Double.parseDouble(tab[5]);
			Double frequencyEaten = Double.parseDouble(tab[6]);
			Double normalizedPrice = Double.parseDouble(tab[7]);
			Double frequencySold = Double.parseDouble(tab[8]);
			Sushi sushi = new Sushi(idSushi, name, style, majorGroup, minorGroup, oiliness, frequencyEaten,
					normalizedPrice, frequencySold);
			this.listItems.add(sushi);
		}
		return this.listItems;
	}

	/**
	 * Generate ranking method.
	 *
	 * @param filePath    the file path
	 * @param userRanking the user ranking
	 * @return the integer
	 */
	public Integer generateRankingMethod(String filePath, Map<Integer, List<Integer>> userRanking) {
		ArrayList<String> linesRead = this.getLines(filePath);
		// infos premiere ligne:
		// nombre de sushi differents notés - - 1
		// corps: 0 - - longueur de l'ordre - - Liste de l'ordre (idItem-Iditem..)
		// item en top = le plus préféré
		// ligne = ordre repondu par le repondant du fichier sushi3.udata

		// obtenir le nombre de sushis à noter:
		String firstLine = linesRead.get(0);
		String[] tab = firstLine.split(" ", -1);
		Integer numberOfSushi = Integer.parseInt(tab[0]); // 10 ou 100 pour nous
		int lineCount = 0;

		for (int i = 1; i < linesRead.size(); i++) {
			lineCount += 1;
			// liste de ranking de sushis
			List<Integer> sushiRankingMethod = new ArrayList<>();
			String line = linesRead.get(i);
			String[] tab2 = line.split(" ", -1);
			// premier et deuxieme ne pas prendre, reste prend la liste des id sushi rankés
			for (int j = 2; j < tab2.length; j++) {
				int sushiId = Integer.parseInt(tab2[j]);
				sushiRankingMethod.add(sushiId);
			}
			userRanking.put(lineCount, sushiRankingMethod);
		}
		return numberOfSushi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Parser#makeRankingsOrderWithUsers()
	 */
	@Override
	public void makeRankingsOrderWithPerson() {
		this.setItemsetSushi(this.generateRankingMethod(filePathItemsSet, personRankingItemsSet));
		for (Map.Entry<Integer, List<Integer>> entry : personRankingItemsSet.entrySet()) {
			User user = (User) this.listPersons.get(entry.getKey() - 1);
			user.setSushiRankingMethod(entry.getValue());
		}
	}

	/**
	 * Gets the matrices of users created itemset order.
	 *
	 * @return the matricesOfPersonsCreatedItemsetOrder
	 */
	public List<Double[][]> getMatricesOfPersonsCreatedItemsetOrder() {
		return matricesOfPersonsCreatedItemsetOrder;
	}

	/**
	 * Sets the matrices of users created itemset order.
	 *
	 * @param matricesOfPersonsCreatedItemsetOrder the
	 *                                             matricesOfPersonsCreatedItemsetOrder
	 *                                             to set
	 */
	public void setMatricesOfPersonsCreatedItemsetOrder(List<Double[][]> matricesOfPersonsCreatedItemsetOrder) {
		this.matricesOfPersonsCreatedItemsetOrder = matricesOfPersonsCreatedItemsetOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Parser#matrixesCreation()
	 */
	@Override
	public void matrixesCreation() {
		for (Person p : this.listPersons) {
			Double[][] matriceUser = new Double[this.getItemsetSushi()][this.getItemsetSushi()];
			for (int x = 0; x < matriceUser.length; x++) {
				for (int y = 0; y < matriceUser.length; y++) {
					matriceUser[x][y] = (double) 0;
				}
			}
			User u = (User) (p);
			// liste des sushi rankés
			List<Integer> orderList = u.getSushiRankingMethod();

			for (int a = 0; a < orderList.size() - 1; a++) {
				for (int b = a + 1; b < orderList.size(); b++) {
					if (orderList.indexOf(a) < orderList.indexOf(b)) {
						matriceUser[orderList.get(a)][orderList.get(b)] = (double) 1;
						matriceUser[orderList.get(b)][orderList.get(a)] = (double) -1;
					} else if ((orderList.indexOf(a) > orderList.indexOf(b))) {
						matriceUser[orderList.get(a)][orderList.get(b)] = (double) -1;
						matriceUser[orderList.get(b)][orderList.get(a)] = (double) 1;
					}
				}
			}
			// matrice pour l'user
			// souci ? revoir

			u.setSushiMatrix(matriceUser);
			this.matricesOfPersonsCreatedItemsetOrder.add(matriceUser);
			// v2 avec dictionnaire
			this.dictionnaryPreferencesMatrix.put(u, matriceUser);
		}
	}

	/**
	 * get number of sushi total.
	 *
	 * @return the itemsetSushi
	 */
	public Integer getItemsetSushi() {
		return itemsetSushi;
	}

	/**
	 * Sets the itemset sushi.
	 *
	 * @param itemsetASushi the itemsetASushi to set
	 */
	public void setItemsetSushi(Integer itemsetASushi) {
		this.itemsetSushi = itemsetASushi;
	}

}
