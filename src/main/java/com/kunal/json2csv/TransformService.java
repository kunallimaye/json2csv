/**
 * 
 */
package com.kunal.json2csv;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author kunallimaye
 *
 */
public interface TransformService extends Serializable {
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value = "json2csv")
	public String convert(String stringToConvert);
}
