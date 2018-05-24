package frsf.isi.died.tp.modelo;


public class MaterialNoEncontradoException extends RuntimeException{
	public MaterialNoEncontradoException(Integer costo) {
		super("Material de precio "+ costo +" no encontrado.");
	}

}
