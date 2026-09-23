public  class Pedido {
    private  Cliente cliente;
    private Repartidor repartidor;
    private Pizza [] pizzas = new Pizza[100] ;
    private String direccion;
    int contador_de_pizzas=0;

    public Pedido(Cliente cli, Repartidor rep , String direccion){
            this.cliente = cli;
            this.repartidor  =  rep;
            this.direccion = direccion;

    }

    public void agregarPizza(Pizza pizza){

        this.pizzas[contador_de_pizzas] = pizza;
        this.contador_de_pizzas = this.contador_de_pizzas + 1;
        


    }


    public void cuantasPizzasLLeva(){

        System.out.println(  this.contador_de_pizzas );
    }

    public double total(double porcentaje){
        
        if (porcentaje > 0 && porcentaje < 100){
        double suma=0; 
        for(int i = 0 ; i < this.contador_de_pizzas  ; i++ ){
            System.out.println(pizzas[i].getPrecio());
            suma = pizzas[i].getPrecio() + suma;
        } 
        double pr = porcentaje/100.0;
    System.out.println(pr);    
    System.out.println(suma);
    System.out.println(suma - suma*(pr));
        return  (suma - suma*(pr) );
        
           
        }else{

            System.out.println("PORCENTEJA INVALIDO");
        }
        return 0;
    }


}


