package com.economy.infrastructure.api.rest;
import com.economy.domain.model.Empregado;
import com.economy.dto.input.EmpregadoInputDto;
import com.economy.dto.output.EmpregadoOutputDto;
import com.economy.interfaces.EmpregadoController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import com.economy.mapper.EmpregadoMapper;

@Path("/empregado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpregadoRestController {
    private final EmpregadoController empregadoController;

    public EmpregadoRestController(EmpregadoController empregadoController) {
        this.empregadoController = empregadoController;
    }

    @POST
    public Response create(EmpregadoInputDto dto) {
        try {
            Empregado empregado = EmpregadoMapper.toModel(dto);
            Empregado criado = empregadoController.criarEmpregado(empregado);
            EmpregadoOutputDto saida = EmpregadoMapper.toDto(criado);

            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, EmpregadoInputDto dto) {
        try {
            Empregado empregado = EmpregadoMapper.toModel(dto);
            Empregado atualizado = empregadoController.editarEmpregado(id, empregado);
            EmpregadoOutputDto saida = EmpregadoMapper.toDto(atualizado);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            empregadoController.deletarEmpregado(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        try {
            Empregado empregado = empregadoController.buscarPorId(id);
            EmpregadoOutputDto saida = EmpregadoMapper.toDto(empregado);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response listAll() {
        try {
            List<Empregado> lista = empregadoController.listarEmpregados();
            List<EmpregadoOutputDto> saida = new ArrayList<>();

            for (Empregado emp : lista) {
                saida.add(EmpregadoMapper.toDto(emp));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(EmpregadoInputDto dto) {
        try {
            Empregado empregado = empregadoController.loginEmpregado(dto.getEmail(), dto.getSenha());
            EmpregadoOutputDto saida = EmpregadoMapper.toDto(empregado);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

}
