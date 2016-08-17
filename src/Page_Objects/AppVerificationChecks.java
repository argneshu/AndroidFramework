package Page_Objects;

//This interface hold all data of checkpoints used in test cases script

public interface AppVerificationChecks {
//Submit Review Scenario check 
String SubmitReviewCheck = ".";
//Review with special char check
String ReviewWithSpecialChar = ".";
//Review with similar products check
String SimilarProductsIssue = "Samsung Galaxy Grand Neo 8GB Black";
//HTC product connection issue scenario
String HomeText ="Home";
//Shopping Cart Product delete scenario
String NoItemInCartLabel = "No Item in Cart";
String ShoppingCarttext = "Shopping Cart";
String GetPricesText = "GET PRICES";
//Checkout error on cart
String ContinueLabel = "CONTINUE";
//Overflow option is missing scenario
String MyOrdertext ="My Orders";
String MyProfiletext="My Profile";
//Coupon Prompt Issue scenario
String CouponErrorText = "Sorry, This coupon code is not valid";
String CouponErrorTextDiscounted = "Hey! We’re offering the best price on this item. Coupons won’t apply.";
String CouponErrorTextDiscountedUnique = "Sorry, You have reached the maximum limit for this coupon";
//Application crash issue
String Checkouttext = "Checkout";
String ReviewProductText = "Product Reviews";
//AppVerificationCheck scenario
String AddressEmailtext ="Please enter a valid email ID";
String AddresContactNumber = "Please enter a 10 digit mobile number";

String EmailregEx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)* @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
String OperatingSystemtext = "Operating System";
String GeneralFeatureText = "GENERAL FEATURE SET";
String Logintext = "Login";
String Asustext = "Asus";
String Samsung ="Samsung";
String AndroidPhonestext = "Android Phones";
String SmartPhonetext="Smartphone";
String Relevancetext = "Relevance";
String Hometext = "Home";
String NoItemInCart = "No Orders";
String locality = "Sector 63";
String localitycities = "BengaluruDelhiGurgaon/FaridabadMumbaiNoida/GhaziabadSector 63, NoidaJaipurChandigarhMohaliPanchkulaAhmedabad";
String OLADEBITCREDITCARDS = "DEBIT/CREDIT CARDS";
String OLANETBANKING = "NET BANKING";
String PaytmCancel= "Cancel";
String Android_Phone_text = "Android Phones";
String AutoLocationtext = "Location Set to ";

String OrderStatusProcessing = "Order Placed";
}

