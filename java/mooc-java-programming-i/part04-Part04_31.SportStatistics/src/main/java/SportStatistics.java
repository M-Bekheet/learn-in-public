
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String file = scan.nextLine();
        System.out.println("Team:");
        String team = scan.nextLine();
        int gamesPlayed = 0;
        int wins = 0;
        int losses = 0;

        ArrayList<Game> games = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();
                if (row.isEmpty())
                    continue;
                String[] parts = row.split(",");
                String teamA = parts[0];
                String teamB = parts[1];
                int goalsA = Integer.valueOf(parts[2]);
                int goalsB = Integer.valueOf(parts[3]);
                Game game = new Game(teamA, teamB, goalsA, goalsB);
                games.add(game);

            }
            for (Game game : games) {
                if (game.getHomeTeam().equals(team) || game.getOtherTeam().equals(team)) {
                    gamesPlayed++;
                    if (game.isWinner(team))
                        wins++;
                    else
                        losses++;
                }
            }
            System.out.println("Games: " + gamesPlayed);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
