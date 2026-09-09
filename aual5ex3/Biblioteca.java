package aual5ex3;

public class Biblioteca {
	public String titulo;
	public String autor;
	public int ano;

	public Biblioteca(String titulo, String autor, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano: " + ano;
    }
    

	@Override
	public String toString() {
		return titulo + " — " + autor + " (" + ano + ")";
	}
}
