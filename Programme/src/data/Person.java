package data;

import java.util.List;
import java.util.Map;

/**
 * The Interface Person.
 */
public interface Person {

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId();

	/**
	 * Sets the descriptors.
	 *
	 * @param listDescriptors the list descriptors
	 */
	public void setDescriptors(Map<Integer, Integer> listDescriptors);

	/**
	 * Gets the descriptors.
	 *
	 * @return the descriptors
	 */
	public Map<Integer, Integer> getDescriptors();

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id);

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	// anonyme ou non
	public String getName();

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name);

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName();

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName);

	/**
	 * Gets the line number.
	 *
	 * @return the line number
	 */
	public Integer getLineNumber();

	/**
	 * Sets the sushi ranking method.
	 *
	 * @param sushiRankingMethod the new sushi ranking method
	 */
	public void setSushiRankingMethod(List<Integer> sushiRankingMethod);

}
