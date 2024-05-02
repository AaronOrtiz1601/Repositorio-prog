package prog.unidad07.expresiones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class pruebas {

  @Test
  void literalQueVale3() {
    Expresiones literal = new Literal(3);
    assertEquals(3, literal.getValor());
  }
  @Test
  void VariableQueVale3() {
    Expresiones a = new Variable("a",3);
    assertEquals(3, a.getValor());
  }
  @Test
  void cambioSignoLit() {
    Expresiones literal = new Literal(3);
    OperacionUnaria cambio = new CambioSigno(literal.getValor());
    assertEquals(-3, cambio.getResultado());
  }
  @Test
  void cambioSignoLit2() {
    Expresiones literal = new Literal(-3);
    OperacionUnaria cambio = new CambioSigno(literal.getValor());
    assertEquals(3, cambio.getResultado());
  }
  @Test
  void absLit() {
    Expresiones literal = new Literal(3);
    OperacionUnaria abs = new ValorAbs(literal.getValor());
    assertEquals(3, abs.getResultado());
  }
  @Test
  void absLit2() {
    Expresiones literal = new Literal(-3);
    OperacionUnaria abs = new ValorAbs(literal.getValor());
    assertEquals(3, abs.getResultado());
  }
  @Test
  void Suma() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias suma = new Suma(literal.getValor(),literal2.getValor());
    assertEquals(7, suma.getResultado());
  }
  @Test
  void Suma2() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias suma = new Suma(literal.getValor(),literal2.getValor());
    assertEquals(1, suma.getResultado());
  }
  @Test
  void Suma3() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias suma = new Suma(literal.getValor(),literal2.getValor());
    assertEquals(-1, suma.getResultado());
  }
  @Test
  void Suma4() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias suma = new Suma(literal.getValor(),literal2.getValor());
    assertEquals(-7, suma.getResultado());
  }
  @Test
  void Resta() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias resta = new Resta(literal.getValor(),literal2.getValor());
    assertEquals(-1, resta.getResultado());
  }
  @Test
  void resta2() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias resta = new Resta(literal.getValor(),literal2.getValor());
    assertEquals(-7, resta.getResultado());
  }
  @Test
  void resta3() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias resta = new Resta(literal.getValor(),literal2.getValor());
    assertEquals(7, resta.getResultado());
  }
  @Test
  void resta4() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias resta = new Resta(literal.getValor(),literal2.getValor());
    assertEquals(1, resta.getResultado());
  }
  @Test
  void producto() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias producto = new Producto(literal.getValor(),literal2.getValor());
    assertEquals(12, producto.getResultado());
  }
  @Test
  void producto2() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias producto = new Producto(literal.getValor(),literal2.getValor());
    assertEquals(-12, producto.getResultado());
  }
  @Test
  void producto3() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias producto = new Producto(literal.getValor(),literal2.getValor());
    assertEquals(-12, producto.getResultado());
  }
  @Test
  void producto4() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias producto = new Producto(literal.getValor(),literal2.getValor());
    assertEquals(12, producto.getResultado());
  }
  @Test
  void Division()  {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Division;
    try {
      Division = new Division(literal.getValor(),literal2.getValor());
      assertEquals(0, Division.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Division2() {
    Expresiones literal = new Literal(4);
    Expresiones literal2 = new Literal(3);
    OperacionesBinarias Division;
    try {
      Division = new Division(literal.getValor(),literal2.getValor());
      assertEquals(1, Division.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Division3() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias Division;
    try {
      Division = new Division(literal2.getValor(),literal.getValor());
      assertEquals(-1, Division.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
  @Test
  void Division4() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Division;
    try {
      Division = new Division(literal2.getValor(),literal.getValor());
      assertEquals(-1, Division.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
  @Test
  void Division5() {
    Expresiones literal = new Literal(4);
    Expresiones literal2 = new Literal(0);
    OperacionesBinarias Division;
      assertThrows(ExpresionException.class, () -> new Division(literal.getValor(),literal2.getValor()));
   
   
  }
  @Test
  void Division6() {
    Expresiones literal = new Literal(-4);
    Expresiones literal2 = new Literal(0);
    OperacionesBinarias Division;
      assertThrows(ExpresionException.class, () -> new Division(literal.getValor(),literal2.getValor()));
   
   
  }
  @Test
  void Resto()  {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Resto;
    try {
      Resto = new Resto(literal.getValor(),literal2.getValor());
      assertEquals(3, Resto.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Resto2() {
    Expresiones literal = new Literal(4);
    Expresiones literal2 = new Literal(3);
    OperacionesBinarias Resto;
    try {
      Resto = new Resto(literal.getValor(),literal2.getValor());
      assertEquals(1, Resto.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Resto3() {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias Resto;
    try {
      Resto = new Division(literal2.getValor(),literal.getValor());
      assertEquals(-1, Resto.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
  @Test
  void Resto4() {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Resto;
    try {
      Resto = new Resto(literal2.getValor(),literal.getValor());
      assertEquals(1, Resto.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
  }
  @Test
  void Resto5() {
    Expresiones literal = new Literal(4);
    Expresiones literal2 = new Literal(0);
    OperacionesBinarias Resto;
      assertThrows(ExpresionException.class, () -> new Resto(literal.getValor(),literal2.getValor()));
   
   
  }
  @Test
  void Resto6() {
    Expresiones literal = new Literal(-4);
    Expresiones literal2 = new Literal(0);
    OperacionesBinarias Resto;
      assertThrows(ExpresionException.class, () -> new Resto(literal.getValor(),literal2.getValor()));
   
   
  }
  @Test
  void Potencia()  {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Potencia;
    try {
      Potencia = new Potencia(literal.getValor(),literal2.getValor());
      assertEquals(81, Potencia.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Potencia2()  {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(4);
    OperacionesBinarias Potencia;
    try {
      Potencia = new Potencia(literal.getValor(),literal2.getValor());
      assertEquals(81, Potencia.getResultado());
    } catch (ExpresionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  @Test
  void Potencia3()  {
    Expresiones literal = new Literal(3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias Potencia;
    assertThrows(ExpresionException.class, () -> new Potencia(literal.getValor(),literal2.getValor()));
    
  }
  @Test
  void Potencia4()  {
    Expresiones literal = new Literal(-3);
    Expresiones literal2 = new Literal(-4);
    OperacionesBinarias Potencia;
    assertThrows(ExpresionException.class, () -> new Potencia(literal.getValor(),literal2.getValor()));
    
  }
  @Test
  void Combinado()  {
    Expresiones b = new Variable("b",3);
    Expresiones literal = new Literal(2);
    Expresiones literal2 = new Literal(4);
    Expresiones a = new Variable("a",2);
    Expresiones c = new Variable("c",4);
    OperacionesBinarias Potencia;
    OperacionesBinarias resta;
    OperacionesBinarias producto;
    OperacionesBinarias producto2;
    OperacionUnaria abs;
    try {
      Potencia = new Potencia(b.getValor(),literal.getValor());
      producto = new Producto(literal2.getValor(),a.getValor());
      producto2 = new Producto(producto.getResultado(),c.getValor());
      resta = new Resta(Potencia.getResultado(),producto2.getResultado());
      abs = new ValorAbs(resta.getResultado());
      assertEquals(23, abs.getResultado());
      
    } catch (ExpresionException e) {
      e.printStackTrace();
    }
    
  }
  @Test
  void Combinado2()  {
    Expresiones b = new Variable("b",6);
    Expresiones literal = new Literal(2);
    Expresiones literal2 = new Literal(4);
    Expresiones a = new Variable("a",5);
    Expresiones c = new Variable("c",7);
    OperacionesBinarias Potencia;
    OperacionesBinarias resta;
    OperacionesBinarias producto;
    OperacionesBinarias producto2;
    OperacionUnaria abs;
    try {
      Potencia = new Potencia(b.getValor(),literal.getValor());
      producto = new Producto(literal2.getValor(),a.getValor());
      producto2 = new Producto(producto.getResultado(),c.getValor());
      resta = new Resta(Potencia.getResultado(),producto2.getResultado());
      abs = new ValorAbs(resta.getResultado());
      assertEquals(104, abs.getResultado());
      
    } catch (ExpresionException e) {
      e.printStackTrace();
    }
    
  }
  @Test
  void Combinado3()  {
    Expresiones literal = new Literal(2);
    Expresiones literal2 = new Literal(3);
    Expresiones literal3 = new Literal(4);
    Expresiones literal4 = new Literal(5);
    OperacionesBinarias suma;
    OperacionesBinarias producto;
    OperacionesBinarias resto;
    try {
      producto = new Producto(literal.getValor(),literal2.getValor());
      suma = new Suma(literal3.getValor(),producto.getResultado());
      resto = new Resto(suma.getResultado(),5);
      assertEquals(0, resto.getResultado());
      
    } catch (ExpresionException e) {
      e.printStackTrace();
    }
    
  }
  @Test
  void Combinado4()  {
    Expresiones literal = new Literal(2);
    Expresiones literal2 = new Literal(4);
    Expresiones literal3 = new Literal(5);
    Expresiones literal4 = new Literal(6);
    OperacionesBinarias suma;
    OperacionesBinarias resta;
    OperacionesBinarias resto;
    OperacionUnaria abs;
    try {
      suma = new Suma(literal.getValor(),literal2.getValor());
      resto = new Resto(suma.getResultado(),literal3.getValor());
      resta = new Resta(resto.getResultado(),literal4.getValor());
      abs = new ValorAbs(resta.getResultado());
      assertEquals(5, abs.getResultado());
      
    } catch (ExpresionException e) {
      e.printStackTrace();
    }
    
  }
  
  
}
