package west.west.lcmcalculator;

import com.west.lcmcalculator.LcmService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

/**
 * Unit tests for LcmService. Ensures that the LCM calculation logic is working correctly for
 * various ranges.
 */
public class LcmServiceTest {

  private final LcmService lcmService = new LcmService();

    /** Tests LCM calculation for numbers from 1 to 10. Expected result: 2520 */
    @Test
    void testLcmOfRangeOf1() {
        assertEquals(BigInteger.valueOf(1), lcmService.calculateLcmOfRange(1));
    }

  /** Tests LCM calculation for numbers from 1 to 10. Expected result: 2520 */
  @Test
  void testLcmOfRangeOf10() {
    assertEquals(BigInteger.valueOf(2520), lcmService.calculateLcmOfRange(10));
  }

  /** Tests LCM calculation for numbers from 1 to 15. Expected result: 360360 */
  @Test
  void testLcmOfRangeOf15() {
    assertEquals(BigInteger.valueOf(360360), lcmService.calculateLcmOfRange(15));
  }

  /** Tests LCM calculation for numbers from 1 to 25. Expected result: 26771144400 */
  @Test
  void testLcmOfRangeOf25() {
    BigInteger expected = new BigInteger("26771144400");
    assertEquals(expected, lcmService.calculateLcmOfRange(25));
  }
}
