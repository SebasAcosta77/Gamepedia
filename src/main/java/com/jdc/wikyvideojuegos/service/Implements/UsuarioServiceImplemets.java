package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.UsuarioDTO;
import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;
import com.jdc.wikyvideojuegos.Entities.RolEntity;
import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.NoticiaRepository;
import com.jdc.wikyvideojuegos.repository.RolRepository;
import com.jdc.wikyvideojuegos.repository.UsuarioRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImplemets implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuariorepository;
    //busca el id de Rol
    @Autowired
    private RolRepository rolrepository;

    @Override
    public UsuarioEntity save(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuariosave = new UsuarioEntity();

        // Obtener el videojuego desde el repositorio
        RolEntity fkRol = rolrepository.findById(usuarioDTO.getRol()).orElse(null);

        // Validar que el rol no sea null antes de asignarlo
        if (fkRol == null) {
            throw new IllegalArgumentException("El ID del rol  no es válido.");
        }

        usuariosave.setNombreusuario(usuarioDTO.getNombreusuario());
        usuariosave.setDocumentousuario(usuarioDTO.getDocumentousuario());
        usuariosave.setCorreousuario(usuarioDTO.getCorreousuario());
        usuariosave.setFechanacimientousuario(usuarioDTO.getFechanacimientousuario());
        // Asignar correctamente el rol obtenido
        usuariosave.setRol(fkRol);

        return usuariorepository.save(usuariosave);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuariorepository.findAll();
    }

    @Override
    public UsuarioEntity findById(Long id) {
        return usuariorepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioExistente = usuariorepository.findById(id).orElse(null);

        if (usuarioExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        usuarioExistente.setNombreusuario(usuarioDTO.getNombreusuario());
        usuarioExistente.setDocumentousuario(usuarioDTO.getDocumentousuario());
        usuarioExistente.setCorreousuario(usuarioDTO.getCorreousuario());
        usuarioExistente.setFechanacimientousuario(usuarioDTO.getFechanacimientousuario());

        //guardamos los datos actualizados de usuario
        return usuariorepository.save(usuarioExistente);
    }

    @Override
    public void deleteById(Long id) {
        usuariorepository.deleteById(id);

    }
}
