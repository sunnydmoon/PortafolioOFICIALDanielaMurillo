/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Controller;

/*@author Daniela*/
import java.util.List;

import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.CategoriaDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ProductoDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service.CategoriaService
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service.ProductoService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
@Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    private String listado(Model model) {var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        model.addAttribute("totalProductos", productos.size());
        return "/producto/listado";}

    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";}
    /*
     * @Autowired
     * private FirebaseStorageServiceImpl firebaseStorageService;
     * 
     * @PostMapping("/guardar")
     * public String productoGuardar(Producto producto,
     * 
     * @RequestParam("imagenFile") MultipartFile imagenFile) {
     * if (!imagenFile.isEmpty()) {
     * productoService.save(producto);
     * producto.setRutaImagen(
     * firebaseStorageService.cargaImagen(
     * imagenFile,
     * "producto",
     * producto.getIdProducto()));
     * }
     * productoService.save(producto);
     * return "redirect:/producto/listado";
     * }
     */

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(ProductoDomain productoDomain) {
        productoService.delete(productoDomain);
        return "redirect:/producto/listado";}

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(ProductoDomain productoDomain, Model model) {
        producto = productoService.getProducto(productoDomain);
        model.addAttribute("producto", productoDomain);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/producto/modifica";}
}