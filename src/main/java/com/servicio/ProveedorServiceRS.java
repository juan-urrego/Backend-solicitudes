package com.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import com.data.ProveedorDao;
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
    @Path("{idProveedor}") //hace referencia al path: /personas/{id}, ej. /personas/1
    public Proveedor encontrarProveedor(@PathParam("idProveedor") int idProveedor) {
        Proveedor proveedor = proveedorDao.encontrarProveedor(new Proveedor(idProveedor));
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
    @Path("{idProveedor}")
    public Response modificarProveedor(@PathParam("idProveedor") int idProveedor, Proveedor proveedorModificado) {
        Proveedor proveedor = proveedorDao.encontrarProveedor(new Proveedor(idProveedor));
        if ( proveedor != null) {
            proveedorDao.actualizarProveedor(proveedorModificado);
            System.out.println("Proveedor modificado:" + proveedorModificado);
            eliminarProveedor(idProveedor);
            return Response.ok().entity(proveedorModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
 

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idProveedor}")
    public Response eliminarProveedor(@PathParam("idProveedor") int idProveedor) {
        proveedorDao.eliminarProveedor(new Proveedor(idProveedor));
        System.out.println("Proveedor eliminado con el id_proveedor:" + idProveedor);
        return Response.ok().build();
    }
}
