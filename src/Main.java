
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int op = -1;
		int cantidad;
		double precio;
		String titulo, isbn;
		
		Inventario inventario = new Inventario();
		ArrayList<Libro> libros = inventario.getLibros(); 
		
		while(op!=0) {
			System.out.println("----------------MENÚ---------------------");
			System.out.println("<1> Registrar libros");
			System.out.println("<2> Buscar libro por ISBN");
			System.out.println("<3> Venta de libros");
			System.out.println("<4> Mostrar todos los libros");
			System.out.println("<5> Mostrar top tres libros más caros");
			System.out.println("<0> Salir");
			System.out.println("Escoja una opción:");
			op = sc.nextInt();
			System.out.println();
			
			switch(op) {
				case 0:
					System.out.println("¡Hasta la próxima! :)");
					break;
				case 1:
					System.out.println("REGISTRO DE LIBROS.-");
					for(int i=0;i<6;i++) {
						System.out.println("Registro #"+(i+1));
						System.out.println("ISBN: ");
						isbn = sc.next();
						Libro result = inventario.getLibrobyIsbn(isbn);
						if(result != null) {
							System.out.println("¡ERROR! ISBN "+isbn+" ya existe.");
						}else {
							System.out.println("Título del libro: ");
							titulo = sc.next();
							System.out.println("Precio: ");
							precio = sc.nextInt();
							System.out.println("¿Cuántos hay?: ");
							cantidad = sc.nextInt(); 
							Libro ln = new Libro(isbn, titulo, precio, cantidad);
							inventario.almacenar(ln);
						}
						System.out.println();
					}
					System.out.println();
					break;
				case 2:
					System.out.println("BÚSQUEDA POR ISBN.-");
					System.out.println("Introduzca ISBN para buscar: ");
					isbn = sc.next();
					System.out.println();
					Libro result = inventario.getLibrobyIsbn(isbn);
					if(result != null) {
						System.out.println("ISBN pertenece a.-");
						System.out.println(result);
					}else {
						System.out.println("No se encontro el libro con el ISBN "+ isbn);
					}
					System.out.println();
					break;
				case 3:
					System.out.println("VENTA DE LIBROS.-");
					System.out.println();
					System.out.println("Libros disponibles.-");
					inventario.verLibreria();
					System.out.println();
					System.out.println("Ingrese ISBN del libro que desee comprar:");
					isbn = sc.next();
					Libro resul = inventario.getLibrobyIsbn(isbn);
					if(resul != null) {
						System.out.println("¿Cuantós desea comprar?");
						cantidad = sc.nextInt();
						inventario.ventaLibro(resul, cantidad);
						System.out.println();
						System.out.println("Compra concretada éxitosamente!");
					}else {
						System.out.println("ERROR! No se encontro el libro con el ISBN "+ isbn + " por ende no se realizo la compra.");
						System.out.println("Lo sientimos. :(");
					}
					System.out.println();
					break;
				case 4:
					inventario.verLibreria();
					System.out.println();
					break;
				case 5:
					System.out.println("TOP 3 MÁS CAROS.-");
					Collections.sort(libros);
					for (int i=0; i <3;i++ ) { 
						System.out.println(libros.get(i)); 
					}
					System.out.println();
					break;
			}
		}
		sc.close();	
	}
}
