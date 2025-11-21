package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Empresa;
import com.economy.dto.input.EmpresaInputDto;
import com.economy.dto.output.EmpresaOutputDto;
import com.economy.interfaces.EmpresaController;
import com.economy.mapper.EmpresaMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaRestController {
    private final EmpresaController empresaController;
    public EmpresaRestController(EmpresaController empresaController) {
        this.empresaController = empresaController;
    }

    @POST
    public Response create(EmpresaInputDto dto) {
        try {
            Empresa empresa = EmpresaMapper.toModel(dto);
            Empresa criada = empresaController.criarEmpresa(empresa);
            EmpresaOutputDto saida = EmpresaMapper.toDto(criada);

            return Response.status(Response.Status.CREATED).entity(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, EmpresaInputDto dto) {
        try {
            Empresa empresa = EmpresaMapper.toModel(dto);
            Empresa atualizada = empresaController.editarEmpresa(id, empresa);
            EmpresaOutputDto saida = EmpresaMapper.toDto(atualizada);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            empresaController.deletarEmpresa(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        try {
            Empresa empresa = empresaController.buscarPorId(id);
            EmpresaOutputDto saida = EmpresaMapper.toDto(empresa);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response listAll() {
        try {
            List<Empresa> lista = empresaController.listarEmpresas();
            List<EmpresaOutputDto> saida = new ArrayList<>();

            for (Empresa emp : lista) {
                saida.add(EmpresaMapper.toDto(emp));
            }

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(EmpresaInputDto dto) {
        try {
            Empresa empresa = empresaController.login(dto.getCnpj(), dto.getSenha());
            EmpresaOutputDto saida = EmpresaMapper.toDto(empresa);

            return Response.ok(saida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

}
