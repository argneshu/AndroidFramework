package App_Functions;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import App_Functions.APIParameters;
import App_Functions.APIPayload;
import Utility.ParamObject;
import Utility.RestClient;

public class API_Main {

	private static String getValueFromParser(String str, String keyValue) throws Exception {
		String value = "";
		Object temp;
		try {
			JsonParser jsonParser = new JsonParser();
			JsonElement element = jsonParser.parse(str.toString());
			JsonObject jsonObject = element.getAsJsonObject();
			try {
				temp = jsonObject.get("status");
				value = temp.toString();
				if (value.contains("Failed")) {
					temp = jsonObject.get("msg");
					value = temp.toString();
					throw new Exception(value);
				}
			} catch (Exception e) {

			}

			temp = jsonObject.get(keyValue);
			value = temp.toString().replaceAll("\"", "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(value);
		}
		return value;

	}

	public static boolean OrderAccept_Consumer(String order_id, String status) throws Exception {
		boolean flag = false;
		try {
			String payload = APIPayload.jsonPayLoadForConsumerOrderAcceptAPI(order_id, status);

			ParamObject params = APIParameters.getParamsForOrderAcceptAPI(order_id, payload);

			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);

			System.out.println("Json string : " + jsonString);

			if (RestClient.getResponseCode() == 200) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return flag;

	}

	public static boolean RetailerOrder_Confirm(String order_id, String store_Id, String status) throws Exception {
		boolean flag = false;
		try {
			RestClient.restClient_Flag = false;
			String payload = APIPayload.jsonPayLoadForOrderStatusAPI(store_Id, status);

			ParamObject params = APIParameters.getParamsForOrderStatusAPI(order_id, payload);

			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);

			String order_Status = getValueFromParser(jsonString, "message");
			if (order_Status.trim().equalsIgnoreCase("Retailer status successfully registered")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return flag;
	}

	public static String getOrder_Item(String order_id, String store_id, String status) throws Exception {
		String order_items, order_List = "";
		try {
			ParamObject params = APIParameters.getParamsForOrderDetailAPI(order_id, store_id, status);
			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);
			System.out.println("jsonString::::::::" + jsonString);
			JSONObject serv = new JSONObject(jsonString);
			JSONArray ch = serv.getJSONArray("items");
			for (int j = 0; j < ch.length(); j++) {
				JSONObject json_ChildObj = ch.getJSONObject(j);
				order_items = getValueFromParser(json_ChildObj.toString(), "id").trim();
				order_List = order_List + " " + order_items;
			}
		} catch (Exception e) {
		}
		return order_List;

	}

	public static String getShipmentHandler(String type, String orderItems, String storeId) throws Exception {

		String shipmentId = "";
		try {
			RestClient.restClient_Flag = false;
			String payload = APIPayload.jsonPayLoadForShipmentHandler(type, orderItems, storeId);
			ParamObject params = APIParameters.getParamsForShipmentHandler(payload);

			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);

			shipmentId = getValueFromParser(jsonString, "shipment_id");
		} catch (Exception e) {

		}
		return shipmentId;
	}
	
	public static boolean getOrderDeliveryStatus(String shipmentId, String shipmentStatus, String storeId, String orderId)
			throws Exception {
		boolean flag=false;
		String summary = "";
		try {
			RestClient.restClient_Flag = false;
			String payload = APIPayload.jsonPayLoadForOrderDeliveryStatus(shipmentId, shipmentStatus, storeId);
			ParamObject params = APIParameters.getParamsForOrderDeliveryStatus(payload, orderId);
			System.out.println(params.getPayload());

			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);

			summary = getValueFromParser(jsonString, "message");
			if (summary.trim().equalsIgnoreCase("Status updated")) {
				flag=true;
			}
		} catch (Exception e) {
		}
		return flag;

	}
	
}
