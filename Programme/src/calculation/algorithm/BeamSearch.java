package calculation.algorithm;

import data.Group;
import data.Person;

import java.util.*;

import calculation.Deviation;

/**
 * Beamsearch heuristics algorithm.
 */
public class BeamSearch {

	int typeOfScoring;

	/** The min frequency. */
	int minFrequency;

	/** The population. */
	List<Person> population;

	/** all the descriptors possible. */
	TreeMap<Integer, Set<Integer>> allDescriptorsPossible;

	/**
	 * Instantiates a new beam search.
	 *
	 * @param minFrequency           the min frequency
	 * @param population             the population
	 * @param allDescriptorsPossible the all descriptors possible
	 */
	public BeamSearch(int minFrequency, List<Person> population, TreeMap<Integer, Set<Integer>> allDescriptorsPossible,
			int typeOfScoring) {
		this.minFrequency = minFrequency;
		this.population = population;
		this.allDescriptorsPossible = allDescriptorsPossible;
		this.typeOfScoring = typeOfScoring;
	}

	/**
	 * Search K.
	 *
	 * @param beamWidth  the beam width
	 * @param beamDepth  the beam depth
	 * @param keysSearch the keys search
	 * @return the list
	 */
	public List<Group> searchK(int beamWidth, int beamDepth, List<Integer> keysSearch) {
		Comparator<Group> nameSorter = Comparator.comparing(Group::getScore);
		PriorityQueue<Group> candidateQueue = new PriorityQueue<Group>(nameSorter.reversed()); // S

		int currentDepth = 0;

		Group original = new Group(this.population, true);
		original.setScore(0.0);
		original.setDescriptorsOfGroup(new HashMap<Integer, Integer>());
		candidateQueue.add(original);

		List<Integer> keysToSearch = new ArrayList<Integer>();
		if (beamDepth > keysSearch.size()) {
			beamDepth = keysSearch.size();
		}
		for (int i = 0; i < beamDepth; i++) {
			keysToSearch.add((Integer) keysSearch.get(i));
		}

		while (currentDepth < beamDepth) {
			Integer key = keysToSearch.get(currentDepth);
			PriorityQueue<Group> candidateQueueTmp = new PriorityQueue<Group>(nameSorter.reversed()); // S
			for (Integer descVal : this.allDescriptorsPossible.get(key)) {
				PriorityQueue<Group> candidateQueueCP = new PriorityQueue<Group>(nameSorter.reversed()); // S
				candidateQueueCP.addAll(candidateQueue);
				Map<Integer, Integer> selection = new HashMap<Integer, Integer>();
				selection.put(key, descVal);

				while (!candidateQueueCP.isEmpty()) {
					Group select = candidateQueueCP.poll();

					Map<Integer, Integer> desc = new HashMap<Integer, Integer>(select.getDescriptorsOfGroup());
					desc.put(key, descVal);

					Group sousgroupe = select.generateSubGroup(this.minFrequency, selection);

					if (sousgroupe != null) {
						sousgroupe.setDescriptorsOfGroup(desc);

						Double scoreX = Deviation.computeScore(sousgroupe, this.typeOfScoring);
						// Double scoreX = Deviation.rankingWiseMeasures(sousgroupe);
						sousgroupe.setScore(scoreX);
						candidateQueueTmp.add(sousgroupe);
					}
				}
			}
			PriorityQueue<Group> candidateQueue2Step = new PriorityQueue<Group>(nameSorter.reversed());
			// add candidates from past step
			candidateQueue2Step.addAll(candidateQueue);
			// add candidates from current step
			if (candidateQueueTmp.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue2Step.add(candidateQueueTmp.poll());
				}
			} else {
				candidateQueue2Step.addAll(candidateQueueTmp);
			}
			// add best candidates within past and current steps
			candidateQueue = new PriorityQueue<Group>(nameSorter.reversed());
			if (candidateQueue2Step.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			} else {
				int taille = candidateQueue2Step.size();
				for (int i = 0; i < taille; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			}
			currentDepth += 1;
		}
		List<Group> WidthResult = new ArrayList<Group>();
		int nbCandidates = candidateQueue.size();
		for (int i = 0; i < nbCandidates; i++) {
			WidthResult.add(candidateQueue.poll());
		}
		return WidthResult;
	}

	/**
	 * method generate every possible group, sorted by score, stop until x time.
	 *
	 * @param beamWidth the beam width
	 * @param beamDepth the beam depth
	 * @param temps     the temps
	 * @return a list of x best groups at current stop time
	 */
	public List<Group> searchPTimer(int beamWidth, int beamDepth, long time) {
		Comparator<Group> nameSorter = Comparator.comparing(Group::getScore);
		PriorityQueue<Group> candidateQueue = new PriorityQueue<Group>(nameSorter.reversed()); // S

		int currentDepth = 0;

		Group original = new Group(this.population, true);
		original.setScore(0.0);
		original.setDescriptorsOfGroup(new HashMap<Integer, Integer>());
		candidateQueue.add(original);

		List<Integer> keysToSearch = new ArrayList<Integer>();
		if (beamDepth > this.allDescriptorsPossible.size()) {
			beamDepth = this.allDescriptorsPossible.size();
		}
		for (int i = 0; i < beamDepth; i++) {
			keysToSearch.add((Integer) this.allDescriptorsPossible.keySet().toArray()[i]);
		}
		long debutTimer = System.currentTimeMillis();
		long fin = debutTimer + time;

		while (currentDepth < beamDepth) {

			Integer key = keysToSearch.get(currentDepth);
			PriorityQueue<Group> candidateQueueTmp = new PriorityQueue<Group>(nameSorter.reversed()); // S
			for (Integer descVal : this.allDescriptorsPossible.get(key)) {
				PriorityQueue<Group> candidateQueueCP = new PriorityQueue<Group>(nameSorter.reversed()); // S
				candidateQueueCP.addAll(candidateQueue);
				// descriptor + value
				Map<Integer, Integer> selection = new HashMap<Integer, Integer>();
				selection.put(key, descVal);

				while (!candidateQueueCP.isEmpty()) {
					Group select = candidateQueueCP.poll();

					Map<Integer, Integer> desc = new HashMap<Integer, Integer>(select.getDescriptorsOfGroup());
					desc.put(key, descVal);

					Group sousgroupe = select.generateSubGroup(this.minFrequency, selection);

					if (sousgroupe != null) {
						sousgroupe.setDescriptorsOfGroup(desc);
						Double scoreX = Deviation.computeScore(sousgroupe, this.typeOfScoring);
						sousgroupe.setScore(scoreX);
						candidateQueueTmp.add(sousgroupe);
					}
					if (System.currentTimeMillis() > fin) {
						break;
					}
				}
			}
			PriorityQueue<Group> candidateQueue2Step = new PriorityQueue<Group>(nameSorter.reversed());
			// add candidates from previous step
			candidateQueue2Step.addAll(candidateQueue);
			// add candidates from current step
			if (candidateQueueTmp.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue2Step.add(candidateQueueTmp.poll());
				}
			} else {
				candidateQueue2Step.addAll(candidateQueueTmp);
			}
			// add best candidates within current and previous steps.
			candidateQueue = new PriorityQueue<Group>(nameSorter.reversed());
			if (candidateQueue2Step.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			} else {
				int taille = candidateQueue2Step.size();
				for (int i = 0; i < taille; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			}
			currentDepth += 1;
			if (System.currentTimeMillis() > fin) {
				break;
			}
		}
		List<Group> WidthResult = new ArrayList<Group>();
		int nbCandidates = candidateQueue.size();
		for (int i = 0; i < nbCandidates; i++) {
			WidthResult.add(candidateQueue.poll());
		}
		return WidthResult;
	}

	/**
	 * method that get best group per subbranch.
	 *
	 * @param beamWidth the beam width
	 * @param key       the key
	 * @return the list
	 */
	public List<Group> searchPBest(int beamWidth, Integer key) {
		int beamDepth = 1;
		Comparator<Group> nameSorter = Comparator.comparing(Group::getScore);
		PriorityQueue<Group> candidateQueue = new PriorityQueue<Group>(nameSorter.reversed()); // S

		int currentDepth = 0;
		Group original = new Group(this.population, true);
		original.setScore(0.0);
		original.setDescriptorsOfGroup(new HashMap<Integer, Integer>());
		candidateQueue.add(original);
		while (currentDepth < beamDepth) {
			PriorityQueue<Group> candidateQueueTmp = new PriorityQueue<Group>(nameSorter.reversed()); // S
			for (Integer descVal : this.allDescriptorsPossible.get(key)) {
				PriorityQueue<Group> candidateQueueCP = new PriorityQueue<Group>(nameSorter.reversed()); // S
				candidateQueueCP.addAll(candidateQueue);
				// descriptor + value
				Map<Integer, Integer> selection = new HashMap<Integer, Integer>();
				selection.put(key, descVal);

				while (!candidateQueueCP.isEmpty()) {
					Group select = candidateQueueCP.poll();

					Map<Integer, Integer> desc = new HashMap<Integer, Integer>(select.getDescriptorsOfGroup());
					desc.put(key, descVal);

					Group sousgroupe = select.generateSubGroup(this.minFrequency, selection);

					if (sousgroupe != null) {
						sousgroupe.setDescriptorsOfGroup(desc);
						Double scoreX = Deviation.computeScore(sousgroupe, this.typeOfScoring);
						sousgroupe.setScore(scoreX);
						candidateQueueTmp.add(sousgroupe);
					}
				}
			}
			PriorityQueue<Group> candidateQueue2Step = new PriorityQueue<Group>(nameSorter.reversed());
			// add candidates from previous step
			candidateQueue2Step.addAll(candidateQueue);
			// add candidates from current step
			if (candidateQueueTmp.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue2Step.add(candidateQueueTmp.poll());
				}
			} else {
				candidateQueue2Step.addAll(candidateQueueTmp);
			}
			// add best candidates within previous and current step
			candidateQueue = new PriorityQueue<Group>(nameSorter.reversed());
			if (candidateQueue2Step.size() > beamWidth) {
				for (int i = 0; i < beamWidth; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			} else {
				int taille = candidateQueue2Step.size();
				for (int i = 0; i < taille; i++) {
					candidateQueue.add(candidateQueue2Step.poll());
				}
			}
			currentDepth += 1;
		}
		List<Group> WidthResult = new ArrayList<Group>();
		int nbCandidates = candidateQueue.size();
		for (int i = 0; i < nbCandidates; i++) {
			WidthResult.add(candidateQueue.poll());
		}
		return WidthResult;
	}

	/**
	 * Gets the k random descriptors but only from the first level
	 *
	 * @param numberToTake the number to take
	 * @return the k random descriptors
	 */
	public List<Integer> getKRandomDescriptors(int numberToTake) {
		List<Integer> keysToSearch = new ArrayList<Integer>();
		List<Integer> copie = new ArrayList<>(this.allDescriptorsPossible.keySet());
		Collections.shuffle(copie);
		if (numberToTake > this.allDescriptorsPossible.size()) {
			numberToTake = this.allDescriptorsPossible.size();
		}
		for (int i = 0; i < numberToTake; i++) {
			keysToSearch.add(copie.get(i));
		}
		return keysToSearch;
	}

	/**
	 * Gets the k best descriptors.
	 *
	 * @param numberToTake the number to take
	 * @return the k best descriptors
	 */
	public List<Integer> getKBestDescriptors(int numberToTake) {
		Map<Integer, Double> mapDescGroup = new HashMap<>();
		List<Integer> listKBest = new ArrayList<Integer>();

		// take all descriptors
		List<Integer> listeDescriptors = new ArrayList<Integer>(this.allDescriptorsPossible.keySet());

		// take best group for all descriptors
		for (int i = 0; i < listeDescriptors.size(); i++) {
			List<Group> ls = searchPBest(1, listeDescriptors.get(i));
			mapDescGroup.put(i, ls.get(0).getScore());
		}

		// sort by score
		LinkedHashMap<Integer, Double> scoresTri = new LinkedHashMap<>();
		mapDescGroup.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(nb -> scoresTri.put(nb.getKey(), nb.getValue()));
		List<Integer> descriptorOrder = new ArrayList<Integer>(scoresTri.keySet());

		// return k best descriptor
		for (int i = 0; i < numberToTake; i++) {
			if (i < descriptorOrder.size()) {
				listKBest.add(listeDescriptors.get(descriptorOrder.get(i)));
			}
		}
		return listKBest;
	}

	/**
	 * Gets the k first descriptors.
	 *
	 * @param beamDepth the beam depth
	 * @return the k first descriptors
	 */
	public List<Integer> getKFirstDescriptors(int beamDepth) {
		List<Integer> listeDescriptors = new ArrayList<>();
		for (int i = 0; i < beamDepth; i++) {
			listeDescriptors.add((Integer) this.allDescriptorsPossible.keySet().toArray()[i]);
		}
		return listeDescriptors;
	}

	/**
	 * Gets the min frequency.
	 *
	 * @return the minFrequency
	 */
	public int getMinFrequency() {
		return minFrequency;
	}

	/**
	 * Sets the min frequency.
	 *
	 * @param minFrequency the minFrequency to set
	 */
	public void setMinFrequency(int minFrequency) {
		this.minFrequency = minFrequency;
	}

	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public List<Person> getPopulation() {
		return population;
	}

	/**
	 * Sets the population.
	 *
	 * @param population the population to set
	 */
	public void setPopulation(List<Person> population) {
		this.population = population;
	}

	/**
	 * Gets the all descriptors possible.
	 *
	 * @return the allDescriptorsPossible
	 */
	public TreeMap<Integer, Set<Integer>> getAllDescriptorsPossible() {
		return allDescriptorsPossible;
	}

	/**
	 * Sets the all descriptors possible.
	 *
	 * @param allDescriptorsPossible the allDescriptorsPossible to set
	 */
	public void setAllDescriptorsPossible(TreeMap<Integer, Set<Integer>> allDescriptorsPossible) {
		this.allDescriptorsPossible = allDescriptorsPossible;
	}

}