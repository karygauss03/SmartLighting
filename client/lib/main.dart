import 'package:flutter/material.dart';
import 'package:client/src/views/home_page/home_page.dart';
import 'package:client/src/views/authentication/login_page.dart';
import 'package:client/src/views/authentication/registration_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Smart Lights',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const LoginPage(),
    );
  }
}