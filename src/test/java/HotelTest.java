import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rellenarFila() {

    }

    @Test
    void rellComida() {
        int habitaciones[][]= new int[10][3];
        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length ; j++) {
                habitaciones[i][j] =0;
            }
        }
        
        habitaciones[1][1]= 1;
        int habitacione[][]= new int[10][3];
        for (int i = 0; i < habitacione.length; i++) {
            for (int j = 0; j < habitacione[i].length ; j++) {
                habitacione[i][j] =0;
            }
        }
        Hotel.RellComida(habitacione,1);
        assertEquals(habitaciones,habitacione);
    }
}