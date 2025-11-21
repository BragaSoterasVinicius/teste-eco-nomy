package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Proposta;
import com.economy.dto.input.PropostaInputDto;
import com.economy.dto.output.PropostaOutputDto;
import com.economy.interfaces.PropostaController;
import com.economy.mapper.PropostaMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/proposta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropostaRestController {
    private final PropostaController propostaController;

    public PropostaRestController(PropostaController propostaController) {
        this.propostaController = propostaController;
    }

    @POST
    public Response create(PropostaInputDto dto) {
        try {
            Proposta proposta = PropostaMapper.toModel(dto);
            Proposta criada = propostaController.criarProposta(proposta);
            PropostaOutputDto saida = PropostaMapper.toDto(criada);

            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, PropostaInputDto dto) {
        try {
            Proposta proposta = PropostaMapper.toModel(dto);
            Proposta atualizada = propostaController.editarProposta(id, proposta);
            PropostaOutputDto saida = PropostaMapper.toDto(atualizada);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            propostaController.deletarProposta(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        try {
            Proposta proposta = propostaController.buscarPorId(id);
            PropostaOutputDto saida = PropostaMapper.toDto(proposta);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response listAll() {
        try {
            List<Proposta> lista = propostaController.listarPropostas();
            List<PropostaOutputDto> saida = new ArrayList<>();

            for (Proposta p : lista) {
                saida.add(PropostaMapper.toDto(p));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/empresa/{empresaId}")
    public Response listByEmpresa(@PathParam("empresaId") int empresaId) {
        try {
            List<Proposta> lista = propostaController.listarPropostasPorEmpresa(empresaId);
            List<PropostaOutputDto> saida = new ArrayList<>();

            for (Proposta p : lista) {
                saida.add(PropostaMapper.toDto(p));
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
            List<Proposta> lista = propostaController.listarPropostasPorEmpregado(empregadoId);
            List<PropostaOutputDto> saida = new ArrayList<>();

            for (Proposta p : lista) {
                saida.add(PropostaMapper.toDto(p));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
