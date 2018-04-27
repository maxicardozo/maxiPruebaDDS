package model;

public enum CategoriaEnum {
	R1("R1", 18.76, 0.644),
	R2("R2", 35.32, 0.644),
	R3("R3", 60.71, 0.681),
	R4("R4", 71.74, 0.738),
	R5("R5", 110.38, 0.794),
	R6("R6", 220.75, 0.832),
	R7("R7", 443.59, 0.851),
	R8("R8", 545.96, 0.851),
	R9("R9", 887.19, 0.851);
	
    private String nombre;
    private double cargoFijo;
    private double cargoVariable;
    
    private CategoriaEnum(String nombre, double cargoFijo, double cargoVariable) {
        this.nombre = nombre;
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
    }
    
    public double getCargoFijo()
    {
    	return this.cargoFijo;
    }
    
    public double getCargoVariable()
    {
    	return this.cargoVariable;
    }
   
    @Override
    public String toString(){
        return this.nombre;
    }
}
