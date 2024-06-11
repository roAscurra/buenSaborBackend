package com.example.dashboard.services.impl;

import com.example.dashboard.entities.DetallePedido;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.DetallePedidoRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.DetallePedidoService;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido,Long> implements DetallePedidoService {

    private DetallePedidoRepository detallePedido;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        super((BaseRepository<DetallePedido, Long>) detallePedidoRepository);
        this.detallePedido = detallePedidoRepository;
        {
        }
    }
}
