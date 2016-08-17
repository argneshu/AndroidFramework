package App_Functions;

import org.json.JSONException;
import org.json.JSONObject;

public class APIPayload {

	public static String jsonPayLoadForConsumerOrderAcceptAPI(String order_id, String status) throws JSONException {
		 JSONObject root = new JSONObject();
		 JSONObject dataJson = new JSONObject();
		 dataJson.put("order_id", order_id);
		 dataJson.put("status", status);
		 root.put("action", "customer_order_acceptance");
		 root.put("data", dataJson);
		 return root.toString();
	}
	
	public static String jsonPayLoadForOrderStatusAPI(String store_Id, String status) throws JSONException {
		return "store_id=" + store_Id + "&retailer_status=" + status;
	}
	
	public static String jsonPayLoadForShipmentHandler(String type, String orderItems, String storeId)
			throws JSONException {
		return "type=" + type + "&order_items=" + orderItems + "&store_id=" + storeId;
	}
	
	public static String jsonPayLoadForOrderDeliveryStatus(String shipmentId, String shipmentStatus, String storeId)
			throws JSONException {
		return "shipment_id=" + shipmentId + "&shipment_status=" + shipmentStatus + "&store_id=" + storeId;
	}
}
