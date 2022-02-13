
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import calculation.algorithm.BeamSearch;
import data.*;
import data.sushiSet.ParserSushiSet;

/**
 * The Class ExperimentationsMain.
 */
public class ExperimentationsMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		StringBuilder dataForCsv = CsvWriter.newSb();

		System.out.println("####################### EXECUTE M1 #########################");
		System.out.println("LabelWise method");
		launch(1,1,1, dataForCsv);
		launch(1,1,2, dataForCsv);
		launch(1,1,3, dataForCsv);
		launch(1,1,4, dataForCsv);
		launch(1,1,5, dataForCsv);
		
		launch(1,2,1, dataForCsv);
		launch(1,2,2, dataForCsv);
		launch(1,2,3, dataForCsv);
		launch(1,2,4, dataForCsv);
		launch(1,2,5, dataForCsv);

		launch(1,3,1, dataForCsv);
		launch(1,3,2, dataForCsv);
		launch(1,3,3, dataForCsv);
		launch(1,3,4, dataForCsv);
		launch(1,3,5, dataForCsv);
		
		launch(1,4,1, dataForCsv);
		launch(1,4,2, dataForCsv);
		launch(1,4,3, dataForCsv);
		launch(1,4,4, dataForCsv);
		launch(1,4,5, dataForCsv);
		
		launch(1,5,1, dataForCsv);
		launch(1,5,2, dataForCsv);
		launch(1,5,3, dataForCsv);
		launch(1,5,4, dataForCsv);
		launch(1,5,5, dataForCsv);
		System.out.println("####################### EXECUTE M2 #########################");
		System.out.println("Pairwise method");
		launch(2,1,1, dataForCsv);
		launch(2,1,2, dataForCsv);
		launch(2,1,3, dataForCsv);
		launch(2,1,4, dataForCsv);
		launch(2,1,5, dataForCsv);
		
		launch(2,2,1, dataForCsv);
		launch(2,2,2, dataForCsv);
		launch(2,2,3, dataForCsv);
		launch(2,2,4, dataForCsv);
		launch(2,2,5, dataForCsv);
		
		launch(2,3,1, dataForCsv);
		launch(2,3,2, dataForCsv);
		launch(2,3,3, dataForCsv);
		launch(2,3,4, dataForCsv);
		launch(2,3,5, dataForCsv);
		
		launch(2,4,1, dataForCsv);
		launch(2,4,2, dataForCsv);
		launch(2,4,3, dataForCsv);
		launch(2,4,4, dataForCsv);
		launch(2,4,5, dataForCsv);
		
		launch(2,5,1, dataForCsv);
		launch(2,5,2, dataForCsv);
		launch(2,5,3, dataForCsv);
		launch(2,5,4, dataForCsv);
		launch(2,5,5, dataForCsv);
		System.out.println("####################### EXECUTE M3 #########################");
		System.out.println("RankingWise method");
		launch(3,1,1, dataForCsv);
		launch(3,1,2, dataForCsv);
		launch(3,1,3, dataForCsv);
		launch(3,1,4, dataForCsv);
		launch(3,1,5, dataForCsv);
		
		launch(3,2,1, dataForCsv);
		launch(3,2,2, dataForCsv);
		launch(3,2,3, dataForCsv);
		launch(3,2,4, dataForCsv);
		launch(3,2,5, dataForCsv);
		
		launch(3,3,1, dataForCsv);
		launch(3,3,2, dataForCsv);
		launch(3,3,3, dataForCsv);
		launch(3,3,4, dataForCsv);
		launch(3,3,5, dataForCsv);
		
		launch(3,4,1, dataForCsv);
		launch(3,4,2, dataForCsv);
		launch(3,4,3, dataForCsv);
		launch(3,4,4, dataForCsv);
		launch(3,4,5, dataForCsv);
		
		launch(3,5,1, dataForCsv);
		launch(3,5,2, dataForCsv);
		launch(3,5,3, dataForCsv);
		launch(3,5,4, dataForCsv);
		launch(3,5,5, dataForCsv);

		CsvWriter.WriteCsv(dataForCsv.toString());
		System.out.println("####################### END #########################");
		
		System.out.println("####################### avec timer qui stop le beam: #########################");
		
		
		
	}

	public static void getGroupsAverageScore(List<Group> list, StringBuilder dataForCsv) {
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
			Group g = groupsTaken.get(0);

			dataForCsv.append(g.getPop().size());
			dataForCsv.append(";");
			dataForCsv.append(g.getDescriptorsOfGroup().toString());
			dataForCsv.append(";");
			dataForCsv.append(g.getScore());
			dataForCsv.append(";");
			dataForCsv.append(meanScore);
			dataForCsv.append(";");
		} else {
			System.out.println("No group found that heuristic.");
		}
		System.out.println("*********************************");
	}
	
	public static void generateTimerHeuristicSecondes(BeamSearch b, int secondes) {
		System.out.println("-------------**Beam search with timer** " + secondes + " secondes-------------------"); // search
																													// timer
		
		int beamWidthTimer = Integer.MAX_VALUE;
		int beamDepthTimer = Integer.MAX_VALUE;
		long time = 1 * secondes * 1000; // 1 minute, used for beamSearchTimer
		List<Group> listTimer = b.searchPTimer(beamWidthTimer, beamDepthTimer, time);
		//getGroupsAverageScore(listTimer);
	}
	
	public static void generateTimerHeuristicMinutes(BeamSearch b, int minutes) {
		System.out.println("-------------**Beam search with timer** " + minutes + " minutes-------------------"); // search
																													// timer
		
		int beamWidthTimer = Integer.MAX_VALUE;
		int beamDepthTimer = Integer.MAX_VALUE;
		long time = minutes * 60 * 1000; // 1 minute, used for beamSearchTimer
		List<Group> listTimer = b.searchPTimer(beamWidthTimer, beamDepthTimer, time);
		//getGroupsAverageScore(listTimer);
	}
	
	public static void launch(int typeOfScoring, int beamWidth, int beamDepth, StringBuilder dataForCsv) {
		System.out.println("....................................................................................");

		// file paths
				// code pour navid

				  String filePathUsers = "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3.udata";
				  String filePathSushis = "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3.idata";
				  String filePathA = "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3a.5000.10.order";
				  String filePathB = "C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/Programme/ressources/sushi3-2016/sushi3b.5000.10.order";



				// code pour nicolas
				/*
				 * String filePathUsers = "Programme/ressources/sushi3-2016/sushi3.udata";
				 * String filePathSushis = "Programme/ressources/sushi3-2016/sushi3.idata";
				 * 
				 * String filePathA = "Programme/ressources/sushi3-2016/sushi3a.5000.10.order";
				 * String filePathB = "Programme/ressources/sushi3-2016/sushi3b.5000.10.order";
				 */

				// code pour lucie eclipse
				/*String filePathUsers = "ressources/sushi3-2016/sushi3.udata"; // user data
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
				//int beamWidth = 4;
				//int beamDepth = 4;

				//int typeOfScoring = 1; // labelwiseMeasures
				// int typeOfScoring = 2; //pairwiseMeasures
				// int typeOfScoring = 3; //rankingWiseMeasures

				BeamSearch b = new BeamSearch(minFrequency, listPopulation, dicDescriptors, typeOfScoring);
				List<Integer> kBestDescriptors = b.getKBestDescriptors(beamWidth);
				List<Integer> kFirstDescriptors = b.getKFirstDescriptors(beamWidth);
				List<Integer> kRandomDescriptors = b.getKRandomDescriptors(beamWidth);
				Set<Integer> allDescriptors = b.getAllDescriptorsPossible().keySet();

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

				//System.out.println("Parameters used for beam searches except for timer:");
				System.out.println("BeamWidth: " + beamWidth);
				System.out.println("BeamDepth: " + beamDepth);

				System.out.println("-------------Beam search with " + beamWidth + " firsts-------------------");
				// search with k first descriptors

				System.out.println("List of k first descriptors generated: " + kFirstDescriptors);
				long starttime = System.nanoTime();
				List<Group> listFirst = b.searchK(beamWidth, beamDepth, kFirstDescriptors);

				long endtime = System.nanoTime();
				long e= endtime-starttime;
				double es = (double) e / 1000000000;

				if (typeOfScoring == 1) {
					dataForCsv.append("LabelWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 2) {
					dataForCsv.append("PairWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 3) {
					dataForCsv.append("RankingWise");
					dataForCsv.append(";");
				}

				dataForCsv.append("kFirsts");
				dataForCsv.append(";");
				dataForCsv.append(minFrequency);
				dataForCsv.append(";");
				dataForCsv.append(beamWidth);
				dataForCsv.append(";");
				dataForCsv.append(beamDepth);
				dataForCsv.append(";");
				getGroupsAverageScore(listFirst, dataForCsv);
				dataForCsv.append(es);
				dataForCsv.append(";");
				dataForCsv.append("\n");

				System.out.println("-------------Beam search with " + beamWidth + " randoms-------------------");
				// search k random
				System.out.println("List of k random descriptors generated: " + kRandomDescriptors);
				starttime = System.nanoTime();
				List<Group> listRandom = b.searchK(beamWidth, beamDepth, kRandomDescriptors);

				endtime = System.nanoTime();
				e= endtime-starttime;
				es = (double) e / 1000000000;

				if (typeOfScoring == 1) {
					dataForCsv.append("LabelWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 2) {
					dataForCsv.append("PairWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 3) {
					dataForCsv.append("RankingWise");
					dataForCsv.append(";");
				}

				dataForCsv.append("kRandoms");
				dataForCsv.append(";");

				dataForCsv.append(minFrequency);
				dataForCsv.append(";");
				dataForCsv.append(beamWidth);
				dataForCsv.append(";");
				dataForCsv.append(beamDepth);
				dataForCsv.append(";");
				getGroupsAverageScore(listRandom, dataForCsv);
				dataForCsv.append(es);
				dataForCsv.append(";");
				dataForCsv.append("\n");

				System.out.println("-------------Beam search with " + beamWidth + " bests -------------------");
				// search k best descriptors
				System.out.println("List of k best descriptors generated: " + kBestDescriptors);
				starttime = System.nanoTime();
				List<Group> listBest = b.searchK(beamWidth, beamDepth, kBestDescriptors);

				endtime = System.nanoTime();
				e= endtime-starttime;
				es = (double) e / 1000000000;

				if (typeOfScoring == 1) {
					dataForCsv.append("LabelWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 2) {
					dataForCsv.append("PairWise");
					dataForCsv.append(";");
				} else if (typeOfScoring == 3) {
					dataForCsv.append("RankingWise");
					dataForCsv.append(";");
				}

				dataForCsv.append("kBests");
				dataForCsv.append(";");

				dataForCsv.append(minFrequency);
				dataForCsv.append(";");
				dataForCsv.append(beamWidth);
				dataForCsv.append(";");
				dataForCsv.append(beamDepth);
				dataForCsv.append(";");
				getGroupsAverageScore(listBest, dataForCsv);
				dataForCsv.append(es);
				dataForCsv.append(";");
				dataForCsv.append("\n");

				/*System.out.println("....................................................................................");
				System.out.println("....................................................................................");
				System.out.println("............................Timing..................................................");
				System.out.println("List of all descriptors used for the beam with timer : " + allDescriptors);
				//generateTimerHeuristicSecondes(b, 1);
				//generateTimerHeuristicSecondes(b, 5);
				
				generateTimerHeuristicMinutes(b,30);
				*/
				
				
				
				
				/*System.out.println("List of all descriptors used for the beam with timer : " + allDescriptors);
				int beamWidthTimer = Integer.MAX_VALUE;
				int beamDepthTimer = Integer.MAX_VALUE;
				long time = 1 * 30 * 1000; // 1 minute, used for beamSearchTimer
				List<Group> listTimer = b.searchPTimer(beamWidthTimer, beamDepthTimer, time);
				getGroupsAverageScore(listTimer);*/
				
				/*System.out.println("....................................................................................");
				System.out.println("....................................................................................");*/
				System.out.println("....................................................................................");
		
	}

}
