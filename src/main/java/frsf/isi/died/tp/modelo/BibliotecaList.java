package frsf.isi.died.tp.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class BibliotecaList implements Biblioteca{
	
	
	private ArrayList<MaterialCapacitacion> materiales;
		
	public BibliotecaList() {
		this.materiales=new ArrayList<>();
	}
	
	
	public void agregar(MaterialCapacitacion mat) {
	materiales.add(mat);
	}
	
	public Integer cantidadMateriales() {
		return materiales.size();
	}
	
	public Integer cantidadLibros() {
		
		int cantLibros=0;
		
		for(int i=0;i<materiales.size();i++) {
			if (materiales.get(i).esLibro()) cantLibros++;
		}
	return cantLibros;
	}
	
	
	public Integer cantidadVideos() {
		
		int cantVideos=0;
		
		for(int i=0;i<materiales.size();i++) {
			if (materiales.get(i).esLibro()) cantVideos++;
		}
	return cantVideos;
	}
	
	
	public Collection<MaterialCapacitacion> materiales(){
		return this.materiales;
	}
	
	public void imprimir(){
		
		for(int i=0;i<this.materiales.size();i++) {
			System.out.print(this.materiales.get(i));
		}
		
	}
	
	public void ordenarPorPrecio(Boolean b) {
		if(b==false){
			Collections.sort(this.materiales);
		}
		else{
			Collections.sort(this.materiales, (m1,m2)->m1.precio().intValue()-m2.precio().intValue());
		}
	}
	
	@Override
	public MaterialCapacitacion buscar(Integer precio){
		Collections.sort(this.materiales, (m1,m2)->m1.getCosto().intValue()-m2.getCosto().intValue());
		return buscadorBinario(0,this.materiales.size(),precio);
		}

	private MaterialCapacitacion buscadorBinario(Integer i, Integer f, Integer c) throws MaterialNoEncontradoException{
			int mitad=i+((f-i)/2);
			int aux = this.materiales.get(mitad).getCosto().intValue();
			if(c!=aux && ((f-i)<2)) throw new MaterialNoEncontradoException(c);
			else {
			if(aux == c) {
				return this.materiales.get(mitad); 
			}
			else {
				if(c<aux) {
					return buscadorBinario(i,mitad,c);
				}
				else{
					
					return buscadorBinario(mitad,f,c);
				}
					
			}
			}
	}



}
