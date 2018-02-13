package controllers;

import java.util.List;

import models.Subscriber;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;

import views.html.*;


public class Subscribers extends Controller {
	
	private final Form<Subscriber> subscriberForm;
	
	   @Inject
	   public Subscribers(FormFactory formFactory) {
	      this.subscriberForm =  formFactory.form(Subscriber.class);
	  }
	
	public Result index() {
	      return ok(index.render(subscriberForm));
	}
	
	public Result save() {
		Form<Subscriber> boundForm = subscriberForm.bindFromRequest();
		if(boundForm.hasErrors()) {
			return badRequest(index.render(boundForm));
		}
		Subscriber subscriber = boundForm.get();
		subscriber.save();
		return ok(String.format("You are subscribed for our future letters"));	
		}
	}


