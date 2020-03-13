package com.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import com.data.InvestigadorDao;
import com.domain.Investigador;


@Stateless
@Path("/investigadores")
public class InvestigadorServiceRS {

    @Inject
    private InvestigadorDao investigadorDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Investigador> listarInvestigadores() {
        List<Investigador> investigador = investigadorDao.encontrarTodosInvestigadores();
        System.out.println("Investigador encontrados:" + investigador);
        return investigador;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idInvestigador}") //hace referencia al path: /personas/{id}, ej. /personas/1
    public Investigador encontrarInvestigador(@PathParam("idInvestigador") String idInvestigador) {
        Investigador investigador = investigadorDao.encontrarInvestigador(new Investigador(idInvestigador));
        System.out.println("Investigador encontrado:" + investigador);
        return investigador;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Investigador agregarInvestigador(Investigador investigador) {
        investigadorDao.insertarInvestigador(investigador);
        System.out.println("Investigador agregado:" + investigador);
        return investigador;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idInvestigador}")
    public Response modificarInvestigador(@PathParam("idInvestigador") String idInvestigador, Investigador investigadorModificado) {
        Investigador investigador = investigadorDao.encontrarInvestigador(new Investigador(idInvestigador));
        if ( investigador != null) {
            investigadorDao.actualizarInvestigador(investigadorModificado);
            System.out.println("Investigador modificado:" + investigadorModificado);
            eliminarInvestigador(idInvestigador);
            return Response.ok().entity(investigadorModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
 

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idInvestigador}")
    public Response eliminarInvestigador(@PathParam("idInvestigador") String idInvestigador) {
        investigadorDao.eliminarInvestigador(new Investigador(idInvestigador));
        System.out.println("Investigador eliminado con el idInvestigador:" + idInvestigador);
        return Response.ok().build();
    }
}
