/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.ServiceImpl;

import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Dao.ConstanteDao;
import PortafolioOFICIALDanielaMurillo.PortafolioOFICIALDanielaMurillo.Domain.ConstanteDomain;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Portafolio_Jason.Portafolio_Jason.service.ConstanteService;

@Service
public class ConstanteServiceImpl 
        implements ConstanteService {

    @Autowired
    private ConstanteDao constanteDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Constante> getConstantes() {
        var lista = constanteDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Constante getConstante(Constante constante) {
        return constanteDao.findById(constante.getIdConstante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Constante constante) {
        constanteDao.save(constante);
    }

    @Override
    @Transactional
    public void delete(Constante constante) {
        constanteDao.delete(constante);
    }    

    @Override
    @Transactional(readOnly=true)
    public Constante getConstantePorAtributo(String atributo) {
        return constanteDao.findByAtributo(atributo);
    }
}
