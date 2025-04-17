/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Dao;

import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ProductoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    // Ejemplo de método utilizando Métodos de Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Ejemplo de método utilizando Métodos de Query para buscar por inicio de letra
    // en descripción
    public List<Producto> findByDescripcionStartingWith(String letraInicial);

    // Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    // Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true, value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
