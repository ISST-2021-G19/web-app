package es.upm.dit.isst.edoc.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.edoc.model.Encuesta;
import es.upm.dit.isst.edoc.model.PreguntaEncuesta;
import es.upm.dit.isst.edoc.model.Subject;
import es.upm.dit.isst.edoc.dao.EncuestaDAOImplementation;
import es.upm.dit.isst.edoc.dao.PreguntaEncuestaDAOImplementation;
import es.upm.dit.isst.edoc.dao.SubjectDAOImplementation;;

@Path("/EDOC") 
public class EDOCResource {
	@GET //Accede a las asignaturas de un alumno
	@Path("alumno/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subject> readAllSubject(@PathParam("id") String id){
		return SubjectDAOImplementation.getInstance().readAll(id);
	}
	
	@GET //Accede a una asignatura
	@Path("asignatura/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readSubject(@PathParam("id") String id){
		Subject subject = SubjectDAOImplementation.getInstance().read(id);
		if(subject==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(subject, MediaType.APPLICATION_JSON).build();
	}
	
	@GET //Accede a una encuesta
	@Path("encuesta/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readEncuesta(@PathParam("id") String id){
		Encuesta encuesta = EncuestaDAOImplementation.getInstance().read(id);
		if(encuesta==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(encuesta, MediaType.APPLICATION_JSON).build();
	}
	
	@GET //Accede a una pregunta de una encuesta
	@Path("encuesta/pregunta{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readPreguntaEncuesta(@PathParam("id") String id){
		PreguntaEncuesta pregunta = PreguntaEncuestaDAOImplementation.getInstance().read(id);
		if(pregunta==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(pregunta, MediaType.APPLICATION_JSON).build();
	}
	
	@POST //Envia pregunta encuesta
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePreguntaEncuesta(@PathParam("id") String id, Encuesta e) {
        System.out.println("Update request for" + id + " " + e.toString());
        Encuesta told = EncuestaDAOImplementation.getInstance().read(id);
        if ((told == null) || (! told.getAlumno().getId().contentEquals(e.getAlumno().getId())))
          return Response.notModified().build();
        EncuestaDAOImplementation.getInstance().update(e);
        return Response.ok().build();                
    }

}
