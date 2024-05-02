package prog.unidad07.relacion01.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import prog.unidad07.ejercicio02.CalculadorNomina;

class pruebaTest {

  @Test
  void testEmpleadoFijoOk() {
    // Caso: Inserta un empleado fijo con datos correctos
    // RE  : El empleado se crea correctamente y su salario es 1000
    String nif = "73370382Z";
    String nombre = "Pepe";
    String tfn = "666666666";
    double facturacion = 1000;
    List<Empleado> empleados = new ArrayList<>() ;
    CalculadorNomina calculadora = new CalculadorNomina();
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    try {
      Pepe = new empleadosFijos(nombre, nif, tfn, facturacion);
      empleados.add(Pepe);
    } catch (Exception e) {
      fail("No se pudo crear el Cliente");
      
    }
    
    
    
    assertEquals(calculadora.calculaNominaCompleta(empleados),1000);
    
    
  }
  @Test
  void testEmpleadoFijoNombreNulo() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "73370382Z";
    String nombre = "GHLSSR";
    String tfn = "666666666";
    double facturacion = 1000;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new empleadosFijos(nombre, nif, tfn
        ,facturacion));
    
    
  }
  @Test
  void testEmpleadoFijoDniNulo() {
    // Caso: Inserta un empleado fijo con el dni en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = null;
    String nombre = "Paco";
    String tfn = "666666666";
    double facturacion = 1000;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new empleadosFijos(nombre, nif, tfn
        ,facturacion));
    
    
  }
  @Test
  void testEmpleadoFijoTfnNulo() {
    // Caso: Inserta un empleado fijo con el tfn en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "26845672A";
    String nombre = "Paco";
    String tfn = null;
    double facturacion = 1000;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new empleadosFijos(nombre, nif, tfn
        ,facturacion));
    
    
  }
  @Test
  void testEmpleadoFijoSalario0() {
    // Caso: Inserta un empleado fijo con datos correctos
    // RE  : El empleado se crea correctamente y su salario es 0
    String nif = "73370382Z";
    String nombre = "Pepe";
    String tfn = "666666666";
    double facturacion = 0;
    List<Empleado> empleados = new ArrayList<>() ;
    CalculadorNomina calculadora = new CalculadorNomina();
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    try {
      Pepe = new empleadosFijos(nombre, nif, tfn, facturacion);
      empleados.add(Pepe);
    } catch (Exception e) {
      fail("No se pudo crear el Cliente");
      
    }
    
    
    
    assertEquals(calculadora.calculaNominaCompleta(empleados),0);
    
    
  }
  @Test
  void testEmpleadoFijoSalarioNegativo() {
    // Caso: Inserta un empleado fijo con el salario negativo
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "26845672A";
    String nombre = "Paco";
    String tfn = "657953039";
    double facturacion = -9;
   
    Empleado Pepe = null;
    assertThrows(IllegalArgumentException.class, () -> new empleadosFijos(nombre, nif, tfn
        ,facturacion));
    
    
  }
  @Test
  void testConsultorOk() {
    // Caso: Inserta un empleado fijo con datos correctos
    // RE  : El empleado se crea correctamente y su salario es 0
    String nif = "73370382Z";
    String nombre = "Pepe";
    String tfn = "666666666";
    double tarifa = 100;
    double horas = 8;
    List<Empleado> empleados = new ArrayList<>() ;
    CalculadorNomina calculadora = new CalculadorNomina();
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    try {
      Pepe = new Consultores(nombre, nif, tfn, tarifa,horas);
      empleados.add(Pepe);
    } catch (Exception e) {
      fail("No se pudo crear el Cliente");
      
    }
    
    
    
    assertEquals(calculadora.calculaNominaCompleta(empleados),800);
    
    
  }
  @Test
  void testConsultorNombreNulo() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "73370382Z";
    String nombre = null;
    String tfn = "666666666";
    double tarifa = 100;
    double horas = 8;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new Consultores(nombre, nif, tfn
        ,tarifa,horas));
    
    
  }
  @Test
  void testConsultorDniNulo() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = null;
    String nombre = "Paco";
    String tfn = "666666666";
    double tarifa = 100;
    double horas = 8;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new Consultores(nombre, nif, tfn
        ,tarifa,horas));
    
    
  }
  @Test
  void testConsultorTfnNulo() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "26845672A";
    String nombre = "Paco";
    String tfn = null;
    double tarifa = 100;
    double horas = 8;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(NullPointerException.class, () -> new Consultores(nombre, nif, tfn
        ,tarifa,horas));
    
    
  }
  @Test
  void testConsultorTarifa0() {
    // Caso: Inserta un empleado fijo con datos correctos
    // RE  : El empleado se crea correctamente y su salario es 0
    String nif = "73370382Z";
    String nombre = "Pepe";
    String tfn = "666666666";
    double tarifa = 0;
    double horas = 8;
    List<Empleado> empleados = new ArrayList<>() ;
    CalculadorNomina calculadora = new CalculadorNomina();
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    try {
      Pepe = new Consultores(nombre, nif, tfn, tarifa,horas);
      empleados.add(Pepe);
    } catch (Exception e) {
      fail("No se pudo crear el Cliente");
      
    }
    
    
    
    assertEquals(calculadora.calculaNominaCompleta(empleados),0);
    
    
  }
  @Test
  void testConsultorHoras0() {
    // Caso: Inserta un empleado fijo con datos correctos
    // RE  : El empleado se crea correctamente y su salario es 0
    String nif = "73370382Z";
    String nombre = "Pepe";
    String tfn = "666666666";
    double tarifa = 100;
    double horas = 0;
    List<Empleado> empleados = new ArrayList<>() ;
    CalculadorNomina calculadora = new CalculadorNomina();
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    try {
      Pepe = new Consultores(nombre, nif, tfn, tarifa,horas);
      empleados.add(Pepe);
    } catch (Exception e) {
      fail("No se pudo crear el Cliente");
      
    }
    
    
    
    assertEquals(calculadora.calculaNominaCompleta(empleados),0);
    
    
  }
  @Test
  void testConsultorTarifaNegativa() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "26845672A";
    String nombre = "Paco";
    String tfn = "657953039";
    double tarifa = -100;
    double horas = 8;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(IllegalArgumentException.class, () -> new Consultores(nombre, nif, tfn
        ,tarifa,horas));
    
    
  }
  @Test
  void testConsultorHorasNegativa() {
    // Caso: Inserta un empleado fijo con el nombre en nulo 
    // RE  : El empleado no se crea y se lanza la excepcion
    String nif = "26845672A";
    String nombre = "Paco";
    String tfn = "657953039";
    double tarifa = 100;
    double horas = -8;
    // Creamos el objeto y no debe lanzar excepcion
    Empleado Pepe = null;
    assertThrows(IllegalArgumentException.class, () -> new Consultores(nombre, nif, tfn
        ,tarifa,horas));
    
    
  }

@Test
void testComercialNombreNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = null;
  String tfn = "666666666";
  double ventas = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comerciales(nombre, nif, tfn
      ,ventas));
  
  
}
@Test
void testComercialDniNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = null;
  String nombre = "Paco";
  String tfn = "666666666";
  double ventas = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comerciales(nombre, nif, tfn
      ,ventas));
  
  
}
@Test
void testComercialTfnNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = null;
  double ventas = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comerciales(nombre, nif, tfn
      ,ventas));
  
  
}
@Test
void testComercialVentasNegaativas() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = - 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(IllegalArgumentException.class, () -> new Comerciales(nombre, nif, tfn
      ,ventas));
  
  
}

@Test
void testConsultorVentas0() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 0;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comerciales(nombre, nif, tfn,ventas);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),300);
  
  
}
@Test
void testConsultorVentas10000() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comerciales(nombre, nif, tfn,ventas);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),500);
  
  
}
@Test
void testConsultorVentas10001() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10001;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comerciales(nombre, nif, tfn,ventas);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),800.08);
  
  
}
@Test
void testConsultorVentas30000() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 30000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comerciales(nombre, nif, tfn,ventas);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),2400);
  
  
}
@Test
void testConsultorVentas30001() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 30001;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comerciales(nombre, nif, tfn,ventas);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),3000.10);
  
  
}

@Test
void testComisionistaNombreNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = null;
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 10;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}

@Test
void testComisionistaDniNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = null;
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 10;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaTfnNulo() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = null;
  double ventas = 10000;
  double porcentaje = 10;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(NullPointerException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaVentasNegativas() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = -10000;
  double porcentaje = 10;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(IllegalArgumentException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaPorcentajeNegativas() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = -10;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(IllegalArgumentException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaSalarioNegativas() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 10;
  double salario = -1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(IllegalArgumentException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaPorcentajeSuperiorA100() {
  // Caso: Inserta un empleado fijo con el nombre en nulo 
  // RE  : El empleado no se crea y se lanza la excepcion
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 101;
  double salario = 1000;
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  assertThrows(IllegalArgumentException.class, () -> new Comisionistas(nombre, nif, tfn,salario
      ,ventas,porcentaje));
  
  
}
@Test
void testComisionistaSalario0() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 10;
  double salario = 0;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comisionistas(nombre, nif, tfn,salario,ventas,porcentaje);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),1000);
  
  
}
@Test
void testComisionistaPorcenateje0() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 0;
  double salario = 1000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comisionistas(nombre, nif, tfn,salario,ventas,porcentaje);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),1000);
  
  
}
@Test
void testComisionistaVentas0() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 0;
  double porcentaje = 10;
  double salario = 1000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comisionistas(nombre, nif, tfn,salario,ventas,porcentaje);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),1000);
  
  
}
@Test
void testComisionistaOk() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 100;
  double salario = 1000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comisionistas(nombre, nif, tfn,salario,ventas,porcentaje);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),11000);
  
  
}
@Test
void testComisionistaPorcentaje50() {
  // Caso: Inserta un empleado fijo con datos correctos
  // RE  : El empleado se crea correctamente y su salario es 0
  String nif = "73370382Z";
  String nombre = "Pepe";
  String tfn = "666666666";
  double ventas = 10000;
  double porcentaje = 50;
  double salario = 1000;
  List<Empleado> empleados = new ArrayList<>() ;
  CalculadorNomina calculadora = new CalculadorNomina();
  // Creamos el objeto y no debe lanzar excepcion
  Empleado Pepe = null;
  try {
    Pepe = new Comisionistas(nombre, nif, tfn,salario,ventas,porcentaje);
    empleados.add(Pepe);
  } catch (Exception e) {
    fail("No se pudo crear el Cliente");
    
  }
  
  
  
  assertEquals(calculadora.calculaNominaCompleta(empleados),6000);
  
  
}

}
