package com.uuidable;

import org.jboss.logging.Logger;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@RunOnVirtualThread
@Path("/pin-items")
public class PinItemResource {

	@Inject
	Logger log;

	@GET
	@Path("/{id}")
	public Item get(@PathParam("id") Long id) throws InterruptedException {
		currentThreadLog();
		pin();
		return Item.findById(id);
	}

	@POST
	@Transactional
	public Response create(Item item) throws InterruptedException {
		currentThreadLog();
		pin();
		item.persist();
		return Response.status(Status.CREATED).entity(item).build();
	}

	private void pin() throws InterruptedException {
		synchronized (this) {
			Thread.sleep(3000);
			Log.info("Pinning the carrier thread");
		}
	}

	private void currentThreadLog() {
		Log.infof("Current thread %s", Thread.currentThread());
	}
}
