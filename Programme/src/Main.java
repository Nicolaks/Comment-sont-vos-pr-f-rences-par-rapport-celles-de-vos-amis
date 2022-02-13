
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import calculation.algorithm.BeamSearch;
import data.Group;
import data.Item;
import data.Parser;
import data.Person;
import data.sushiSet.ParserSushiSet;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// file paths
				// code pour navid
				/*
				 * String filePathUsers =
				 * "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3.udata"
				 * ; String filePathSushis =
				 * "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3.idata"
				 * ; String filePathA =
				 * "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3a.5000.10.order"
				 * ; String filePathB =
				 * "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3b.5000.10.order"
				 * ;
				 * 
				 */

				// code pour nicolas
				
				  String filePathUsers = "Programme/ressources/sushi3-2016/sushi3.udata";
				  String filePathSushis = "Programme/ressources/sushi3-2016/sushi3.idata";
				  
				  String filePathA = "Programme/ressources/sushi3-2016/sushi3a.5000.10.order";
				  String filePathB = "Programme/ressources/sushi3-2016/sushi3b.5000.10.order";
				 

				// code pour lucie eclipse
				/*
				String filePathUsers = "ressources/sushi3-2016/sushi3.udata"; // user data
				String filePathSushis = "ressources/sushi3-2016/sushi3.idata"; // sushi data

				String filePathA = "ressources/sushi3-2016/sushi3a.5000.10.order"; // set a ranking
				String filePathB = "ressources/sushi3-2016/sushi3b.5000.10.order"; // set b ranking
				*/

				// init parsing
				// System.out.println("init parsing");
				Parser parser = new ParserSushiSet();
				parser.setFilePathItemsSet(filePathA); // premier item set 10 sur 10 : : comment to analyze with itemsetB
														// instead of itemsetA
				// parser.setFilePathItemsSet(filePathB); // second item set 10 sur 100
				// :decomment to analyze with itemsetB instead of itemsetA
				parser.setFilePathItems(filePathSushis);
				parser.setFilePathPersons(filePathUsers);
				parser.launch();

				// init population list
				List<Person> listPopulation = parser.getListPersons();

				// init sushi list, not used but maybe for another purpose later
				ArrayList<Item> listSushi = parser.generateItemList();

				// init all possible descriptors from the dataset, 10 for sushi dataset
				TreeMap<Integer, Set<Integer>> dicDescriptors = parser.getDictionnaryDescriptors();

				// System.out.println("initialisation: beam search heuristics");

				int minFrequency = 10; // threshold minimum persons
				int beamWidth = 4;
				int beamDepth = 4;

				//int typeOfScoring = 1; // labelwiseMeasures
				// int typeOfScoring = 2; //pairwiseMeasures
				 int typeOfScoring = 3; //rankingWiseMeasures

				BeamSearch b = new BeamSearch(minFrequency, listPopulation, dicDescriptors, typeOfScoring);
				List<Integer> kBestDescriptors = b.getKBestDescriptors(beamWidth);
				List<Integer> kFirstDescriptors = b.getKFirstDescriptors(beamWidth);
				List<Integer> kRandomDescriptors = b.getKRandomDescriptors(beamWidth);
				Set<Integer> allDescriptors = b.getAllDescriptorsPossible().keySet();
				System.out.println("all descriptors source from the dataset"+allDescriptors);
				System.out.println("Parameters used for beam searches:");
				System.out.println("Minimum Frequency: " + minFrequency);
				if (typeOfScoring == 1) {
					System.out.println("Type of scoring:labelwiseMeasures");
				} else if (typeOfScoring == 2) {
					System.out.println("Type of scoring:pairwiseMeasures");
				} else if (typeOfScoring == 3) {
					System.out.println("Type of scoring: rankingWiseMeasures");
				} else {
					System.out.print("Type of scoring: You need to put 1,2 or 3 as typeOfScoring method");
				}

				System.out.println("Parameters used for beam searches except for timer:");
				System.out.println("BeamWidth: " + beamWidth);
				System.out.println("BeamDepth: " + beamDepth);

				System.out.println("-------------Beam search with " + beamWidth + " firsts-------------------");
				// search with k first descriptors
				System.out.println("List of k first descriptors generated: " + kFirstDescriptors);
				List<Group> listFirst = b.searchK(beamWidth, beamDepth, kFirstDescriptors);
				getGroupsAverageScore(listFirst);

				System.out.println("-------------Beam search with " + beamWidth + " randoms-------------------");
				// search k random
				System.out.println("List of k random descriptors generated: " + kRandomDescriptors);
				List<Group> listRandom = b.searchK(beamWidth, beamDepth, kRandomDescriptors);
				getGroupsAverageScore(listRandom);

				System.out.println("-------------Beam search with " + beamWidth + " bests -------------------");
				// search k best descriptors
				System.out.println("List of k best descriptors generated: " + kBestDescriptors);
				List<Group> listBest = b.searchK(beamWidth, beamDepth, kBestDescriptors);
				getGroupsAverageScore(listBest);

				//used for timing beam search
				/*System.out.println("....................................................................................");
				System.out.println("....................................................................................");
				System.out.println("............................Timing..................................................");
				System.out.println("List of all descriptors used for the beam with timer : " + allDescriptors);
				
				
				int timeWanted = 1;
				
				System.out.println("List of all descriptors used for the beam with timer : " + allDescriptors);
				int beamWidthTimer = Integer.MAX_VALUE;
				int beamDepthTimer = Integer.MAX_VALUE;
				long time = timeWanted * 60 * 1000;
				List<Group> listTimer = b.searchPTimer(beamWidthTimer, beamDepthTimer, time);
				getGroupsAverageScore(listTimer);
				
				System.out.println("....................................................................................");
				System.out.println("....................................................................................");
				System.out.println("....................................................................................");*/
	}

	/**
	 * Gets the groups average score.
	 *
	 * @param list the list
	 * @return the groups average score
	 */
	public static void getGroupsAverageScore(List<Group> list) {
		System.out.println("*********************************");
		int numberOfGroups = 10; // take max 10 groups
		if (list.size() < numberOfGroups) {
			numberOfGroups = list.size();
		}
		List<Group> groupsTaken = new ArrayList<>();
		if (list.size() != 0) {
			Double sommeScore = 0.0;
			for (int x = 0; x < numberOfGroups; x++) {
				groupsTaken.add(list.get(x));
				sommeScore += list.get(x).getScore();
			}
			Double meanScore = sommeScore / numberOfGroups;
			System.out.println("Groups found:");
			System.out.println(groupsTaken);
			System.out.println("Mean score of the resulted list: " + meanScore);
		} else {
			System.out.println("No group found that heuristic.");
		}
		System.out.println("*********************************");
	}
	
	
	
	

}
