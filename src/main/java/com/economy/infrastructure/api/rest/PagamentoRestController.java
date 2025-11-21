package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Pagamento;
import com.economy.dto.input.PagamentoInputDto;
import com.economy.dto.output.PagamentoOutputDto;
import com.economy.interfaces.PagamentoController;
import com.economy.mapper.PagamentoMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/pagamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoRestController {

    private final PagamentoController pagamentoController;

    public PagamentoRestController(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }

    @POST
    public Response create(PagamentoInputDto dto) {
        try {
            Pagamento pagamento = PagamentoMapper.toModel(dto);
            Pagamento criado = pagamentoController.criarTransacao(pagamento);
            PagamentoOutputDto saida = PagamentoMapper.toDto(criado);

            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, PagamentoInputDto dto) {
        try {
            Pagamento pagamento = PagamentoMapper.toModel(dto);
            Pagamento atualizado = pagamentoController.editarTransacao(id, pagamento);
            PagamentoOutputDto saida = PagamentoMapper.toDto(atualizado);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        try {
            Pagamento pagamento = pagamentoController.buscarPorId(id);
            PagamentoOutputDto saida = PagamentoMapper.toDto(pagamento);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/empresa/{empresaId}")
    public Response listByEmpresa(@PathParam("empresaId") int empresaId) {
        try {
            List<Pagamento> lista = pagamentoController.listarPorEmpresa(empresaId);
            List<PagamentoOutputDto> saida = new ArrayList<>();

            for (Pagamento p : lista) {
                saida.add(PagamentoMapper.toDto(p));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/empregado/{empregadoId}")
    public Response listByEmpregado(@PathParam("empregadoId") int empregadoId) {
        try {
            List<Pagamento> lista = pagamentoController.listarPorEmpregado(empregadoId);
            List<PagamentoOutputDto> saida = new ArrayList<>();

            for (Pagamento p : lista) {
                saida.add(PagamentoMapper.toDto(p));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
