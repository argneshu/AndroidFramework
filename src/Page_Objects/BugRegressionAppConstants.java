package Page_Objects;

import java.io.File;
import java.io.FileInputStream;

import BugRegressionSuite.BaseTestBugRegression;

//This interface hold all the objects of consumer application

public interface BugRegressionAppConstants {
	// Lets go shopping button on first time application launch
	
	String buildType = ".staging";
	//String buildType = "";

	// Quick Tour

	String LetsGoShopping_text = "LET'S GO SHOPPING";
	String LetGoShopping_Id = "com.zopperapp"+buildType+":id/tv_boarding_page_done";
	// Shop The Zopper Way
	String ShopTheZopperWayMobile_id = "com.zopperapp.dev:id/iv_smart_cat";
	String ShopTheZopperWayTablet_id = "com.zopperapp.dev:id/iv_smart_cat1";
	String PageSpinner_id = "com.zopperapp.dev:id/pb_location_parent";

	// Gmail

	String Mail_To_id = "com.google.android.gm:id/to";
	String Mail_To_xpath = "//android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout[@index=1]/android.widget.MultiAutoCompleteTextView";
	String Mail_Subject_id = "com.google.android.gm:id/subject";
	String Mail_Send_id = "com.google.android.gm:id/send";

	// String Mail_From_id="com.google.android.gm:id/body";
	String Mail_From_id = "com.google.android.gm:id/from_account_name";
	String Gmail_name = "Gmail";

	// Find the right Mobiles

	String STZWSkip_text = "SKIP";
	String STZWGaming_xpath = "//android.widget.FrameLayout /android.view.View /android.view.View /android.view.View /android.view.View[1]";
	String STZWPhotos_xpath = "//android.widget.FrameLayout /android.view.View /android.view.View /android.view.View /android.view.View[2]";
	String STZWBusiness_xpath = "//android.widget.FrameLayout /android.view.View /android.view.View /android.view.View /android.view.View[3]";
	String STZWCalling_xpath = "//android.widget.FrameLayout /android.view.View /android.view.View /android.view.View /android.view.View[4]";

	// Mobiles for You

	String STZWFirstMobileProduct_text = "//android.widget.FrameLayout /android.support.v7.widget.RecyclerView /android.widget.RelativeLayout[1] /android.widget.TextView[1]";
	String STZWSecondMobileproduct_text = "//android.widget.FrameLayout /android.support.v7.widget.RecyclerView /android.widget.RelativeLayout[2] /android.widget.TextView[1]";

	// Welcome Page
	String Lets_Go_Shopping_Id = "com.zopperapp"+buildType+":id/tv_boarding_page_done";
	String Prod_Lets_Go_Shopping_Id = "com.zopperapp:id/tv_boarding_page_done";

	String LetsGoShopping_name = "Let's go shopping";

	
	// Home page
	String Prod_Home_Menu_Id = "com.zopperapp:id/tv_drawer_list_row_title";
	String Home_ExcitingCategory = "com.zopperapp" + buildType + ":id/cat_name";
	String Prod_Cart_Id = "com.zopperapp"+buildType+":id/iv_cart";
	String ProductionCart_id = "com.zopperapp:id/action_cart";
	String TrendingProducts_ID = "com.zopperapp" + buildType + ":id/tv_home_popular_products_title";
	String RecentlyViewedFirstProduct_id = "com.zopperapp" + buildType + ":id/iv_product_image_first";
	String RecentlyViewedSecondProduct_id = "com.zopperapp" + buildType + ":id/iv_product_image_second";
	String ConnectionErrorPage_id = "com.zopperapp" + buildType + ":id/tv_error_label";
	String NoItemInCart_id = "com.zopperapp" + buildType + ":id/tv_error_label";
	String Home_RecentltViewed_name = "Recently Viewed";
	String ConnectionErrorPage_name = "Connection timeout";
	String AutoSuggestSearch_id = "com.zopperapp" + buildType + ":id/tv_auto_suggest";
	String Home_SearchEditBox_id = "com.zopperapp" + buildType + ":id/et_search_product";
	String HomeSearchtextbox_id = "com.zopperapp" + buildType + ":id/home_search";
	String HomeSpinner_id = "com.zopperapp"+buildType+":id/pb_home";
	String SearchSuggestionlist_id = "com.zopperapp" + buildType + ":id/lv_auto_suggest";
	// String SearchIcon_id = "com.zopperapp:id/action_search";

	String HomeRecentlyViewedHeader_Text = "Your recent interests";
	String recentlyViewedProduct_id = "com.zopperapp"+buildType+":id/rl_products";
	String HomePageExploreExcitingCategories_text = "Explore Exciting Categories";

	String ExploreExcitingMobileAndTablets_xpath = "//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/"
			+ "android.widget.ScrollView/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=0]";
	String CategoryHeader_Xpath = "//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/"
			+ "android.widget.FrameLayout/android.widget.TextView[@index=1]";

	String AddWarrantyFromHome_id = "com.zopperapp" + buildType + ":id/save_invoice";
	String AddWarrantyFromHome_Text = "Save Purchase Invoice For Brand Warranty";
	String HomePageExchange_Text = "Exchange";
	String HomePageExchangeCategory_xpath = "//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/"
			+ "android.widget.ScrollView/android.widget.LinearLayout[@index=29]";
	String ExchangeCategoryHeader_xpath = "//android.widget.FrameLayout/android.widget.TextView[@index=1]";

	// Rediffmail selenium scenario

	String Rediff_LoginUser_id = "txtlogin";
	String Rediff_ContinueButton_id = "btn_go";
	String Rediff_Password_id = "pass_box";
	String Rediff_LoginButton_xpath = "//input[@type='submit' and @value='Login']";
	String Rediff_MailBox_xpath = "//a[@class='curhand' and @title='Lightning fast free email']//u[contains(text(),'rediffmail')]";
	String Rediff_ResetMail_xpath = "//*[@id='mailList']//a[contains(text(),'no-reply@zopper.com')]";
	String Rediff_ResetLinkInMail_xpath = "//*[@id='mailMsgBody']/a";
	String Rediff_NewPassword_id = "password";
	String Rediff_ConfirmPassword_id = "confirm_password";
	String Rediff_Submit_id = "changePWD";
	String Rediff_SuccessMsg_id = "successMessage";
	String SignUpIcon_id = "com.zopperapp" + buildType + ":id/iv_drawer_signup_icon";

	// Nav drawer category list

	String Category_List_Id = "com.zopperapp"+buildType+":id/tv_drawer_list_row_title";
	// Navigation Drawer

	String Skip_button = "android.widget.Button";
	// String Skip_button = "android.widget.TextView";
	String skip_button_text = "Skip";
	//String Open_Navigation_Drawer = "com.zopperapp" + buildType + ":id/home_navigation";
	String Open_Navigation_Drawer = "android.widget.ImageView";
	String OpenNavigationDrawerForMobAndTabPage = "android.widget.ImageButton";
	String NavDrawer_Mobile_tablets_link = "Mobiles & Tablets";
	String NavDrawer_Kitchen_Appliances_link = "Kitchen Appliances";
	String NavDrawer_Home_Appliances_link = "Home Appliances";
	String NavDrawer_TV_VideoPlayer_link = "TV & Video Player";
	String NavDrawer_Login_button_id = "com.zopperapp"+buildType+":id/tv_drawer_signup_title";
	String NavDrawer_Location_text = "Delhi";

	String NavDrawer_SubLocation_id = "com.zopperapp"+buildType+":id/tv_drawer_location_child";
	String NavDrawer_ContactUs_link="Contact Us";
	String NavDrawer_ContactUs_id="com.zopperapp"+buildType+":id/drawer_contact_us";
	String NavDrawer_Login_Id="com.zopperapp"+buildType+":id/tv_drawer_signup_title";
	String NavDrawer_Locality_Id="com.zopperapp"+buildType+":id/tv_drawer_location_child";
	String NavDrawer_Location_Id="com.zopperapp"+buildType+":id/tv_drawer_location_title";


      

	// Navigation Drawer
	String Homelink_id = "com.zopperapp" + buildType + ":id/tv_drawer_home_title";
	String Hometext_name = "Home";
	String NavDrawerLocation_id = "com.zopperapp"+buildType+":id/tv_drawer_location_title";

	String NavDrawer_Mobile_tablets_xpath = "//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[@index=0]/"
			+ "android.widget.ListView/android.widget.RelativeLayout[@index=1]/android.widget.TextView";

	String NavDrawer_TV_Home_Entertainment_link = "TV & Home Entertainment";
	String NavDrawerComputerAccessorieslink_name = "Computers & Accessories";
	String NavDrawerPersonalCare_name = "Personal Care & Health";
	String NavDrawerHomeElectricals = "Home Electricals & Security";

	String NavDrawerLocationChild_id = "com.zopperapp" + buildType + ":id/tv_drawer_location_child";
	String NavDrawerLocationIcon_id = "com.zopperapp" + buildType + ":id/iv_drawer_location_icon";
	String NavDrawerLocationTitle_id = "com.zopperapp" + buildType + ":id/tv_drawer_location_title";
	String NavDrawer_loginbutton_name = "Login or Sign up";
	String NavDrawerHomeIcon_id = "com.zopperapp" + buildType + ":id/iv_drawer_home_icon";
	
	String NavDrawer_NameProfile_Id="com.zopperapp"+buildType+":id/name_profile";
	String Login_UserName_Id = "com.zopperapp" + buildType + ":id/et_login_username";
	String Login_Password_Id = "com.zopperapp" + buildType + ":id/et_login_password";
	String Login_Button_id = "com.zopperapp" + buildType + ":id/button_login";
	String Homelink_Prod_id = "com.zopperapp" + buildType + ":id/tv_drawer_home_title";
	String addWarranty_id = "com.zopperapp" + buildType + ":id/layout_drawer_warranty";
	String Add_Product_For_Warranty_Text = "Add product for Warranty";
	String Add_Product_For_Warranty_id = "com.zopperapp" + buildType + ":id/iv_drawer_warranty_icon";
	// Home page

	String Home_Menu_Id = "com.zopperapp" + buildType + ":id/tv_drawer_list_row_title";
	String Home_Mobiles_Tablets_id = "com.zopperapp.dev:id/iv_root_cat_full1";
	String Home_Kitchen_Appliances_id = "com.zopperapp.dev:id/iv_root_cat_full2";
	String Home_Appliances_id = "com.zopperapp.dev:id/iv_root_cat_full3";
	String Home_TV_Video_Player_id = "com.zopperapp.dev:id/iv_root_cat";
	String Home_search_button_id = "com.zopperapp" + buildType + ":id/home_search";
	String InnerPage_search_button_id = "com.zopperapp" + buildType + ":id/action_search";
	String Search_Bar_textbar_text = "Best Products from Trusted Local Stores";
	String Search_Bar_textbar_id = "com.zopperapp"+buildType+":id/et_search_product";
	String Cart_id = "com.zopperapp"+buildType+":id/action_cart";
	String Home_name = "Home";
	String HomeOverflow_name = "More options";
	String first_product_id = "com.zopperapp.dev:id/rl_first_product_block";
	String second_product_id = "com.zopperapp.dev:id/rl_second_product_block";
	String third_product_id = "com.zopperapp.dev:id/rl_third_product_block";
	String fourth_product_id = "com.zopperapp"+buildType+":id/rl_fourth_product_block";
	String Home_search_button_xpath = "//android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.TextView[2]";
	String Home_Search_box_id = "com.zopperapp"+buildType+":id/home_search";
	String Home_Search_TextBox_Id = "com.zopperapp" + buildType + ":id/home_search";

	// Login page
	String Login_text = "Login";
	String Facebook_button_id = "com.zopperapp"+buildType+":id/login_button_fb";
	String Facebook_button_xpath = "//android.widget.FrameLayout/ android.widget.Button[2]";
	String Google_button_xpath = "//android.widget.FrameLayout/ android.widget.Button[3]";
	String Gmail_account_id_option1_xpath = "//android.widget.CheckedTextView[@index=0]";
	String Gmail_account_ok_button = "android:id/button2";
	String Google_SignIn_link = "Sign in";
	String Email_name = "E-mail ID";
	String Password_xpath = "//android.widget.FrameLayout/ android.widget.EditText[2]";
	String LoginButton_name = "LOGIN";
	String StagingLoginButton_name = "Login";
	String LoginButton_id = "com.zopperapp" + buildType + ":id/button_login";
	String SignUP_name = "sign up";
	String SkipButton_id = "com.zopperapp.dev:id/item_skip";
	String login_passwd_id = "com.zopperapp"+buildType+":id/et_login_password";
	String Forgot_password_id = "com.zopperapp"+buildType+":id/tv_forgot_password";
	String Gmail_account_id_option2_xpath = "//android.widget.CheckedTextView[@index=0]";
	String Login_Button_Id = "com.zopperapp"+buildType+":id/button_login";
	String Google_SignInId = "com.zopperapp"+buildType+":id/login_button_google";
	String Forgot_Password_Link_id = "com.zopperapp" + buildType + ":id/tv_forgot_password";
	String FB_User_Password_Id = "android.widget.EditText";
	String FB_Login_Button_Id = "android.widget.Button";
	String Logout_PopUp_Yes_Id = "com.zopperapp" + buildType + ":id/logout_yes";

	// Forgot Password Page
	String Forgot_password_text = "Forgot Password";
	String submit_button_text = "SUBMIT";
	String Email_id_text = "E-mail ID";

	// Shopping Cart

	String ShoppingCartDeleteButton_id = "com.zopperapp"+buildType+":id/iv_cart_delete_product";
	String ShoppingCart_Text = "Shopping Cart";
	String NoItemInCartLabel_id = "com.zopperapp"+buildType+":id/tv_error_label";
	String CheckoutButton_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String ContinueButton_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String CashOnDelivery_id = "com.zopperapp"+buildType+":id/tv_payment_mode_cod";
	String CashOnDelivery_Name = "CASH ON DELIVERY";
	String PlaceOrder_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String CouponTextbox_id = "com.zopperapp"+buildType+":id/et_coupon_value";
	String CouponApplyButton_id = "com.zopperapp"+buildType+":id/tv_apply_coupon";
	String CouponError_id = "com.zopperapp"+buildType+":id/tv_apply_coupon_error";
	String NameValidation_text = "Please enter your full name";
	String EmailValidation_text = "Please enter a valid email ID";
	String MobileNumber_text = "Please enter a 10 digit mobile number";
	String AddNewAdress_id = "com.zopperapp"+buildType+":id/saved_address";
	String CouponCode_id = "com.zopperapp"+buildType+":id/et_coupon_value";
	String ApplyCoupon_id = "com.zopperapp"+buildType+":id/tv_apply_coupon";
	String PlaceOrderButton_id = "com.zopperapp.dev:id/tv_checkout";
	String ShopMoreButton_id = "com.zopperapp.dev:id/tv_payment_next_step";
	String AddToCartButton_id = "com.zopperapp"+buildType+":id/tv_buy";
	String LargeImageBuyNowButton_id = "com.zopperapp"+ buildType +"id/tv_gallery_buy";
	String ProductItemCountIncrease_Id="com.zopperapp"+buildType+":id/iv_increase_product_count";
	String ProductItemCount_Id="com.zopperapp"+buildType+":id/tv_cart_product_quantity";
	String CartGoHome_Id="com.zopperapp"+buildType+":id/tv_error_home";
	String CartTrendingProduct_Id="com.zopperapp"+buildType+":id/tv_error_retry";

	String CouponErrorMessage_id = "com.zopperapp.dev:id/tv_apply_coupon_error";
	String CartDeleteButton_Id = "com.zopperapp"+buildType+":id/iv_cart_delete_product";

	String ProductionCheckoutButton_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String ProductionContinueButton_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String ProductionCashOnDelivery_id = "com.zopperapp"+buildType+":id/tv_payment_mode_cod";
	String CashOnDelievery_name = "CASH ON DELIVERY";
	String OlaMoneyIcon_name = "OLA MONEY";
	String ProductionPlaceOrder_id = "com.zopperapp"+buildType+":id/tv_checkout";
	String ViewStore_id = "com.zopperapp" + buildType + ":id/tv_cart_view_store";
	String StoreTitle_id = "com.zopperapp" + buildType + ":id/tv_store_title";
	String StoreLocality_id = "com.zopperapp" + buildType + ":id/tv_store_locality";
	

	// Shipping Address Page

	String AddressPageFullName_id = "com.zopperapp"+buildType+":id/et_full_name";
	String AddressPageEmail_id = "com.zopperapp"+buildType+":id/et_email";
	String AddressPageContactNumber_id = "com.zopperapp"+buildType+":id/et_contact";

	// Sign UP Page

	String Fullname_Name = "Full Name";
	String EmailID_Name = "E-mail ID";
	String Password_id = "com.zopperapp.dev:id/et_signup_password";
	String Sign_Up_button_name = "Sign Up";
	String signUp_id = "com.zopperapp.dev:id/tv_sign_up";
	String signUp_fullname_id = "com.zopperapp.dev:id/et_signup_name";
	String signUp_emailId_id = "com.zopperapp.dev:id/et_signup_email";
	String signUp_Contact_no_id = "com.zopperapp.dev:id/et_contact";
	String signUp_password_id = "com.zopperapp.dev:id/et_signup_password";
	String signUp_referral_id = "com.zopperapp.dev:id/et_referral_code";
	String signUp_button_id = "com.zopperapp.dev:id/button_sign_up";
	String SignUp_already_have_acc_id = "com.zopperapp"+buildType+":id/tv_have_account";
	String Olamoney_id = "com.zopperapp:id/tv_payment_mode_ola";

	// OLA Page

	String OLADEBITCREDITCARDS_name = "DEBIT/CREDIT CARDS";
	String OLANETBANKING_name = "NET BANKING";
	String OLAAmount_id = "com.olacabs.customer:id/ola_total_amount_value";
	String OLABalance_id = "com.olacabs.customer:id/ola_use_balance";

	// My Account page
	String Myaccount_text = "My Account";
	String Logout_button_id = "com.zopperapp" + buildType + ":id/log_out";
	String MyAccountSearchIcon_xpath = "//android.widget.FrameLayout /android.widget.TextView[2]";
	String UserEmailtext_id = "com.zopperapp" + buildType + ":id/name_email";
	String MyProfileOrderLink_id = "com.zopperapp" + buildType + ":id/profile_order";
	String MyAccount_OrderMenu_Id = "com.zopperapp" + buildType + ":id/order_heading";
	String OrderID_id = "com.zopperapp" + buildType + ":id/tv_order_id";
	String MyAccountFavouritesButton_xpath = "//android.widget.RelativeLayout[@index=0]"; // android.widget.FrameLayout/android.widget.ScrollView/android.widget.ImageView[@index=2]";
	String MyAccountWarrantyButton_xpath = "//android.widget.RelativeLayout[@index=3]";
	String Logout_button_Prod_id = "com.zopperapp" + buildType + ":id/profile_log_out";
	String MyAccountAddProduct_id = "com.zopperapp" + buildType + ":id/tv_add_product";
	String MyAccountTabs = "com.zopperapp" + buildType + ":id/image_tab";
	String myAccount_FavouriteList_id = "com.zopperapp" + buildType + ":id/fav_heading";
	String myAccount_Warranty_id = "com.zopperapp" + buildType + ":id/profile_warraanty";
	String myAccount_LogOutPopupMessage_Id = "com.zopperapp" + buildType + ":id/otp_description";
	String Back_Arrow_ClassName = "android.widget.ImageButton";
	String ProfileName_id = "com.zopperapp"+buildType+":id/tv_drawer_signup_title";
    String MyAccountEmail_id = "com.zopperapp:id/name_email";
	String MyAccount_Address_Id="com.zopperapp"+buildType+":id/address_heading";
	


	// Add Products
	String AddProductsContacts_id = "com.zopperapp:id/et_add_product_contact";
	String AddProductsSelectProducts_id = "com.zopperapp:id/et_add_product_product";
	String AddProductsCategories_name = "LCD/LED/Plasma";
	String AddProductsSearchtextbox_id = "com.zopperapp"+buildType+":id/et_search_product";
	String AddProductsFirstProduct_id = "com.zopperapp:id/iv_warranty_product";
	String AddProductSelectOption_id = "com.zopperapp:id/tv_select";
	String AddProductSerialNumber_id = "com.zopperapp:id/et_add_product_serial_number";
	String AddProductPrice_id = "com.zopperapp:id/et_add_product_price";
	String AddProductDate_id = "com.zopperapp:id/tv_add_product_date";
	String AddProductsSet_name = "Set";
	String AddProductInvoice_id = "com.zopperapp:id/tv_add_product_invoice_action";
	String TakePhoto_id = "com.zopperapp:id/tv_add_product_invoice_action";
	String Uploadfile = "com.zopperapp:id/gallery";
	String AddProductSubmit_id = "com.zopperapp:id/submit_warrenty";
	String AddProductProductName_id = "com.zopperapp:id/tv_product_name";

	// Mobile and Tablets page
	String Android_phones_id = "com.zopperapp"+buildType+":id/iv_popular_cat1";
	String iphone_id = "com.zopperapp"+buildType+":id/iv_popular_cat2";
	String iPad_id = "com.zopperapp.dev:id/iv_popular_cat3";
	String Windows_phones_id = "com.zopperapp.dev:id/iv_popular_cat4";
	String Prod_Android_phones_id = "com.zopperapp:id/iv_popular_cat1";
	String MobileAndTablets_text = "Mobiles and Tablets";
	String MoreCategories_id = "com.zopperapp" + buildType + ":id/tv_other_categories_title";
	String PopularCategories_id = "com.zopperapp" + buildType + ":id/tv_popular_categories_title";
	String OtherCategores_id = "com.zopperapp" + buildType + ":id/tv_other_categories_title";
	String ProductionAndroid_phones_id = "com.zopperapp" + buildType + ":id/iv_popular_cat1";
	String Productioniphone_id = "com.zopperapp:id/iv_popular_cat2";
	String ProductioniPad_id = "com.zopperapp:id/iv_popular_cat3";
	String ProductionWindows_phones_id = "com.zopperapp:id/iv_popular_cat4";
	String HeadphoneHeadset_text = "Headphone & Headset";

	// Home Appliances page
	String HomeAppliances_text = "Home Appliances";
	String STZWAC_name = "Air Conditioners";
	String STZWWashingMachine_name = "Washing Machines";
	String STZWReferigerator_name = "Refrigerators";

	// Tv and Video player page
	String tv_player_text = "TV & Video Player";

	// Android phones page
	String MyAccountFirstFavouriteProduct_id = "com.zopperapp"+buildType+":id/iv_similar_product";
	String first_android_phone_xpath = "//android.widget.FrameLayout/ android.support.v7.widget.RecyclerView/ android.widget.RelativeLayout[1]/ android.widget.TextView";
	String second_android_phone_xpath = "//android.widget.FrameLayout/ android.support.v7.widget.RecyclerView/ android.widget.RelativeLayout[2]/ android.widget.TextView";
	String third_android_phone_xpath = "//android.widget.FrameLayout/ android.support.v7.widget.RecyclerView/ android.widget.RelativeLayout[3]/ android.widget.TextView";
	String fourth_android_phone_xpath = "//android.widget.FrameLayout/ android.support.v7.widget.RecyclerView/ android.widget.RelativeLayout[4]/ android.widget.TextView";
	String AndroidPhonesSortingButton_id = "com.zopperapp"+buildType+":id/layout_product_sort";
	String PriceOfFirstProduct_id = "com.zopperapp"+buildType+":id/tv_product_listing_price";
	String AndroidPhonesSortingButton_name = "Sort By";
	String Android_Phone_text = "Android Phones";
	String AndroidPhoneGoAhead_id = "com.zopperapp:id/tv_smart_cat_go_ahead";
	String AndroidPhonesShuffle_id = "com.zopperapp:id/shuffle";
	String AndroidPhonesShuffle_xpath = "//android.widget.FrameLayout /android.widget.ImageView[2]";
	String Filter_id = "com.zopperapp" + buildType + ":id/tv_product_filter";
	String FilerApplybutton_id = "com.zopperapp" + buildType + ":id/item_apply_filter";
	String AndroidPhones_name = "Android Phones";
	String SmartphoneName="Smartphone";
	String ProductionAndroidPhonesSortingButton_id = "com.zopperapp:id/layout_product_sort";
	String ProductionPriceOfFirstProduct_id = "com.zopperapp:id/tv_product_listing_price";

	// Calling tablet page
	String CallingTabletTitle_text = "Tablets";
	String CallingTbalets_text = "Tablets";

	// Filter
	String SamsungFilter_name = "Samsung";
	String ClearSelected_id = "com.zopperapp" + buildType + ":id/tv_filter_clear_facet";
	String ClearAll_id = "com.zopperapp" + buildType + ":id/item_clear_filter";

	// Forget Password Page
	String Forgot_Email_id = "com.zopperapp" + buildType + ":id/et_forgot_password_email";
	String Forgot_Submit_id = "com.zopperapp" + buildType + ":id/button_forgot_password";

	// Product details page

	String BuyNow_button_text = "Buy Now";
	String BuyNow_Button_Text_Upper = "BUY NOW";
	String BuyNow_id = "com.zopperapp"+buildType+":id/tv_buy";
	String Product_details_page_text = "Product Details";
	String SecondViewDetailsLink_xpath = "//android.widget.FrameLayout /android.widget.ScrollView /android.widget.RelativeLayout[1] /android.widget.TextView[1]";
	String SamsungProductSimilarProductIssue_text = "Samsung Galaxy Grand Neo 8GB Black";
	String SamsungProductSimilarProductIssue_text1 = "Samsung Z1 Dual Sim Red";
	String EurekaForbesEasyCleanVacuumCleaner_text = "Eureka Forbes Easy Clean Vacuum Cleaner";
	String FirstSimilarProduct_id = "com.zopperapp.dev:id/iv_product_image_first";
	String SecondSimilarProduct_id = "com.zopperapp.dev:id/iv_product_image_second";
	String ThirdSimilarProduct_id = "com.zopperapp.dev:id/iv_product_image_third";
	String FourthSimilarProduct_id = "com.zopperapp.dev:id/iv_product_image_fourth";
	String FirstProductSimilarName_id = "com.zopperapp" + buildType + ":id/tv_first_product_name";
	String SecondProductSimilarName_id = "com.zopperapp" + buildType + ":id/tv_second_product_name";
	String ThirdProductSimilarName_id = "com.zopperapp" + buildType + ":id/tv_third_product_name";
	String FourthProductSimilarName_id = "com.zopperapp" + buildType + ":id/tv_fourth_product_name";
	String ProductDetailsBackbutton_class = "android.widget.ImageButton";
	String ProductDetailsBigBuyNow_id = "com.zopperapp:id/tv_item_buy";
	String ProductDetailsSmallBuyNow_id = "com.zopperapp:id/tv_buy_ab";
	String FirstSimilarProductPagination_id = "com.zopperapp.dev:id/tv_product_title";
	String GetPricesButton_id = "com.zopperapp.dev:id/tv_get_prices";
	String BuyNow_xpath = "//android.widget.FrameLayout /android.widget.TextView[10]";
	String SubmitReview_id = "com.zopperapp" + buildType + ":id/tv_product_reviews_all";
	String ProductionProductTitleOnProductDetails_id = "com.zopperapp"+buildType+":id/tv_product_title";
	String ProductionProductTitle_id = "com.zopperapp:id/tv_product_title";
	String ProductionGetPricesButton_id = "com.zopperapp" + buildType + ":id/tv_get_prices";
	String ProductImage_id = "com.zopperapp" + buildType + ":id/pager";
	String EnlargedImage_BuyNow_Id="com.zopperapp" + buildType + ":id/tv_gallery_buy";
	String ProductLargeImage_id = "com.zopperapp" + buildType + ":id/pager_product_gallery";
	String OperatingSystem_name = "Operating System";
	String ProductDetailsPageFirstViewAll_id = "com.zopperapp" + buildType + ":id/tv_product_features_view_all";
	String ProductDetailsPageFirstViewAll_Text = "VIEW ALL SPECIFICATIONS";
	String BookmarkButton_id = "com.zopperapp" + buildType + ":id/iv_product_title_bookmark";
	String Exchange_id = "com.zopperapp" + buildType + ":id/exchange_image";
	String BuyWithExchange_id = "com.zopperapp" + buildType + ":id/buy_with_exchange";
	String MoreSeller_Exchange = "com.zopperapp" + buildType + ":id/with_exchange";
	String MoreSellers_id = "com.zopperapp" + buildType + ":id/tv_product_store_view_all";
	String ExchangeAvailable_Text = "(Exchange Available)";
	String BuyWithoutExchange_id = "com.zopperapp" + buildType + ":id/buy_without_exchange";
	String RefrigratorType_text = "Refrigerator Type";
	String type_id = "android:id/text1";
	String ProductPrice_id = "com.zopperapp" + buildType + ":id/tv_product_price";
	String SimilarProduct_id = "com.zopperapp" + buildType + ":id/iv_similar_product";
	String ImageCloseButton_id = "com.zopperapp" + buildType + ":id/ib_product_gallery_close";
	String ZSP_Price_xpath = "//android.widget.FrameLayout/android.widget.ScrollView/android.widget.TextView[@index=4]";
	String SP_Price_xpath = "//android.widget.FrameLayout/android.widget.ScrollView/android.widget.TextView[@index=7]";
	String MRP_Price_xpath = "//android.widget.FrameLayout/android.widget.ScrollView/android.widget.TextView[@index=10]";
	String Product_Store_Name_id = "com.zopperapp" + buildType + ":id/tv_product_store_title";
	String View_More_Sellers_Id = "com.zopperapp" + buildType + ":id/tv_product_store_view_all";
	String More_Sellers_Store_Name_Id = "com.zopperapp" + buildType + ":id/tv_item_product_store_title";
	String ProductPriceOnPrdctDetails_id = "com.zopperapp" + buildType + ":id/tv_product_price";
	String ProductDetailsVarBuyNow_xpath = "//android.widget.TextView[contains(@resource-id,'com.zopperapp" + buildType+ ":id/tv_buy')]";
	String Product_Description_Link="Product Description";
	String Product_Description_Read_Id="com.zopperapp"+buildType+":id/read_description";
	String Product_Description_Id="com.zopperapp"+buildType+":id/readmore";
	String Product_Description_Title_Link="Product Description";
	String ProductReviewStarCardId="com.zopperapp"+buildType+":id/rating";
	String ProductReviewStarClass="android.widget.ImageView";
	String ReviewListingId="com.zopperapp"+buildType+":id/ll";
	String SubmitReviewDoneId="com.zopperapp"+buildType+":id/button_done";


	// Product Features
	String GeneralFeatureSet_text = "GENERAL FEATURE SET";
	String ProductFeature_Text = "Product Features";

	// Product Reviews Page
	String BackButton_class = "android.widget.ImageButton";
	String ProductionProductReviewsPencilIcon_id = "com.zopperapp:id/menu_write_review";
	String ProductReviewsPencilIcon_id = "com.zopperapp"+buildType+":id/menu_write_review";
	String ProductReviewsAddedTitle_id = "com.zopperapp.dev:id/review_title";
	String ProductReviewsBackbutton_class = "android.widget.ImageButton";
	String WriteAReview_Id = "com.zopperapp"+buildType+":id/tv_write_review";

	// Review Product Page
	String ReviewProductFiveStarRating_text = "5";
	String ReviewRatingList_id = "com.zopperapp"+ buildType+":id/ll";
	String ReviewProductText = "Product Reviews";
	String ReviewProductSubmitButton = "SUBMIT";
	String ReviewProductSubmitButton_id = "com.zopperapp" + buildType + ":id/button_done";
	String ReviewProductTitle_ID = "com.zopperapp"+buildType+":id/review_title";
	String ReviewProductDescription_ID = "com.zopperapp"+buildType+":id/review_content";
	String ReadAllReviews_Id = "com.zopperapp"+buildType+":id/tv_product_reviews_all";
	String ReviewText_Id = "com.zopperapp"+buildType+":id/review_text";
	String ProductionReviewProductTitle_ID = "com.zopperapp" + buildType + ":id/rate_title";
	String ProductionReviewProductDescription_ID = "com.zopperapp" + buildType + ":id/rate_description";


	// Search page
	String Search_product_text = "Search Product";
	String SuggestedProductForSubmitReviewScenario = "//android.widget.FrameLayout /android.widget.ListView /android.widget.LinearLayout /android.widget.TextView";
	String Search_list_view = "android.widget.ListView";
	String SearchSuggestedFirstProduct_xpath = "//android.widget.FrameLayout /android.widget.ListView /android.widget.LinearLayout /android.widget.TextView";
	String ListView_class = "android.widget.ListView";
	String TextView_class = "android.widget.TextView";
	
    String SearchList_id = "com.zopperapp" + buildType + ":id/lv_auto_suggest";
    String SearchHistoryList_Id="com.zopperapp"+buildType+":id/tv_auto_suggest";
    String SearchLinearLayout_classname = "android.widget.LinearLayout";

	// Select Location
	String DetectAutomatically_name = "Detect Automatically";
	String DetectAutomaticallyDisabled_popup_cancelButton_id = "android:id/button2";
	String SelectLocation_text = "Select Location";
	String BangaloreLocation_text = "Bengaluru";
	String BTMLocation_text = "BTM";
	String AbsentCity_id = "com.zopperapp" + buildType + ":id/tv_location_not_present";
	String OopsPrompt_id = "android" + buildType + ":id/alertTitle";
	String Citylocality_id = "com.zopperapp" + buildType + ":id/tv_location_child_name";
	String EmailIdTextBox_Id = "com.zopperapp" + buildType + ":id/et_email";
	String YourCityTextBox_Id = "com.zopperapp" + buildType + ":id/et_city";
	String OkButton_Id = "android:id/button1";
	String Location_CitiesNames_Id = "com.zopperapp" + buildType + ":id/tv_location_parent_name";
	String Location_Sub_City_Id="com.zopperapp" + buildType + ":id/tv_locality_name";
	String DelhiLocation_text = "Delhi";
	String DelhiSubLocation_AnandLok_text = "Anand Lok";
	String LocatioCity_id = "com.zopperapp" + buildType + ":id/tv_location_parent_name";

	// Excel path
	String Path_TestData = "D:\\Zopper\\ConsumerAppBugRegression\\src\\TestData\\";
	String File_TestData = "TestData.xlsx";

	// Prompt

	String DeleteCartItemPrompt_id = "android:id/button1";
	String LocationChangeCartPrompt_name = "Okay!  GOT IT";

	// Overflow menu
	String OFMyOrders_name = "My Orders";
	String MyProfileText = "My Profile";
	String MyProfile_name = "My Profile";
	String ShareApp_name = "Share App";
	String ContactUs_name = "Contact Us";
	String FAQ_name = "FAQ";

	// Order Success page

	String ProductionShopMore_id = "com.zopperapp"+buildType+":id/tv_payment_next_step";
	String ShopMore_id = "com.zopperapp.dev:id/tv_payment_next_step";

	// Constant other than app

	String WhatsApp_name = "WhatsApp";
	String FaceBook_Name = "Facebook";
	String JustOnceButton_id = "android:id/button1";

	// Sort By prompt
	String LTH = "Prices: Low to High";
	String HTL = "Prices: High to Low";
	String Relevance_text = "Relevance";

	// Android Settings

	String Android_Location_Setting_Id = "com.android.systemui:id/settings_button";

	// Verify Order Page
	String VerifyOrderPageOrderId_id = "com.zopperapp" + buildType + ":id/tv_order_status_order_id";

	// Contact us Page
	String SelectNatureofFeedback_id = "com.zopperapp" + buildType + ":id/feeling";
	String PaymentRelated_name = "Payment Related";
	String HowAreYouFeeling_name = "How are you feeling?";
	String Happy_name = "Happy";
	String Product_Radio_Text="Product";
	String Fullname_id = "com.zopperapp" + buildType + ":id/et_name";
	String EmailID_id = "com.zopperapp" + buildType + ":id/et_email";
	String PromptOKButton_id = "com.zopperapp" + buildType + ":id/logout_no";
	String WriteAfeedback_id = "com.zopperapp" + buildType + ":id/et_feedback";
	String SubmitButton_id = "com.zopperapp" + buildType + ":id/button_submit";
	String ItemCancelled_name = "Item Cancelled";
	String WeCare_Email_id="com.zopperapp"+buildType+":id/mail_zopper";

	// warrenty scanerio

	String AddWarrantyPageHeader_xpath = "//android.widget.FrameLayout/android.widget.TextView[@index=1]";
	String Add_Product_id = "com.zopperapp" + buildType + ":id/tv_add_product";
	String Add_Product_Name_id = "com.zopperapp" + buildType + ":id/et_add_product_name";
	String Warranty_Product_id = "com.zopperapp" + buildType + ":id/tv_warranty_pro_name";
	String Select_id = "com.zopperapp" + buildType + ":id/tv_select";
	String Camera_id = "com.zopperapp" + buildType + ":id/camera";
	String Next_Add_Warrenty_One_id = "com.zopperapp" + buildType + ":id/next_add_warrenty_one";
	String Warranty_Valid_For_name = "Warranty Valid For";
	String Warranty_Purchase_Date_id = "com.zopperapp" + buildType + ":id/tv_add_product_date";
	String WarrantyValidFor_date_xpath = "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index=1]/android.widget.TextView[@index=2]";
	String Next_Add_Warrenty_Two_id = "com.zopperapp" + buildType + ":id/next_add_warrenty_two";
	String EditWarrantySubmitButton_Id = "com.zopperapp" + buildType + ":id/next_add_warrenty_three";
	String Warrant_Product_Name = "com.zopperapp" + buildType + ":id/tv_product_name";
	String Warranty_Product_Category_name = "Refrigerator";
	String Warranty_Date_Done_id = "android:id/button1";
	String WarrantyListFirstProduct_xpath = "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index=1]";
	String WarrantyReason_id = "com.zopperapp" + buildType + ":id/w_reason_for_claim";
	String WarrantyContactNo_id = "com.zopperapp" + buildType + ":id/et_contact";
	String WarrantyClaimButton_id = "com.zopperapp" + buildType + ":id/w_claim";
	String WarrantyRequestConfirmation_text = "Request Confirmation";
	String WarrantyClaimID_xpath = "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index=1]/"
			+ "android.widget.TextView[@index=3]";
	String WarrantyClaimID_text = "Warranty claim id :";
	String WarrantyViewInvoice_xpath = "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index=1]/"
			+ "android.widget.TextView[@index=5]";

	String ImageShareButton_Id = "com.zopperapp" + buildType + ":id/tv_share";

	String ImageShareButton_Text = "Share";

	String ClaimWarrantyPageHeader_xpath = "//android.widget.FrameLayout/android.widget.TextView[@index=1]";
	String WarrantyEditPageDate_id = "com.zopperapp" + buildType + ":id/ed_warranty_duration";
	String WarrantyDate_text = "2 years";
	String EditPageContactNo_Id = "com.zopperapp" + buildType + ":id/tv_add_user_contact";
	String Warranty_Valid_For_Id = "com.zopperapp" + buildType + ":id/tv_brand_warranty_valid";
	String Claim_Warranty_Header_Text = "Claim Warranty";
	String Warranty_ClaimId_Id = "com.zopperapp" + buildType + ":id/tv_claim_id_value";
	String Warranty_ClaimUnderProcess_Id = "com.zopperapp:" + buildType + "id/tv_claim_status";
	String Warranty_ClaimStatus_Id = "com.zopperapp" + buildType + ":id/tv_claim_status";
	String View_Warranty_Invoice_Id = "com.zopperapp" + buildType + ":id/tv_show_invoice";
	String Add_Product_Header_Text = "Add Product";
	String ClaimWarrantyPencil_id = "com.zopperapp" + buildType + ":id/w_address_edit";

	// Play store
	String WebAppDownoad_Class="download-app android";
	String Play_Store_SignIn_id = "gb_70";
	String Play_Store_AndroidApp_Download_css = ".android";
	String Play_Store_Email_id = "Email";
	String Play_Store_Next_id = "next";
	String Play_Store_Password_id = "Passwd";
	String Play_Store_Login_id = "signIn";
	String Play_Store_Installed_xpath = "//span[@class='consume-label']/button[contains(text(),'Installed')]";
	String Play_Store_DropDown_xpath = ".//*[@id='device-selector-container']/div/button";
	String Play_Store_Device_xpath = "//button[contains(.,'Airtel Samsung SM-N750')]";
	String Play_Store_InstallButton_id = "purchase-ok-button";
	String Play_Store_CongratulationMessage_xpath = "//div[@class='purchase-complete-container']//div[contains(text(),'Congratulations')]";
	String Play_Store_CongratulationMessage_Ok_id = "close-dialog-button";

	// Mobile Notification

	String Mobile_Notification_Class = "android.widget.TextView";

	// FAQs page
	String FAQsList_id = "com.zopperapp:id/wv_smart_cat";
	String WarrantyFAQsHeaders_xpath = "//android.widget.FrameLayout/android.view.View/android.view.View[@index=2]";
	String WarrantyFAQsHeader_Text = "Warranty FAQ";

	// Payment Mode
	String AllPaymentMode_id = "com.zopperapp" + buildType + ":id/tv_payment_mode_text";
	String PaytmpageCancel_name = "Cancel";

	// Banners
	String Banners_id = "com.zopperapp" + buildType + ":id/daimajia_slider_image";
	String VadodaraCity = "Vadodara";
	String Akotalocation = "Akota";

	// More Sellers
	String MoreSellersBuyNow_id = "com.zopperapp" + buildType + ":id/tv_item_buy";
	String MoreSellersBuyNow_Text = "BUY NOW";

	// Branded Stores
	String BrandedStorestext_id = "com.zopperapp" + buildType + ":id/branded_store_heading";
	String BrandedStoresViewPricelink_id = "com.zopperapp" + buildType + ":id/branded_view_store";
	String BrandedStoresProductTitle_id = "com.zopperapp" + buildType + ":id/product_title";
	String BrandedStoresProductImage_id = "com.zopperapp" + buildType + ":id/product_image";
	String BrandedStoresProductPrice_id = "com.zopperapp" + buildType + ":id/tv_product_price";
	String BrandedStoresStoreAddress_id = "com.zopperapp" + buildType + ":id/branded_tv_product_store_distance";
	String BrandedStoresCloseOption_id = "com.zopperapp" + buildType + ":id/ib_product_gallery_close";
	String BrandedStoresBuyNow_id = "com.zopperapp" + buildType + ":id/tv_buy";
	String BrandedStoresLogo_id = "com.zopperapp" + buildType + ":id/branded_store_logo";
	String BrandedStoresLocationtext_id = "com.zopperapp" + buildType + ":id/branded_tv_product_store_address";
	String BrandedStoresdistancevalue_id = "com.zopperapp" + buildType + ":id/branded_tv_product_store_distance";

	// AutoDetectLocationToast

	String AutoLocationToast_id = "com.zopperapp" + buildType + ":id/snackbar_text";
	String AutoLocationChangetext_id = "com.zopperapp" + buildType + ":id/snackbar_action";
	String AutolocationChangetext_name = "CHANGE";

	// Orderdetails

	String OrderPlaced_id = "com.zopperapp" + buildType + ":id/status_text";
	String CancelButton_id = "com.zopperapp" + buildType + ":id/tv_product_cancel_status";
	
	//OrderCancellation
	
	String CancellationReason_id = "com.zopperapp" + buildType+":id/cancel_reason";
	String Others_name = "Others";
	
	//Camera
	String LollipopCameraSaveButton_id = "com.sec.android.app.camera:id/save";
	
	//Gmail Web Scenrios
    String GMail_User_Id="Email";
    String Gmail_Next_Id="next";
    String Gmail_Password_Id="Passwd";
    String Gmail_SignIn_Button_Id="signIn";
    String Gmail_MailList_User_Id="//b[contains(text(),'Zopper account password reset')]";
    String Gmail_ChangePassword_LinkText="//a[contains(.,'Reset Password')]";//"//a[@rel='noreferrer']";
    		//"https://api.zopper.com/forgot-password";
    String Gmail_NewPassword_Id="password";
    String Gmail_ConfirmPassword_Id="confirm_password";
    String Gmail_ChangePWDButton="changePWD";
    String Gmail_PwdChangeSuccessMsg_Id="successMessage";
    String Gmail_Signout_Xpath="//div[@id='gb']/div/div/div[2]/div[4]/div/a/span";
    String Gmail_SignOut_Button_Link="Sign out";
    String Gmail_ContactUs_Compose_Link="Compose";
    
    
    String Complete_ActionUsing_Link="Complete action using";
    String Email_Client_Selection_Id="android:id/resolver_list";
    String Email_Client_Class="android.widget.LinearLayout";
    String Select_JustOnce_Link="Just once";
    
    //Seller Information on Product Details
    String Seller_Info_Product_Details_Id="com.zopperapp"+buildType+":id/store_parent";
    String Seller_Rating_Product_Details_Id="com.zopperapp"+buildType+":id/store_rating";
    String Seller_View_All_Stores_Id="com.zopperapp"+buildType+":id/tv_product_store_view_all";
    String Seller_More_Sellers_Title_Link="More Sellers";
    String Seller_All_Stores_More_Sellers_Id="com.zopperapp:id/rv_stores";
    String Seller_More_Seller_Sorting="com.zopperapp"+buildType+":id/layout_product_sort";
    String Seller_More_Sellers_Store_Class="android.widget.LinearLayout";
    
    String Address_Add_New_No_Saved_Id="com.zopperapp"+buildType+":id/tv_error_retry";
    String Address_Add_New_For_Saved_Id="com.zopperapp"+buildType+":id/saved_address";
    String Address_Saved_Address_Id="com.zopperapp"+buildType+":id/parent_row";
    String Address_Address_Text="My Addresses";
    String Address_FullName_Id="com.zopperapp"+buildType+":id/et_full_name";
    String Address_Email_Id="com.zopperapp"+buildType+":id/et_email";
    String Address_PhoneNumber_Id="com.zopperapp"+buildType+":id/et_contact";
    String Address_Locality_Id="com.zopperapp"+buildType+":id/tv_locality";
    String Address_location_Id="com.zopperapp"+buildType+":id/tv_city";
    String Address_Pincode_Id="com.zopperapp"+buildType+":id/tv_pincode";
    
    //Color Variant
    String ColorVariants_Id="com.zopperapp"+buildType+":id/image_variant";
    
    ///trending products
    String Sorting_orders_Id="android:id/text1";
    
    //phone functionality
    String ClearNotifications_Id="com.android.systemui:id/clear_all_button_label";
}

