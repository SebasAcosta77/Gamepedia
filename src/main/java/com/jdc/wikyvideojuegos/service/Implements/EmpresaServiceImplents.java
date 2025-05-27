package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.EmpresaDTO;
import com.jdc.wikyvideojuegos.Entities.AccesoEntity;
import com.jdc.wikyvideojuegos.Entities.EmpresaEntity;
import com.jdc.wikyvideojuegos.repository.EmpresaRepository;
import com.jdc.wikyvideojuegos.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaServiceImplents implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresarepository;

    @Override
    public EmpresaEntity save(EmpresaDTO empresaDTO) {
        EmpresaEntity empresa = new EmpresaEntity();

        empresa.setNombres(empresaDTO.getNombres());
        empresa.setPaisempresa(empresaDTO.getPaisempresa());
        empresa.setAnofundacionempresa(empresaDTO.getAnofundacionempresa());
        empresa.setSitiowebempresa(empresaDTO.getSitiowebempresa());

        return empresarepository.save(empresa);
    }

    @Override
    public List<EmpresaEntity> findAll() {
        return empresarepository.findAll();
    }

    @Override
    public EmpresaEntity findById(Long id) {
        return empresarepository.findById(id).orElse(null);
    }

    @Override
    public EmpresaEntity update(Long id, EmpresaDTO empresaDTO) {
        EmpresaEntity empresaExistente = empresarepository.findById(id).orElse(null);

        if (empresaExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        empresaExistente.setNombres(empresaDTO.getNombres());
        empresaExistente.setPaisempresa(empresaDTO.getPaisempresa());
        empresaExistente.setAnofundacionempresa(empresaDTO.getAnofundacionempresa());
        empresaExistente.setSitiowebempresa(empresaDTO.getSitiowebempresa());


        //guardamos los datos actualizados de el acceso
        return empresarepository.save(empresaExistente);
    }

    @Override
    public void deleteById(Long id) {
        empresarepository.deleteById(id);

    }
}
