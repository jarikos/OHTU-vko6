package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstatistics.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(15, "goals"),
                             new HasAtLeast(15, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("...\n");
        m = new And( new HasFewerThan(15, "goals"),
                             new HasFewerThan(15, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("...\n");
        m = new Or( new HasAtLeast(50, "goals"),
                             new HasAtLeast(50, "assists")
                         
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("...\n");
        
        m = new Not( new HasFewerThan(50, "goals"),
                             new HasAtLeast(50, "assists")
                         
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("...\n");
    }
}
