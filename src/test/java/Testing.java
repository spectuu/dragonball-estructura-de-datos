import org.junit.jupiter.api.Test;
import taller.service.DataStructureService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Testing {

    @Test
    void testQueueOfTournamentPower() {
        assertDoesNotThrow(DataStructureService::QueueOfTournamentPower);
    }

    @Test
    void testStackOfPower() {
        assertDoesNotThrow(DataStructureService::StackOfPower);
    }

    @Test
    void testCensusUniverse7() {
        assertDoesNotThrow(DataStructureService::CensusUniverse7);
    }

}
