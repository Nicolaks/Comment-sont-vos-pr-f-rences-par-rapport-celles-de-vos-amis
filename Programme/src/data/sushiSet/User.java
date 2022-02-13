package data.sushiSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import data.Person;

/**
 * The Class User.
 */
public class User implements Person {

	/** The line number. */
	int lineNumber;

	/** The last name. */
	String name, lastName;

	/** The age. */
	int id, gender, age;

	/** The timepassed. */
	int timepassed;

	/** The prefecture id now. */
	int prefectureIdYoung, prefectureIdNow;

	/** The region id now. */
	int regionIdYoung, regionIdNow;

	/** The eastwest id now. */
	int eastwestIdYoung, eastwestIdNow;

	/** The still in prefecture. */
	int stillInPrefecture;

	/** The sushi ranking method. */
	List<Integer> sushiRankingMethod;

	/** The sushi matrix. */
	Double[][] sushiMatrix;

	/** The list descriptors. */
	Map<Integer, Integer> listDescriptors = new HashMap<Integer, Integer>();

	/**
	 * Instantiates a new user.
	 *
	 * @param lineNumber        the line number
	 * @param name              the name
	 * @param lastName          the last name
	 * @param id                the id
	 * @param gender            the gender
	 * @param age               the age
	 * @param timepassed        the timepassed
	 * @param prefectureIdYoung the prefecture id young
	 * @param prefectureIdNow   the prefecture id now
	 * @param regionIdYoung     the region id young
	 * @param regionIdNow       the region id now
	 * @param eastwestIdYoung   the eastwest id young
	 * @param eastwestIdNow     the eastwest id now
	 * @param stillInPrefecture the still in prefecture
	 */
	public User(int lineNumber, String name, String lastName, Integer id, int gender, int age, int timepassed,
			int prefectureIdYoung, int prefectureIdNow, int regionIdYoung, int regionIdNow, int eastwestIdYoung,
			int eastwestIdNow, int stillInPrefecture) {
		super();
		this.lineNumber = lineNumber;
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.timepassed = timepassed;
		this.prefectureIdYoung = prefectureIdYoung;
		this.prefectureIdNow = prefectureIdNow;
		this.regionIdYoung = regionIdYoung;
		this.regionIdNow = regionIdNow;
		this.eastwestIdYoung = eastwestIdYoung;
		this.eastwestIdNow = eastwestIdNow;
		this.stillInPrefecture = stillInPrefecture;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Person#getLineNumber()
	 */
	@Override
	public Integer getLineNumber() {
		return lineNumber;
	}

	/**
	 * Sets the line number.
	 *
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the timepassed.
	 *
	 * @return the timepassed
	 */
	public int getTimepassed() {
		return timepassed;
	}

	/**
	 * Sets the timepassed.
	 *
	 * @param timepassed the timepassed to set
	 */
	public void setTimepassed(int timepassed) {
		this.timepassed = timepassed;
	}

	/**
	 * Gets the prefecture id young.
	 *
	 * @return the prefectureIdYoung
	 */
	public int getPrefectureIdYoung() {
		return prefectureIdYoung;
	}

	/**
	 * Sets the prefecture id young.
	 *
	 * @param prefectureIdYoung the prefectureIdYoung to set
	 */
	public void setPrefectureIdYoung(int prefectureIdYoung) {
		this.prefectureIdYoung = prefectureIdYoung;
	}

	/**
	 * Gets the prefecture id now.
	 *
	 * @return the prefectureIdNow
	 */
	public int getPrefectureIdNow() {
		return prefectureIdNow;
	}

	/**
	 * Sets the prefecture id now.
	 *
	 * @param prefectureIdNow the prefectureIdNow to set
	 */
	public void setPrefectureIdNow(int prefectureIdNow) {
		this.prefectureIdNow = prefectureIdNow;
	}

	/**
	 * Gets the region id young.
	 *
	 * @return the regionIdYoung
	 */
	public int getRegionIdYoung() {
		return regionIdYoung;
	}

	/**
	 * Sets the region id young.
	 *
	 * @param regionIdYoung the regionIdYoung to set
	 */
	public void setRegionIdYoung(int regionIdYoung) {
		this.regionIdYoung = regionIdYoung;
	}

	/**
	 * Gets the region id now.
	 *
	 * @return the regionIdNow
	 */
	public int getRegionIdNow() {
		return regionIdNow;
	}

	/**
	 * Sets the region id now.
	 *
	 * @param regionIdNow the regionIdNow to set
	 */
	public void setRegionIdNow(int regionIdNow) {
		this.regionIdNow = regionIdNow;
	}

	/**
	 * Gets the eastwest id young.
	 *
	 * @return the eastwestIdYoung
	 */
	public int getEastwestIdYoung() {
		return eastwestIdYoung;
	}

	/**
	 * Sets the eastwest id young.
	 *
	 * @param eastwestIdYoung the eastwestIdYoung to set
	 */
	public void setEastwestIdYoung(int eastwestIdYoung) {
		this.eastwestIdYoung = eastwestIdYoung;
	}

	/**
	 * Gets the eastwest id now.
	 *
	 * @return the eastwestIdNow
	 */
	public int getEastwestIdNow() {
		return eastwestIdNow;
	}

	/**
	 * Sets the eastwest id now.
	 *
	 * @param eastwestIdNow the eastwestIdNow to set
	 */
	public void setEastwestIdNow(int eastwestIdNow) {
		this.eastwestIdNow = eastwestIdNow;
	}

	/**
	 * Gets the still in prefecture.
	 *
	 * @return the stillInPrefecture
	 */
	public int getStillInPrefecture() {
		return stillInPrefecture;
	}

	/**
	 * Sets the still in prefecture.
	 *
	 * @param stillInPrefecture the stillInPrefecture to set
	 */
	public void setStillInPrefecture(int stillInPrefecture) {
		this.stillInPrefecture = stillInPrefecture;
	}

	/**
	 * Gets the sushi ranking method.
	 *
	 * @return the sushiRankingMethod
	 */
	public List<Integer> getSushiRankingMethod() {
		return sushiRankingMethod;
	}

	/**
	 * Sets the sushi ranking method.
	 *
	 * @param sushiRankingMethod the sushiRankingMethod to set
	 */
	public void setSushiRankingMethod(List<Integer> sushiRankingMethod) {
		this.sushiRankingMethod = sushiRankingMethod;
	}

	/**
	 * Gets the sushi matrix.
	 *
	 * @return the sushiMatrix
	 */
	public Double[][] getSushiMatrix() {
		return sushiMatrix;
	}

	/**
	 * Sets the sushi matrix.
	 *
	 * @param sushiMatrix the sushiMatrix to set
	 */
	public void setSushiMatrix(Double[][] sushiMatrix) {
		this.sushiMatrix = sushiMatrix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[User name=" + name + ", lastName=" + lastName + ", id=" + id + ", gender=" + gender + ", age=" + age
				+ ", timepassed=" + timepassed + ", prefectureIdYoung=" + prefectureIdYoung + ", prefectureIdNow="
				+ prefectureIdNow + ", regionIdYoung=" + regionIdYoung + ", regionIdNow=" + regionIdNow
				+ ", eastwestIdYoung=" + eastwestIdYoung + ", eastwestIdNow=" + eastwestIdNow + ", stillInPrefecture="
				+ stillInPrefecture + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Person#setDescriptors(java.util.Map)
	 */
	@Override
	public void setDescriptors(Map<Integer, Integer> listDescriptors) {
		this.listDescriptors = listDescriptors;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.Person#getDescriptors()
	 */
	@Override
	public Map<Integer, Integer> getDescriptors() {
		return this.listDescriptors;
	}

}
