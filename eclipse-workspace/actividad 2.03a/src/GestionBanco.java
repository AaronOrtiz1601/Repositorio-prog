import java.util.Scanner;

public class GestionBanco {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    CuentaCorriente  cuentaCorriente = new CuentaCorriente("11111");
    System.out.println(cuentaCorriente.getNumero());
    cuentaCorriente.ingresar(1000);
    System.out.println(cuentaCorriente.getSaldo());
    cuentaCorriente.retirar(1100);
    System.out.println(cuentaCorriente.getSaldo());
    cuentaCorriente.retirar(900);
    System.out.println(cuentaCorriente.getSaldo());
    cuentaCorriente.retirar(100);
    cuentaCorriente.ingresar(350);
    System.out.println(cuentaCorriente.getSaldo());
    cuentaCorriente.retirar(400);
    System.out.println(cuentaCorriente.getSaldo());
    
  }

}
