import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:client/src/services/rest_services/api_resources.dart';
import 'package:client/models/employee.dart';

class AuthToken {
  String accessToken;
  String refreshToken;
  int keepAlive;
  String employee; //email address as unique identifier

  AuthToken(
      {required this.accessToken,
      required this.keepAlive,
      required this.employee,
      required this.refreshToken});
}

Future<AuthToken> signIn(String email, String password) async {
  final response = await http.post(
    Uri.parse(ApiResources.baseURL + ApiResources.authEndpoint),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(
      <String, String>{
        'grandType': "PASSWORD",
        'email': email,
        'password': password,
      },
    ),
  );
  final jsonResponse = jsonDecode(response.body);
  print(response.statusCode);
  return AuthToken(
      accessToken: jsonResponse["accessToken"],
      keepAlive: jsonResponse["expiresIn"],
      employee: jsonResponse["employeeId"],
      refreshToken: jsonResponse["refreshToken"]);
}

Future<http.Response> signup(String email, String pwd, String surname,
    String forename, String phoneNumber, String role, String address) {
    print(ApiResources.baseURL + ApiResources.registrationEndpoints);
  return http.post(
    Uri.parse(ApiResources.baseURL + ApiResources.registrationEndpoints),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(<String, dynamic>{
      "email": email,
      "forename": forename,
      "surname": surname,
      "address_id": address,
      "phoneNumber": phoneNumber,
      "password": pwd,
      "roles": ["ADMIN"]
    }),
  );
}
