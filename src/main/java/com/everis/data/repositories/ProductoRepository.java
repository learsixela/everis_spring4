package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	//trabajando con querys
	
	//obtener todos los productos
	@Query("SELECT p FROM Producto p")
	List<Producto> findAllProductos();

	//obtener nombres de producctos
	@Query("SELECT p.nombre FROM Producto p")
	List<String> findAllProductosNombres();
	
	//query con parametros (nos devuelve una lista)
	@Query("SELECT p FROM Producto p WHERE id=?1")
	List<Producto> getProductoWhereId(Long id);
	
	//filtro de data
	@Query("SELECT p FROM Producto p WHERE id=?1")
	Producto getSingleProductoWhereId(Long id);
	
	/**
	 * Modificar
	 * */
	@Modifying
	@Query("UPDATE Producto p set p.nombre= ?1 WHERE p.id=?2")
	int setNombreForOne(String nombre,Long id);
	
	@Modifying
	@Query("UPDATE Producto p set p.nombre= ?1")
	int setNombreForAll(String nombre);
	
	@Modifying
	@Query("DELETE Producto p WHERE p.id=?1")
	 int deleteOneProducto(Long id);
	
	/**
	 * Querys nativas
	 * */
	@Query(nativeQuery= true, value="select * from Productos")
	List<Producto> findAllProductosNativa();
	
	//datos especificos
	@Query(value="select id,nombre from Productos",nativeQuery= true)
	List<Object[]> findAllProductosWithfilter();
	
	
	
}