/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Controller;

/*@author Daniela*/

import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.UsuarioDomain
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model){
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";}

    @GetMapping("/nuevo")
    public String usuarioNuevo(UsuarioDomain usuarioDomain){return "/usuario/modifica";}

    @PostMapping("/guardar")
    public String usuarioGuardar(UsuarioDomain usuarioDomain,
            @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()){
            usuarioService.save(usuario,false);}
        usuarioService.save(usuario,true);
        return "redirect:/usuario/listado";}

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(UsuarioDomain usuarioDomain){
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";}

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(UsuarioDomain usuarioDomain, Model model){
        usuario = usuarioService.getUsuario(usuarioDomain);
        model.addAttribute("usuario", usuarioDomain);
        return "/usuario/modifica";}
}
