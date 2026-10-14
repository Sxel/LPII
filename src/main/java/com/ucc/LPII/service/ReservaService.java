package com.ucc.LPII.service;

import com.ucc.LPII.dto.ReservaRequestDTO;
import com.ucc.LPII.dto.ReservaResponseDTO;
import com.ucc.LPII.entity.Reserva;
import com.ucc.LPII.entity.Usuario;
import com.ucc.LPII.exception.ReservaNotFoundException;
import com.ucc.LPII.exception.UsuarioNotFoundException;
import com.ucc.LPII.mapper.ReservaMapper;
import com.ucc.LPII.repository.ReservaRepository;
import com.ucc.LPII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservaService {

    private final ReservaMapper reservaMapper;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaService(ReservaMapper reservaMapper, ReservaRepository reservaRepository, UsuarioRepository usuarioRepository) {
        this.reservaMapper = reservaMapper;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<ReservaResponseDTO> obtenerTodasLasReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::entityToDTO)
                .toList();
    }

    public ReservaResponseDTO obtenerUnaReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ReservaNotFoundException(id));
        return reservaMapper.entityToDTO(reserva);
    }

    public ReservaResponseDTO agregarReserva(ReservaRequestDTO dto) {
        Usuario usuario = buscarUsuarioById(dto.idUsuario());
        Reserva reserva = reservaMapper.dtoToEntity(dto, usuario);
        Reserva reservaGuardada = reservaRepository.save(reserva);
        return reservaMapper.entityToDTO(reservaGuardada);
    }

    public ReservaResponseDTO modificarReserva(Long id, ReservaRequestDTO dto){
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);

        if(reservaOpt.isEmpty()){
            throw new ReservaNotFoundException(id);
        }

        Reserva reservaModificada = reservaOpt.get();
        reservaModificada.setCantidadPersonas(dto.cantidadPersonas());
        reservaModificada.setFechaReserva(dto.fechaReserva());

        Usuario usuario = buscarUsuarioById(dto.idUsuario());
        reservaModificada.setUsuario(usuario);
        reservaModificada.setObservaciones(dto.observaciones());

        Reserva reservaGuardada = reservaRepository.save(reservaModificada);
        return reservaMapper.entityToDTO(reservaGuardada);
    }

    public void borrarUnaReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<ReservaResponseDTO> obtenerReservasByUsuario(Long idUsuario) {
        Usuario usuario = buscarUsuarioById(idUsuario);
        // tratamos entidad to dto
        //  ""      listas
        return reservaRepository.findByUsuario_Id(idUsuario)
                .stream()
                .map(reservaEntity -> reservaMapper.entityToDTO(reservaEntity))
                .toList();
    }

    private Usuario buscarUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(
                        () -> new UsuarioNotFoundException(idUsuario)
                );
    }

}
