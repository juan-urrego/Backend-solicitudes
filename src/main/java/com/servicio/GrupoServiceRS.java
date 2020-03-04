package com.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import com.data.GrupoDao;
import com.domain.Grupo;

@Stateless
@Path("/grupos")
public class GrupoServiceRS {

    @Inject
    private GrupoDao grupoDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Grupo> listarGrupos() {
        List<Grupo> grupos = grupoDao.encontrarTodosGrupos();
        System.out.println("grupos encontrados:" + grupos);
        return grupos;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}") //hace referencia al path: /personas/{id}, ej. /personas/1
    public Grupo encontrarGrupo(@PathParam("codigo") int codigo) {
        Grupo grupo = grupoDao.encontrarGrupo(new Grupo(codigo));
        System.out.println("Grupo encontrado:" + grupo);
        return grupo;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Grupo agregarGrupo(Grupo grupo) {
        grupoDao.insertarGrupo(grupo);
        System.out.println("grupo agregado:" + grupo);
        return grupo;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public Response modificarGrupo(@PathParam("codigo") int codigo, Grupo grupoModificado) {
        Grupo grupo = grupoDao.encontrarGrupo(new Grupo(codigo));
        if ( grupo != null) {
            grupoDao.actualizarGrupo(grupoModificado);
            System.out.println("grupo modificado:" + grupoModificado);
            return Response.ok().entity(grupoModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
 

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public Response eliminarGrupo(@PathParam("codigo") int codigo) {
        grupoDao.eliminarGrupo(new Grupo(codigo));
        System.out.println("grupo eliminado con el codigo:" + codigo);
        return Response.ok().build();
    }
}
