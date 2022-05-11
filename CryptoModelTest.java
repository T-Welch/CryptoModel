import static org.junit.Assert.*;
// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;

public class CryptoModelTest {
@Test
public void testGetPeriodHigh() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "2021-07-22", "2021-07-22")));
    assertEquals(32611.84, validModel.getPeriodATH(), .0001);
}

@Test(expected = java.lang.NullPointerException.class)
public void testGetPeriodHighError() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "1990-01-01", "1990-01-01")));
    assertEquals(null, validModel.getPeriodATH());

}

@Test
public void testGetPeriodClose() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "2021-07-22", "2021-07-22")));
    assertEquals(32287.74, validModel.getPeriodClose(), .01);
}

@Test
public void testGetPeriodpen() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "2021-07-22", "2021-07-22")));
    assertEquals(32154.68, validModel.getPeriodOpen(), .01);
}
@Test
public void testGetPeriodLow() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "2021-07-22", "2021-07-22")));
    assertEquals(31703.15, validModel.getPeriodATL(), .01);
}
@Test
public void testGetTradVolume() {
    CryptoModel validModel = new CryptoModel();
    // System.out.println(validModel.queryAPI(validModel.constructURL("X:BTCUSD", "2021-07-22", "2021-07-22")));
    assertEquals("282603", validModel.getPeriodNumberTransactions());
}
}

