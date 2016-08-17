package Page_Objects;

public interface SanitySuiteAppConstants {

	String buildType = ".staging";
	//String buildType = "";


	String MyAccountFirstFavouriteProductName_id = "com.zopperapp" + buildType + ":id/tv_similar_product_name";
	String Google_SignInId = "com.zopperapp" + buildType + ":id/login_button_google";
	String NavDrawer_Login_button_id = "com.zopperapp" + buildType + ":id/iv_drawer_signup_icon";
	String NavDrawer_Login_Title_Id = "com.zopperapp" + buildType + ":id/tv_drawer_signup_title";
	String Lets_Go_Shopping_Id = "com.zopperapp" + buildType + ":id/tv_boarding_page_done";
	String Home_Menu_Id = "com.zopperapp" + buildType + ":id/tv_drawer_list_row_title";
	String Android_phones_id = "com.zopperapp" + buildType + ":id/iv_popular_cat1";
	String Cart_id = "com.zopperapp" + buildType + ":id/iv_cart";
	String MyAccountFirstFavouriteProduct_id = "com.zopperapp" + buildType + ":id/iv_similar_product";
	String MyAccountTabsParent_class = "android.widget.ScrollView";
	String MyAccountTabsChilld_class = "android.widget.RelativeLayout";
	String NavDrawerCategories_id = "com.zopperapp" + buildType + ":id/tv_drawer_list_row_title";
	String SignUp_FullName_Edit_Id = "com.zopperapp" + buildType + ":id/et_signup_name";
	String SignUp_Email_Edit_Id = "com.zopperapp" + buildType + ":id/et_signup_email";
	String SignUp_ContactNo_Edit_Id = "com.zopperapp" + buildType + ":id/et_contact";
	String SignUp_Password_Edit_Id = "com.zopperapp" + buildType + ":id/et_signup_password";
	String SignUp_RefferalCode_Edit_Id = "com.zopperapp" + buildType + ":id/et_referral_code";
	String SignUp_SignUp_Button_Id = "com.zopperapp" + buildType + ":id/button_sign_up";
	String OTP_PopUp_Edit_Id = "com.zopperapp" + buildType + ":id/number_otp";
	String OTP_PopUp_Submit_Button_Id = "com.zopperapp" + buildType + ":id/generate_otp";
	String OTP_OTP_Edit_Id = "com.zopperapp" + buildType + ":id/enter_otp";
	String OTP_Verify_Button_Id = "com.zopperapp" + buildType + ":id/verify_otp";
	String Login_LoggedIn_User_Id = "com.zopperapp" + buildType + ":id/name_profile";
	String Shipping_FullName_Id = "com.zopperapp" + buildType + ":id/et_full_name";
	String Shipping_Address_Id = "com.zopperapp" + buildType + ":id/et_address";
	String Shipping_Pincode_Id = "com.zopperapp" + buildType + ":id/et_address_pincode";
	String Shipping_SaveButton_Id = "com.zopperapp" + buildType + ":id/tv_shipping_save";
	String FresdeskUsername_id = "user_session_email";
	String FreshdsekPassword_id = "user_session_password";
	String FreshdeskButton_xpath = "//button[contains(.,'Login')]";
	String zoppertest_link = "Argneshu99";
	String MyProfile_Wallent_Amount_Id = "com.zopperapp" + buildType + ":id/wallet_count";
	String AllPaymentMode_id = "com.zopperapp" + buildType + ":id/tv_payment_mode_text";
	String Product_Price_id = "com.zopperapp" + buildType + ":id/tv_product_price";
	String ProductList_Product_Id = "com.zopperapp" + buildType + ":id/tv_similar_product_name";
	String ViewOrder_id = "com.zopperapp" + buildType + ":id/tv_view_order";
	String OrderStatus_id = "com.zopperapp" + buildType + ":id/tv_product_item_status";
	String MyAccount_Wallet_Id = "com.zopperapp" + buildType + ":id/wallet_heading";
	String Wallet_RefferalAmount_Id = "com.zopperapp" + buildType + ":id/tv_referral_amount";
	String Wallet_Refferal_Date_Id = "com.zopperapp" + buildType + ":id/tv_conversion_date";
	String MyAccount_OrderStatus_id = "com.zopperapp" + buildType + ":id/tv_order_status";
	
	
	//fake caller
	
	String Caller_Name_Id="com.popularapp.fakecall:id/name";
	String Caller_Number_Id="com.popularapp.fakecall:id/number";
	String Caller_SaveButton_Id="com.popularapp.fakecall:id/save";
	String Caller_TimeSet_Text="Set time";
	String Caller_TimeInMinutes_Text="30 seconds later";
	
	//Wallet
	 String Wallet_Layout_Id="com.zopperapp" + buildType + ":id/rv_wallet";
     String Wallet_Relative_Layout_Class="android.widget.RelativeLayout";
     String Wallet_Card_Title_Id="com.zopperapp" + buildType + ":id/tv_wallet_card_title";
     String Wallet_ValidityDate_Id="com.zopperapp" + buildType + ":id/tv_validity_date";
     
     //Homepage
     
     String LFRStore_id = "com.zopperapp"+ buildType+":id/cat_tile";
     String PartnersStorestext_name = "Our Partner Chain Stores";
	

     //OLA
     
     String OlaNavDrawer = "com.olacabs.customer:id/button_navigation_drawer";
     String OlaMoney="Ola Money";
     String OlaWalletMoney = "com.olacabs.customer:id/item_value";
     String UtilizeOlaWalletMoney = "com.olacabs.customer:id/ola_use_balance";
     String OlaMoneyBalance="com.olacabs.customer"+buildType+":id/balance_amount_text";

}
