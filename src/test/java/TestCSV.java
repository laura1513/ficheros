import org.example.ejercicio1csv.Funko;
import org.example.ejercicio1csv.FunkoCollection;
import org.example.ejercicio1csv.MainFunko;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCSV {
    @Test
    public void funkomascaroTrue() {
        Funko uno = new Funko("123", "Pepe", "Disney", 55.30, LocalDate.of(2023,6,15));
        Funko dos = new Funko("456", "Roberto", "Marvel", 40.30, LocalDate.of(2022,12,20));
        List<Funko> f = List.of(uno, dos);
        FunkoCollection funkos = new FunkoCollection(new Funko[] {uno, dos});


        String funkoCaro = funkos.funkoMasCaro(f);

        f.forEach((Funko fu) -> Assertions.assertEquals("Pepe", funkoCaro));
    }
    @Test
    public void mediaPreciosTrue() {
        Funko uno = new Funko("123", "Pepe", "Disney", 40.30, LocalDate.of(2023,6,15));
        Funko dos = new Funko("456", "Roberto", "Marvel", 40.30, LocalDate.of(2022,12,20));
        List<Funko> f = List.of(uno, dos);

        FunkoCollection funkos = new FunkoCollection(new Funko[] {uno, dos});

        double funkoMedia = funkos.mediaDePrecios(f);

        f.forEach((Funko fu) -> Assertions.assertEquals(40.30, funkoMedia));
    }
    @Test
    public void funkos2023True() {
        Funko uno = new Funko("123", "Pepe", "Disney", 40.30, LocalDate.of(2023,6,15));
        Funko dos = new Funko("456", "Roberto", "Marvel", 40.30, LocalDate.of(2022,12,20));
        List<Funko> f = List.of(uno, dos);

        Funko uno2023 = new Funko("123", "Pepe", "Disney", 40.30, LocalDate.of(2023, 6,15));
        List<Funko> f2023 = List.of(uno2023);

        FunkoCollection funkos = new FunkoCollection(new Funko[] {uno, dos});

        List<Funko> funko2023 = funkos.funkosSacadosEn2023(f);

        Assertions.assertEquals(f2023, funko2023);
    }
}
