package com.practice.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/TournamentWinner.png" />
 *
 */
public class TournamentWinner_4 {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
		competitions.add(new ArrayList<String>(Arrays.asList("HTML", "C#")));
		competitions.add(new ArrayList<String>(Arrays.asList("C#", "Python")));
		competitions.add(new ArrayList<String>(Arrays.asList("Python", "HTML")));

		String winningTeam = tournamentWinner(competitions, new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
		System.out.println(winningTeam);

	}

	public static String tournamentWinner(

			ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		Map<String, Integer> teamNameToPoints = new HashMap<String, Integer>();

		for (int i = 0; i < results.size(); i++) {

			ArrayList<String> teams = competitions.get(i);

			if (results.get(i) == 0) {

				String teamName = teams.get(1);

				updateMap(teamName, teamNameToPoints);

			} else {

				String teamName = teams.get(0);

				updateMap(teamName, teamNameToPoints);

			}

		}

		int maxValue = Collections.max(teamNameToPoints.values());

		for (Entry<String, Integer> e : teamNameToPoints.entrySet()) {

			if (e.getValue() == maxValue) {

				return e.getKey();

			}

		}

		return null;

	}

	public static void updateMap(String teamName, Map<String, Integer> teamNameToPoints) {

		Integer existingPoint = teamNameToPoints.get(teamName);

		if (null == existingPoint) {

			teamNameToPoints.put(teamName, 3);

		} else {

			teamNameToPoints.put(teamName, existingPoint + 3);

		}

	}
}
