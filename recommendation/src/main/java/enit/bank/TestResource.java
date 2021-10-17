package enit.bank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import enit.bank.Domain.Recommendation;
import enit.bank.Algo.Algorithme;
import java.util.*;

@Path("/api/persons")
public class TestResource {

   
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        List<Recommendation> recommendations=new ArrayList<>();
        recommendations.add(new Recommendation("12","1"));
        recommendations.add(new Recommendation("15", "10"));
        Algorithme algo=new Algorithme();
        List<String> listId=new ArrayList<>();
        listId.add("1");
        listId.add("12");
        listId.add("2");
        var table=algo.algo(listId, recommendations);
        String s="";
        for(int i=0;i<table.size();i++){
            s+=table.get(i).toString()+"\n";
        }
        return s;
    }

}