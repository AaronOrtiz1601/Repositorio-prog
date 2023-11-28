package prog.unidad04.actividad402.ejercicio06;
import java.lang.Math;
public class Triangulo {
    private Punto vertice1;
    private Punto vertice2;
    private Punto vertice3;
    private double area;
    private double perimetro;
    public Triangulo(Punto vertice1,Punto vertice2,Punto vertice3)
    {
      this.vertice1=vertice1;
      this.vertice2=vertice2;
      this.vertice3=vertice3;
    }
    public double getArea() {
      area = Math.abs((vertice1.getX() * (vertice2.getY() - vertice3.getY()) + vertice2.getX() * (vertice3.getY() - vertice1.getY()) + vertice3.getX() * (vertice1.getY() - vertice2.getY())) / 2);
      return area;
    }
    public double getPerimetro() {
      return perimetro;
    }
    
    
}
