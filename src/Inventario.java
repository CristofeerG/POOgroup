
import java.util.ArrayList;

public class Inventario {
	
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}
	
	public void verLibreria() {
		for(Libro lb: libros) {
			System.out.println(lb);
		}
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void ventaLibro(Libro libro, int cantidad) {
		if(libro.getCantidad()<cantidad) {
			System.out.println("No disponemos en stock, lo sentimos.");
		}else if(libro.getCantidad()>=cantidad) {
			libro.setCantidad(libro.getCantidad()-cantidad);
		}
	}
}
