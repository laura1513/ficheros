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
    public void funkomascaro() {
        Funko uno = new Funko("123", "Pepe", "Disney", 55.30, LocalDate.of(2023,06,15));
        Funko dos = new Funko("456", "Roberto", "Marvel", 40.30, LocalDate.of(2022,12,20));
        List<Funko> f = List.of(uno, dos);
        FunkoCollection funkos = new FunkoCollection(new Funko[] {uno, dos});
        String funkoCaro = funkos.funkoMasCaro(f);

        f.forEach((Funko fu) -> Assertions.assertEquals("Pepe", funkoCaro));
    }
}
