/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Controller;

/*@author Daniela*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.CategoriaDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service.CategoriaService        

        
@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
@Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";}
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(CategoriaDomain categoriaDomain){
        return "/categoria/modifica";}
}
