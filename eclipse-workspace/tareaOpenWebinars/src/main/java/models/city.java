package models;
/**
 * Clase city
 */

public class city {
  /**
   * Atributos privados de la clase
   */
  private int id;
  private String name;
  private String countryCode;
  private String district;
  private int population;
  /**
   * Constructor de la clase city con id
   * @param id
   * @param name
   * @param countryCode
   * @param district
   * @param population
   */
  public city(int id, String name, String countryCode, String district, int population) {
   
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }
  /**
   * Constructor de la clase city sin id
   * @param id
   * @param name
   * @param countryCode
   * @param district
   * @param population
   */
  public city(String name, String countryCode, String district, int population) {
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }
  /**
   * Metodos getter and setter de la clase
   */
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
  public String getDistrict() {
    return district;
  }
  public void setDistrict(String district) {
    this.district = district;
  }
  public int getPopulation() {
    return population;
  }
  public void setPopulation(int population) {
    this.population = population;
  }
}
