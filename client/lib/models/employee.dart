import './resource.dart';

class Employee implements Resource{
  String email;
  String firstName;
  String familyName;
  String address;
  String phoneNumber;
  // String Role;
  Employee({required this.email, required this.firstName, required this.familyName, required this.address, required this.phoneNumber});

  @override
  Employee fromJson(json) {
    return Employee(email: json["email"]??"", firstName: json["forename"]??"", familyName: json["surname"]??"", address: json["address"]??"", phoneNumber: json["phoneNumber"]??"");
  }

}