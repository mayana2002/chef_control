package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepositorio extends JpaRepository<TipoDocumento, Integer> { }