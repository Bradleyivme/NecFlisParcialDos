package necflis;
import java.util.Scanner;

/* @author bradley */

public class NecFlis {
    
    public static Clientes[] redimensionar(Clientes[] listaclientes){

        Clientes [] listaclientescopia = new Clientes[listaclientes.length + aumento];
        System.arraycopy(listaclientes, 0, listaclientescopia, 0, listaclientes.length);
        
        return listaclientescopia; 

    }
    
    public static Peliculas[] redimensionarpelis(Peliculas[] listapelis){

        Peliculas [] listapeliscopia = new Peliculas[listapelis.length + aumento];
        System.arraycopy(listapelis, 0, listapeliscopia, 0, listapelis.length);
        
        return listapeliscopia; 

    }
    
    public static String [] redimensionarplay(String[] ps){

        String [] ps_copia = new String[ps.length + aumento];
        System.arraycopy(ps, 0, ps_copia, 0, ps.length);
        
        return ps_copia; 

    }
    
    public static int [] redimensionarint(int[] contps){

        int [] nmps = new int[contps.length + aumento];
        System.arraycopy(contps, 0, nmps, 0, contps.length);
        
        return nmps; 

    }
    /**
     *
     */
    public final static int aumento = 1;
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int opmenu = 0, 
                opclientes = 0, 
                opcliente = 0, 
                oppeliculas = 0, 
                elegirpeli = 0, 
                elegircliente = 0;
        int increclientes = 0, 
                increpelis = 0, 
                edad = 0, 
                selecliente = 0, 
                increplay = 0;
        
        String nombre = "", 
                direccion = "", 
                nombrepeli = "", 
                tipo = "", 
                genero = "", 
                sinopsis = "", 
                peli = "", 
                playlt = "", 
                aux = "";
        
        Clientes [] listaclientes = new Clientes[1];
        Peliculas [] listapelis = new Peliculas[1];
        String ps [] = new String[1];
        int contps [] = new int [1];
        
        do{
        
            System.out.println("\n=======================================");
            System.out.println("NECFLIS, UN PROGRAMA DE ENTRETENIMIENTO");
            System.out.println("=======================================");
            System.out.println("1. Clientes \n"
                    + "2. Películas \n"
                    + "3. Salir");
            opmenu = tec.nextInt();
            
            switch(opmenu){
            
                case 1 -> {
                    do{
                        System.out.println("\n=======================================");
                        System.out.println("1. Ver listado de clientes \n"
                                + "2. Crear nuevo cliente \n"
                                + "3. Seleccionar cliente \n"
                                + "4. Atrás");
                        opclientes = tec.nextInt();
                        
                        switch(opclientes){
                        
                            case 1 -> {
                                if(increclientes == 0){
                                    
                                    System.out.println("\nNo se han registrado clientes");
                                    
                                }else{
                                
                                    for (int i = 0; i < listaclientes.length-1; i++) {
                                        Clientes clientes = listaclientes[i];
                                        System.out.println("\n" + i + ". Nombre: " + 
                                                clientes.nombre + " - Direccion: " + 
                                                clientes.direccion + " - Edad: " + clientes.edad);
                                    }
                                
                                }
                            }
                                
                            case 2 -> {
                                tec.nextLine();
                                System.out.println("\n=======================================");
                                System.out.println("\nIngresar el nombre: ");
                                nombre = tec.nextLine();
                                System.out.println("Ingresar la dirección: ");
                                direccion = tec.nextLine();
                                System.out.println("Ingresar la edad: ");
                                edad = tec.nextInt();
                                System.out.println("\nCliente registrado.");
                                
                                Clientes clientes = new Clientes(nombre, direccion, edad);
                                
                                listaclientes[increclientes] = clientes;
                                
                                increclientes++;
                                
                                listaclientes = redimensionar(listaclientes);
                                ps = redimensionarplay(ps);
                                contps = redimensionarint(contps);
                            }
                                
                            case 3 -> {
                                Clientes clientes;
                                if(increclientes == 0){
                                    
                                    System.out.println("\nNo se han registrado clientes");
                                    
                                }else{
                                
                                    for (int i = 0; i < listaclientes.length-1; i++) {
                                        clientes = listaclientes[i];
                                        
                                        System.out.println("\n=======================================");
                                        System.out.println( i + 1 + ". " + clientes.nombre);
                                    }
                                    
                                    System.out.println("\nSelecciona el cliente: ");
                                    selecliente = tec.nextInt();
                                    
                                    while(selecliente > listaclientes.length){
                                    
                                        System.out.println("\nLa posición no existe.");
                                        System.out.println("Selecciona el cliente correctamente: ");
                                        selecliente = tec.nextInt();
                                    
                                    }
                                    
                                    do{
                                        increplay = 0;
                                        
                                        System.out.println("\n=======================================");
                                        System.out.println("1. Playlist \n"
                                                + "2. Agregar película \n"
                                                + "3. Salir");
                                        opcliente = tec.nextInt();
                                
                                        switch(opcliente){
                                
                                            case 1 -> {
                                                if(contps[selecliente-1] == 0){
                                                
                                                    System.out.println("\nNo existen películas en el PlayList");
                                                
                                                }else{
                                                    
                                                    System.out.println("\n=======================================");
                                                    clientes = listaclientes[selecliente-1];
                                                    System.out.println("Playlist de " + clientes.nombre);
                                                    System.out.println(ps[selecliente-1]);
                                                
                                                }
                                            }
                                            case 2 -> {
                                                tec.nextLine();
                                                if(increpelis == 0){
                                    
                                                    System.out.println("\nNo se han registrado películas");
                                    
                                                }else{
                                
                                                    for (int i = 0; i < listapelis.length-1; i++) {
                                                        Peliculas peliculas = listapelis[i];
                                                        System.out.println("\n" + i + ". " + peliculas.nombrepeli);
                                                    }
                                                    
                                                    System.out.println("\nSelecciona la película: ");
                                                    elegirpeli = tec.nextInt();
                                                    
                                                    while(elegirpeli > listapelis.length){
                                                    
                                                        System.out.println("\nLa posición no existe.");
                                                        System.out.println("Selecciona la película correctamente: ");
                                                        elegirpeli = tec.nextInt();
                                                    
                                                    }
                                                    
                                                    contps[selecliente-1] += 1;
                                                    
                                                    Peliculas peliculas = listapelis[elegirpeli-1];
                                                    
                                                    
                                                    ps[selecliente-1] += peliculas.nombrepeli + "\n";
                                                    
                                                    increplay++;
                                
                                                }
                                            }
                                            
                                            case 3 -> {
                                            }
                                            
                                            default -> System.out.println("\nOpción incorrecta");
                                
                                        }
                                
                                    }while(opcliente != 3);
                                }
                            }
                            
                            case 4 -> {
                            }
                                
                            default -> System.out.println("\nOpción incorrecta");
                                       
                        }
                    
                    }while(opclientes != 4);
                }
                    
                case 2 -> {
                    do{
                        System.out.println("\n=======================================");
                        System.out.println("1. Ver listado de películas \n"
                                + "2. Crear película \n"
                                + "3. Atrás");
                        oppeliculas = tec.nextInt();
                        
                        switch(oppeliculas){
                        
                            case 1 -> {
                                if(increpelis == 0){
                                    
                                    System.out.println("\nAún no se registran peliculas");
                                    
                                }else{
                                
                                    for (int i = 0; i < listapelis.length-1; i++) {
                                        Peliculas peliculas = listapelis[i];
                                        System.out.println("\n" + i + ". Nombre: " + peliculas.nombrepeli
                                                + "\nTipo: " + peliculas.tipo + "\nGenero: " 
                                                + peliculas.genero + "\nSinopsis: " + peliculas.sinopsis);
                                    }
                                
                                }
                            }
                            case 2 -> {
                                tec.nextLine();
                                System.out.println("\n=======================================");
                                System.out.println("Ingresar el nombre: ");
                                nombrepeli = tec.nextLine();
                                System.out.println("Ingresar si es (serie/pelicula): ");
                                tipo = tec.nextLine();
                                System.out.println("Ingresar el género (terror, suspenso, comedia, aventura, etc): ");
                                genero = tec.nextLine();
                                System.out.println("Ingresar la sinopsis: ");
                                sinopsis =  tec.nextLine();
                                System.out.println("Pelicula registrada.");
                                
                                Peliculas peliculas = new Peliculas(nombrepeli, tipo, genero, sinopsis);
                                
                                listapelis[increpelis] = peliculas;
                                
                                increpelis++;
                                
                                listapelis = redimensionarpelis(listapelis);
                            }
                            case 3 -> {
                            }
                            default -> System.out.println("\nOpción incorrecta");
                                
                        }
                    
                    }while(oppeliculas != 3);
                }
                    
                case 3 -> System.out.println("\nGracias por usar el programa.");
                 
                default -> System.out.println("\nOpcion incorrecta.");
            
            }
        
        }while(opmenu != 3); 
    }
    
}
