package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * abstract class Parser, to parse data.
 */
public abstract class Parser {

	/** The file path items set. */
	protected String filePathItemsSet;

	/** The file path items. */
	protected String filePathItems;

	/** The file path persons. */
	protected String filePathPersons;
	/** The list item. */
	protected ArrayList<Item> listItems = new ArrayList<>();
	/** The dictionnary descriptors. */
	protected TreeMap<Integer, Set<Integer>> dictionnaryDescriptors = new TreeMap<Integer, Set<Integer>>();
	/** The list persons. */
	protected ArrayList<Person> listPersons = new ArrayList<>();
	/** The person ranking with itemset. */
	protected Map<Integer, List<Integer>> personRankingItemsSet = new HashMap<Integer, List<Integer>>();

	/** The matrices of persons created itemset order. */
	protected List<Double[][]> matricesOfPersonsCreatedItemsetOrder = new ArrayList<>();

	/** The dictionnary preferences matrix. */
	protected Map<Person, Double[][]> dictionnaryPreferencesMatrix = new HashMap<Person, Double[][]>();

	/**
	 * Generate person list.
	 */
	public abstract void generatePersonList();

	/**
	 * Generate item list.
	 *
	 * @return the array list
	 */
	public abstract ArrayList<Item> generateItemList();

	/**
	 * Make rankings order with person.
	 */
	public abstract void makeRankingsOrderWithPerson();

	/**
	 * Matrixes creation.
	 */
	public abstract void matrixesCreation();

	/**
	 * Launch.
	 */
	public void launch() {
		this.generatePersonList();
		this.generateItemList();
		this.makeRankingsOrderWithPerson();
		this.matrixesCreation();
	}

	/**
	 * Gets the lines.
	 *
	 * @param filePath the file path
	 * @return the lines
	 */
	public ArrayList<String> getLines(String filePath) {
		ArrayList<String> lines = new ArrayList<>();
		try {
			FileInputStream fstream;
			fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			try {
				while ((strLine = br.readLine()) != null) {
					lines.add(strLine);
				}
			} catch (IOException e) {
				System.out.println("error when reading the file");
				e.printStackTrace();
			}
			try {
				fstream.close();
			} catch (IOException e) {
				System.out.println("error when closing the file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			System.out.println("problem of file path");
			e1.printStackTrace();
		}
		return lines;
	}

	/**
	 * Gets the file path items set.
	 *
	 * @return the file path items set
	 */
	public String getFilePathItemsSet() {
		return filePathItemsSet;
	}

	/**
	 * Sets the file path items set.
	 *
	 * @param filePathItemsSet the new file path items set
	 */
	public void setFilePathItemsSet(String filePathItemsSet) {
		this.filePathItemsSet = filePathItemsSet;
	}

	/**
	 * Gets the file path items.
	 *
	 * @return the file path items
	 */
	public String getFilePathItems() {
		return filePathItems;
	}

	/**
	 * Sets the file path items.
	 *
	 * @param filePathItems the new file path items
	 */
	public void setFilePathItems(String filePathItems) {
		this.filePathItems = filePathItems;
	}

	/**
	 * Gets the file path persons.
	 *
	 * @return the file path persons
	 */
	public String getFilePathPersons() {
		return filePathPersons;
	}

	/**
	 * Sets the file path persons.
	 *
	 * @param filePathPersons the new file path persons
	 */
	public void setFilePathPersons(String filePathPersons) {
		this.filePathPersons = filePathPersons;
	}

	/**
	 * Gets the list items.
	 *
	 * @return the list items
	 */
	public ArrayList<Item> getListItems() {
		return listItems;
	}

	/**
	 * Sets the list items.
	 *
	 * @param listItems the new list items
	 */
	public void setListItems(ArrayList<Item> listItems) {
		this.listItems = listItems;
	}

	/**
	 * Gets the dictionnary descriptors.
	 *
	 * @return the dictionnary descriptors
	 */
	public TreeMap<Integer, Set<Integer>> getDictionnaryDescriptors() {
		return dictionnaryDescriptors;
	}

	/**
	 * Sets the dictionnary descriptors.
	 *
	 * @param dictionnaryDescriptors the dictionnary descriptors
	 */
	public void setDictionnaryDescriptors(TreeMap<Integer, Set<Integer>> dictionnaryDescriptors) {
		this.dictionnaryDescriptors = dictionnaryDescriptors;
	}

	/**
	 * Gets the list persons.
	 *
	 * @return the list persons
	 */
	public ArrayList<Person> getListPersons() {
		return listPersons;
	}

	/**
	 * Sets the list persons.
	 *
	 * @param listPersons the new list persons
	 */
	public void setListPersons(ArrayList<Person> listPersons) {
		this.listPersons = listPersons;
	}

	/**
	 * Gets the person ranking items set.
	 *
	 * @return the person ranking items set
	 */
	public Map<Integer, List<Integer>> getPersonRankingItemsSet() {
		return personRankingItemsSet;
	}

	/**
	 * Sets the person ranking items set.
	 *
	 * @param personRankingItemsSet the person ranking items set
	 */
	public void setPersonRankingItemsSet(Map<Integer, List<Integer>> personRankingItemsSet) {
		this.personRankingItemsSet = personRankingItemsSet;
	}

	/**
	 * Gets the matrices of persons created itemset order.
	 *
	 * @return the matrices of persons created itemset order
	 */
	public List<Double[][]> getMatricesOfPersonsCreatedItemsetOrder() {
		return matricesOfPersonsCreatedItemsetOrder;
	}

	/**
	 * Sets the matrices of persons created itemset order.
	 *
	 * @param matricesOfPersonsCreatedItemsetOrder the new matrices of persons
	 *                                             created itemset order
	 */
	public void setMatricesOfPersonsCreatedItemsetOrder(List<Double[][]> matricesOfPersonsCreatedItemsetOrder) {
		this.matricesOfPersonsCreatedItemsetOrder = matricesOfPersonsCreatedItemsetOrder;
	}

	/**
	 * Gets the dictionnary preferences matrix.
	 *
	 * @return the dictionnary preferences matrix
	 */
	public Map<Person, Double[][]> getDictionnaryPreferencesMatrix() {
		return dictionnaryPreferencesMatrix;
	}

	/**
	 * Sets the dictionnary preferences matrix.
	 *
	 * @param dictionnaryPreferencesMatrix the dictionnary preferences matrix
	 */
	public void setDictionnaryPreferencesMatrix(Map<Person, Double[][]> dictionnaryPreferencesMatrix) {
		this.dictionnaryPreferencesMatrix = dictionnaryPreferencesMatrix;
	}

}
