package model;

public enum Categoria {
	R1(0, 150, 18.76, 0.644),
	R2(150, 325, 35.32, 0.644),
	R3(325, 400, 60.71, 0.681),
	R4(400, 450, 71.74, 0.738),
	R5(450, 500, 110.38, 0.794),
	R6(500, 600, 220.75, 0.832),
	R7(600, 700, 443.59, 0.851),
	R8(700, 1400, 545.96, 0.851),
	R9(1400, Double.MAX_VALUE, 887.19, 0.851);
	
    private double cargoFijo;
    private double cargoVariable;
    private double consumoMinimo;
    private double consumoMaximo;
    
    private Categoria(double consumoMinimo, double consumoMaximo, double cargoFijo, double cargoVariable) {
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
        this.consumoMinimo = consumoMinimo;
        this.consumoMaximo = consumoMaximo;
    }
    
    public double getCargoFijo()
    {
    	return this.cargoFijo;
    }
    
    public double getCargoVariable()
    {
    	return this.cargoVariable;
    }
    
    public double getConsumoMinimo()
    {
    	return this.consumoMinimo;
    }
    
    public double getConsumoMaximo()
    {
    	return this.consumoMaximo;
    }
}
