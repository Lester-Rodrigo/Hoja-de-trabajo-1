import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarRadioTest {
    private CarRadio radio;

    @Before
    public void setUp(){
        radio = new CarRadio();
    }
    
    @Test
    public void testMoveStationBackward_AM(){
        radio.PowerOn();
        radio.MoveStationForward();
        radio.MoveStationForward();
        assertEquals(550f, radio.getCurrentStation(), 0.001f); //se necesita el 0.001f porque es float
        radio.MoveStationBackward();
        assertEquals(540f, radio.getCurrentStation(), 0.001f);
    }

    @Test
    public void testSaveToFavorite(){
        radio.PowerOn();
        radio.SaveToFavorite(0);
        radio.MoveStationBackward();
        assertEquals(1610f, radio.getCurrentStation(), 0.001f);//este va a probar si al regresar desde 530, llega a 1610
        radio.GoFavorite(0);
        assertEquals(530f, radio.getCurrentStation(), 0.001f);
    }

    @Test
    public void testIsRadioAM(){
        assertTrue(radio.isRadioAM());
        radio.ChangeModulation();
        assertFalse(radio.isRadioAM());
    }
}
