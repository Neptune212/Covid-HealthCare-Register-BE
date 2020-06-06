# CovidHealthcareRegister

# Deploy to EC2
chkconfig --add chr
chkconfig chr --level 1235 on


Backend service for CovidHealthcareRegister project

# Sample Hospital Record Object Json:
```json
{
	"hospitalRegistration": {
		"name": "Max Shalimar Bagh",
		"emailId": "pandemichealthcareregister@gmail.com",
		"phone": "65645645646",
		"addressDetails": "Max Super Speciality Hospital, Shalimar Bagh",
		"city": "Delhi",
		"zipCode": "110088",
		"hospitalId": "Max Shalimar Bagh110088"
	},
	"floor": "1",
	"section": "1",
	"room": "104",
	"itemType": "Bed",
	"itemCount": "25",
	"availableCount": "15",
	"itemName": "Inclined Bed",
	"itemId": "104-BED-1-25",
	"availableFrom": "2020-06-05",
	"availableTill": "2020-06-26",
	"notifyWhenUserSubscribe": true,
	"note": "Covid-19 isolation ward is separat"
}
```
