package frsf.isi.died.tp.modelo.productos;

import java.util.Date;
import java.util.Objects;

/**
 * Representa un video en el sistema de biblioteca digital
 * @author jraviolo
 */
public class Video extends MaterialCapacitacion {
	
	public static final Double CostoPorSegundo=0.15;
	
	private Integer duracion;
	
	public Video() {
	}
	
	public Video(Integer id, String titulo) {
		this(id,titulo,0.0,0);
	}
	
	public Video(Integer id, String titulo, Double costo, Integer duracion) {
		super(id,titulo,costo);
		this.duracion=duracion;
	}
	
	@Override
	public Boolean esLibro() {
		return false;
	}

	@Override
	public Boolean esVideo() {
		return true;
	}

	@Override
	public Double precio() {
		double precio;
		precio= this.costo+(CostoPorSegundo*duracion);
	return precio;
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Video && super.equals(obj)) {
		 return true;	
		}
		
	return false;
	
	}
	
}
