/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Service;

import org.springframework.security.core.userdetails.*;

public interface UsuarioDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
