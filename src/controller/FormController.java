package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController 
{
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;
	
	//On submission
	public String onSubmit(User user)
	{
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		service.test();
		timer.setTimer(10000);
		return "TestResponse.xhtml";
	}
	
	//
	public OrdersBusinessInterface getService()
	{
		return service;
	}
	
	//On flash
	public String onFlash(User user)
	{
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse.xhtml?faces-redirect=true";
	}
}