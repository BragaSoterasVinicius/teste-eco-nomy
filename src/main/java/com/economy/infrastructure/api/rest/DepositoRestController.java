package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Deposito;
import com.economy.dto.input.DepositoInputDto;
import com.economy.dto.input.PixDepositInputDto;
import com.economy.dto.output.DepositoOutputDto;
import com.economy.dto.output.PixQrCodeOutputDto;
import com.economy.interfaces.DepositoController;
import com.economy.mapper.DepositoMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/deposito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepositoRestController {

    // TODO - 18112025
    // TODO ver se esse endpoint ainda sera necessario, ja que eu posso registrar o deposito durante o processo de pagamento do pix
    private final DepositoController depositoController;

    public DepositoRestController(DepositoController depositoController) {
        this.depositoController = depositoController;
    }

    //CONTROLLER criar QRCode
        //chama mercadoPago api
        // mercadoPago Api cria QR Code
    @POST
    @Path("/qrCodePix")
    public Response createPixQr(PixDepositInputDto dto) {
        try {
            PixQrCodeOutputDto qrCodePagamento = depositoController.createPixQr(dto);
            return Response.status(Response.Status.CREATED).entity(qrCodePagamento).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    //O webhook idealmente bateria aqui
    @POST
    public Response depositar(DepositoInputDto dto) {
        try {
            //CONTROLLER webhook faz o deposito
                //SERVICE registro de deposito é criado

            Deposito deposito = DepositoMapper.toModel(dto);
            Deposito criado = depositoController.fazerDeposito(deposito);
            DepositoOutputDto saida = DepositoMapper.toDto(criado);

            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/empresa/{empresaId}")
    public Response listarPorEmpresa(@PathParam("empresaId") int empresaId) {
        try {
            List<Deposito> lista = depositoController.listarDepositosPorEmpresa(empresaId);
            List<DepositoOutputDto> saida = new ArrayList<>();

            for (Deposito d : lista) {
                saida.add(DepositoMapper.toDto(d));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
