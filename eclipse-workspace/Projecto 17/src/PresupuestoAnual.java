import java.util.Scanner;

public class PresupuestoAnual {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double presupuestoTotal;
    double presupuestoGinecologia;
    double presupustoPediatria;
    double presupustoTraumatologia;
    System.out.println("Dime el presupuesto total que se le ha dado al hospital");
    presupuestoTotal=Double.parseDouble(sc.nextLine());
    presupuestoGinecologia=presupuestoTotal*40/100;
    presupustoTraumatologia=presupuestoTotal*35/100;
    presupustoPediatria=presupuestoTotal*25/100;
    System.out.println("El presupuesto de Ginecologia este año es de "+presupuestoGinecologia);
    System.out.println("El presupusto de Traumatologia este año es de "+ presupustoTraumatologia);
    System.out.println("El presupusto devPediatria este año es de "+presupustoPediatria);
    
    

  }

}
