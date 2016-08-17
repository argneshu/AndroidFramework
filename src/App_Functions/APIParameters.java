package App_Functions;

import java.util.concurrent.TimeUnit;

import Utility.ParamObject;

public class APIParameters {

	static String URL_Consumer="http://52.76.238.126";
	static String authorization_Consumer = "Token 29d240f85c2966060ab280db471cbecf83dbc098";
	static String URL_Retailer = "http://139.162.6.154";
	static String xAPIVersion = "1.1";
	static String accessToken = "ffc08b95d9ea451d308d35c44545100986691911";
	public static ParamObject getParamsForOrderAcceptAPI(String order_id, String payLoad) {
		ParamObject obj = new ParamObject();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Consumer + "/dashboard/accounts/sales/orders/action/";
		System.out.println(url);
		obj.setUrl(url);
		obj.addHeader("Authorization", authorization_Consumer);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}
	
	public static ParamObject getParamsForOrderStatusAPI(String order_id, String payLoad) {
		ParamObject obj = new ParamObject();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Retailer + "/rms/retailer/orders/" + order_id + "/confirm_retailer_status/";
		System.out.println(url);
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Access-Token", accessToken);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}
	
	public static ParamObject getParamsForOrderDetailAPI(String order_id, String store_id, String status) {
		ParamObject obj = new ParamObject();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Retailer + "/rms/retailer/orders/" + order_id + "/?store_id=" + store_id + "&status=" + status;
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Access-Token", accessToken);
		// obj.setPayload(payLoad);
		obj.setMethodType("GET");
		return obj;
	}
	
	public static ParamObject getParamsForShipmentHandler(String payLoad) {
		ParamObject obj = new ParamObject();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Retailer + "/rms/retailer/shipment/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Access-Token", accessToken);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}
	
	public static ParamObject getParamsForOrderDeliveryStatus(String payLoad, String orderID) {
		ParamObject obj = new ParamObject();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Retailer + "/rms/retailer/shipment/" + orderID + "/delivery_status/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Access-Token", accessToken);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}
}
