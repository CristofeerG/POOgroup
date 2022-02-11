public class Libro implements Comparable<Libro> {
	private String isbn;
	private String titulo;
	private double precio;
	private int cantidad;

	public Libro() {
		
	}
	
	public Libro(String isbn, String titulo, double precio, int cantidad) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	// getters y setters
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		Libro l = (Libro)obj;
		return this.isbn.equals(l.isbn);
	}

	@Override
	public String toString() {
		return this.isbn + " - " + this.titulo + " - " +"$"+ this.precio + " - " + this.cantidad; 
	}
	
	@Override
	public int compareTo(Libro l) {
		if(l.getPrecio() < precio) {
			return -1;
		}else {
			return 1;
		}
	}
}

