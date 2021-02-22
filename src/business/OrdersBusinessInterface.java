package business;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Order;


@Local
public interface OrdersBusinessInterface
{
	public void test();
	public ArrayList<Order> getOrders();
	public void setOrders(ArrayList<Order> orders);
}