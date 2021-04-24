package com.urbanosamuele.vabSeismograph.api.contoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urbanosamuele.vabSeismograph.api.mapper.SeismographDataRequestMapper;
import com.urbanosamuele.vabSeismograph.dao.DAOFactory;
import com.urbanosamuele.vabSeismograph.model.SeismographData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("seismographData")
public class SeismographDataController {

    @GET
    @Path("/getAllData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAll() {
        List<SeismographData> seismographData = DAOFactory.getDaoFactory(DAOFactory.Type.JPA).getSeismographDataDAO().selectAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(seismographData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.ok()
                .entity(json)
                .build();
    }

    @GET
    @Path("/getLastData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectLastRow() {
        List<SeismographData> seismographData = DAOFactory.getDaoFactory(DAOFactory.Type.JPA).getSeismographDataDAO().selectLastRow();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(seismographData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.ok()
                .entity(json)
                .build();
    }

    @POST
    @Path("/putDataList")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(SeismographDataRequestMapper seismographDataMapper) {
        if (DAOFactory.getDaoFactory(DAOFactory.Type.JPA).getSeismographDataDAO().insert(seismographDataMapper.getSeismographData())) {
            return Response.ok()
                    .entity(null)
                    .build();
        }
        return Response.ok()
                .entity(null)
                .build();
    }
}
