package prog.unidad06.mapas.ejercicio01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiccionarioSpanishEnglish {
  private Map<String, String> diccionario = new HashMap<>(); 
   public DiccionarioSpanishEnglish()
  {
     diccionario();
  }
  public String traducir(String palabra) {
    String palabraTraducida;
    if(palabra == null)
    {
      throw new IllegalArgumentException();
    }else
    {
    palabraTraducida = diccionario.get(palabra);
    }
    return palabraTraducida;
  }
  public Set<String> getPalabrasSpanish()
  {
  
  return diccionario.keySet();
   
   
    
  }
  private  void diccionario()
  {
    
    diccionario.put("girar","spin");
    diccionario.put("sorpresa","surprise");
    diccionario.put("maceta","pot");
    diccionario.put("historiador","historian");
    diccionario.put("enjuagar","rinse");
    diccionario.put("casilla","square");
    diccionario.put("signo","sign");
    diccionario.put("importar","import");
    diccionario.put("ficha","piece");
    diccionario.put("patines","skates");
    diccionario.put("historia","history");
    diccionario.put("tornillo","screw");
    diccionario.put("cantante","singer");
    diccionario.put("insulto","insult");
    diccionario.put("firma","sign");
    diccionario.put("lechuga","lettuce");
    diccionario.put("tiza","chalk");
    diccionario.put("adoptar","adopt");
    diccionario.put("pila","battery");
    diccionario.put("ciudad","city");
    diccionario.put("rail","rail");
    diccionario.put("frontera","border");
    diccionario.put("prisionero","prisoner");
    diccionario.put("capullo","cocoon");
    diccionario.put("anchoa","anchovy");
    diccionario.put("pierna","leg");
    diccionario.put("habito","habit");
    diccionario.put("hueso","bone");
  }
}
