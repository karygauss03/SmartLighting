import 'package:http/http.dart';

class ApiResources {
  // TODO: replace domain name with "api.smart-lighting.me" later
  static String baseURL = "https://api.smart-lighting.me:8443/smartlighting-1.0-SNAPSHOT/api";
  // static String baseURL = "http://10.0.2.2:8080/smartlighting-1.0-SNAPSHOT/api";

  // Security resources
  static String registrationEndpoints = "/employees/signup";
  static String authEndpoint = "/oauth2/token";
  // static String 
  // static String updatePassEndpoint = 
   
  // object endpoints
  static String employeesEndpoint = "/employees";
  static String citiesEndpoint = "/cities";
  static String lightModulesEndpoint = "/lightingModules";
  static String assignmentsEndpoints = "/assignments";
}
