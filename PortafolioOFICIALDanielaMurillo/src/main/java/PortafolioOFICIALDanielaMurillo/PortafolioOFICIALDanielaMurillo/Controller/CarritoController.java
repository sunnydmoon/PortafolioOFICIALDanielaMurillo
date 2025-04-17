/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Controller;

/*@author Daniela*/

import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ItemDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ProductoDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ItemService
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service.ProductoService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {

@Autowired
    private ItemService itemService;
    @Autowired
    private ProductoService productoService;

    //Se agrega un producto al carrito de compras
    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregar(Model model, Item item) {Item item2 = itemService.get(item);
        if (item2 == null) {
            //No está el producto en el carrito
            ProductoDomain productoDomain = productoService.getProducto(item);
            item2=new Item(productoDomain);}
        
        itemService.save(item2);
        var lista=itemService.gets();
        var venta=itemService.getTotal();
        var total=lista.size();
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", total);
        model.addAttribute("carritoTotal", venta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");}

    @GetMapping("/carrito/listado")
    public String listado(Model model) {
        var lista=itemService.gets();
        var venta=itemService.getTotal();
        model.addAttribute("items", lista);
        model.addAttribute("carritoTotal", venta);
        return "/carrito/listado";
    }
    
    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminar(Model model, Item item){
        itemService.delete(item);
        return "redirect:/carrito/listado";}
    
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificar(Model model, Item item){
        item=itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";}
    
    @PostMapping("/carrito/guardar")
    public String guardar(Item item){
        itemService.update(item);
        return "redirect:/carrito/listado";}
    
    @GetMapping("/facturar/carrito")
    public String facturar(){
        itemService.facturar();
        return "redirect:/";}
    
}