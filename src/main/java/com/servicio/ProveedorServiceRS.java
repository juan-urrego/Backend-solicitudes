package com.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import com.data.GrupoDao;
import com.data.ProveedorDao;
import com.domain.Grupo;
import com.domain.Proveedor;

@Stateless
@Path("/proveedores")
public class ProveedorServiceRS {

    @Inject
    private ProveedorDao proveedorDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = proveedorDao.encontrarTodosProveedores();
        System.out.println("Proveedor encontrados:" + proveedores);
        return proveedores;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}") //hace referencia al path: /personas/{id}, ej. /personas/1
    public Proveedor encontrarProveedor(@PathParam("codigo") int codigo) {
        Proveedor proveedor = proveedorDao.encontrarProveedor(new Proveedor(codigo));
        System.out.println("Proveedor encontrado:" + proveedor);
        return proveedor;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Proveedor agregarProveedor(Proveedor proveedor) {
        proveedorDao.insertarProveedor(proveedor);
        System.out.println("Proveedor agregado:" + proveedor);
        return proveedor;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public Response modificarProveedor(@PathParam("codigo") int codigo, Proveedor proveedorModificado) {
        Proveedor proveedor = proveedorDao.encontrarProveedor(new Proveedor(codigo));
        if ( proveedor != null) {
            proveedorDao.actualizarProveedor(proveedorModificado);
            System.out.println("Proveedor modificado:" + proveedorModificado);
            return Response.ok().entity(proveedorModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
 

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{codigo}")
    public Response eliminarProveedor(@PathParam("codigo") int codigo) {
        proveedorDao.eliminarProveedor(new Proveedor(codigo));
        System.out.println("Proveedor eliminado con el codigo:" + codigo);
        return Response.ok().build();
    }
}
