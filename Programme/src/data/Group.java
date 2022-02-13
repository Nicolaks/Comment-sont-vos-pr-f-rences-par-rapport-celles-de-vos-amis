package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * a group, is a list of persons, with descriptors.
 */
public class Group {

	/** The score of the group. */
	Double score;

	/** The isoriginal to check if its a root group or non. */
	boolean isOriginal = false;

	/** The pop. */
	List<Person> pop;

	/** The original. */
	List<Person> original;

	/** The descriptors of group. */
	Map<Integer, Integer> descriptorsOfGroup = new HashMap<Integer, Integer>();

	/**
	 * group, type subgroup.
	 *
	 * @param pop      the pop
	 * @param original the original
	 */
	public Group(List<Person> pop, List<Person> original) {
		this.pop = pop;
		this.original = original;
	}

	/**
	 * group root.
	 *
	 * @param pop        the pop
	 * @param isOriginal the is original
	 */
	public Group(List<Person> pop, boolean isOriginal) {
		this.pop = pop;
		this.original = pop;
		this.isOriginal = isOriginal;
	}

	/**
	 * method to generate a subgroup.
	 *
	 * @param threshold  minimum of persons
	 * @param descriptor the descriptor
	 * @return a group
	 */
	public Group generateSubGroup(Integer threshold, Map<Integer, Integer> descriptor) {
		Group gEnfant = null;
		List<Person> enfant = new ArrayList<Person>();
		for (Person p : this.pop) {
			Map<Integer, Integer> mapPerson = p.getDescriptors();
			boolean check = checkInMap(descriptor, mapPerson);
			if (check) {
				enfant.add(p);
				check = false;
			}
		}
		if (enfant.size() >= threshold) {
			gEnfant = new Group(enfant, this.original);
		}
		return gEnfant;
	}

	/**
	 * method to check if a descriptor is part of the descriptors of a person.
	 *
	 * @param mapSelected the map selected
	 * @param mapPerson   the map person
	 * @return a boolean
	 */
	public boolean checkInMap(Map<Integer, Integer> mapSelected, Map<Integer, Integer> mapPerson) {
		List<Integer> ok = new ArrayList<>();
		HashSet<Integer> selectedKeys = new HashSet<>(mapSelected.keySet());
		for (Integer k : selectedKeys) {
			if (mapSelected.get(k).equals(mapPerson.get(k))) {
				ok.add(k);
			}
		}
		boolean test = false;
		if (selectedKeys.size() == ok.size()) {
			test = true;
		} else {
			test = false;
		}
		return test;
	}

	/**
	 * Gets the descriptors of group.
	 *
	 * @return the descriptorsOfGroup
	 */
	public Map<Integer, Integer> getDescriptorsOfGroup() {
		return descriptorsOfGroup;
	}

	/**
	 * Sets the descriptors of group.
	 *
	 * @param descriptorsOfGroup the descriptorsOfGroup to set
	 */
	public void setDescriptorsOfGroup(Map<Integer, Integer> descriptorsOfGroup) {
		this.descriptorsOfGroup = new HashMap<Integer, Integer>(descriptorsOfGroup);
	}

	/**
	 * Gets the pop.
	 *
	 * @return the score
	 */
	public List<Person> getPop() {
		return this.pop;
	}

	/**
	 * Gets the original.
	 *
	 * @return the score
	 */
	public List<Person> getOriginal() {
		return this.original;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[size:" + this.getPop().size() + " ,descriptors: " + this.getDescriptorsOfGroup() + ", score: "
				+ this.getScore() + "]";
	}

}
