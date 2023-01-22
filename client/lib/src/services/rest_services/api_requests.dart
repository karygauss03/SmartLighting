import 'dart:async';
import 'dart:convert';
import 'dart:io';

import 'package:http/http.dart' as http;
import './api_resources.dart';
import 'package:client/models/resource.dart';
import 'package:client/models/assignment.dart';
import 'package:client/models/light_module.dart';
import 'package:client/models/employee.dart';

Future<http.Response> fetchResource(resource, token) {
  return http.get(
    Uri.parse(ApiResources.baseURL + resource),
    headers: {
      HttpHeaders.authorizationHeader: 'Bearer $token',
    },
  );
  // final responseJson = jsonDecode(response.body);
  // return resource.fromJson(responseJson);
}


// //authenticated requests
// Future<Album> fetchAlbum() async {
//   final response = await http.get(
//     Uri.parse('https://jsonplaceholder.typicode.com/albums/1'),
//     // Send authorization headers to the backend.
//     headers: {
//       HttpHeaders.authorizationHeader: 'Basic your_api_token_here',
//     },
//   );
//   final responseJson = jsonDecode(response.body);

//   return Album.fromJson(responseJson);
// }

// Future<http.Response> createAlbum(String title) {
//   return http.post(
//     Uri.parse('https://jsonplaceholder.typicode.com/albums'),
//     headers: <String, String>{
//       'Content-Type': 'application/json; charset=UTF-8',
//     },
//     body: jsonEncode(<String, String>{
//       'title': title,
//     }),
//   );
// }


// Future<http.Response> updateAlbum(String title) {
//   return http.put(
//     Uri.parse('https://jsonplaceholder.typicode.com/albums/1'),
//     headers: <String, String>{
//       'Content-Type': 'application/json; charset=UTF-8',
//     },
//     body: jsonEncode(<String, String>{
//       'title': title,
//     }),
//   );
// }


// Future<http.Response> deleteAlbum(String id) async {
//   final http.Response response = await http.delete(
//     Uri.parse('https://jsonplaceholder.typicode.com/albums/$id'),
//     headers: <String, String>{
//       'Content-Type': 'application/json; charset=UTF-8',
//     },
//   );

//   return response;
// }
