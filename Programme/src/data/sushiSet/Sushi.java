package data.sushiSet;

import data.Item;

/**
 * The Class Sushi.
 */
public class Sushi implements Item {

	/** The name. */
	String name;

	/** The style. */
	int id, style;

	/** The minor group. */
	int majorGroup, minorGroup;

	/** The oiliness. */
	double oiliness;

	/** The sold frequency. */
	double eatenFrequency, soldFrequency;

	/** The normalized price. */
	double normalizedPrice;

	/**
	 * Instantiates a new sushi.
	 *
	 * @param id              the id
	 * @param name            the name
	 * @param style           the style
	 * @param majorGroup      the major group
	 * @param minorGroup      the minor group
	 * @param oiliness        the oiliness
	 * @param eatenFrequency  the eaten frequency
	 * @param normalizedPrice the normalized price
	 * @param soldFrequency   the sold frequency
	 */
	public Sushi(int id, String name, int style, int majorGroup, int minorGroup, double oiliness, double eatenFrequency,
			double normalizedPrice, double soldFrequency) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.majorGroup = majorGroup;
		this.minorGroup = minorGroup;
		this.oiliness = oiliness;
		this.eatenFrequency = eatenFrequency;
		this.normalizedPrice = normalizedPrice;
		this.soldFrequency = soldFrequency;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id 1) id du sushi
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
	 * Gets the name.
	 *
	 * @return the name 2) name of sushi
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
	 * Gets the style.
	 *
	 * @return the style 3)style of sushi
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * Sets the style.
	 *
	 * @param style the style to set
	 */
	public void setStyle(int style) {
		this.style = style;
	}

	/**
	 * Gets the major group.
	 *
	 * @return the majorGroup 4) major Group of sushi
	 */
	public int getMajorGroup() {
		return majorGroup;
	}

	/**
	 * Sets the major group.
	 *
	 * @param majorGroup the majorGroup to set
	 */
	public void setMajorGroup(int majorGroup) {
		this.majorGroup = majorGroup;
	}

	/**
	 * Gets the minor group.
	 *
	 * @return the minorGroup 5) Minor group of sushi
	 */
	public int getMinorGroup() {
		return minorGroup;
	}

	/**
	 * Sets the minor group.
	 *
	 * @param minorGroup the minorGroup to set
	 */
	public void setMinorGroup(int minorGroup) {
		this.minorGroup = minorGroup;
	}

	/**
	 * Gets the oiliness.
	 *
	 * @return the oiliness 6) rating for seasoning/oliness of sushi
	 */
	public double getOiliness() {
		return oiliness;
	}

	/**
	 * Sets the oiliness.
	 *
	 * @param oiliness the oiliness to set
	 */
	public void setOiliness(double oiliness) {
		this.oiliness = oiliness;
	}

	/**
	 * Gets the eaten frequency.
	 *
	 * @return the eatenFrequency 7) eaten frequency of sushi
	 */
	public double getEatenFrequency() {
		return eatenFrequency;
	}

	/**
	 * Sets the eaten frequency.
	 *
	 * @param eatenFrequency the eatenFrequency to set
	 */
	public void setEatenFrequency(double eatenFrequency) {
		this.eatenFrequency = eatenFrequency;
	}

	/**
	 * Gets the sold frequency.
	 *
	 * @return the soldFrequency 9) sold in shop frequency of the sushi
	 */
	public double getSoldFrequency() {
		return soldFrequency;
	}

	/**
	 * Sets the sold frequency.
	 *
	 * @param soldFrequency the soldFrequency to set
	 */
	public void setSoldFrequency(double soldFrequency) {
		this.soldFrequency = soldFrequency;
	}

	/**
	 * Gets the normalized price.
	 *
	 * @return the normalizedPrice 8) normalised price of sushi
	 */
	public double getNormalizedPrice() {
		return normalizedPrice;
	}

	/**
	 * Sets the normalized price.
	 *
	 * @param normalizedPrice the normalizedPrice to set
	 */
	public void setNormalizedPrice(double normalizedPrice) {
		this.normalizedPrice = normalizedPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Sushi name=" + name + ", id=" + id + ", style=" + style + ", majorGroup=" + majorGroup
				+ ", minorGroup=" + minorGroup + ", oiliness=" + oiliness + ", eatenFrequency=" + eatenFrequency
				+ ", soldFrequency=" + soldFrequency + ", normalizedPrice=" + normalizedPrice + "]";
	}

}
