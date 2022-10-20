package com.example.PrimerProyectoTIC1;

import com.example.PrimerProyectoTIC1.EmpleadoP.VentanaActividadController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimerProyectoTic1ApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	void obtenerNombreCentros(){
		VentanaActividadController vent=new VentanaActividadController();
		List<String> centros=vent.nombreDeCentrosDeportivos("futbol");
		assertEquals(2,centros.size());
	}

}
