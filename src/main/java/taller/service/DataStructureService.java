package taller.service;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taller.model.Character;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DataStructureService {

    private static final Logger logger = LogManager.getLogger(DataStructureService.class);

    private static List<Character> characterList;

    static {
        try {
            characterList = HttpService.get("https://dragonball-api.com/api/characters");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void QueueOfTournamentPower() {

        try {


            Queue<Character> tournamentPowerTeam1 = new LinkedList<>();
            Queue<Character> tournamentPowerTeam2 = new LinkedList<>();

            for (int i = 0; i < characterList.size(); i++) {
                if (i < characterList.size() / 2) {
                    tournamentPowerTeam1.add(characterList.get(i));
                } else {
                    tournamentPowerTeam2.add(characterList.get(i));
                }
            }

            while (!tournamentPowerTeam1.isEmpty() && !tournamentPowerTeam2.isEmpty()) {

                Character fighter1 = tournamentPowerTeam1.poll();
                Character fighter2 = tournamentPowerTeam2.poll();

                logger.info("Fighter from Team 1: {} vs Fighter from Team 2: {}", fighter1.getName(), fighter2.getName());
                System.out.println("Fighter from Team 1: " + fighter1.getName() + " vs Fighter from Team 2: " + fighter2.getName());
            }
        } catch (Exception e){

            logger.error("Error processing tournament power queues", e);
            System.out.println("An error occurred while processing the tournament power queues: " + e.getMessage());

        }

    }

    public static void StackOfPower() {

        try {

            Stack<Character> powerTracker = new Stack<>();

            for (Character character : characterList) {
                if (Long.parseLong(character.getKi().replace(".", "")) > 1000000) {
                    powerTracker.push(character);
                }
            }

            while (!powerTracker.isEmpty()) {

                Character powerfulCharacter = powerTracker.pop();
                logger.info("Powerful Character: {}", powerfulCharacter.getName());

                System.out.println("Powerful Character: " + powerfulCharacter.getName() +
                        " with Ki: " + powerfulCharacter.getKi() +
                        " and Max Ki: " + powerfulCharacter.getMaxKi());

            }
        } catch (Exception e){
            logger.error("Error processing stack of power", e);
            System.out.println("An error occurred while processing the stack of power: " + e.getMessage());
        }

    }

    public static void CensusUniverse7(){

        Bag<String> censusRaceBag = BagUtils.synchronizedBag(new HashBag<>());

        try {

            for (Character character : characterList) {
                censusRaceBag.add(character.getRace());
            }

            for (String race : censusRaceBag.uniqueSet()) {
                int count = censusRaceBag.getCount(race);

                System.out.println(race + ": " + count + " occurrences");
            }

        } catch (Exception e) {
            logger.error("Error processing census of Universe 7", e);
            System.out.println("An error occurred while processing the census of Universe 7: " + e.getMessage());
        }

    }


}
