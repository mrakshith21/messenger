package javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javabrains.messenger.model.Comment;
import javabrains.messenger.service.CommentService;

@Path("/")
public class CommentResource {

	CommentService commentService = new CommentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
		
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		
		commentService.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		System.out.println("Inside getComment in CommentResource");
		return commentService.getComment(messageId, commentId);
	}
	
}
